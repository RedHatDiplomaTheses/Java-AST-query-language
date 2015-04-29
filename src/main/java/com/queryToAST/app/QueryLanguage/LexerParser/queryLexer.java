package com.queryToAST.app.QueryLanguage.LexerParser;

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
		SELECT=1, FROM=2, WHERE=3, AND=4, EXIST=5, NOT_EXIST=6, METHOD=7, JOIN=8, 
		OPERATORS=9, ORDER_BY=10, UNIQUE=11, COMMA=12, LBRACKET=13, RBRACKET=14, 
		LPAREN=15, RPAREN=16, EXCLAMANTION=17, STAR=18, AT_NAME=19, DOT=20, NAME_DOT=21, 
		DOT_NAME=22, AS=23, INT=24, NAME=25, PATTERN=26, STRING=27, WS=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "FROM", "WHERE", "AND", "EXIST", "NOT_EXIST", "METHOD", "JOIN", 
		"OPERATORS", "ORDER_BY", "UNIQUE", "COMMA", "LBRACKET", "RBRACKET", "LPAREN", 
		"RPAREN", "EXCLAMANTION", "STAR", "AT_NAME", "DOT", "NAME_DOT", "DOT_NAME", 
		"AS", "INT", "DIGIT", "NAME", "LETTER", "PATTERN", "STRING", "ESC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"','", "'['", "']'", "'('", "')'", "'!'", "'*'", null, "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "FROM", "WHERE", "AND", "EXIST", "NOT_EXIST", "METHOD", 
		"JOIN", "OPERATORS", "ORDER_BY", "UNIQUE", "COMMA", "LBRACKET", "RBRACKET", 
		"LPAREN", "RPAREN", "EXCLAMANTION", "STAR", "AT_NAME", "DOT", "NAME_DOT", 
		"DOT_NAME", "AS", "INT", "NAME", "PATTERN", "STRING", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00de\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\nz\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\6\24\u009c\n\24\r\24\16\24\u009d\3"+
		"\25\3\25\3\26\6\26\u00a3\n\26\r\26\16\26\u00a4\3\26\3\26\3\27\3\27\6\27"+
		"\u00ab\n\27\r\27\16\27\u00ac\3\30\3\30\3\30\3\31\6\31\u00b3\n\31\r\31"+
		"\16\31\u00b4\3\32\3\32\3\33\6\33\u00ba\n\33\r\33\16\33\u00bb\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\7\35\u00c4\n\35\f\35\16\35\u00c7\13\35\3\35\3\35"+
		"\3\36\3\36\3\36\7\36\u00ce\n\36\f\36\16\36\u00d1\13\36\3\36\3\36\3\37"+
		"\3\37\3\37\3 \6 \u00d9\n \r \16 \u00da\3 \3 \4\u00c5\u00cf\2!\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\33\67\29\34;\35=\2?\36\3\2"+
		"\33\4\2UUuu\4\2GGgg\4\2NNnn\4\2EEee\4\2VVvv\4\2HHhh\4\2TTtt\4\2QQqq\4"+
		"\2OOoo\4\2YYyy\4\2JJjj\4\2CCcc\4\2PPpp\4\2FFff\4\2ZZzz\4\2KKkk\3\2\"\""+
		"\4\2LLll\4\2DDdd\4\2[[{{\4\2WWww\4\2SSss\4\2C\\c|\b\2$$^^ddppttvv\5\2"+
		"\13\f\17\17\"\"\u00e7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\65\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2?\3\2\2\2\3A\3\2\2\2\5H\3\2\2\2\7M\3\2\2\2\tS\3\2\2\2\13W\3\2\2\2"+
		"\r]\3\2\2\2\17g\3\2\2\2\21n\3\2\2\2\23y\3\2\2\2\25{\3\2\2\2\27\u0084\3"+
		"\2\2\2\31\u008b\3\2\2\2\33\u008d\3\2\2\2\35\u008f\3\2\2\2\37\u0091\3\2"+
		"\2\2!\u0093\3\2\2\2#\u0095\3\2\2\2%\u0097\3\2\2\2\'\u0099\3\2\2\2)\u009f"+
		"\3\2\2\2+\u00a2\3\2\2\2-\u00a8\3\2\2\2/\u00ae\3\2\2\2\61\u00b2\3\2\2\2"+
		"\63\u00b6\3\2\2\2\65\u00b9\3\2\2\2\67\u00bd\3\2\2\29\u00bf\3\2\2\2;\u00ca"+
		"\3\2\2\2=\u00d4\3\2\2\2?\u00d8\3\2\2\2AB\t\2\2\2BC\t\3\2\2CD\t\4\2\2D"+
		"E\t\3\2\2EF\t\5\2\2FG\t\6\2\2G\4\3\2\2\2HI\t\7\2\2IJ\t\b\2\2JK\t\t\2\2"+
		"KL\t\n\2\2L\6\3\2\2\2MN\t\13\2\2NO\t\f\2\2OP\t\3\2\2PQ\t\b\2\2QR\t\3\2"+
		"\2R\b\3\2\2\2ST\t\r\2\2TU\t\16\2\2UV\t\17\2\2V\n\3\2\2\2WX\t\3\2\2XY\t"+
		"\20\2\2YZ\t\21\2\2Z[\t\2\2\2[\\\t\6\2\2\\\f\3\2\2\2]^\t\16\2\2^_\t\t\2"+
		"\2_`\t\6\2\2`a\t\22\2\2ab\t\3\2\2bc\t\20\2\2cd\t\21\2\2de\t\2\2\2ef\t"+
		"\6\2\2f\16\3\2\2\2gh\t\n\2\2hi\t\3\2\2ij\t\6\2\2jk\t\f\2\2kl\t\t\2\2l"+
		"m\t\17\2\2m\20\3\2\2\2no\t\23\2\2op\t\t\2\2pq\t\21\2\2qr\t\16\2\2r\22"+
		"\3\2\2\2sz\7?\2\2tu\7#\2\2uz\7?\2\2vz\7\u0080\2\2wx\t\21\2\2xz\t\16\2"+
		"\2ys\3\2\2\2yt\3\2\2\2yv\3\2\2\2yw\3\2\2\2z\24\3\2\2\2{|\t\t\2\2|}\t\b"+
		"\2\2}~\t\17\2\2~\177\t\3\2\2\177\u0080\t\b\2\2\u0080\u0081\t\22\2\2\u0081"+
		"\u0082\t\24\2\2\u0082\u0083\t\25\2\2\u0083\26\3\2\2\2\u0084\u0085\t\26"+
		"\2\2\u0085\u0086\t\16\2\2\u0086\u0087\t\21\2\2\u0087\u0088\t\27\2\2\u0088"+
		"\u0089\t\26\2\2\u0089\u008a\t\3\2\2\u008a\30\3\2\2\2\u008b\u008c\7.\2"+
		"\2\u008c\32\3\2\2\2\u008d\u008e\7]\2\2\u008e\34\3\2\2\2\u008f\u0090\7"+
		"_\2\2\u0090\36\3\2\2\2\u0091\u0092\7*\2\2\u0092 \3\2\2\2\u0093\u0094\7"+
		"+\2\2\u0094\"\3\2\2\2\u0095\u0096\7#\2\2\u0096$\3\2\2\2\u0097\u0098\7"+
		",\2\2\u0098&\3\2\2\2\u0099\u009b\7B\2\2\u009a\u009c\5\67\34\2\u009b\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"(\3\2\2\2\u009f\u00a0\7\60\2\2\u00a0*\3\2\2\2\u00a1\u00a3\5\67\34\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\60\2\2\u00a7,\3\2\2\2\u00a8\u00aa"+
		"\7\60\2\2\u00a9\u00ab\5\67\34\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2"+
		"\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad.\3\2\2\2\u00ae\u00af"+
		"\t\r\2\2\u00af\u00b0\t\2\2\2\u00b0\60\3\2\2\2\u00b1\u00b3\5\63\32\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2"+
		"\2\2\u00b5\62\3\2\2\2\u00b6\u00b7\4\62;\2\u00b7\64\3\2\2\2\u00b8\u00ba"+
		"\5\67\34\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2"+
		"\u00bb\u00bc\3\2\2\2\u00bc\66\3\2\2\2\u00bd\u00be\t\30\2\2\u00be8\3\2"+
		"\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c5\7)\2\2\u00c1\u00c4\5=\37\2\u00c2\u00c4"+
		"\13\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2"+
		"\u00c5\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c5"+
		"\3\2\2\2\u00c8\u00c9\7)\2\2\u00c9:\3\2\2\2\u00ca\u00cf\7)\2\2\u00cb\u00ce"+
		"\5=\37\2\u00cc\u00ce\13\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc\3\2\2\2"+
		"\u00ce\u00d1\3\2\2\2\u00cf\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d2"+
		"\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\7)\2\2\u00d3<\3\2\2\2\u00d4\u00d5"+
		"\7^\2\2\u00d5\u00d6\t\31\2\2\u00d6>\3\2\2\2\u00d7\u00d9\t\32\2\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\b \2\2\u00dd@\3\2\2\2\16\2y\u009d"+
		"\u00a4\u00ac\u00b4\u00bb\u00c3\u00c5\u00cd\u00cf\u00da\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}