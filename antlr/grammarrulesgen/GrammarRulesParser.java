// Generated from /Users/admikhailov/IdeaProjects/parserGen/ANTLR/GrammarRules.g4 by ANTLR 4.13.1
package grammarrulesgen;

    import myparserrulesinformation.*;

    import java.util.ArrayList;

    import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
    import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarRulesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAME=1, TERM=2, LETTER=3, OR=4, COLON=5, EQUAL=6, SEMICOLON=7, COMMA=8, 
		LPAREN=9, RPAREN=10, LBRACKET=11, RBRACKET=12, LBRACE=13, RBRACE=14, NEWLINE=15, 
		TAB=16, CLASS=17, STCODE=18, ARGCODE=19, STRING=20, REGEXP=21, WHITESPACE=22;
	public static final int
		RULE_rules = 0, RULE_helperClass = 1, RULE_lexerRuleDeclaration = 2, RULE_parserRuleDeclaration = 3, 
		RULE_signature = 4, RULE_input = 5, RULE_return = 6, RULE_argument = 7, 
		RULE_arguments = 8, RULE_statements = 9, RULE_sequence = 10, RULE_nontermDeclaration = 11, 
		RULE_type = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"rules", "helperClass", "lexerRuleDeclaration", "parserRuleDeclaration", 
			"signature", "input", "return", "argument", "arguments", "statements", 
			"sequence", "nontermDeclaration", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'|'", "':'", "'='", "';'", "','", "'('", "')'", 
			"'['", "']'", "'{'", "'}'", null, "'\\t'", null, null, null, null, null, 
			"' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "NAME", "TERM", "LETTER", "OR", "COLON", "EQUAL", "SEMICOLON", 
			"COMMA", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", 
			"NEWLINE", "TAB", "CLASS", "STCODE", "ARGCODE", "STRING", "REGEXP", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "GrammarRules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarRulesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RulesContext extends ParserRuleContext {
		public List<HelperClassContext> helperClass() {
			return getRuleContexts(HelperClassContext.class);
		}
		public HelperClassContext helperClass(int i) {
			return getRuleContext(HelperClassContext.class,i);
		}
		public List<LexerRuleDeclarationContext> lexerRuleDeclaration() {
			return getRuleContexts(LexerRuleDeclarationContext.class);
		}
		public LexerRuleDeclarationContext lexerRuleDeclaration(int i) {
			return getRuleContext(LexerRuleDeclarationContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(GrammarRulesParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GrammarRulesParser.NEWLINE, i);
		}
		public List<ParserRuleDeclarationContext> parserRuleDeclaration() {
			return getRuleContexts(ParserRuleDeclarationContext.class);
		}
		public ParserRuleDeclarationContext parserRuleDeclaration(int i) {
			return getRuleContext(ParserRuleDeclarationContext.class,i);
		}
		public RulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterRules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitRules(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitRules(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RulesContext rules() throws RecognitionException {
		RulesContext _localctx = new RulesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rules);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(26);
				helperClass();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				lexerRuleDeclaration();
				setState(34); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(33);
						match(NEWLINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(36); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TERM );
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(42);
				match(NEWLINE);
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(48);
				parserRuleDeclaration();
				setState(50); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(49);
					match(NEWLINE);
					}
					}
					setState(52); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HelperClassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(GrammarRulesParser.CLASS, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GrammarRulesParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GrammarRulesParser.NEWLINE, i);
		}
		public HelperClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_helperClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterHelperClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitHelperClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitHelperClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HelperClassContext helperClass() throws RecognitionException {
		HelperClassContext _localctx = new HelperClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_helperClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(CLASS);
			setState(60); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(59);
				match(NEWLINE);
				}
				}
				setState(62); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LexerRuleDeclarationContext extends ParserRuleContext {
		public TerminalNode TERM() { return getToken(GrammarRulesParser.TERM, 0); }
		public TerminalNode COLON() { return getToken(GrammarRulesParser.COLON, 0); }
		public TerminalNode SEMICOLON() { return getToken(GrammarRulesParser.SEMICOLON, 0); }
		public TerminalNode STRING() { return getToken(GrammarRulesParser.STRING, 0); }
		public TerminalNode REGEXP() { return getToken(GrammarRulesParser.REGEXP, 0); }
		public LexerRuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexerRuleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterLexerRuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitLexerRuleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitLexerRuleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexerRuleDeclarationContext lexerRuleDeclaration() throws RecognitionException {
		LexerRuleDeclarationContext _localctx = new LexerRuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lexerRuleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(TERM);
			setState(65);
			match(COLON);
			setState(66);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==REGEXP) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(67);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParserRuleDeclarationContext extends ParserRuleContext {
		public SignatureContext signature() {
			return getRuleContext(SignatureContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ParserRuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parserRuleDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterParserRuleDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitParserRuleDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitParserRuleDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParserRuleDeclarationContext parserRuleDeclaration() throws RecognitionException {
		ParserRuleDeclarationContext _localctx = new ParserRuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parserRuleDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			signature();
			setState(70);
			statements();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SignatureContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(GrammarRulesParser.NAME, 0); }
		public TerminalNode NEWLINE() { return getToken(GrammarRulesParser.NEWLINE, 0); }
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public ReturnContext return_() {
			return getRuleContext(ReturnContext.class,0);
		}
		public SignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterSignature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitSignature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SignatureContext signature() throws RecognitionException {
		SignatureContext _localctx = new SignatureContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_signature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(NAME);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(73);
				input();
				}
			}

			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACKET) {
				{
				setState(76);
				return_();
				}
			}

			setState(79);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputContext extends ParserRuleContext {
		public ArrayList<Argument> args;
		public ArgumentsContext arguments;
		public TerminalNode LPAREN() { return getToken(GrammarRulesParser.LPAREN, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(GrammarRulesParser.RPAREN, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_input);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(LPAREN);
			setState(82);
			((InputContext)_localctx).arguments = arguments();
			((InputContext)_localctx).args =  ((InputContext)_localctx).arguments.args;
			setState(84);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends ParserRuleContext {
		public Argument oneArg;
		public ArgumentContext argument;
		public TerminalNode LBRACKET() { return getToken(GrammarRulesParser.LBRACKET, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(GrammarRulesParser.RBRACKET, 0); }
		public ReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnContext return_() throws RecognitionException {
		ReturnContext _localctx = new ReturnContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(LBRACKET);
			setState(87);
			((ReturnContext)_localctx).argument = argument();
			((ReturnContext)_localctx).oneArg =  ((ReturnContext)_localctx).argument.arg;
			setState(89);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentContext extends ParserRuleContext {
		public Argument arg;
		public TypeContext type;
		public Token NAME;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NAME() { return getToken(GrammarRulesParser.NAME, 0); }
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			((ArgumentContext)_localctx).type = type();
			setState(92);
			((ArgumentContext)_localctx).NAME = match(NAME);
			((ArgumentContext)_localctx).arg =  new Argument(((ArgumentContext)_localctx).type.typeName, (((ArgumentContext)_localctx).NAME!=null?((ArgumentContext)_localctx).NAME.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public ArrayList<Argument> args;
		public ArgumentContext a;
		public ArgumentContext b;
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GrammarRulesParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GrammarRulesParser.COMMA, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			((ArgumentsContext)_localctx).a = argument();
			((ArgumentsContext)_localctx).args =  new ArrayList<>(); _localctx.args.add(((ArgumentsContext)_localctx).a.arg);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(97);
				match(COMMA);
				setState(98);
				((ArgumentsContext)_localctx).b = argument();
				_localctx.args.add(((ArgumentsContext)_localctx).b.arg);
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public ArrayList<Sequence> rights;
		public SequenceContext a;
		public SequenceContext b;
		public List<TerminalNode> TAB() { return getTokens(GrammarRulesParser.TAB); }
		public TerminalNode TAB(int i) {
			return getToken(GrammarRulesParser.TAB, i);
		}
		public TerminalNode COLON() { return getToken(GrammarRulesParser.COLON, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(GrammarRulesParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GrammarRulesParser.NEWLINE, i);
		}
		public TerminalNode SEMICOLON() { return getToken(GrammarRulesParser.SEMICOLON, 0); }
		public List<SequenceContext> sequence() {
			return getRuleContexts(SequenceContext.class);
		}
		public SequenceContext sequence(int i) {
			return getRuleContext(SequenceContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(GrammarRulesParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(GrammarRulesParser.OR, i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(TAB);
			setState(107);
			match(COLON);
			setState(108);
			((StatementsContext)_localctx).a = sequence();
			((StatementsContext)_localctx).rights =  new ArrayList<>(); _localctx.rights.add(((StatementsContext)_localctx).a.seq);
			setState(110);
			match(NEWLINE);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(111);
					match(TAB);
					setState(112);
					match(OR);
					setState(113);
					((StatementsContext)_localctx).b = sequence();
					_localctx.rights.add(((StatementsContext)_localctx).b.seq);
					setState(115);
					match(NEWLINE);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(122);
			match(TAB);
			setState(123);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SequenceContext extends ParserRuleContext {
		public Sequence seq;
		public NontermDeclarationContext nontermDeclaration;
		public Token TERM;
		public Token STCODE;
		public List<NontermDeclarationContext> nontermDeclaration() {
			return getRuleContexts(NontermDeclarationContext.class);
		}
		public NontermDeclarationContext nontermDeclaration(int i) {
			return getRuleContext(NontermDeclarationContext.class,i);
		}
		public List<TerminalNode> TERM() { return getTokens(GrammarRulesParser.TERM); }
		public TerminalNode TERM(int i) {
			return getToken(GrammarRulesParser.TERM, i);
		}
		public List<TerminalNode> STCODE() { return getTokens(GrammarRulesParser.STCODE); }
		public TerminalNode STCODE(int i) {
			return getToken(GrammarRulesParser.STCODE, i);
		}
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((SequenceContext)_localctx).seq =  new Sequence();
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(133);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NAME:
					{
					setState(126);
					((SequenceContext)_localctx).nontermDeclaration = nontermDeclaration();
					_localctx.seq.addDef(((SequenceContext)_localctx).nontermDeclaration.nonTermWithAttrs);
					}
					break;
				case TERM:
					{
					setState(129);
					((SequenceContext)_localctx).TERM = match(TERM);
					_localctx.seq.addDef(new Definition(new Term((((SequenceContext)_localctx).TERM!=null?((SequenceContext)_localctx).TERM.getText():null))));
					}
					break;
				case STCODE:
					{
					setState(131);
					((SequenceContext)_localctx).STCODE = match(STCODE);
					_localctx.seq.addDef(new Definition(new Code((((SequenceContext)_localctx).STCODE!=null?((SequenceContext)_localctx).STCODE.getText():null))));
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 262150L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NontermDeclarationContext extends ParserRuleContext {
		public Definition nonTermWithAttrs;
		public Token NAME;
		public Token ARGCODE;
		public TerminalNode NAME() { return getToken(GrammarRulesParser.NAME, 0); }
		public TerminalNode ARGCODE() { return getToken(GrammarRulesParser.ARGCODE, 0); }
		public NontermDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nontermDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterNontermDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitNontermDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitNontermDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NontermDeclarationContext nontermDeclaration() throws RecognitionException {
		NontermDeclarationContext _localctx = new NontermDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nontermDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			((NontermDeclarationContext)_localctx).NAME = match(NAME);
			((NontermDeclarationContext)_localctx).nonTermWithAttrs =  new Definition(new NonTerm((((NontermDeclarationContext)_localctx).NAME!=null?((NontermDeclarationContext)_localctx).NAME.getText():null)));
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ARGCODE) {
				{
				setState(139);
				((NontermDeclarationContext)_localctx).ARGCODE = match(ARGCODE);
				_localctx.nonTermWithAttrs.setInput(new Code((((NontermDeclarationContext)_localctx).ARGCODE!=null?((NontermDeclarationContext)_localctx).ARGCODE.getText():null)));
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public String typeName;
		public Token NAME;
		public Token TERM;
		public TerminalNode NAME() { return getToken(GrammarRulesParser.NAME, 0); }
		public TerminalNode TERM() { return getToken(GrammarRulesParser.TERM, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarRulesListener ) ((GrammarRulesListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarRulesVisitor ) return ((GrammarRulesVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(143);
				((TypeContext)_localctx).NAME = match(NAME);
				((TypeContext)_localctx).typeName =  (((TypeContext)_localctx).NAME!=null?((TypeContext)_localctx).NAME.getText():null);
				}
				break;
			case TERM:
				{
				setState(145);
				((TypeContext)_localctx).TERM = match(TERM);
				((TypeContext)_localctx).typeName =  (((TypeContext)_localctx).TERM!=null?((TypeContext)_localctx).TERM.getText():null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0016\u0096\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0001\u0000\u0005\u0000\u001c\b\u0000\n\u0000\f\u0000"+
		"\u001f\t\u0000\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000\u000b\u0000"+
		"\f\u0000$\u0004\u0000\'\b\u0000\u000b\u0000\f\u0000(\u0001\u0000\u0005"+
		"\u0000,\b\u0000\n\u0000\f\u0000/\t\u0000\u0001\u0000\u0001\u0000\u0004"+
		"\u00003\b\u0000\u000b\u0000\f\u00004\u0004\u00007\b\u0000\u000b\u0000"+
		"\f\u00008\u0001\u0001\u0001\u0001\u0004\u0001=\b\u0001\u000b\u0001\f\u0001"+
		">\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004K\b\u0004"+
		"\u0001\u0004\u0003\u0004N\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bf"+
		"\b\b\n\b\f\bi\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\tv\b\t\n\t\f\ty\t\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0004\n\u0086\b\n\u000b\n\f\n\u0087\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u008e\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u0094\b\f\u0001\f\u0000\u0000\r\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0001\u0001\u0000\u0014\u0015"+
		"\u0098\u0000\u001d\u0001\u0000\u0000\u0000\u0002:\u0001\u0000\u0000\u0000"+
		"\u0004@\u0001\u0000\u0000\u0000\u0006E\u0001\u0000\u0000\u0000\bH\u0001"+
		"\u0000\u0000\u0000\nQ\u0001\u0000\u0000\u0000\fV\u0001\u0000\u0000\u0000"+
		"\u000e[\u0001\u0000\u0000\u0000\u0010_\u0001\u0000\u0000\u0000\u0012j"+
		"\u0001\u0000\u0000\u0000\u0014}\u0001\u0000\u0000\u0000\u0016\u0089\u0001"+
		"\u0000\u0000\u0000\u0018\u0093\u0001\u0000\u0000\u0000\u001a\u001c\u0003"+
		"\u0002\u0001\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001f\u0001"+
		"\u0000\u0000\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001"+
		"\u0000\u0000\u0000\u001e&\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000"+
		"\u0000\u0000 \"\u0003\u0004\u0002\u0000!#\u0005\u000f\u0000\u0000\"!\u0001"+
		"\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000"+
		"$%\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000\u0000& \u0001\u0000\u0000"+
		"\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000"+
		"\u0000\u0000)-\u0001\u0000\u0000\u0000*,\u0005\u000f\u0000\u0000+*\u0001"+
		"\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000.6\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000"+
		"\u000002\u0003\u0006\u0003\u000013\u0005\u000f\u0000\u000021\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u000057\u0001\u0000\u0000\u000060\u0001\u0000\u0000\u0000"+
		"78\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009\u0001\u0001\u0000\u0000\u0000:<\u0005\u0011\u0000\u0000;=\u0005"+
		"\u000f\u0000\u0000<;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		"><\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?\u0003\u0001\u0000"+
		"\u0000\u0000@A\u0005\u0002\u0000\u0000AB\u0005\u0005\u0000\u0000BC\u0007"+
		"\u0000\u0000\u0000CD\u0005\u0007\u0000\u0000D\u0005\u0001\u0000\u0000"+
		"\u0000EF\u0003\b\u0004\u0000FG\u0003\u0012\t\u0000G\u0007\u0001\u0000"+
		"\u0000\u0000HJ\u0005\u0001\u0000\u0000IK\u0003\n\u0005\u0000JI\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LN\u0003"+
		"\f\u0006\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001"+
		"\u0000\u0000\u0000OP\u0005\u000f\u0000\u0000P\t\u0001\u0000\u0000\u0000"+
		"QR\u0005\t\u0000\u0000RS\u0003\u0010\b\u0000ST\u0006\u0005\uffff\uffff"+
		"\u0000TU\u0005\n\u0000\u0000U\u000b\u0001\u0000\u0000\u0000VW\u0005\u000b"+
		"\u0000\u0000WX\u0003\u000e\u0007\u0000XY\u0006\u0006\uffff\uffff\u0000"+
		"YZ\u0005\f\u0000\u0000Z\r\u0001\u0000\u0000\u0000[\\\u0003\u0018\f\u0000"+
		"\\]\u0005\u0001\u0000\u0000]^\u0006\u0007\uffff\uffff\u0000^\u000f\u0001"+
		"\u0000\u0000\u0000_`\u0003\u000e\u0007\u0000`g\u0006\b\uffff\uffff\u0000"+
		"ab\u0005\b\u0000\u0000bc\u0003\u000e\u0007\u0000cd\u0006\b\uffff\uffff"+
		"\u0000df\u0001\u0000\u0000\u0000ea\u0001\u0000\u0000\u0000fi\u0001\u0000"+
		"\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u0011"+
		"\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jk\u0005\u0010\u0000"+
		"\u0000kl\u0005\u0005\u0000\u0000lm\u0003\u0014\n\u0000mn\u0006\t\uffff"+
		"\uffff\u0000nw\u0005\u000f\u0000\u0000op\u0005\u0010\u0000\u0000pq\u0005"+
		"\u0004\u0000\u0000qr\u0003\u0014\n\u0000rs\u0006\t\uffff\uffff\u0000s"+
		"t\u0005\u000f\u0000\u0000tv\u0001\u0000\u0000\u0000uo\u0001\u0000\u0000"+
		"\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000"+
		"\u0000\u0000xz\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000z{\u0005"+
		"\u0010\u0000\u0000{|\u0005\u0007\u0000\u0000|\u0013\u0001\u0000\u0000"+
		"\u0000}\u0085\u0006\n\uffff\uffff\u0000~\u007f\u0003\u0016\u000b\u0000"+
		"\u007f\u0080\u0006\n\uffff\uffff\u0000\u0080\u0086\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0005\u0002\u0000\u0000\u0082\u0086\u0006\n\uffff\uffff\u0000"+
		"\u0083\u0084\u0005\u0012\u0000\u0000\u0084\u0086\u0006\n\uffff\uffff\u0000"+
		"\u0085~\u0001\u0000\u0000\u0000\u0085\u0081\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u0015\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u0001\u0000\u0000\u008a"+
		"\u008d\u0006\u000b\uffff\uffff\u0000\u008b\u008c\u0005\u0013\u0000\u0000"+
		"\u008c\u008e\u0006\u000b\uffff\uffff\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0017\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0005\u0001\u0000\u0000\u0090\u0094\u0006\f\uffff\uffff"+
		"\u0000\u0091\u0092\u0005\u0002\u0000\u0000\u0092\u0094\u0006\f\uffff\uffff"+
		"\u0000\u0093\u008f\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0094\u0019\u0001\u0000\u0000\u0000\u000f\u001d$(-48>JMgw\u0085"+
		"\u0087\u008d\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}