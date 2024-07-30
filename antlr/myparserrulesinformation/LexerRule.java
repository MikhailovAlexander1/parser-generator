package myparserrulesinformation;

public class LexerRule {
    private final Term term;
    private final String definition;

    public LexerRule(Term term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public Term getName() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    public void print() {
        System.out.printf("%s: %s;%n", term.getName(), definition);
    }
}
