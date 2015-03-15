package com.queryToAST.app.QueryLanguage;

// Generated from query.g by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class queryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, SELECT=20, FROM=21, WHERE=22, ORDER_BY=23, OP_BOOL=24, 
		OP_IN=25, BOOL=26, STRING=27, WS=28;
	public static final int
		RULE_query = 0, RULE_select = 1, RULE_spec = 2, RULE_from = 3, RULE_path = 4, 
		RULE_st_co = 5, RULE_prop = 6, RULE_operand = 7, RULE_st_in = 8;
	public static final String[] ruleNames = {
		"query", "select", "spec", "from", "path", "st_co", "prop", "operand", 
		"st_in"
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

	@Override
	public String getGrammarFileName() { return "query.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public queryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class QueryContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(queryParser.SELECT, 0); }
		public List<SelectContext> select() {
			return getRuleContexts(SelectContext.class);
		}
		public SelectContext select(int i) {
			return getRuleContext(SelectContext.class,i);
		}
		public TerminalNode FROM() { return getToken(queryParser.FROM, 0); }
		public List<FromContext> from() {
			return getRuleContexts(FromContext.class);
		}
		public FromContext from(int i) {
			return getRuleContext(FromContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(queryParser.WHERE, 0); }
		public List<St_coContext> st_co() {
			return getRuleContexts(St_coContext.class);
		}
		public St_coContext st_co(int i) {
			return getRuleContext(St_coContext.class,i);
		}
		public List<TerminalNode> OP_BOOL() { return getTokens(queryParser.OP_BOOL); }
		public TerminalNode OP_BOOL(int i) {
			return getToken(queryParser.OP_BOOL, i);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_query);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(SELECT);
			setState(19);
			select();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(20);
				match(T__0);
				setState(21);
				select();
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
			match(FROM);
			setState(28);
			from();
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(29);
				match(T__0);
				setState(30);
				from();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			match(WHERE);
			setState(37);
			st_co();
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_BOOL) {
				{
				{
				setState(38);
				match(OP_BOOL);
				setState(39);
				st_co();
				}
				}
				setState(44);
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

	public static class SelectContext extends ParserRuleContext {
		public SpecContext spec() {
			return getRuleContext(SpecContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitSelect(this);
		}
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_select);
		try {
			setState(48);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(T__1);
				{
				setState(46);
				spec();
				}
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				spec();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SpecContext extends ParserRuleContext {
		public SpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitSpec(this);
		}
	}

	public final SpecContext spec() throws RecognitionException {
		SpecContext _localctx = new SpecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class FromContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public FromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterFrom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitFrom(this);
		}
	}

	public final FromContext from() throws RecognitionException {
		FromContext _localctx = new FromContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_from);
		try {
			setState(55);
			switch (_input.LA(1)) {
			case T__2:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(52);
				path();
				}
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(T__1);
				{
				setState(54);
				path();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PathContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_path);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==STRING) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class St_coContext extends ParserRuleContext {
		public List<PropContext> prop() {
			return getRuleContexts(PropContext.class);
		}
		public PropContext prop(int i) {
			return getRuleContext(PropContext.class,i);
		}
		public OperandContext operand() {
			return getRuleContext(OperandContext.class,0);
		}
		public List<St_inContext> st_in() {
			return getRuleContexts(St_inContext.class);
		}
		public St_inContext st_in(int i) {
			return getRuleContext(St_inContext.class,i);
		}
		public TerminalNode OP_IN() { return getToken(queryParser.OP_IN, 0); }
		public TerminalNode BOOL() { return getToken(queryParser.BOOL, 0); }
		public St_coContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st_co; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterSt_co(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitSt_co(this);
		}
	}

	public final St_coContext st_co() throws RecognitionException {
		St_coContext _localctx = new St_coContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_st_co);
		try {
			setState(68);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(59);
				prop();
				}
				{
				setState(60);
				operand();
				}
				{
				setState(61);
				prop();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				st_in();
				setState(64);
				match(OP_IN);
				setState(65);
				st_in();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				match(BOOL);
				}
				break;
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

	public static class PropContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public PropContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterProp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitProp(this);
		}
	}

	public final PropContext prop() throws RecognitionException {
		PropContext _localctx = new PropContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class OperandContext extends ParserRuleContext {
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_la = _input.LA(1);
			if ( !(_la==T__13 || _la==T__14) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class St_inContext extends ParserRuleContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public St_inContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_st_in; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterSt_in(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitSt_in(this);
		}
	}

	public final St_inContext st_in() throws RecognitionException {
		St_inContext _localctx = new St_inContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_st_in);
		try {
			setState(84);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				match(T__15);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(T__3);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				match(T__5);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(T__4);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				match(T__17);
				setState(80);
				query();
				setState(81);
				match(T__18);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 7);
				{
				setState(83);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36Y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2"+
		"\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\2\3\2\7\2\"\n\2\f\2\16\2%\13"+
		"\2\3\2\3\2\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\3\3\3\3\3\5\3\63\n\3\3\4"+
		"\3\4\3\5\3\5\3\5\5\5:\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7G\n\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"W\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\6\3\2\5\f\4\2\5\5\35\35\5\2\7"+
		"\7\r\17\35\35\3\2\20\21\\\2\24\3\2\2\2\4\62\3\2\2\2\6\64\3\2\2\2\b9\3"+
		"\2\2\2\n;\3\2\2\2\fF\3\2\2\2\16H\3\2\2\2\20J\3\2\2\2\22V\3\2\2\2\24\25"+
		"\7\26\2\2\25\32\5\4\3\2\26\27\7\3\2\2\27\31\5\4\3\2\30\26\3\2\2\2\31\34"+
		"\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3\2\2\2\35\36"+
		"\7\27\2\2\36#\5\b\5\2\37 \7\3\2\2 \"\5\b\5\2!\37\3\2\2\2\"%\3\2\2\2#!"+
		"\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7\30\2\2\',\5\f\7\2()\7\32\2"+
		"\2)+\5\f\7\2*(\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\3\3\2\2\2.,\3\2"+
		"\2\2/\60\7\4\2\2\60\63\5\6\4\2\61\63\5\6\4\2\62/\3\2\2\2\62\61\3\2\2\2"+
		"\63\5\3\2\2\2\64\65\t\2\2\2\65\7\3\2\2\2\66:\5\n\6\2\678\7\4\2\28:\5\n"+
		"\6\29\66\3\2\2\29\67\3\2\2\2:\t\3\2\2\2;<\t\3\2\2<\13\3\2\2\2=>\5\16\b"+
		"\2>?\5\20\t\2?@\5\16\b\2@G\3\2\2\2AB\5\22\n\2BC\7\33\2\2CD\5\22\n\2DG"+
		"\3\2\2\2EG\7\34\2\2F=\3\2\2\2FA\3\2\2\2FE\3\2\2\2G\r\3\2\2\2HI\t\4\2\2"+
		"I\17\3\2\2\2JK\t\5\2\2K\21\3\2\2\2LW\7\22\2\2MW\7\6\2\2NW\7\b\2\2OW\7"+
		"\7\2\2PW\7\23\2\2QR\7\24\2\2RS\5\2\2\2ST\7\25\2\2TW\3\2\2\2UW\7\35\2\2"+
		"VL\3\2\2\2VM\3\2\2\2VN\3\2\2\2VO\3\2\2\2VP\3\2\2\2VQ\3\2\2\2VU\3\2\2\2"+
		"W\23\3\2\2\2\t\32#,\629FV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}