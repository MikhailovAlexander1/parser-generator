package org.example.generator;

import myparserrulesinformation.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ParserGenerator {
    private final static Term NONE = new Term("NONE");
    private final Map<NonTerm, Set<Term>> FIRST;
    private final Map<NonTerm, Set<Term>> FOLLOW;
    private final ArrayList<ParserRule> rules;
    private final Map<NonTerm, ArrayList<Sequence>> mapRules;
    private final StringBuilder sb = new StringBuilder();
    private final String packageName;
    private final String fileName;
    private final Path saveTo;

    private void addString(int tab, int lineSeparatorsCount, String str) {
        sb.append(C.TAB.repeat(Math.max(0, tab)));
        sb.append(str);
        sb.append(C.NEWLINE.repeat(Math.max(0, lineSeparatorsCount)));
    }

    private void printPackage() {
        if (!this.packageName.isEmpty()) {
            sb.append(C.PACKAGE).append(C.SPACE).append(this.packageName)
                    .append(C.SEMICOLON).append(C.NEWLINE).append(C.NEWLINE);
        }
    }

    private void printImports() {
        addString(0, 1, "import java.io.ByteArrayInputStream;");
        addString(0, 1, "import java.io.InputStream;");
        addString(0, 1, "import java.nio.charset.StandardCharsets;");
        addString(0, 2, "import java.text.ParseException;");
        addString(0, 2, String.format("import static %s.%s.*;", packageName, fileName + "Token"));
    }

    private void printFields() {
        addString(1, 2, String.format("public %sLexer la;", this.fileName));
    }

    private void printParse() {
        String returnType = rules.get(0).getReturnValue() == null ? "void" : rules.get(0).getReturnValue().getType();
        addString(1, 1, String.format("public %s parse(String str) throws ParseException {", returnType));
        addString(2, 1, "InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));");
        addString(2, 1, String.format("la = new %sLexer(is);", this.fileName));
        addString(2, 1, "la.nextToken();");
        addString(2, 1, returnType.equals("void") ?
                String.format("%s();", rules.get(0).getNonTerm().getName()) :
                String.format("return %s();", rules.get(0).getNonTerm().getName()));
        addString(1, 1, C.CLOSE_BRACE);
    }

    private void printAssert() {
        addString(1, 1,
                String.format("private void assertToken(%s token) throws ParseException {", fileName + "Token"));
        addString(2, 1, "if (la.curToken != token) {");
        addString(3, 1, "throw new ParseException(String.format(\"Wrong token: %s!\", token), 0);");
        addString(2, 1, "}");
        addString(1, 2, "}");
    }

    public Sequence getRuleBy(NonTerm main, Term term) {
        for (int i = 0; i < mapRules.get(main).size(); i++) {
            Sequence sequence = mapRules.get(main).get(i);
            int index = sequence.getNextEl(0);
            SequenceMember member = sequence.getFromSeq(index);
            while (true) {
                if (member instanceof Term) {
                    if (term.equals(member)) {
                        return sequence;
                    } else {
                        break;
                    }
                }
                if (FIRST.get((NonTerm) member).contains(term)) {
                    return sequence;
                } else if (FIRST.get((NonTerm) member).contains(NONE)) {
                    index = sequence.getNextEl(index + 1);
                    member = sequence.getFromSeq(index);
                } else {
                    break;
                }
            }
        }
        return null;
    }

//    Функция генерирует тело внутри оператора switch-case. Идет по правилу и генерирует код вида:
//    case LPAREN -> {
//        double f = f();               ---
//        double tsup = tsup(f);        --- сгенерированные строки
//        value = tsup;                 ---
//    }
    private void printRule(Sequence sequence) {
        for (Definition definition: sequence.getDefinitions()) {
            SequenceMember member = definition.getMember();
            if (member instanceof Term) {
                addString(4, 1, String.format("assertToken(%s);", ((Term) member).getName()));
                addString(4, 1, "la.nextToken();");
                continue;
            }
            if (member instanceof Code) {
                addString(4, 1, ((Code) definition.getMember()).getCode());
            } else {
                ParserRule neededRule = rules.stream().filter(x -> x.getNonTerm().equals(member)).findAny().orElse(null);
                assert neededRule != null;
                String nonTermString = neededRule.getNonTerm().getName();
                if (neededRule.hasReturnValue()) {
                    addString(4, 1, String.format("%s %s = %s(%s);",
                            neededRule.getReturnValue().getType(),
                            nonTermString,
                            nonTermString,
                            definition.hasInput() ? definition.getInput().getCode() : ""));
                } else {
                    addString(4, 1, String.format("%s(%s);",
                            nonTermString,
                            definition.hasInput() ? definition.getInput().getCode() : ""));
                }
            }
        }
    }

    private void printParser() {
        for (ParserRule rule: rules) {
            String returnValueType = rule.hasReturnValue() ? rule.getReturnValue().getType() : "void";
            boolean isVoid = returnValueType.equals("void");
            addString(1, 1, String.format("private %s %s(%s) throws ParseException {",
                    returnValueType,
                    rule.getNonTerm().getName(),
                    rule.getInput() == null ? "" : rule.getInput().stream().map(Argument::toString).collect(Collectors.joining(","))));

            if (!isVoid) {
                addString(2, 1, String.format("%s %s;", returnValueType, rule.getReturnValue().getVarName()));
            }

            addString(2, 1, "switch(la.curToken) {");
            boolean noneToken = false;
            for (Term first : FIRST.get(rule.getNonTerm())) {
                if (first.equals(NONE)) {
                    noneToken = true;
                    continue;
                }
                addString(3, 1, String.format("case %s -> {", first.getName()));
                printRule(getRuleBy(rule.getNonTerm(), first));
                addString(3, 1, C.CLOSE_BRACE);
            }
            if (noneToken) {
                addString(3, 1, String.format("case %s -> {",
                        FOLLOW.get(rule.getNonTerm()).stream().map(Term::getName).collect(Collectors.joining(", "))));
                for (Sequence sequence: rule.getSequences()) {
                    if (sequence.containsNONE()) {
                        addString(4, 1, sequence.getCode());
                    }
                }
                addString(3, 1, C.CLOSE_BRACE);
            }
            addString(3, 1, "default -> throw new AssertionError();");
            addString(2, 1, C.CLOSE_BRACE);
            if (rule.isFirstRule()) {
                addString(2, 1, "assertToken(END);");
            }
            if (!isVoid) {
                addString(2, 1, String.format("return %s;", rule.getReturnValue().getVarName()));
            }
            addString(1, 2, C.CLOSE_BRACE);
        }
    }

    private void printMethods() {
        printAssert();
        printParser();
        printParse();
    }

    private void printClass() {
        sb.append(C.PUBLIC).append(C.SPACE).append(C.CLASS).append(C.SPACE)
                .append(String.format("%sParser {\n", this.fileName));
        printFields();
        printMethods();
        sb.append(C.CLOSE_BRACE);
    }

    public ParserGenerator(Map<NonTerm, Set<Term>> FIRST, Map<NonTerm, Set<Term>> FOLLOW, ArrayList<ParserRule> rules,
                           String pathToGen, String packageToGen, String taskName) {
        this.FIRST = FIRST;
        this.FOLLOW = FOLLOW;
        this.rules = rules;
        this.mapRules = new HashMap<>();
        for (ParserRule rule: rules) {
            mapRules.put(rule.getNonTerm(), rule.getSequences());
        }
        this.fileName = Character.toUpperCase(taskName.charAt(0)) + taskName.substring(1);
        this.packageName = packageToGen;
        this.saveTo = Paths.get(pathToGen, fileName + "Parser.java");
    }

    public void generate() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(saveTo)) {
            printPackage();
            printImports();
            printClass();
            writer.write(sb.toString());
            writer.flush();
        }
    }
}
