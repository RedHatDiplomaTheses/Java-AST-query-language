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
		SELECT=1, FROM=2, WHERE=3, AND=4, MM=5, OPERATORS=6, COMMA=7, LBRACKET=8, 
		RBRACKET=9, LPAREN=10, RPAREN=11, EXCLAMANTION=12, STAR=13, AT=14, DOT=15, 
		INT=16, NAME=17, STRING=18, WS=19;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SELECT", "FROM", "WHERE", "AND", "MM", "OPERATORS", "COMMA", "LBRACKET", 
		"RBRACKET", "LPAREN", "RPAREN", "EXCLAMANTION", "STAR", "AT", "DOT", "INT", 
		"DIGIT", "NAME", "LETTER", "STRING", "ESC", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "','", "'['", "']'", "'('", 
		"')'", "'!'", "'*'", "'@'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "FROM", "WHERE", "AND", "MM", "OPERATORS", "COMMA", "LBRACKET", 
		"RBRACKET", "LPAREN", "RPAREN", "EXCLAMANTION", "STAR", "AT", "DOT", "INT", 
		"NAME", "STRING", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\25\u0083\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7N\n\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\6\21c\n"+
		"\21\r\21\16\21d\3\22\3\22\3\23\6\23j\n\23\r\23\16\23k\3\24\3\24\3\25\3"+
		"\25\3\25\7\25s\n\25\f\25\16\25v\13\25\3\25\3\25\3\26\3\26\3\26\3\27\6"+
		"\27~\n\27\r\27\16\27\177\3\27\3\27\3t\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\23\'\2)\24+\2"+
		"-\25\3\2\24\4\2UUuu\4\2GGgg\4\2NNnn\4\2EEee\4\2VVvv\4\2HHhh\4\2TTtt\4"+
		"\2QQqq\4\2OOoo\4\2YYyy\4\2JJjj\4\2CCcc\4\2PPpp\4\2FFff\4\2KKkk\4\2C\\"+
		"c|\b\2$$^^ddppttvv\5\2\13\f\17\17\"\"\u0087\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2%\3\2\2\2\2)\3\2\2\2\2-\3\2\2\2"+
		"\3/\3\2\2\2\5\66\3\2\2\2\7;\3\2\2\2\tA\3\2\2\2\13E\3\2\2\2\rM\3\2\2\2"+
		"\17O\3\2\2\2\21Q\3\2\2\2\23S\3\2\2\2\25U\3\2\2\2\27W\3\2\2\2\31Y\3\2\2"+
		"\2\33[\3\2\2\2\35]\3\2\2\2\37_\3\2\2\2!b\3\2\2\2#f\3\2\2\2%i\3\2\2\2\'"+
		"m\3\2\2\2)o\3\2\2\2+y\3\2\2\2-}\3\2\2\2/\60\t\2\2\2\60\61\t\3\2\2\61\62"+
		"\t\4\2\2\62\63\t\3\2\2\63\64\t\5\2\2\64\65\t\6\2\2\65\4\3\2\2\2\66\67"+
		"\t\7\2\2\678\t\b\2\289\t\t\2\29:\t\n\2\2:\6\3\2\2\2;<\t\13\2\2<=\t\f\2"+
		"\2=>\t\3\2\2>?\t\b\2\2?@\t\3\2\2@\b\3\2\2\2AB\t\r\2\2BC\t\16\2\2CD\t\17"+
		"\2\2D\n\3\2\2\2EF\t\n\2\2F\f\3\2\2\2GN\7?\2\2HI\7#\2\2IN\7?\2\2JN\7\u0080"+
		"\2\2KL\t\20\2\2LN\t\16\2\2MG\3\2\2\2MH\3\2\2\2MJ\3\2\2\2MK\3\2\2\2N\16"+
		"\3\2\2\2OP\7.\2\2P\20\3\2\2\2QR\7]\2\2R\22\3\2\2\2ST\7_\2\2T\24\3\2\2"+
		"\2UV\7*\2\2V\26\3\2\2\2WX\7+\2\2X\30\3\2\2\2YZ\7#\2\2Z\32\3\2\2\2[\\\7"+
		",\2\2\\\34\3\2\2\2]^\7B\2\2^\36\3\2\2\2_`\7\60\2\2` \3\2\2\2ac\5#\22\2"+
		"ba\3\2\2\2cd\3\2\2\2db\3\2\2\2de\3\2\2\2e\"\3\2\2\2fg\4\62;\2g$\3\2\2"+
		"\2hj\5\'\24\2ih\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2l&\3\2\2\2mn\t\21"+
		"\2\2n(\3\2\2\2ot\7)\2\2ps\5+\26\2qs\13\2\2\2rp\3\2\2\2rq\3\2\2\2sv\3\2"+
		"\2\2tu\3\2\2\2tr\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7)\2\2x*\3\2\2\2yz\7^\2"+
		"\2z{\t\22\2\2{,\3\2\2\2|~\t\23\2\2}|\3\2\2\2~\177\3\2\2\2\177}\3\2\2\2"+
		"\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\b\27\2\2\u0082.\3\2"+
		"\2\2\t\2Mdkrt\177\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}