package myparserrulesinformation;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Sequence {
    private final static Term NONE = new Term("NONE");

    private final ArrayList<Definition> seq;

    public Sequence() {
        this.seq = new ArrayList<>();
    }

    public SequenceMember getFirstEl(int index) {
        while (seq.get(index).getMember() instanceof Code) {
            index++;
        }
        return seq.get(index).getMember();
    }

    public int getNextEl(int index) {
        for (int i = index; i < seq.size(); i++) {
            if (!(seq.get(i).getMember() instanceof Code)) {
                return i;
            }
        }
        return -1;
    }

    public int getNextNonTerm(int index) {
        for (int i = index; i < seq.size(); i++) {
            if (seq.get(i).getMember() instanceof NonTerm) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsNONE() {
        return seq.stream().map(Definition::getMember).filter(x -> x instanceof Term)
                .map(x -> (Term) x).anyMatch(x -> x.equals(NONE));
    }

    public SequenceMember getFromSeq(int index) {
        return seq.get(index).getMember();
    }

    public String getCode() {
        return seq.stream().map(Definition::getMember).filter(x -> x instanceof Code)
                .map(x -> ((Code) x).getCode()).collect(Collectors.joining(System.lineSeparator()));
    }

    public int getSeqSize() {
        return seq.size();
    }

    public ArrayList<Definition> getDefinitions() {
        return seq;
    }

    public void addDef(Definition def) {
        this.seq.add(def);
    }
}
