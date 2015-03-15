package com.queryToAST.app.QueryLanguage;

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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, SELECT=20, FROM=21, WHERE=22, ORDER_BY=23, OP_BOOL=24, 
		OP_IN=25, BOOL=26, STRING=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "SELECT", "FROM", "WHERE", "ORDER_BY", "OP_BOOL", "OP_IN", 
		"BOOL", "STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'!'", "'*'", "'import'", "'extend'", "'implement'", "'subclass'", 
		"'superclass'", "'subinterface'", "'superinterface'", "'type'", "'name'", 
		"'annotation'", "'='", "'!='", "'callmethod'", "'method'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "SELECT", "FROM", "WHERE", 
		"ORDER_BY", "OP_BOOL", "OP_IN", "BOOL", "STRING", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u0153\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u00da"+
		"\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u00e4\n\32\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0142\n\33\3\34\3\34\7\34\u0146\n"+
		"\34\f\34\16\34\u0149\13\34\3\34\3\34\3\35\6\35\u014e\n\35\r\35\16\35\u014f"+
		"\3\35\3\35\3\u0147\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36\3\2\25\4\2UUuu\4\2GGgg\4\2NNnn\4\2EEee\4\2VVvv\4\2"+
		"HHhh\4\2TTtt\4\2QQqq\4\2OOoo\4\2YYyy\4\2JJjj\4\2FFff\3\2\"\"\4\2DDdd\4"+
		"\2[[{{\4\2CCcc\4\2PPpp\4\2KKkk\5\2\13\f\17\17\"\"\u015f\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2"+
		"\2\7?\3\2\2\2\tA\3\2\2\2\13H\3\2\2\2\rO\3\2\2\2\17Y\3\2\2\2\21b\3\2\2"+
		"\2\23m\3\2\2\2\25z\3\2\2\2\27\u0089\3\2\2\2\31\u008e\3\2\2\2\33\u0093"+
		"\3\2\2\2\35\u009e\3\2\2\2\37\u00a0\3\2\2\2!\u00a3\3\2\2\2#\u00ae\3\2\2"+
		"\2%\u00b5\3\2\2\2\'\u00b7\3\2\2\2)\u00b9\3\2\2\2+\u00c0\3\2\2\2-\u00c5"+
		"\3\2\2\2/\u00cb\3\2\2\2\61\u00d9\3\2\2\2\63\u00e3\3\2\2\2\65\u0141\3\2"+
		"\2\2\67\u0143\3\2\2\29\u014d\3\2\2\2;<\7.\2\2<\4\3\2\2\2=>\7#\2\2>\6\3"+
		"\2\2\2?@\7,\2\2@\b\3\2\2\2AB\7k\2\2BC\7o\2\2CD\7r\2\2DE\7q\2\2EF\7t\2"+
		"\2FG\7v\2\2G\n\3\2\2\2HI\7g\2\2IJ\7z\2\2JK\7v\2\2KL\7g\2\2LM\7p\2\2MN"+
		"\7f\2\2N\f\3\2\2\2OP\7k\2\2PQ\7o\2\2QR\7r\2\2RS\7n\2\2ST\7g\2\2TU\7o\2"+
		"\2UV\7g\2\2VW\7p\2\2WX\7v\2\2X\16\3\2\2\2YZ\7u\2\2Z[\7w\2\2[\\\7d\2\2"+
		"\\]\7e\2\2]^\7n\2\2^_\7c\2\2_`\7u\2\2`a\7u\2\2a\20\3\2\2\2bc\7u\2\2cd"+
		"\7w\2\2de\7r\2\2ef\7g\2\2fg\7t\2\2gh\7e\2\2hi\7n\2\2ij\7c\2\2jk\7u\2\2"+
		"kl\7u\2\2l\22\3\2\2\2mn\7u\2\2no\7w\2\2op\7d\2\2pq\7k\2\2qr\7p\2\2rs\7"+
		"v\2\2st\7g\2\2tu\7t\2\2uv\7h\2\2vw\7c\2\2wx\7e\2\2xy\7g\2\2y\24\3\2\2"+
		"\2z{\7u\2\2{|\7w\2\2|}\7r\2\2}~\7g\2\2~\177\7t\2\2\177\u0080\7k\2\2\u0080"+
		"\u0081\7p\2\2\u0081\u0082\7v\2\2\u0082\u0083\7g\2\2\u0083\u0084\7t\2\2"+
		"\u0084\u0085\7h\2\2\u0085\u0086\7c\2\2\u0086\u0087\7e\2\2\u0087\u0088"+
		"\7g\2\2\u0088\26\3\2\2\2\u0089\u008a\7v\2\2\u008a\u008b\7{\2\2\u008b\u008c"+
		"\7r\2\2\u008c\u008d\7g\2\2\u008d\30\3\2\2\2\u008e\u008f\7p\2\2\u008f\u0090"+
		"\7c\2\2\u0090\u0091\7o\2\2\u0091\u0092\7g\2\2\u0092\32\3\2\2\2\u0093\u0094"+
		"\7c\2\2\u0094\u0095\7p\2\2\u0095\u0096\7p\2\2\u0096\u0097\7q\2\2\u0097"+
		"\u0098\7v\2\2\u0098\u0099\7c\2\2\u0099\u009a\7v\2\2\u009a\u009b\7k\2\2"+
		"\u009b\u009c\7q\2\2\u009c\u009d\7p\2\2\u009d\34\3\2\2\2\u009e\u009f\7"+
		"?\2\2\u009f\36\3\2\2\2\u00a0\u00a1\7#\2\2\u00a1\u00a2\7?\2\2\u00a2 \3"+
		"\2\2\2\u00a3\u00a4\7e\2\2\u00a4\u00a5\7c\2\2\u00a5\u00a6\7n\2\2\u00a6"+
		"\u00a7\7n\2\2\u00a7\u00a8\7o\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7v\2\2"+
		"\u00aa\u00ab\7j\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad\7f\2\2\u00ad\"\3\2"+
		"\2\2\u00ae\u00af\7o\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2"+
		"\7j\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7f\2\2\u00b4$\3\2\2\2\u00b5\u00b6"+
		"\7*\2\2\u00b6&\3\2\2\2\u00b7\u00b8\7+\2\2\u00b8(\3\2\2\2\u00b9\u00ba\t"+
		"\2\2\2\u00ba\u00bb\t\3\2\2\u00bb\u00bc\t\4\2\2\u00bc\u00bd\t\3\2\2\u00bd"+
		"\u00be\t\5\2\2\u00be\u00bf\t\6\2\2\u00bf*\3\2\2\2\u00c0\u00c1\t\7\2\2"+
		"\u00c1\u00c2\t\b\2\2\u00c2\u00c3\t\t\2\2\u00c3\u00c4\t\n\2\2\u00c4,\3"+
		"\2\2\2\u00c5\u00c6\t\13\2\2\u00c6\u00c7\t\f\2\2\u00c7\u00c8\t\3\2\2\u00c8"+
		"\u00c9\t\b\2\2\u00c9\u00ca\t\3\2\2\u00ca.\3\2\2\2\u00cb\u00cc\t\t\2\2"+
		"\u00cc\u00cd\t\b\2\2\u00cd\u00ce\t\r\2\2\u00ce\u00cf\t\3\2\2\u00cf\u00d0"+
		"\t\b\2\2\u00d0\u00d1\t\16\2\2\u00d1\u00d2\t\17\2\2\u00d2\u00d3\t\20\2"+
		"\2\u00d3\60\3\2\2\2\u00d4\u00d5\t\21\2\2\u00d5\u00d6\t\22\2\2\u00d6\u00da"+
		"\t\r\2\2\u00d7\u00d8\t\t\2\2\u00d8\u00da\t\b\2\2\u00d9\u00d4\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\62\3\2\2\2\u00db\u00dc\t\23\2\2\u00dc\u00e4\t\22"+
		"\2\2\u00dd\u00de\t\22\2\2\u00de\u00df\t\t\2\2\u00df\u00e0\t\6\2\2\u00e0"+
		"\u00e1\t\16\2\2\u00e1\u00e2\t\23\2\2\u00e2\u00e4\t\22\2\2\u00e3\u00db"+
		"\3\2\2\2\u00e3\u00dd\3\2\2\2\u00e4\64\3\2\2\2\u00e5\u00e6\7k\2\2\u00e6"+
		"\u00e7\7p\2\2\u00e7\u00e8\7v\2\2\u00e8\u00e9\7g\2\2\u00e9\u00ea\7t\2\2"+
		"\u00ea\u00eb\7h\2\2\u00eb\u00ec\7c\2\2\u00ec\u00ed\7e\2\2\u00ed\u0142"+
		"\7g\2\2\u00ee\u00ef\7u\2\2\u00ef\u00f0\7w\2\2\u00f0\u00f1\7d\2\2\u00f1"+
		"\u00f2\7k\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7g\2\2"+
		"\u00f5\u00f6\7t\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9"+
		"\7e\2\2\u00f9\u0142\7g\2\2\u00fa\u00fb\7u\2\2\u00fb\u00fc\7w\2\2\u00fc"+
		"\u00fd\7r\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7k\2\2"+
		"\u0100\u0101\7p\2\2\u0101\u0102\7v\2\2\u0102\u0103\7g\2\2\u0103\u0104"+
		"\7t\2\2\u0104\u0105\7h\2\2\u0105\u0106\7c\2\2\u0106\u0107\7e\2\2\u0107"+
		"\u0142\7g\2\2\u0108\u0109\7e\2\2\u0109\u010a\7n\2\2\u010a\u010b\7c\2\2"+
		"\u010b\u010c\7u\2\2\u010c\u0142\7u\2\2\u010d\u010e\7u\2\2\u010e\u010f"+
		"\7w\2\2\u010f\u0110\7d\2\2\u0110\u0111\7e\2\2\u0111\u0112\7n\2\2\u0112"+
		"\u0113\7c\2\2\u0113\u0114\7u\2\2\u0114\u0142\7u\2\2\u0115\u0116\7u\2\2"+
		"\u0116\u0117\7w\2\2\u0117\u0118\7r\2\2\u0118\u0119\7g\2\2\u0119\u011a"+
		"\7t\2\2\u011a\u011b\7e\2\2\u011b\u011c\7n\2\2\u011c\u011d\7c\2\2\u011d"+
		"\u011e\7u\2\2\u011e\u0142\7u\2\2\u011f\u0120\7c\2\2\u0120\u0121\7d\2\2"+
		"\u0121\u0122\7u\2\2\u0122\u0123\7v\2\2\u0123\u0124\7t\2\2\u0124\u0125"+
		"\7c\2\2\u0125\u0126\7e\2\2\u0126\u0142\7v\2\2\u0127\u0128\7g\2\2\u0128"+
		"\u0129\7p\2\2\u0129\u012a\7w\2\2\u012a\u0142\7o\2\2\u012b\u012c\7c\2\2"+
		"\u012c\u012d\7p\2\2\u012d\u012e\7p\2\2\u012e\u012f\7q\2\2\u012f\u0130"+
		"\7v\2\2\u0130\u0131\7c\2\2\u0131\u0132\7v\2\2\u0132\u0133\7k\2\2\u0133"+
		"\u0134\7q\2\2\u0134\u0142\7p\2\2\u0135\u0136\7u\2\2\u0136\u0137\7w\2\2"+
		"\u0137\u0138\7d\2\2\u0138\u0139\7k\2\2\u0139\u013a\7p\2\2\u013a\u013b"+
		"\7v\2\2\u013b\u013c\7g\2\2\u013c\u013d\7t\2\2\u013d\u013e\7h\2\2\u013e"+
		"\u013f\7c\2\2\u013f\u0140\7e\2\2\u0140\u0142\7g\2\2\u0141\u00e5\3\2\2"+
		"\2\u0141\u00ee\3\2\2\2\u0141\u00fa\3\2\2\2\u0141\u0108\3\2\2\2\u0141\u010d"+
		"\3\2\2\2\u0141\u0115\3\2\2\2\u0141\u011f\3\2\2\2\u0141\u0127\3\2\2\2\u0141"+
		"\u012b\3\2\2\2\u0141\u0135\3\2\2\2\u0142\66\3\2\2\2\u0143\u0147\7$\2\2"+
		"\u0144\u0146\13\2\2\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a"+
		"\u014b\7$\2\2\u014b8\3\2\2\2\u014c\u014e\t\24\2\2\u014d\u014c\3\2\2\2"+
		"\u014e\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0151\u0152\b\35\2\2\u0152:\3\2\2\2\b\2\u00d9\u00e3\u0141\u0147"+
		"\u014f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}