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
		SELECT=1, FROM=2, WHERE=3, AND=4, OPERATORS=5, MM=6, COLON=7, COMMA=8, 
		LBRACKET=9, RBRACKET=10, LPAREN=11, RPAREN=12, EXCLAMANTION=13, STAR=14, 
		AT=15, DOT=16, ID_DOLLAR=17, ID_SLASH=18, INT=19, NAME=20, STRING=21, 
		WS=22;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "FROM", "WHERE", "AND", "OPERATORS", "MM", "COLON", "COMMA", 
		"LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "EXCLAMANTION", "STAR", "AT", 
		"DOT", "ID_DOLLAR", "DOLLAR", "ID_SLASH", "SLASH", "INT", "DIGIT", "NAME", 
		"LETTER", "STRING", "ESC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'#'", "'<'", "'?'", "'&&'", null, null, "':'", "','", "'['", "']'", 
		"'('", "')'", "'!'", "'*'", "'@'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "FROM", "WHERE", "AND", "OPERATORS", "MM", "COLON", "COMMA", 
		"LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "EXCLAMANTION", "STAR", "AT", 
		"DOT", "ID_DOLLAR", "ID_SLASH", "INT", "NAME", "STRING", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\30\u008c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6I\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\6\26l\n\26\r\26\16"+
		"\26m\3\27\3\27\3\30\6\30s\n\30\r\30\16\30t\3\31\3\31\3\32\3\32\3\32\7"+
		"\32|\n\32\f\32\16\32\177\13\32\3\32\3\32\3\33\3\33\3\33\3\34\6\34\u0087"+
		"\n\34\r\34\16\34\u0088\3\34\3\34\3}\2\35\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\2\'\24)\2+\25-"+
		"\2/\26\61\2\63\27\65\2\67\30\3\2\b\4\2KKkk\4\2PPpp\4\2OOoo\4\2C\\c|\b"+
		"\2$$^^ddppttvv\5\2\13\f\17\17\"\"\u008e\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2\'\3\2\2\2\2+\3\2\2\2\2/"+
		"\3\2\2\2\2\63\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\t"+
		"?\3\2\2\2\13H\3\2\2\2\rJ\3\2\2\2\17L\3\2\2\2\21N\3\2\2\2\23P\3\2\2\2\25"+
		"R\3\2\2\2\27T\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35Z\3\2\2\2\37\\\3\2\2\2"+
		"!^\3\2\2\2#`\3\2\2\2%c\3\2\2\2\'e\3\2\2\2)h\3\2\2\2+k\3\2\2\2-o\3\2\2"+
		"\2/r\3\2\2\2\61v\3\2\2\2\63x\3\2\2\2\65\u0082\3\2\2\2\67\u0086\3\2\2\2"+
		"9:\7%\2\2:\4\3\2\2\2;<\7>\2\2<\6\3\2\2\2=>\7A\2\2>\b\3\2\2\2?@\7(\2\2"+
		"@A\7(\2\2A\n\3\2\2\2BI\7?\2\2CD\7#\2\2DI\7?\2\2EI\7\u0080\2\2FG\t\2\2"+
		"\2GI\t\3\2\2HB\3\2\2\2HC\3\2\2\2HE\3\2\2\2HF\3\2\2\2I\f\3\2\2\2JK\t\4"+
		"\2\2K\16\3\2\2\2LM\7<\2\2M\20\3\2\2\2NO\7.\2\2O\22\3\2\2\2PQ\7]\2\2Q\24"+
		"\3\2\2\2RS\7_\2\2S\26\3\2\2\2TU\7*\2\2U\30\3\2\2\2VW\7+\2\2W\32\3\2\2"+
		"\2XY\7#\2\2Y\34\3\2\2\2Z[\7,\2\2[\36\3\2\2\2\\]\7B\2\2] \3\2\2\2^_\7\60"+
		"\2\2_\"\3\2\2\2`a\5%\23\2ab\5-\27\2b$\3\2\2\2cd\7&\2\2d&\3\2\2\2ef\5)"+
		"\25\2fg\5-\27\2g(\3\2\2\2hi\7^\2\2i*\3\2\2\2jl\5-\27\2kj\3\2\2\2lm\3\2"+
		"\2\2mk\3\2\2\2mn\3\2\2\2n,\3\2\2\2op\4\62;\2p.\3\2\2\2qs\5\61\31\2rq\3"+
		"\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\60\3\2\2\2vw\t\5\2\2w\62\3\2\2\2"+
		"x}\7)\2\2y|\5\65\33\2z|\13\2\2\2{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}~\3"+
		"\2\2\2}{\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7)\2\2\u0081"+
		"\64\3\2\2\2\u0082\u0083\7^\2\2\u0083\u0084\t\6\2\2\u0084\66\3\2\2\2\u0085"+
		"\u0087\t\7\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\34\2\2\u008b"+
		"8\3\2\2\2\t\2Hmt{}\u0088\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}