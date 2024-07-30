package myparserrulesinformation;

import java.util.ArrayList;

public class ParserRule {
    private NonTerm nonTerm;
    private ArrayList<Argument> input;
    private Argument returnValue;
    private ArrayList<Sequence> sequences;
    private boolean firstRule;

    public ParserRule(boolean firstRule) {
        this.firstRule = firstRule;
    }

    public boolean isFirstRule() {
        return firstRule;
    }

    public NonTerm getNonTerm() {
        return nonTerm;
    }

    public ArrayList<Argument> getInput() {
        return input;
    }

    public Argument getReturnValue() {
        return returnValue;
    }

    public ArrayList<Sequence> getSequences() {
        return sequences;
    }

    public boolean hasReturnValue() {
        return !(returnValue == null);
    }

    public void setNonTerm(NonTerm nonTerm) {
        this.nonTerm = nonTerm;
    }

    public void setInput(ArrayList<Argument> input) {
        this.input = input;
    }

    public void setReturnValue(Argument returnValue) {
        this.returnValue = returnValue;
    }

    public void setSequences(ArrayList<Sequence> sequences) {
        this.sequences = sequences;
    }
}
