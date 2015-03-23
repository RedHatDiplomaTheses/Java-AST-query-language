// Generated from query.g by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class queryLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SELECT=1, FROM=2, WHERE=3, AND=4, OPERATORS=5, ORDER_BY=6, CC=7, MM=8, 
		PP=9, COLON=10, COMMA=11, LBRACKET=12, RBRACKET=13, LPAREN=14, RPAREN=15, 
		LBRACE=16, RBRACE=17, EXCLAMANTION=18, STAR=19, AT=20, DOT=21, INT=22, 
		NAME=23, STRING=24, WS=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "FROM", "WHERE", "AND", "OPERATORS", "ORDER_BY", "CC", "MM", 
		"PP", "COLON", "COMMA", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "EXCLAMANTION", "STAR", "AT", "DOT", "INT", "DIGIT", "NAME", 
		"LETTER", "STRING", "ESC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "':'", "','", 
		"'['", "']'", "'('", "')'", "'{'", "'}'", "'!'", "'*'", "'@'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "FROM", "WHERE", "AND", "OPERATORS", "ORDER_BY", "CC", 
		"MM", "PP", "COLON", "COMMA", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "EXCLAMANTION", "STAR", "AT", "DOT", "INT", "NAME", 
		"STRING", "WS"
	};
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


	public queryLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "query.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u00a7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\5\6X\n\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7"+
		"c\13\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\6\27\u0087\n\27\r\27\16\27\u0088\3\30\3\30\3\31"+
		"\6\31\u008e\n\31\r\31\16\31\u008f\3\32\3\32\3\33\3\33\3\33\7\33\u0097"+
		"\n\33\f\33\16\33\u009a\13\33\3\33\3\33\3\34\3\34\3\34\3\35\6\35\u00a2"+
		"\n\35\r\35\16\35\u00a3\3\35\3\35\3\u0098\2\36\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\2\61\31\63\2\65\32\67\29\33\3\2\27\4\2UUuu\4\2GGgg\4\2NNnn\4"+
		"\2EEee\4\2VVvv\4\2HHhh\4\2TTtt\4\2QQqq\4\2OOoo\4\2YYyy\4\2JJjj\4\2CCc"+
		"c\4\2PPpp\4\2FFff\4\2KKkk\4\2DDdd\4\2[[{{\4\2RRrr\4\2C\\c|\b\2$$^^ddp"+
		"pttvv\5\2\13\f\17\17\"\"\u00ac\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2\61\3\2\2\2\2\65\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5"+
		"B\3\2\2\2\7G\3\2\2\2\tM\3\2\2\2\13W\3\2\2\2\rY\3\2\2\2\17g\3\2\2\2\21"+
		"i\3\2\2\2\23k\3\2\2\2\25m\3\2\2\2\27o\3\2\2\2\31q\3\2\2\2\33s\3\2\2\2"+
		"\35u\3\2\2\2\37w\3\2\2\2!y\3\2\2\2#{\3\2\2\2%}\3\2\2\2\'\177\3\2\2\2)"+
		"\u0081\3\2\2\2+\u0083\3\2\2\2-\u0086\3\2\2\2/\u008a\3\2\2\2\61\u008d\3"+
		"\2\2\2\63\u0091\3\2\2\2\65\u0093\3\2\2\2\67\u009d\3\2\2\29\u00a1\3\2\2"+
		"\2;<\t\2\2\2<=\t\3\2\2=>\t\4\2\2>?\t\3\2\2?@\t\5\2\2@A\t\6\2\2A\4\3\2"+
		"\2\2BC\t\7\2\2CD\t\b\2\2DE\t\t\2\2EF\t\n\2\2F\6\3\2\2\2GH\t\13\2\2HI\t"+
		"\f\2\2IJ\t\3\2\2JK\t\b\2\2KL\t\3\2\2L\b\3\2\2\2MN\t\r\2\2NO\t\16\2\2O"+
		"P\t\17\2\2P\n\3\2\2\2QX\7?\2\2RS\7#\2\2SX\7?\2\2TX\7\u0080\2\2UV\t\20"+
		"\2\2VX\t\16\2\2WQ\3\2\2\2WR\3\2\2\2WT\3\2\2\2WU\3\2\2\2X\f\3\2\2\2YZ\t"+
		"\t\2\2Z[\t\b\2\2[\\\t\17\2\2\\]\t\3\2\2]a\t\b\2\2^`\7\"\2\2_^\3\2\2\2"+
		"`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\t\21\2\2ef\t\22\2"+
		"\2f\16\3\2\2\2gh\t\5\2\2h\20\3\2\2\2ij\t\n\2\2j\22\3\2\2\2kl\t\23\2\2"+
		"l\24\3\2\2\2mn\7<\2\2n\26\3\2\2\2op\7.\2\2p\30\3\2\2\2qr\7]\2\2r\32\3"+
		"\2\2\2st\7_\2\2t\34\3\2\2\2uv\7*\2\2v\36\3\2\2\2wx\7+\2\2x \3\2\2\2yz"+
		"\7}\2\2z\"\3\2\2\2{|\7\177\2\2|$\3\2\2\2}~\7#\2\2~&\3\2\2\2\177\u0080"+
		"\7,\2\2\u0080(\3\2\2\2\u0081\u0082\7B\2\2\u0082*\3\2\2\2\u0083\u0084\7"+
		"\60\2\2\u0084,\3\2\2\2\u0085\u0087\5/\30\2\u0086\u0085\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089.\3\2\2\2\u008a"+
		"\u008b\4\62;\2\u008b\60\3\2\2\2\u008c\u008e\5\63\32\2\u008d\u008c\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\62\3\2\2\2\u0091\u0092\t\24\2\2\u0092\64\3\2\2\2\u0093\u0098\7$\2\2\u0094"+
		"\u0097\5\67\34\2\u0095\u0097\13\2\2\2\u0096\u0094\3\2\2\2\u0096\u0095"+
		"\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0098\3\2\2\2\u009b\u009c\7$\2\2\u009c\66\3\2\2\2"+
		"\u009d\u009e\7^\2\2\u009e\u009f\t\25\2\2\u009f8\3\2\2\2\u00a0\u00a2\t"+
		"\26\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\b\35\2\2\u00a6:\3\2\2\2"+
		"\n\2Wa\u0088\u008f\u0096\u0098\u00a3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}