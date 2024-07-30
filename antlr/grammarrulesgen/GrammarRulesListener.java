// Generated from /Users/admikhailov/IdeaProjects/parserGen/ANTLR/GrammarRules.g4 by ANTLR 4.13.1
package grammarrulesgen;

    import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarRulesParser}.
 */
public interface GrammarRulesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#rules}.
	 * @param ctx the parse tree
	 */
	void enterRules(GrammarRulesParser.RulesContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#rules}.
	 * @param ctx the parse tree
	 */
	void exitRules(GrammarRulesParser.RulesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#helperClass}.
	 * @param ctx the parse tree
	 */
	void enterHelperClass(GrammarRulesParser.HelperClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#helperClass}.
	 * @param ctx the parse tree
	 */
	void exitHelperClass(GrammarRulesParser.HelperClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#lexerRuleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLexerRuleDeclaration(GrammarRulesParser.LexerRuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#lexerRuleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLexerRuleDeclaration(GrammarRulesParser.LexerRuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#parserRuleDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParserRuleDeclaration(GrammarRulesParser.ParserRuleDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#parserRuleDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParserRuleDeclaration(GrammarRulesParser.ParserRuleDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#signature}.
	 * @param ctx the parse tree
	 */
	void enterSignature(GrammarRulesParser.SignatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#signature}.
	 * @param ctx the parse tree
	 */
	void exitSignature(GrammarRulesParser.SignatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(GrammarRulesParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(GrammarRulesParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(GrammarRulesParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(GrammarRulesParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(GrammarRulesParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(GrammarRulesParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(GrammarRulesParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(GrammarRulesParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(GrammarRulesParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(GrammarRulesParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(GrammarRulesParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(GrammarRulesParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#nontermDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNontermDeclaration(GrammarRulesParser.NontermDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#nontermDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNontermDeclaration(GrammarRulesParser.NontermDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarRulesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarRulesParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarRulesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarRulesParser.TypeContext ctx);
}