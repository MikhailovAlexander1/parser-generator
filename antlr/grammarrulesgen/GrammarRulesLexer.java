// Generated from /Users/admikhailov/IdeaProjects/parserGen/ANTLR/GrammarRules.g4 by ANTLR 4.13.1
package grammarrulesgen;

    import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
    import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class GrammarRulesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NAME=1, TERM=2, LETTER=3, OR=4, COLON=5, EQUAL=6, SEMICOLON=7, COMMA=8, 
		LPAREN=9, RPAREN=10, LBRACKET=11, RBRACKET=12, LBRACE=13, RBRACE=14, NEWLINE=15, 
		TAB=16, CLASS=17, STCODE=18, ARGCODE=19, STRING=20, REGEXP=21, WHITESPACE=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"NAME", "TERM", "LETTER", "OR", "COLON", "EQUAL", "SEMICOLON", "COMMA", 
			"LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "LBRACE", "RBRACE", "NEWLINE", 
			"TAB", "CLASS", "STCODE", "ARGCODE", "STRING", "REGEXP", "WHITESPACE"
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


	public GrammarRulesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GrammarRules.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0016\u008c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0001\u0000\u0001\u0000\u0005\u00000\b\u0000"+
		"\n\u0000\f\u00003\t\u0000\u0001\u0001\u0001\u0001\u0005\u00017\b\u0001"+
		"\n\u0001\f\u0001:\t\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e"+
		"\u0003\u000eU\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010^\b\u0010\n\u0010\f\u0010"+
		"a\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011"+
		"g\b\u0011\n\u0011\f\u0011j\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012q\b\u0012\n\u0012\f\u0012t\t\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0004\u0013"+
		"{\b\u0013\u000b\u0013\f\u0013|\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0004\u0014\u0083\b\u0014\u000b\u0014\f\u0014\u0084\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001_\u0000"+
		"\u0016\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016\u0001"+
		"\u0000\u0007\u0001\u0000az\u0001\u0000AZ\u0002\u0000AZaz\u0002\u0000\n"+
		"\n\r\r\u0002\u0000{{}}\u0001\u0000\'\'\u0001\u0000//\u0093\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001"+
		"\u0000\u0000\u0000\u0001-\u0001\u0000\u0000\u0000\u00034\u0001\u0000\u0000"+
		"\u0000\u0005;\u0001\u0000\u0000\u0000\u0007=\u0001\u0000\u0000\u0000\t"+
		"?\u0001\u0000\u0000\u0000\u000bA\u0001\u0000\u0000\u0000\rC\u0001\u0000"+
		"\u0000\u0000\u000fE\u0001\u0000\u0000\u0000\u0011G\u0001\u0000\u0000\u0000"+
		"\u0013I\u0001\u0000\u0000\u0000\u0015K\u0001\u0000\u0000\u0000\u0017M"+
		"\u0001\u0000\u0000\u0000\u0019O\u0001\u0000\u0000\u0000\u001bQ\u0001\u0000"+
		"\u0000\u0000\u001dT\u0001\u0000\u0000\u0000\u001fX\u0001\u0000\u0000\u0000"+
		"!Z\u0001\u0000\u0000\u0000#d\u0001\u0000\u0000\u0000%m\u0001\u0000\u0000"+
		"\u0000\'x\u0001\u0000\u0000\u0000)\u0080\u0001\u0000\u0000\u0000+\u0088"+
		"\u0001\u0000\u0000\u0000-1\u0007\u0000\u0000\u0000.0\u0003\u0005\u0002"+
		"\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000\u00001/\u0001\u0000"+
		"\u0000\u000012\u0001\u0000\u0000\u00002\u0002\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000048\u0007\u0001\u0000\u000057\u0003\u0005\u0002"+
		"\u000065\u0001\u0000\u0000\u00007:\u0001\u0000\u0000\u000086\u0001\u0000"+
		"\u0000\u000089\u0001\u0000\u0000\u00009\u0004\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000;<\u0007\u0002\u0000\u0000<\u0006\u0001\u0000"+
		"\u0000\u0000=>\u0005|\u0000\u0000>\b\u0001\u0000\u0000\u0000?@\u0005:"+
		"\u0000\u0000@\n\u0001\u0000\u0000\u0000AB\u0005=\u0000\u0000B\f\u0001"+
		"\u0000\u0000\u0000CD\u0005;\u0000\u0000D\u000e\u0001\u0000\u0000\u0000"+
		"EF\u0005,\u0000\u0000F\u0010\u0001\u0000\u0000\u0000GH\u0005(\u0000\u0000"+
		"H\u0012\u0001\u0000\u0000\u0000IJ\u0005)\u0000\u0000J\u0014\u0001\u0000"+
		"\u0000\u0000KL\u0005[\u0000\u0000L\u0016\u0001\u0000\u0000\u0000MN\u0005"+
		"]\u0000\u0000N\u0018\u0001\u0000\u0000\u0000OP\u0005{\u0000\u0000P\u001a"+
		"\u0001\u0000\u0000\u0000QR\u0005}\u0000\u0000R\u001c\u0001\u0000\u0000"+
		"\u0000SU\u0005\r\u0000\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VW\u0007\u0003\u0000\u0000W\u001e\u0001"+
		"\u0000\u0000\u0000XY\u0005\t\u0000\u0000Y \u0001\u0000\u0000\u0000Z[\u0005"+
		"@\u0000\u0000[_\u0003\u001d\u000e\u0000\\^\t\u0000\u0000\u0000]\\\u0001"+
		"\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000"+
		"_]\u0001\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000"+
		"\u0000bc\u0005@\u0000\u0000c\"\u0001\u0000\u0000\u0000dh\u0003\u0019\f"+
		"\u0000eg\b\u0004\u0000\u0000fe\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000"+
		"\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0003\u001b\r\u0000l$\u0001\u0000"+
		"\u0000\u0000mn\u0003\u0011\b\u0000nr\u0003\u0019\f\u0000oq\b\u0004\u0000"+
		"\u0000po\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000uv\u0003\u001b\r\u0000vw\u0003\u0013\t\u0000w&\u0001"+
		"\u0000\u0000\u0000xz\u0005\'\u0000\u0000y{\b\u0005\u0000\u0000zy\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0005\'\u0000"+
		"\u0000\u007f(\u0001\u0000\u0000\u0000\u0080\u0082\u0005/\u0000\u0000\u0081"+
		"\u0083\b\u0006\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0005/\u0000\u0000\u0087*\u0001\u0000\u0000\u0000\u0088\u0089\u0005 "+
		"\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0006\u0015"+
		"\u0000\u0000\u008b,\u0001\u0000\u0000\u0000\t\u000018T_hr|\u0084\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}