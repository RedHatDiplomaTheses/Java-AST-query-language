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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, KEY_SELECT=15, KEY_PROP=16, 
		FROM=17, KEY_WHERE=18, KEY_OP_BOOL=19, KEY_OPERAND=20, KEY_OP_IN=21, KEY_BOOL=22, 
		CC=23, MM=24, PP=25, ORDER_BY=26, INT=27, STRING=28, WS=29;
	public static final int
		RULE_query = 0, RULE_select = 1, RULE_sel_li_prop = 2, RULE_sel_prop = 3, 
		RULE_from = 4, RULE_pack = 5, RULE_fro_pac = 6, RULE_where = 7, RULE_cond = 8, 
		RULE_st_co = 9, RULE_annot = 10, RULE_method = 11, RULE_index = 12, RULE_an_value = 13, 
		RULE_params = 14, RULE_param = 15, RULE_para = 16, RULE_order_by = 17;
	public static final String[] ruleNames = {
		"query", "select", "sel_li_prop", "sel_prop", "from", "pack", "fro_pac", 
		"where", "cond", "st_co", "annot", "method", "index", "an_value", "params", 
		"param", "para", "order_by"
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
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
		}
		public FromContext from() {
			return getRuleContext(FromContext.class,0);
		}
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
		}
		public Order_byContext order_by() {
			return getRuleContext(Order_byContext.class,0);
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
			setState(37);
			_la = _input.LA(1);
			if (_la==KEY_SELECT) {
				{
				setState(36);
				select();
				}
			}

			setState(40);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(39);
				from();
				}
			}

			setState(43);
			_la = _input.LA(1);
			if (_la==KEY_WHERE) {
				{
				setState(42);
				where();
				}
			}

			setState(46);
			_la = _input.LA(1);
			if (_la==ORDER_BY) {
				{
				setState(45);
				order_by();
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

	public static class SelectContext extends ParserRuleContext {
		public TerminalNode KEY_SELECT() { return getToken(queryParser.KEY_SELECT, 0); }
		public Sel_li_propContext sel_li_prop() {
			return getRuleContext(Sel_li_propContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(KEY_SELECT);
			setState(49);
			sel_li_prop();
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

	public static class Sel_li_propContext extends ParserRuleContext {
		public List<Sel_propContext> sel_prop() {
			return getRuleContexts(Sel_propContext.class);
		}
		public Sel_propContext sel_prop(int i) {
			return getRuleContext(Sel_propContext.class,i);
		}
		public Sel_li_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_li_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterSel_li_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitSel_li_prop(this);
		}
	}

	public final Sel_li_propContext sel_li_prop() throws RecognitionException {
		Sel_li_propContext _localctx = new Sel_li_propContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sel_li_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			sel_prop();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(52);
				match(T__0);
				setState(53);
				sel_prop();
				}
				}
				setState(58);
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

	public static class Sel_propContext extends ParserRuleContext {
		public TerminalNode KEY_PROP() { return getToken(queryParser.KEY_PROP, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public Sel_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sel_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterSel_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitSel_prop(this);
		}
	}

	public final Sel_propContext sel_prop() throws RecognitionException {
		Sel_propContext _localctx = new Sel_propContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sel_prop);
		int _la;
		try {
			setState(75);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(T__1);
				setState(60);
				match(KEY_PROP);
				setState(65);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(61);
					match(T__2);
					setState(62);
					method();
					setState(63);
					match(T__3);
					}
				}

				}
				break;
			case KEY_PROP:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				match(KEY_PROP);
				setState(72);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(68);
					match(T__2);
					setState(69);
					method();
					setState(70);
					match(T__3);
					}
				}

				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(T__4);
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

	public static class FromContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(queryParser.FROM, 0); }
		public PackContext pack() {
			return getRuleContext(PackContext.class,0);
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
		enterRule(_localctx, 8, RULE_from);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(FROM);
			setState(78);
			pack();
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

	public static class PackContext extends ParserRuleContext {
		public List<Fro_pacContext> fro_pac() {
			return getRuleContexts(Fro_pacContext.class);
		}
		public Fro_pacContext fro_pac(int i) {
			return getRuleContext(Fro_pacContext.class,i);
		}
		public PackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pack; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterPack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitPack(this);
		}
	}

	public final PackContext pack() throws RecognitionException {
		PackContext _localctx = new PackContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pack);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			fro_pac();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(81);
				match(T__0);
				setState(82);
				fro_pac();
				}
				}
				setState(87);
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

	public static class Fro_pacContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public Fro_pacContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fro_pac; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterFro_pac(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitFro_pac(this);
		}
	}

	public final Fro_pacContext fro_pac() throws RecognitionException {
		Fro_pacContext _localctx = new Fro_pacContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fro_pac);
		try {
			setState(92);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				match(STRING);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(T__1);
				setState(90);
				match(STRING);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				match(T__4);
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

	public static class WhereContext extends ParserRuleContext {
		public TerminalNode KEY_WHERE() { return getToken(queryParser.KEY_WHERE, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitWhere(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(KEY_WHERE);
			setState(95);
			cond();
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

	public static class CondContext extends ParserRuleContext {
		public List<St_coContext> st_co() {
			return getRuleContexts(St_coContext.class);
		}
		public St_coContext st_co(int i) {
			return getRuleContext(St_coContext.class,i);
		}
		public List<TerminalNode> KEY_OP_BOOL() { return getTokens(queryParser.KEY_OP_BOOL); }
		public TerminalNode KEY_OP_BOOL(int i) {
			return getToken(queryParser.KEY_OP_BOOL, i);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitCond(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			st_co();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEY_OP_BOOL) {
				{
				{
				setState(98);
				match(KEY_OP_BOOL);
				setState(99);
				st_co();
				}
				}
				setState(104);
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

	public static class St_coContext extends ParserRuleContext {
		public TerminalNode KEY_PROP() { return getToken(queryParser.KEY_PROP, 0); }
		public TerminalNode KEY_OPERAND() { return getToken(queryParser.KEY_OPERAND, 0); }
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public TerminalNode KEY_OP_IN() { return getToken(queryParser.KEY_OP_IN, 0); }
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public TerminalNode KEY_BOOL() { return getToken(queryParser.KEY_BOOL, 0); }
		public AnnotContext annot() {
			return getRuleContext(AnnotContext.class,0);
		}
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
		enterRule(_localctx, 18, RULE_st_co);
		try {
			setState(147);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(KEY_PROP);
				setState(106);
				match(KEY_OPERAND);
				setState(107);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(STRING);
				setState(109);
				match(KEY_OP_IN);
				setState(110);
				match(KEY_PROP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(KEY_PROP);
				setState(112);
				match(T__2);
				setState(113);
				match(STRING);
				setState(114);
				match(T__3);
				setState(115);
				match(KEY_OP_IN);
				setState(116);
				match(T__5);
				setState(117);
				query();
				setState(118);
				match(T__6);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				match(KEY_PROP);
				setState(121);
				match(KEY_OP_IN);
				setState(122);
				match(T__5);
				setState(123);
				query();
				setState(124);
				match(T__6);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				match(T__5);
				setState(127);
				query();
				setState(128);
				match(T__6);
				setState(129);
				match(KEY_OP_IN);
				setState(130);
				match(KEY_PROP);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(132);
				match(T__5);
				setState(133);
				query();
				setState(134);
				match(T__6);
				setState(135);
				match(T__2);
				setState(136);
				match(STRING);
				setState(137);
				match(T__3);
				setState(138);
				match(KEY_OP_IN);
				setState(139);
				match(KEY_PROP);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(141);
				match(KEY_BOOL);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(142);
				match(T__1);
				setState(143);
				match(KEY_BOOL);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(144);
				annot();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(145);
				match(T__1);
				setState(146);
				annot();
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

	public static class AnnotContext extends ParserRuleContext {
		public TerminalNode CC() { return getToken(queryParser.CC, 0); }
		public An_valueContext an_value() {
			return getRuleContext(An_valueContext.class,0);
		}
		public TerminalNode MM() { return getToken(queryParser.MM, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public TerminalNode PP() { return getToken(queryParser.PP, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public AnnotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAnnot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAnnot(this);
		}
	}

	public final AnnotContext annot() throws RecognitionException {
		AnnotContext _localctx = new AnnotContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_annot);
		try {
			setState(168);
			switch (_input.LA(1)) {
			case CC:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(CC);
				setState(150);
				match(T__7);
				setState(151);
				an_value();
				}
				break;
			case MM:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(MM);
				setState(153);
				match(T__2);
				setState(154);
				method();
				setState(155);
				match(T__3);
				setState(156);
				match(T__7);
				setState(157);
				an_value();
				}
				break;
			case PP:
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				match(PP);
				setState(160);
				match(T__2);
				setState(161);
				method();
				setState(162);
				match(T__3);
				setState(163);
				match(T__8);
				setState(164);
				index();
				setState(165);
				match(T__7);
				setState(166);
				an_value();
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

	public static class MethodContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(queryParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(queryParser.STRING, i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitMethod(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_method);
		try {
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(T__9);
				setState(172);
				match(T__10);
				setState(173);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(T__9);
				setState(175);
				match(T__10);
				setState(176);
				match(STRING);
				setState(177);
				match(T__0);
				setState(178);
				match(T__11);
				setState(179);
				match(T__10);
				setState(180);
				match(STRING);
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

	public static class IndexContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(queryParser.INT, 0); }
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitIndex(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__2);
			setState(184);
			match(INT);
			setState(185);
			match(T__3);
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

	public static class An_valueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public An_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_an_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAn_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAn_value(this);
		}
	}

	public final An_valueContext an_value() throws RecognitionException {
		An_valueContext _localctx = new An_valueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_an_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__2);
			setState(188);
			match(STRING);
			setState(189);
			match(T__3);
			setState(195);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(190);
				match(T__8);
				setState(191);
				match(T__2);
				setState(192);
				params();
				setState(193);
				match(T__3);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			param();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(198);
				match(T__0);
				setState(199);
				param();
				}
				}
				setState(204);
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

	public static class ParamContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(queryParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(queryParser.STRING, i);
		}
		public List<ParaContext> para() {
			return getRuleContexts(ParaContext.class);
		}
		public ParaContext para(int i) {
			return getRuleContext(ParaContext.class,i);
		}
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_param);
		int _la;
		try {
			setState(235);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				match(STRING);
				setState(207);
				match(T__10);
				setState(208);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(209);
				match(STRING);
				setState(210);
				match(T__10);
				setState(211);
				match(T__12);
				setState(212);
				para();
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(213);
					match(T__0);
					setState(214);
					para();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220);
				match(T__13);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(222);
				match(STRING);
				setState(223);
				match(T__10);
				setState(224);
				match(T__12);
				setState(225);
				param();
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(226);
					match(T__0);
					setState(227);
					param();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(233);
				match(T__13);
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

	public static class ParaContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public List<ParaContext> para() {
			return getRuleContexts(ParaContext.class);
		}
		public ParaContext para(int i) {
			return getRuleContext(ParaContext.class,i);
		}
		public ParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_para; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitPara(this);
		}
	}

	public final ParaContext para() throws RecognitionException {
		ParaContext _localctx = new ParaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_para);
		int _la;
		try {
			setState(249);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(STRING);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(T__12);
				setState(239);
				para();
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(240);
					match(T__0);
					setState(241);
					para();
					}
					}
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(247);
				match(T__13);
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

	public static class Order_byContext extends ParserRuleContext {
		public TerminalNode ORDER_BY() { return getToken(queryParser.ORDER_BY, 0); }
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public Order_byContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_order_by; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterOrder_by(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitOrder_by(this);
		}
	}

	public final Order_byContext order_by() throws RecognitionException {
		Order_byContext _localctx = new Order_byContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_order_by);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(ORDER_BY);
			setState(252);
			match(STRING);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37\u0101\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\5\2(\n\2\3\2\5\2+\n\2\3\2\5\2.\n\2\3\2\5\2\61\n\2\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"D\n\5\3\5\3\5\3\5\3\5\3\5\5\5K\n\5\3\5\5\5N\n\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\7\7V\n\7\f\7\16\7Y\13\7\3\b\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\7\ng\n\n\f\n\16\nj\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0096\n\13\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ab\n\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b8\n\r\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c6\n\17\3\20\3\20"+
		"\3\20\7\20\u00cb\n\20\f\20\16\20\u00ce\13\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u00da\n\21\f\21\16\21\u00dd\13\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00e7\n\21\f\21\16\21\u00ea\13"+
		"\21\3\21\3\21\5\21\u00ee\n\21\3\22\3\22\3\22\3\22\3\22\7\22\u00f5\n\22"+
		"\f\22\16\22\u00f8\13\22\3\22\3\22\5\22\u00fc\n\22\3\23\3\23\3\23\3\23"+
		"\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2\u0111\2\'\3\2\2"+
		"\2\4\62\3\2\2\2\6\65\3\2\2\2\bM\3\2\2\2\nO\3\2\2\2\fR\3\2\2\2\16^\3\2"+
		"\2\2\20`\3\2\2\2\22c\3\2\2\2\24\u0095\3\2\2\2\26\u00aa\3\2\2\2\30\u00b7"+
		"\3\2\2\2\32\u00b9\3\2\2\2\34\u00bd\3\2\2\2\36\u00c7\3\2\2\2 \u00ed\3\2"+
		"\2\2\"\u00fb\3\2\2\2$\u00fd\3\2\2\2&(\5\4\3\2\'&\3\2\2\2\'(\3\2\2\2(*"+
		"\3\2\2\2)+\5\n\6\2*)\3\2\2\2*+\3\2\2\2+-\3\2\2\2,.\5\20\t\2-,\3\2\2\2"+
		"-.\3\2\2\2.\60\3\2\2\2/\61\5$\23\2\60/\3\2\2\2\60\61\3\2\2\2\61\3\3\2"+
		"\2\2\62\63\7\21\2\2\63\64\5\6\4\2\64\5\3\2\2\2\65:\5\b\5\2\66\67\7\3\2"+
		"\2\679\5\b\5\28\66\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\7\3\2\2\2<:"+
		"\3\2\2\2=>\7\4\2\2>C\7\22\2\2?@\7\5\2\2@A\5\30\r\2AB\7\6\2\2BD\3\2\2\2"+
		"C?\3\2\2\2CD\3\2\2\2DN\3\2\2\2EJ\7\22\2\2FG\7\5\2\2GH\5\30\r\2HI\7\6\2"+
		"\2IK\3\2\2\2JF\3\2\2\2JK\3\2\2\2KN\3\2\2\2LN\7\7\2\2M=\3\2\2\2ME\3\2\2"+
		"\2ML\3\2\2\2N\t\3\2\2\2OP\7\23\2\2PQ\5\f\7\2Q\13\3\2\2\2RW\5\16\b\2ST"+
		"\7\3\2\2TV\5\16\b\2US\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X\r\3\2\2\2"+
		"YW\3\2\2\2Z_\7\36\2\2[\\\7\4\2\2\\_\7\36\2\2]_\7\7\2\2^Z\3\2\2\2^[\3\2"+
		"\2\2^]\3\2\2\2_\17\3\2\2\2`a\7\24\2\2ab\5\22\n\2b\21\3\2\2\2ch\5\24\13"+
		"\2de\7\25\2\2eg\5\24\13\2fd\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\23"+
		"\3\2\2\2jh\3\2\2\2kl\7\22\2\2lm\7\26\2\2m\u0096\7\36\2\2no\7\36\2\2op"+
		"\7\27\2\2p\u0096\7\22\2\2qr\7\22\2\2rs\7\5\2\2st\7\36\2\2tu\7\6\2\2uv"+
		"\7\27\2\2vw\7\b\2\2wx\5\2\2\2xy\7\t\2\2y\u0096\3\2\2\2z{\7\22\2\2{|\7"+
		"\27\2\2|}\7\b\2\2}~\5\2\2\2~\177\7\t\2\2\177\u0096\3\2\2\2\u0080\u0081"+
		"\7\b\2\2\u0081\u0082\5\2\2\2\u0082\u0083\7\t\2\2\u0083\u0084\7\27\2\2"+
		"\u0084\u0085\7\22\2\2\u0085\u0096\3\2\2\2\u0086\u0087\7\b\2\2\u0087\u0088"+
		"\5\2\2\2\u0088\u0089\7\t\2\2\u0089\u008a\7\5\2\2\u008a\u008b\7\36\2\2"+
		"\u008b\u008c\7\6\2\2\u008c\u008d\7\27\2\2\u008d\u008e\7\22\2\2\u008e\u0096"+
		"\3\2\2\2\u008f\u0096\7\30\2\2\u0090\u0091\7\4\2\2\u0091\u0096\7\30\2\2"+
		"\u0092\u0096\5\26\f\2\u0093\u0094\7\4\2\2\u0094\u0096\5\26\f\2\u0095k"+
		"\3\2\2\2\u0095n\3\2\2\2\u0095q\3\2\2\2\u0095z\3\2\2\2\u0095\u0080\3\2"+
		"\2\2\u0095\u0086\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0090\3\2\2\2\u0095"+
		"\u0092\3\2\2\2\u0095\u0093\3\2\2\2\u0096\25\3\2\2\2\u0097\u0098\7\31\2"+
		"\2\u0098\u0099\7\n\2\2\u0099\u00ab\5\34\17\2\u009a\u009b\7\32\2\2\u009b"+
		"\u009c\7\5\2\2\u009c\u009d\5\30\r\2\u009d\u009e\7\6\2\2\u009e\u009f\7"+
		"\n\2\2\u009f\u00a0\5\34\17\2\u00a0\u00ab\3\2\2\2\u00a1\u00a2\7\33\2\2"+
		"\u00a2\u00a3\7\5\2\2\u00a3\u00a4\5\30\r\2\u00a4\u00a5\7\6\2\2\u00a5\u00a6"+
		"\7\13\2\2\u00a6\u00a7\5\32\16\2\u00a7\u00a8\7\n\2\2\u00a8\u00a9\5\34\17"+
		"\2\u00a9\u00ab\3\2\2\2\u00aa\u0097\3\2\2\2\u00aa\u009a\3\2\2\2\u00aa\u00a1"+
		"\3\2\2\2\u00ab\27\3\2\2\2\u00ac\u00b8\7\36\2\2\u00ad\u00ae\7\f\2\2\u00ae"+
		"\u00af\7\r\2\2\u00af\u00b8\7\36\2\2\u00b0\u00b1\7\f\2\2\u00b1\u00b2\7"+
		"\r\2\2\u00b2\u00b3\7\36\2\2\u00b3\u00b4\7\3\2\2\u00b4\u00b5\7\16\2\2\u00b5"+
		"\u00b6\7\r\2\2\u00b6\u00b8\7\36\2\2\u00b7\u00ac\3\2\2\2\u00b7\u00ad\3"+
		"\2\2\2\u00b7\u00b0\3\2\2\2\u00b8\31\3\2\2\2\u00b9\u00ba\7\5\2\2\u00ba"+
		"\u00bb\7\35\2\2\u00bb\u00bc\7\6\2\2\u00bc\33\3\2\2\2\u00bd\u00be\7\5\2"+
		"\2\u00be\u00bf\7\36\2\2\u00bf\u00c5\7\6\2\2\u00c0\u00c1\7\13\2\2\u00c1"+
		"\u00c2\7\5\2\2\u00c2\u00c3\5\36\20\2\u00c3\u00c4\7\6\2\2\u00c4\u00c6\3"+
		"\2\2\2\u00c5\u00c0\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\35\3\2\2\2\u00c7"+
		"\u00cc\5 \21\2\u00c8\u00c9\7\3\2\2\u00c9\u00cb\5 \21\2\u00ca\u00c8\3\2"+
		"\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\37\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00ee\7\36\2\2\u00d0\u00d1\7\36"+
		"\2\2\u00d1\u00d2\7\r\2\2\u00d2\u00ee\7\36\2\2\u00d3\u00d4\7\36\2\2\u00d4"+
		"\u00d5\7\r\2\2\u00d5\u00d6\7\17\2\2\u00d6\u00db\5\"\22\2\u00d7\u00d8\7"+
		"\3\2\2\u00d8\u00da\5\"\22\2\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00de\u00df\7\20\2\2\u00df\u00ee\3\2\2\2\u00e0\u00e1\7\36\2\2\u00e1"+
		"\u00e2\7\r\2\2\u00e2\u00e3\7\17\2\2\u00e3\u00e8\5 \21\2\u00e4\u00e5\7"+
		"\3\2\2\u00e5\u00e7\5 \21\2\u00e6\u00e4\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\3\2\2\2\u00ea\u00e8\3\2"+
		"\2\2\u00eb\u00ec\7\20\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00cf\3\2\2\2\u00ed"+
		"\u00d0\3\2\2\2\u00ed\u00d3\3\2\2\2\u00ed\u00e0\3\2\2\2\u00ee!\3\2\2\2"+
		"\u00ef\u00fc\7\36\2\2\u00f0\u00f1\7\17\2\2\u00f1\u00f6\5\"\22\2\u00f2"+
		"\u00f3\7\3\2\2\u00f3\u00f5\5\"\22\2\u00f4\u00f2\3\2\2\2\u00f5\u00f8\3"+
		"\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f9\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f9\u00fa\7\20\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00ef\3"+
		"\2\2\2\u00fb\u00f0\3\2\2\2\u00fc#\3\2\2\2\u00fd\u00fe\7\34\2\2\u00fe\u00ff"+
		"\7\36\2\2\u00ff%\3\2\2\2\27\'*-\60:CJMW^h\u0095\u00aa\u00b7\u00c5\u00cc"+
		"\u00db\u00e8\u00ed\u00f6\u00fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}