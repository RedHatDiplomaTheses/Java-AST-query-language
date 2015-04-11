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
		SELECT=1, FROM=2, WHERE=3, AND=4, MM=5, OPERATORS=6, COMMA=7, LBRACKET=8, 
		RBRACKET=9, LPAREN=10, RPAREN=11, EXCLAMANTION=12, STAR=13, AT=14, DOT=15, 
		INT=16, NAME=17, STRING=18, WS=19;
	public static final int
		RULE_program = 0, RULE_selectStatment = 1, RULE_paramSelect = 2, RULE_paramName = 3, 
		RULE_alias = 4, RULE_packages = 5, RULE_packageName = 6, RULE_as = 7, 
		RULE_conditions = 8, RULE_cond = 9, RULE_equal = 10, RULE_rightStatment = 11, 
		RULE_innerSelect = 12, RULE_annotated = 13, RULE_method = 14, RULE_index = 15, 
		RULE_annotatedStatment = 16, RULE_annotatedName = 17, RULE_annotatedParams = 18;
	public static final String[] ruleNames = {
		"program", "selectStatment", "paramSelect", "paramName", "alias", "packages", 
		"packageName", "as", "conditions", "cond", "equal", "rightStatment", "innerSelect", 
		"annotated", "method", "index", "annotatedStatment", "annotatedName", 
		"annotatedParams"
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
	public static class ProgramContext extends ParserRuleContext {
		public SelectStatmentContext selectStatment() {
			return getRuleContext(SelectStatmentContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			selectStatment();
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

	public static class SelectStatmentContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(queryParser.SELECT, 0); }
		public ParamSelectContext paramSelect() {
			return getRuleContext(ParamSelectContext.class,0);
		}
		public TerminalNode FROM() { return getToken(queryParser.FROM, 0); }
		public PackagesContext packages() {
			return getRuleContext(PackagesContext.class,0);
		}
		public TerminalNode WHERE() { return getToken(queryParser.WHERE, 0); }
		public ConditionsContext conditions() {
			return getRuleContext(ConditionsContext.class,0);
		}
		public SelectStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterSelectStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitSelectStatment(this);
		}
	}

	public final SelectStatmentContext selectStatment() throws RecognitionException {
		SelectStatmentContext _localctx = new SelectStatmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_selectStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if (_la==SELECT) {
				{
				setState(40);
				match(SELECT);
				setState(41);
				paramSelect();
				}
			}

			setState(46);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(44);
				match(FROM);
				setState(45);
				packages();
				}
			}

			setState(50);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(48);
				match(WHERE);
				setState(49);
				conditions();
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

	public static class ParamSelectContext extends ParserRuleContext {
		public List<ParamNameContext> paramName() {
			return getRuleContexts(ParamNameContext.class);
		}
		public ParamNameContext paramName(int i) {
			return getRuleContext(ParamNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(queryParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(queryParser.COMMA, i);
		}
		public TerminalNode STAR() { return getToken(queryParser.STAR, 0); }
		public ParamSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramSelect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterParamSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitParamSelect(this);
		}
	}

	public final ParamSelectContext paramSelect() throws RecognitionException {
		ParamSelectContext _localctx = new ParamSelectContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_paramSelect);
		int _la;
		try {
			setState(61);
			switch (_input.LA(1)) {
			case LPAREN:
			case EXCLAMANTION:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				paramName();
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(53);
					match(COMMA);
					setState(54);
					paramName();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				match(STAR);
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

	public static class ParamNameContext extends ParserRuleContext {
		public TerminalNode EXCLAMANTION() { return getToken(queryParser.EXCLAMANTION, 0); }
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(queryParser.LBRACKET, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(queryParser.RBRACKET, 0); }
		public InnerSelectContext innerSelect() {
			return getRuleContext(InnerSelectContext.class,0);
		}
		public ParamNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterParamName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitParamName(this);
		}
	}

	public final ParamNameContext paramName() throws RecognitionException {
		ParamNameContext _localctx = new ParamNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paramName);
		int _la;
		try {
			setState(79);
			switch (_input.LA(1)) {
			case EXCLAMANTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				match(EXCLAMANTION);
				setState(65);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(64);
					alias();
					}
					break;
				}
				setState(67);
				match(NAME);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(68);
					alias();
					}
					break;
				}
				setState(71);
				match(NAME);
				setState(76);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(72);
					match(LBRACKET);
					setState(73);
					method();
					setState(74);
					match(RBRACKET);
					}
				}

				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				innerSelect();
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

	public static class AliasContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(queryParser.DOT, 0); }
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public AliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAlias(this);
		}
	}

	public final AliasContext alias() throws RecognitionException {
		AliasContext _localctx = new AliasContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(81);
			match(NAME);
			}
			setState(82);
			match(DOT);
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

	public static class PackagesContext extends ParserRuleContext {
		public List<PackageNameContext> packageName() {
			return getRuleContexts(PackageNameContext.class);
		}
		public PackageNameContext packageName(int i) {
			return getRuleContext(PackageNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(queryParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(queryParser.COMMA, i);
		}
		public TerminalNode STAR() { return getToken(queryParser.STAR, 0); }
		public PackagesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packages; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterPackages(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitPackages(this);
		}
	}

	public final PackagesContext packages() throws RecognitionException {
		PackagesContext _localctx = new PackagesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_packages);
		int _la;
		try {
			setState(93);
			switch (_input.LA(1)) {
			case LPAREN:
			case EXCLAMANTION:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				packageName();
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(85);
					match(COMMA);
					setState(86);
					packageName();
					}
					}
					setState(91);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				match(STAR);
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

	public static class PackageNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public TerminalNode EXCLAMANTION() { return getToken(queryParser.EXCLAMANTION, 0); }
		public InnerSelectContext innerSelect() {
			return getRuleContext(InnerSelectContext.class,0);
		}
		public PackageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitPackageName(this);
		}
	}

	public final PackageNameContext packageName() throws RecognitionException {
		PackageNameContext _localctx = new PackageNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_packageName);
		int _la;
		try {
			setState(108);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				match(STRING);
				setState(97);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(96);
					as();
					}
				}

				}
				break;
			case EXCLAMANTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(EXCLAMANTION);
				setState(100);
				match(STRING);
				setState(102);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(101);
					as();
					}
				}

				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(104);
				innerSelect();
				setState(106);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(105);
					as();
					}
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

	public static class AsContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(queryParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(queryParser.NAME, i);
		}
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAs(this);
		}
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(NAME);
			setState(111);
			match(NAME);
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

	public static class ConditionsContext extends ParserRuleContext {
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(queryParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(queryParser.AND, i);
		}
		public ConditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterConditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitConditions(this);
		}
	}

	public final ConditionsContext conditions() throws RecognitionException {
		ConditionsContext _localctx = new ConditionsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			cond();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(114);
				match(AND);
				setState(115);
				cond();
				}
				}
				setState(120);
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

	public static class CondContext extends ParserRuleContext {
		public EqualContext equal() {
			return getRuleContext(EqualContext.class,0);
		}
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public InnerSelectContext innerSelect() {
			return getRuleContext(InnerSelectContext.class,0);
		}
		public TerminalNode OPERATORS() { return getToken(queryParser.OPERATORS, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public TerminalNode EXCLAMANTION() { return getToken(queryParser.EXCLAMANTION, 0); }
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
		enterRule(_localctx, 18, RULE_cond);
		try {
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				equal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(NAME);
				setState(123);
				innerSelect();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				innerSelect();
				setState(125);
				match(OPERATORS);
				setState(127);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(126);
					alias();
					}
					break;
				}
				setState(129);
				match(NAME);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				match(EXCLAMANTION);
				setState(133);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(132);
					alias();
					}
					break;
				}
				setState(135);
				match(NAME);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(137);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(136);
					alias();
					}
					break;
				}
				setState(139);
				match(NAME);
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

	public static class EqualContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public TerminalNode OPERATORS() { return getToken(queryParser.OPERATORS, 0); }
		public RightStatmentContext rightStatment() {
			return getRuleContext(RightStatmentContext.class,0);
		}
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public AnnotatedContext annotated() {
			return getRuleContext(AnnotatedContext.class,0);
		}
		public EqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitEqual(this);
		}
	}

	public final EqualContext equal() throws RecognitionException {
		EqualContext _localctx = new EqualContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_equal);
		int _la;
		try {
			setState(159);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(142);
					alias();
					}
					break;
				}
				setState(145);
				match(NAME);
				setState(146);
				match(OPERATORS);
				setState(147);
				rightStatment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(148);
					alias();
					}
				}

				setState(151);
				annotated();
				setState(152);
				match(OPERATORS);
				setState(153);
				rightStatment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(155);
					alias();
					}
				}

				setState(158);
				annotated();
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

	public static class RightStatmentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public AnnotatedContext annotated() {
			return getRuleContext(AnnotatedContext.class,0);
		}
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public RightStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rightStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterRightStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitRightStatment(this);
		}
	}

	public final RightStatmentContext rightStatment() throws RecognitionException {
		RightStatmentContext _localctx = new RightStatmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rightStatment);
		int _la;
		try {
			setState(170);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(161);
					alias();
					}
					break;
				}
				setState(164);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				_la = _input.LA(1);
				if (_la==NAME) {
					{
					setState(165);
					alias();
					}
				}

				setState(168);
				annotated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
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

	public static class InnerSelectContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(queryParser.LPAREN, 0); }
		public SelectStatmentContext selectStatment() {
			return getRuleContext(SelectStatmentContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(queryParser.RPAREN, 0); }
		public InnerSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerSelect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterInnerSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitInnerSelect(this);
		}
	}

	public final InnerSelectContext innerSelect() throws RecognitionException {
		InnerSelectContext _localctx = new InnerSelectContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_innerSelect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(LPAREN);
			setState(173);
			selectStatment();
			setState(174);
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

	public static class AnnotatedContext extends ParserRuleContext {
		public AnnotatedStatmentContext annotatedStatment() {
			return getRuleContext(AnnotatedStatmentContext.class,0);
		}
		public TerminalNode MM() { return getToken(queryParser.MM, 0); }
		public TerminalNode LBRACKET() { return getToken(queryParser.LBRACKET, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(queryParser.RBRACKET, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public AnnotatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAnnotated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAnnotated(this);
		}
	}

	public final AnnotatedContext annotated() throws RecognitionException {
		AnnotatedContext _localctx = new AnnotatedContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_annotated);
		int _la;
		try {
			setState(186);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				annotatedStatment();
				}
				break;
			case MM:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(MM);
				setState(178);
				match(LBRACKET);
				setState(179);
				method();
				setState(180);
				match(RBRACKET);
				setState(182);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(181);
					index();
					}
				}

				setState(184);
				annotatedStatment();
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
		public List<TerminalNode> NAME() { return getTokens(queryParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(queryParser.NAME, i);
		}
		public List<TerminalNode> OPERATORS() { return getTokens(queryParser.OPERATORS); }
		public TerminalNode OPERATORS(int i) {
			return getToken(queryParser.OPERATORS, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(queryParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(queryParser.COMMA, i);
		}
		public TerminalNode STAR() { return getToken(queryParser.STAR, 0); }
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
		enterRule(_localctx, 28, RULE_method);
		int _la;
		try {
			setState(202);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(STRING);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(NAME);
				setState(190);
				match(OPERATORS);
				setState(191);
				match(STRING);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(192);
					match(COMMA);
					setState(193);
					match(NAME);
					setState(194);
					match(OPERATORS);
					setState(195);
					match(STRING);
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
				match(STAR);
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

	public static class IndexContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(queryParser.LBRACKET, 0); }
		public TerminalNode INT() { return getToken(queryParser.INT, 0); }
		public TerminalNode RBRACKET() { return getToken(queryParser.RBRACKET, 0); }
		public TerminalNode STAR() { return getToken(queryParser.STAR, 0); }
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
		enterRule(_localctx, 30, RULE_index);
		try {
			setState(210);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(LBRACKET);
				setState(205);
				match(INT);
				setState(206);
				match(RBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(LBRACKET);
				setState(208);
				match(STAR);
				setState(209);
				match(RBRACKET);
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

	public static class AnnotatedStatmentContext extends ParserRuleContext {
		public AnnotatedNameContext annotatedName() {
			return getRuleContext(AnnotatedNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(queryParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(queryParser.DOT, i);
		}
		public List<AnnotatedParamsContext> annotatedParams() {
			return getRuleContexts(AnnotatedParamsContext.class);
		}
		public AnnotatedParamsContext annotatedParams(int i) {
			return getRuleContext(AnnotatedParamsContext.class,i);
		}
		public AnnotatedStatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotatedStatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAnnotatedStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAnnotatedStatment(this);
		}
	}

	public final AnnotatedStatmentContext annotatedStatment() throws RecognitionException {
		AnnotatedStatmentContext _localctx = new AnnotatedStatmentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_annotatedStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			annotatedName();
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(213);
				match(DOT);
				setState(214);
				annotatedParams();
				}
				}
				setState(219);
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

	public static class AnnotatedNameContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(queryParser.AT, 0); }
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public AnnotatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotatedName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAnnotatedName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAnnotatedName(this);
		}
	}

	public final AnnotatedNameContext annotatedName() throws RecognitionException {
		AnnotatedNameContext _localctx = new AnnotatedNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_annotatedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(AT);
			setState(221);
			match(NAME);
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

	public static class AnnotatedParamsContext extends ParserRuleContext {
		public AnnotatedNameContext annotatedName() {
			return getRuleContext(AnnotatedNameContext.class,0);
		}
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public AnnotatedParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotatedParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAnnotatedParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAnnotatedParams(this);
		}
	}

	public final AnnotatedParamsContext annotatedParams() throws RecognitionException {
		AnnotatedParamsContext _localctx = new AnnotatedParamsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_annotatedParams);
		int _la;
		try {
			setState(228);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				annotatedName();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				match(NAME);
				setState(226);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(225);
					index();
					}
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\25\u00e9\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\5\3-\n\3\3\3\3\3\5\3\61\n\3\3\3\3"+
		"\3\5\3\65\n\3\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\5\4@\n\4\3\5\3\5"+
		"\5\5D\n\5\3\5\3\5\5\5H\n\5\3\5\3\5\3\5\3\5\3\5\5\5O\n\5\3\5\5\5R\n\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\7\7Z\n\7\f\7\16\7]\13\7\3\7\5\7`\n\7\3\b\3\b\5"+
		"\bd\n\b\3\b\3\b\3\b\5\bi\n\b\3\b\3\b\5\bm\n\b\5\bo\n\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\7\nw\n\n\f\n\16\nz\13\n\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0082"+
		"\n\13\3\13\3\13\3\13\3\13\5\13\u0088\n\13\3\13\3\13\5\13\u008c\n\13\3"+
		"\13\5\13\u008f\n\13\3\f\5\f\u0092\n\f\3\f\3\f\3\f\3\f\5\f\u0098\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u009f\n\f\3\f\5\f\u00a2\n\f\3\r\5\r\u00a5\n\r\3"+
		"\r\3\r\5\r\u00a9\n\r\3\r\3\r\5\r\u00ad\n\r\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u00b9\n\17\3\17\3\17\5\17\u00bd\n\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00c7\n\20\f\20\16\20\u00ca\13"+
		"\20\3\20\5\20\u00cd\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00d5\n\21"+
		"\3\22\3\22\3\22\7\22\u00da\n\22\f\22\16\22\u00dd\13\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\5\24\u00e5\n\24\5\24\u00e7\n\24\3\24\2\2\25\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&\2\2\u0100\2(\3\2\2\2\4,\3\2\2\2\6?"+
		"\3\2\2\2\bQ\3\2\2\2\nS\3\2\2\2\f_\3\2\2\2\16n\3\2\2\2\20p\3\2\2\2\22s"+
		"\3\2\2\2\24\u008e\3\2\2\2\26\u00a1\3\2\2\2\30\u00ac\3\2\2\2\32\u00ae\3"+
		"\2\2\2\34\u00bc\3\2\2\2\36\u00cc\3\2\2\2 \u00d4\3\2\2\2\"\u00d6\3\2\2"+
		"\2$\u00de\3\2\2\2&\u00e6\3\2\2\2()\5\4\3\2)\3\3\2\2\2*+\7\3\2\2+-\5\6"+
		"\4\2,*\3\2\2\2,-\3\2\2\2-\60\3\2\2\2./\7\4\2\2/\61\5\f\7\2\60.\3\2\2\2"+
		"\60\61\3\2\2\2\61\64\3\2\2\2\62\63\7\5\2\2\63\65\5\22\n\2\64\62\3\2\2"+
		"\2\64\65\3\2\2\2\65\5\3\2\2\2\66;\5\b\5\2\678\7\t\2\28:\5\b\5\29\67\3"+
		"\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<@\3\2\2\2=;\3\2\2\2>@\7\17\2\2?\66"+
		"\3\2\2\2?>\3\2\2\2@\7\3\2\2\2AC\7\16\2\2BD\5\n\6\2CB\3\2\2\2CD\3\2\2\2"+
		"DE\3\2\2\2ER\7\23\2\2FH\5\n\6\2GF\3\2\2\2GH\3\2\2\2HI\3\2\2\2IN\7\23\2"+
		"\2JK\7\n\2\2KL\5\36\20\2LM\7\13\2\2MO\3\2\2\2NJ\3\2\2\2NO\3\2\2\2OR\3"+
		"\2\2\2PR\5\32\16\2QA\3\2\2\2QG\3\2\2\2QP\3\2\2\2R\t\3\2\2\2ST\7\23\2\2"+
		"TU\7\21\2\2U\13\3\2\2\2V[\5\16\b\2WX\7\t\2\2XZ\5\16\b\2YW\3\2\2\2Z]\3"+
		"\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\`\3\2\2\2][\3\2\2\2^`\7\17\2\2_V\3\2\2\2"+
		"_^\3\2\2\2`\r\3\2\2\2ac\7\24\2\2bd\5\20\t\2cb\3\2\2\2cd\3\2\2\2do\3\2"+
		"\2\2ef\7\16\2\2fh\7\24\2\2gi\5\20\t\2hg\3\2\2\2hi\3\2\2\2io\3\2\2\2jl"+
		"\5\32\16\2km\5\20\t\2lk\3\2\2\2lm\3\2\2\2mo\3\2\2\2na\3\2\2\2ne\3\2\2"+
		"\2nj\3\2\2\2o\17\3\2\2\2pq\7\23\2\2qr\7\23\2\2r\21\3\2\2\2sx\5\24\13\2"+
		"tu\7\6\2\2uw\5\24\13\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\23\3\2"+
		"\2\2zx\3\2\2\2{\u008f\5\26\f\2|}\7\23\2\2}\u008f\5\32\16\2~\177\5\32\16"+
		"\2\177\u0081\7\b\2\2\u0080\u0082\5\n\6\2\u0081\u0080\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\23\2\2\u0084\u008f\3\2\2\2"+
		"\u0085\u0087\7\16\2\2\u0086\u0088\5\n\6\2\u0087\u0086\3\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008f\7\23\2\2\u008a\u008c\5\n\6\2"+
		"\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f"+
		"\7\23\2\2\u008e{\3\2\2\2\u008e|\3\2\2\2\u008e~\3\2\2\2\u008e\u0085\3\2"+
		"\2\2\u008e\u008b\3\2\2\2\u008f\25\3\2\2\2\u0090\u0092\5\n\6\2\u0091\u0090"+
		"\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\23\2\2"+
		"\u0094\u0095\7\b\2\2\u0095\u00a2\5\30\r\2\u0096\u0098\5\n\6\2\u0097\u0096"+
		"\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\5\34\17\2"+
		"\u009a\u009b\7\b\2\2\u009b\u009c\5\30\r\2\u009c\u00a2\3\2\2\2\u009d\u009f"+
		"\5\n\6\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0"+
		"\u00a2\5\34\17\2\u00a1\u0091\3\2\2\2\u00a1\u0097\3\2\2\2\u00a1\u009e\3"+
		"\2\2\2\u00a2\27\3\2\2\2\u00a3\u00a5\5\n\6\2\u00a4\u00a3\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00ad\7\23\2\2\u00a7\u00a9\5"+
		"\n\6\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ad\5\34\17\2\u00ab\u00ad\7\24\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a8"+
		"\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\31\3\2\2\2\u00ae\u00af\7\f\2\2\u00af"+
		"\u00b0\5\4\3\2\u00b0\u00b1\7\r\2\2\u00b1\33\3\2\2\2\u00b2\u00bd\5\"\22"+
		"\2\u00b3\u00b4\7\7\2\2\u00b4\u00b5\7\n\2\2\u00b5\u00b6\5\36\20\2\u00b6"+
		"\u00b8\7\13\2\2\u00b7\u00b9\5 \21\2\u00b8\u00b7\3\2\2\2\u00b8\u00b9\3"+
		"\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\5\"\22\2\u00bb\u00bd\3\2\2\2\u00bc"+
		"\u00b2\3\2\2\2\u00bc\u00b3\3\2\2\2\u00bd\35\3\2\2\2\u00be\u00cd\7\24\2"+
		"\2\u00bf\u00c0\7\23\2\2\u00c0\u00c1\7\b\2\2\u00c1\u00c8\7\24\2\2\u00c2"+
		"\u00c3\7\t\2\2\u00c3\u00c4\7\23\2\2\u00c4\u00c5\7\b\2\2\u00c5\u00c7\7"+
		"\24\2\2\u00c6\u00c2\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8"+
		"\u00c9\3\2\2\2\u00c9\u00cd\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\7\17"+
		"\2\2\u00cc\u00be\3\2\2\2\u00cc\u00bf\3\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\37\3\2\2\2\u00ce\u00cf\7\n\2\2\u00cf\u00d0\7\22\2\2\u00d0\u00d5\7\13"+
		"\2\2\u00d1\u00d2\7\n\2\2\u00d2\u00d3\7\17\2\2\u00d3\u00d5\7\13\2\2\u00d4"+
		"\u00ce\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d5!\3\2\2\2\u00d6\u00db\5$\23\2"+
		"\u00d7\u00d8\7\21\2\2\u00d8\u00da\5&\24\2\u00d9\u00d7\3\2\2\2\u00da\u00dd"+
		"\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc#\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00de\u00df\7\20\2\2\u00df\u00e0\7\23\2\2\u00e0%\3\2\2"+
		"\2\u00e1\u00e7\5$\23\2\u00e2\u00e4\7\23\2\2\u00e3\u00e5\5 \21\2\u00e4"+
		"\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e1\3\2"+
		"\2\2\u00e6\u00e2\3\2\2\2\u00e7\'\3\2\2\2%,\60\64;?CGNQ[_chlnx\u0081\u0087"+
		"\u008b\u008e\u0091\u0097\u009e\u00a1\u00a4\u00a8\u00ac\u00b8\u00bc\u00c8"+
		"\u00cc\u00d4\u00db\u00e4\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}