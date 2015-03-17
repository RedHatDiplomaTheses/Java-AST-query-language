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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, KEY_SELECT=15, KEY_PROP=16, 
		FROM=17, KEY_WHERE=18, KEY_OP_BOOL=19, KEY_OPERAND=20, KEY_OP_IN=21, KEY_BOOL=22, 
		CC=23, MM=24, PP=25, ORDER_BY=26, INT=27, STRING=28, WS=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "KEY_SELECT", "KEY_PROP", 
		"FROM", "KEY_WHERE", "KEY_OP_BOOL", "KEY_OPERAND", "KEY_OP_IN", "KEY_BOOL", 
		"CC", "MM", "PP", "ORDER_BY", "INT", "DIGIT", "STRING", "ESC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'!'", "'['", "']'", "'*'", "'('", "')'", "'@'", "'.'", "'name'", 
		"':'", "'arg'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "KEY_SELECT", "KEY_PROP", "FROM", "KEY_WHERE", "KEY_OP_BOOL", 
		"KEY_OPERAND", "KEY_OP_IN", "KEY_BOOL", "CC", "MM", "PP", "ORDER_BY", 
		"INT", "STRING", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u0158\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0096\n\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\5\24\u00ab\n\24\3\25\3\25\3\25\5\25\u00b0\n\25\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00ba\n\26\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u012d"+
		"\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\34\6\34\u013f\n\34\r\34\16\34\u0140\3\35\3\35\3\36\3\36\3"+
		"\36\7\36\u0148\n\36\f\36\16\36\u014b\13\36\3\36\3\36\3\37\3\37\3\37\3"+
		" \6 \u0153\n \r \16 \u0154\3 \3 \3\u0149\2!\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\2;\36=\2?\37\3\2\33\4\2UUuu\4\2G"+
		"Ggg\4\2NNnn\4\2EEee\4\2VVvv\4\2KKkk\4\2OOoo\4\2RRrr\4\2QQqq\4\2TTtt\4"+
		"\2ZZzz\4\2PPpp\4\2FFff\4\2[[{{\4\2CCcc\4\2JJjj\4\2HHhh\4\2SSss\4\2YYy"+
		"y\3\2\"\"\4\2WWww\4\2DDdd\4\2XXxx\b\2$$^^ddppttvv\5\2\13\f\17\17\"\"\u0171"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2;\3\2\2\2\2?\3"+
		"\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2"+
		"\2\2\17M\3\2\2\2\21O\3\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27X\3\2\2\2\31Z\3"+
		"\2\2\2\33^\3\2\2\2\35`\3\2\2\2\37b\3\2\2\2!\u0095\3\2\2\2#\u0097\3\2\2"+
		"\2%\u009c\3\2\2\2\'\u00aa\3\2\2\2)\u00af\3\2\2\2+\u00b9\3\2\2\2-\u012c"+
		"\3\2\2\2/\u012e\3\2\2\2\61\u0130\3\2\2\2\63\u0132\3\2\2\2\65\u0134\3\2"+
		"\2\2\67\u013e\3\2\2\29\u0142\3\2\2\2;\u0144\3\2\2\2=\u014e\3\2\2\2?\u0152"+
		"\3\2\2\2AB\7.\2\2B\4\3\2\2\2CD\7#\2\2D\6\3\2\2\2EF\7]\2\2F\b\3\2\2\2G"+
		"H\7_\2\2H\n\3\2\2\2IJ\7,\2\2J\f\3\2\2\2KL\7*\2\2L\16\3\2\2\2MN\7+\2\2"+
		"N\20\3\2\2\2OP\7B\2\2P\22\3\2\2\2QR\7\60\2\2R\24\3\2\2\2ST\7p\2\2TU\7"+
		"c\2\2UV\7o\2\2VW\7g\2\2W\26\3\2\2\2XY\7<\2\2Y\30\3\2\2\2Z[\7c\2\2[\\\7"+
		"t\2\2\\]\7i\2\2]\32\3\2\2\2^_\7}\2\2_\34\3\2\2\2`a\7\177\2\2a\36\3\2\2"+
		"\2bc\t\2\2\2cd\t\3\2\2de\t\4\2\2ef\t\3\2\2fg\t\5\2\2gh\t\6\2\2h \3\2\2"+
		"\2ij\t\7\2\2jk\t\b\2\2kl\t\t\2\2lm\t\n\2\2mn\t\13\2\2n\u0096\t\6\2\2o"+
		"p\t\3\2\2pq\t\f\2\2qr\t\6\2\2rs\t\3\2\2st\t\r\2\2t\u0096\t\16\2\2uv\t"+
		"\7\2\2vw\t\b\2\2wx\t\t\2\2xy\t\4\2\2yz\t\3\2\2z{\t\b\2\2{|\t\3\2\2|}\t"+
		"\r\2\2}~\t\6\2\2~\u0096\t\2\2\2\177\u0080\t\6\2\2\u0080\u0081\t\17\2\2"+
		"\u0081\u0082\t\t\2\2\u0082\u0096\t\3\2\2\u0083\u0084\t\r\2\2\u0084\u0085"+
		"\t\20\2\2\u0085\u0086\t\b\2\2\u0086\u0096\t\3\2\2\u0087\u0088\t\b\2\2"+
		"\u0088\u0089\t\3\2\2\u0089\u008a\t\6\2\2\u008a\u008b\t\21\2\2\u008b\u008c"+
		"\t\n\2\2\u008c\u0096\t\16\2\2\u008d\u008e\t\5\2\2\u008e\u008f\t\20\2\2"+
		"\u008f\u0090\t\4\2\2\u0090\u0096\t\4\2\2\u0091\u0092\t\22\2\2\u0092\u0093"+
		"\t\23\2\2\u0093\u0094\t\5\2\2\u0094\u0096\t\r\2\2\u0095i\3\2\2\2\u0095"+
		"o\3\2\2\2\u0095u\3\2\2\2\u0095\177\3\2\2\2\u0095\u0083\3\2\2\2\u0095\u0087"+
		"\3\2\2\2\u0095\u008d\3\2\2\2\u0095\u0091\3\2\2\2\u0096\"\3\2\2\2\u0097"+
		"\u0098\t\22\2\2\u0098\u0099\t\13\2\2\u0099\u009a\t\n\2\2\u009a\u009b\t"+
		"\b\2\2\u009b$\3\2\2\2\u009c\u009d\t\24\2\2\u009d\u009e\t\21\2\2\u009e"+
		"\u009f\t\3\2\2\u009f\u00a0\t\13\2\2\u00a0\u00a1\t\3\2\2\u00a1&\3\2\2\2"+
		"\u00a2\u00a3\t\20\2\2\u00a3\u00a4\t\r\2\2\u00a4\u00ab\t\16\2\2\u00a5\u00a6"+
		"\t\n\2\2\u00a6\u00ab\t\13\2\2\u00a7\u00a8\t\r\2\2\u00a8\u00a9\t\n\2\2"+
		"\u00a9\u00ab\t\6\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00a5\3\2\2\2\u00aa\u00a7"+
		"\3\2\2\2\u00ab(\3\2\2\2\u00ac\u00b0\7?\2\2\u00ad\u00ae\7#\2\2\u00ae\u00b0"+
		"\7?\2\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0*\3\2\2\2\u00b1\u00b2"+
		"\t\7\2\2\u00b2\u00ba\t\r\2\2\u00b3\u00b4\t\r\2\2\u00b4\u00b5\t\n\2\2\u00b5"+
		"\u00b6\t\6\2\2\u00b6\u00b7\t\25\2\2\u00b7\u00b8\t\7\2\2\u00b8\u00ba\t"+
		"\r\2\2\u00b9\u00b1\3\2\2\2\u00b9\u00b3\3\2\2\2\u00ba,\3\2\2\2\u00bb\u00bc"+
		"\t\7\2\2\u00bc\u00bd\t\r\2\2\u00bd\u00be\t\6\2\2\u00be\u00bf\t\3\2\2\u00bf"+
		"\u00c0\t\13\2\2\u00c0\u00c1\t\22\2\2\u00c1\u00c2\t\20\2\2\u00c2\u00c3"+
		"\t\5\2\2\u00c3\u012d\t\3\2\2\u00c4\u00c5\t\2\2\2\u00c5\u00c6\t\26\2\2"+
		"\u00c6\u00c7\t\27\2\2\u00c7\u00c8\t\7\2\2\u00c8\u00c9\t\r\2\2\u00c9\u00ca"+
		"\t\6\2\2\u00ca\u00cb\t\3\2\2\u00cb\u00cc\t\13\2\2\u00cc\u00cd\t\22\2\2"+
		"\u00cd\u00ce\t\20\2\2\u00ce\u00cf\t\5\2\2\u00cf\u012d\t\3\2\2\u00d0\u00d1"+
		"\t\2\2\2\u00d1\u00d2\t\26\2\2\u00d2\u00d3\t\t\2\2\u00d3\u00d4\t\3\2\2"+
		"\u00d4\u00d5\t\13\2\2\u00d5\u00d6\t\7\2\2\u00d6\u00d7\t\r\2\2\u00d7\u00d8"+
		"\t\6\2\2\u00d8\u00d9\t\3\2\2\u00d9\u00da\t\13\2\2\u00da\u00db\t\22\2\2"+
		"\u00db\u00dc\t\20\2\2\u00dc\u00dd\t\5\2\2\u00dd\u012d\t\3\2\2\u00de\u00df"+
		"\t\5\2\2\u00df\u00e0\t\4\2\2\u00e0\u00e1\t\20\2\2\u00e1\u00e2\t\2\2\2"+
		"\u00e2\u012d\t\2\2\2\u00e3\u00e4\t\2\2\2\u00e4\u00e5\t\26\2\2\u00e5\u00e6"+
		"\t\27\2\2\u00e6\u00e7\t\5\2\2\u00e7\u00e8\t\4\2\2\u00e8\u00e9\t\20\2\2"+
		"\u00e9\u00ea\t\2\2\2\u00ea\u012d\t\2\2\2\u00eb\u00ec\t\2\2\2\u00ec\u00ed"+
		"\t\26\2\2\u00ed\u00ee\t\t\2\2\u00ee\u00ef\t\3\2\2\u00ef\u00f0\t\13\2\2"+
		"\u00f0\u00f1\t\5\2\2\u00f1\u00f2\t\4\2\2\u00f2\u00f3\t\20\2\2\u00f3\u00f4"+
		"\t\2\2\2\u00f4\u012d\t\2\2\2\u00f5\u00f6\t\20\2\2\u00f6\u00f7\t\27\2\2"+
		"\u00f7\u00f8\t\2\2\2\u00f8\u00f9\t\6\2\2\u00f9\u00fa\t\13\2\2\u00fa\u00fb"+
		"\t\20\2\2\u00fb\u00fc\t\5\2\2\u00fc\u012d\t\6\2\2\u00fd\u00fe\t\3\2\2"+
		"\u00fe\u00ff\t\r\2\2\u00ff\u0100\t\26\2\2\u0100\u012d\t\b\2\2\u0101\u0102"+
		"\t\20\2\2\u0102\u0103\t\r\2\2\u0103\u0104\t\r\2\2\u0104\u0105\t\n\2\2"+
		"\u0105\u0106\t\6\2\2\u0106\u0107\t\20\2\2\u0107\u0108\t\6\2\2\u0108\u0109"+
		"\t\7\2\2\u0109\u010a\t\n\2\2\u010a\u012d\t\r\2\2\u010b\u010c\t\t\2\2\u010c"+
		"\u010d\t\13\2\2\u010d\u010e\t\n\2\2\u010e\u010f\t\6\2\2\u010f\u0110\t"+
		"\3\2\2\u0110\u0111\t\5\2\2\u0111\u0112\t\6\2\2\u0112\u0113\t\3\2\2\u0113"+
		"\u012d\t\16\2\2\u0114\u0115\t\t\2\2\u0115\u0116\t\13\2\2\u0116\u0117\t"+
		"\7\2\2\u0117\u0118\t\30\2\2\u0118\u0119\t\20\2\2\u0119\u011a\t\6\2\2\u011a"+
		"\u012d\t\3\2\2\u011b\u011c\t\t\2\2\u011c\u011d\t\26\2\2\u011d\u011e\t"+
		"\27\2\2\u011e\u011f\t\4\2\2\u011f\u0120\t\7\2\2\u0120\u012d\t\5\2\2\u0121"+
		"\u0122\t\2\2\2\u0122\u0123\t\6\2\2\u0123\u0124\t\20\2\2\u0124\u0125\t"+
		"\6\2\2\u0125\u0126\t\7\2\2\u0126\u012d\t\5\2\2\u0127\u0128\t\22\2\2\u0128"+
		"\u0129\t\7\2\2\u0129\u012a\t\r\2\2\u012a\u012b\t\20\2\2\u012b\u012d\t"+
		"\4\2\2\u012c\u00bb\3\2\2\2\u012c\u00c4\3\2\2\2\u012c\u00d0\3\2\2\2\u012c"+
		"\u00de\3\2\2\2\u012c\u00e3\3\2\2\2\u012c\u00eb\3\2\2\2\u012c\u00f5\3\2"+
		"\2\2\u012c\u00fd\3\2\2\2\u012c\u0101\3\2\2\2\u012c\u010b\3\2\2\2\u012c"+
		"\u0114\3\2\2\2\u012c\u011b\3\2\2\2\u012c\u0121\3\2\2\2\u012c\u0127\3\2"+
		"\2\2\u012d.\3\2\2\2\u012e\u012f\t\5\2\2\u012f\60\3\2\2\2\u0130\u0131\t"+
		"\b\2\2\u0131\62\3\2\2\2\u0132\u0133\t\t\2\2\u0133\64\3\2\2\2\u0134\u0135"+
		"\t\n\2\2\u0135\u0136\t\13\2\2\u0136\u0137\t\16\2\2\u0137\u0138\t\3\2\2"+
		"\u0138\u0139\t\13\2\2\u0139\u013a\t\25\2\2\u013a\u013b\t\27\2\2\u013b"+
		"\u013c\t\17\2\2\u013c\66\3\2\2\2\u013d\u013f\59\35\2\u013e\u013d\3\2\2"+
		"\2\u013f\u0140\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u01418"+
		"\3\2\2\2\u0142\u0143\4\62;\2\u0143:\3\2\2\2\u0144\u0149\7$\2\2\u0145\u0148"+
		"\5=\37\2\u0146\u0148\13\2\2\2\u0147\u0145\3\2\2\2\u0147\u0146\3\2\2\2"+
		"\u0148\u014b\3\2\2\2\u0149\u014a\3\2\2\2\u0149\u0147\3\2\2\2\u014a\u014c"+
		"\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d\7$\2\2\u014d<\3\2\2\2\u014e\u014f"+
		"\7^\2\2\u014f\u0150\t\31\2\2\u0150>\3\2\2\2\u0151\u0153\t\32\2\2\u0152"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b \2\2\u0157@\3\2\2\2\f\2\u0095\u00aa"+
		"\u00af\u00b9\u012c\u0140\u0147\u0149\u0154\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}