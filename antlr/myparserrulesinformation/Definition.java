package myparserrulesinformation;

public class Definition {
    private final SequenceMember member;
    private Code input;

    public Definition(SequenceMember member) {
        this.member = member;
    }

    public Definition(SequenceMember member, Code input) {
        this.member = member;
        this.input = input;
    }

    public SequenceMember getMember() {
        return member;
    }

    public Code getInput() {
        return input;
    }

    public boolean hasInput() {
        return input != null;
    }

    public void setInput(Code input) {
        this.input = input;
    }
}
