package myvisitors;

import grammarrulesgen.GrammarRulesBaseVisitor;
import grammarrulesgen.GrammarRulesParser;
import myparserrulesinformation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GrammarMyVisitor extends GrammarRulesBaseVisitor<Void> {
    private final ArrayList<String> supportClasses = new ArrayList<>();
    private final Set<Term> termSet = new HashSet<>();
    private final HashMap<String, String> tokens = new HashMap<>();
    private final HashMap<String, String> regexp = new HashMap<>();
    private final ArrayList<ParserRule> parserRules = new ArrayList<>();
    private int index = -1;

    private String getSubstring(String s, int begin) {
        return s.substring(begin, s.length() - 1);
    }

    @Override
    public Void visitHelperClass(GrammarRulesParser.HelperClassContext ctx) {
        supportClasses.add(getSubstring(ctx.CLASS().getText(), 2));
        return null;
    }

    @Override
    public Void visitLexerRuleDeclaration(GrammarRulesParser.LexerRuleDeclarationContext ctx) {
        Term term = new Term(ctx.TERM().getText());
        try {
            tokens.put(term.getName(), getSubstring(ctx.STRING().getText(), 1));
        } catch (NullPointerException e) {
            regexp.put(term.getName(), getSubstring(ctx.REGEXP().getText(), 1));
        }
        termSet.add(term);
        return null;
    }

    @Override
    public Void visitParserRuleDeclaration(GrammarRulesParser.ParserRuleDeclarationContext ctx) {
        index++;
        if (index > 0) {
            parserRules.add(new ParserRule(false));
        } else {
            parserRules.add(new ParserRule(true));
        }
        parserRules.get(index).setSequences(ctx.statements().rights);
        return super.visitParserRuleDeclaration(ctx);
    }

    @Override
    public Void visitSignature(GrammarRulesParser.SignatureContext ctx) {
        parserRules.get(index).setNonTerm(new NonTerm(ctx.NAME().getText()));
        try {
            parserRules.get(index).setInput(ctx.input().args);
        } catch (Exception ignore) {}
        try {
            parserRules.get(index).setReturnValue(ctx.return_().oneArg);
        } catch (Exception ignore) {}
        return super.visitSignature(ctx);
    }

    public ArrayList<String> getSupportClasses() {
        return supportClasses;
    }

    public Set<Term> getTermSet() {
        return termSet;
    }

    public HashMap<String, String> getTokens() {
        return tokens;
    }

    public HashMap<String, String> getRegexp() {
        return regexp;
    }

    public ArrayList<ParserRule> getParserRules() {
        return parserRules;
    }
}
