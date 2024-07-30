// Generated from /Users/admikhailov/IdeaProjects/parserGen/ANTLR/GrammarRules.g4 by ANTLR 4.13.1
package grammarrulesgen;

    import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarRulesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarRulesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRules(GrammarRulesParser.RulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#helperClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHelperClass(GrammarRulesParser.HelperClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#lexerRuleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLexerRuleDeclaration(GrammarRulesParser.LexerRuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#parserRuleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParserRuleDeclaration(GrammarRulesParser.ParserRuleDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#signature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignature(GrammarRulesParser.SignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(GrammarRulesParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(GrammarRulesParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(GrammarRulesParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(GrammarRulesParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(GrammarRulesParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequence(GrammarRulesParser.SequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#nontermDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNontermDeclaration(GrammarRulesParser.NontermDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarRulesParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GrammarRulesParser.TypeContext ctx);
}