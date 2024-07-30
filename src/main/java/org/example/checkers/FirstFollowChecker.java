package org.example.checkers;

import myparserrulesinformation.*;

import java.util.*;

public class FirstFollowChecker {
    private final Map<NonTerm, Set<Term>> FIRST = new HashMap<>();
    private final Map<NonTerm, Set<Term>> FOLLOW = new HashMap<>();
    private final ArrayList<ParserRule> rules;
    private final Map<NonTerm, ArrayList<Sequence>> mapRules = new HashMap<>();
    private final static Term NONE = new Term("NONE");
    private final static Term END = new Term("END");
    private final static int ZERO = 0;

    private boolean noLeftRecursion() {
        for (ParserRule rule: rules) {
            ArrayList<NonTerm> continuation = new ArrayList<>();
            Set<NonTerm> visited = new HashSet<>();
            continuation.add(rule.getNonTerm());
            boolean flag = false;
            while (true) {
                if (continuation.isEmpty()) {
                    return true;
                }
                if (flag && !Collections.disjoint(continuation, visited)) {
                    return false;
                }
                for (Sequence sequence : mapRules.get(continuation.get(ZERO))) {
                    SequenceMember member = sequence.getFirstEl(ZERO);
                    if (member instanceof NonTerm) {
                        continuation.add((NonTerm) member);
                    }
                }
                visited.add(continuation.remove(ZERO));
                flag = true;
            }
        }
        return true;
    }

    private boolean noRightRecursion() {
        Map<NonTerm, HashSet<Term>> hm = new HashMap<>();
        for (ParserRule rule: rules) {
            hm.put(rule.getNonTerm(), new HashSet<>());
        }
        for (ParserRule rule : rules) {
            for (Sequence sequence : rule.getSequences()) {
                int index = sequence.getNextEl(ZERO);
                while (index != -1) {
                    if (sequence.getFromSeq(index) instanceof NonTerm) {
                        break;
                    }
                    Term member = (Term) sequence.getFromSeq(index);
                    if (hm.get(rule.getNonTerm()).contains(member)) return false;
                    hm.get(rule.getNonTerm()).add(member);
                    index++;
                    index = sequence.getNextEl(index);
                }
            }
        }
        return true;
    }

    public FirstFollowChecker(ArrayList<ParserRule> rules) {
        this.rules = rules;
        for (ParserRule rule: rules) {
            mapRules.put(rule.getNonTerm(), rule.getSequences());
        }
    }

    public void constructFIRST() {
        for (ParserRule rule: rules) {
            FIRST.put(rule.getNonTerm(), new HashSet<>());
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (ParserRule rule: rules) {
                for (Sequence sequence: rule.getSequences()) {
                    int firstElIndex = sequence.getNextEl(ZERO);
                    SequenceMember member = sequence.getFromSeq(firstElIndex);
                    if (member instanceof Term) {
                        changed |= FIRST.get(rule.getNonTerm()).add((Term) member);
                    } else {
                        Set<Term> termSet = new HashSet<>(Set.of(NONE));
                        while (termSet.remove(NONE)) {
                            if (member instanceof Term) {
                                termSet.add((Term) member);
                                break;
                            }
                            termSet.addAll(FIRST.get((NonTerm) member));
                            firstElIndex = sequence.getNextEl(firstElIndex + 1);
                            if (firstElIndex == -1) {
                                break;
                            }
                            member = sequence.getFromSeq(firstElIndex);
                        }
                        changed |= FIRST.get(rule.getNonTerm()).addAll(termSet);
                    }
                }
            }
        }
    }

    public void constructFOLLOW() {
        for (ParserRule rule: rules) {
            FOLLOW.put(rule.getNonTerm(), new HashSet<>());
        }
        FOLLOW.get(rules.get(0).getNonTerm()).add(END);
        boolean changed = true;
        while (changed) {
            changed = false;
            for (ParserRule rule: rules) {
                NonTerm A = rule.getNonTerm();
                for (Sequence sequence: rule.getSequences()) {
                    int index = 0;
                    index = sequence.getNextNonTerm(index);
                    while (index != -1) {
                        NonTerm B = (NonTerm) sequence.getFromSeq(index);
                        int count = FOLLOW.get(B).size();
                        try {
                            SequenceMember C = sequence.getFirstEl(index + 1);
                            if (C instanceof Term) {
                                FOLLOW.get(B).add((Term) C);
                            } else {
                                FOLLOW.get(B).addAll(FIRST.get((NonTerm) C));
                                if (FOLLOW.get(B).remove(NONE)) {
                                    FOLLOW.get(B).addAll(FOLLOW.get(C));
                                }
                            }
                        } catch (Exception ignored) {
                            FOLLOW.get(B).addAll(FOLLOW.get(A));
                        }
                        if (count != FOLLOW.get(B).size()) {
                            changed = true;
                        }
                        index = sequence.getNextNonTerm(index + 1);
                    }
                }
            }
        }
    }

    public void printSet(String name) {
        Map<NonTerm, Set<Term>> set;
        if (name.equals("FIRST")) {
            set = FIRST;
        } else {
            set = FOLLOW;
        }
        for (Map.Entry<NonTerm, Set<Term>> entry : set.entrySet()) {
            System.out.print(entry.getKey().getName() + " ->");
            for (Term term: entry.getValue()) {
                System.out.print(" " + term.getName());
            }
            System.out.println();
        }
    }

    public boolean isLL1() {
        return noLeftRecursion() && noRightRecursion();
    }

    public Map<NonTerm, Set<Term>> getFIRST() {
        return FIRST;
    }

    public Map<NonTerm, Set<Term>> getFOLLOW() {
        return FOLLOW;
    }
}
