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
		SELECT=1, FROM=2, WHERE=3, AND=4, EXIST=5, NOT_EXIST=6, METHOD=7, JOIN=8, 
		OPERATORS=9, ORDER_BY=10, UNIQUE=11, COMMA=12, LBRACKET=13, RBRACKET=14, 
		LPAREN=15, RPAREN=16, EXCLAMANTION=17, STAR=18, AT_NAME=19, DOT=20, NAME_DOT=21, 
		DOT_NAME=22, AS=23, INT=24, NAME=25, PATTERN=26, STRING=27, WS=28;
	public static final int
		RULE_program = 0, RULE_selectStatment = 1, RULE_paramSelect = 2, RULE_paramName = 3, 
		RULE_packages = 4, RULE_packageLink = 5, RULE_packageName = 6, RULE_alias = 7, 
		RULE_as = 8, RULE_conditions = 9, RULE_cond = 10, RULE_equal = 11, RULE_rightStatment = 12, 
		RULE_innerSelect = 13, RULE_annotated = 14, RULE_annotatedStatment = 15, 
		RULE_annotatedParams = 16, RULE_method = 17, RULE_index = 18;
	public static final String[] ruleNames = {
		"program", "selectStatment", "paramSelect", "paramName", "packages", "packageLink", 
		"packageName", "alias", "as", "conditions", "cond", "equal", "rightStatment", 
		"innerSelect", "annotated", "annotatedStatment", "annotatedParams", "method", 
		"index"
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
		public TerminalNode ORDER_BY() { return getToken(queryParser.ORDER_BY, 0); }
		public TerminalNode UNIQUE() { return getToken(queryParser.UNIQUE, 0); }
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

			setState(53);
			_la = _input.LA(1);
			if (_la==ORDER_BY) {
				{
				setState(52);
				match(ORDER_BY);
				}
			}

			setState(56);
			_la = _input.LA(1);
			if (_la==UNIQUE) {
				{
				setState(55);
				match(UNIQUE);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			paramName();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(59);
				match(COMMA);
				setState(60);
				paramName();
				}
				}
				setState(65);
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
		public TerminalNode STAR() { return getToken(queryParser.STAR, 0); }
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
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				match(EXCLAMANTION);
				setState(68);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(67);
					alias();
					}
				}

				setState(70);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(71);
					alias();
					}
				}

				setState(74);
				match(NAME);
				setState(79);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(75);
					match(LBRACKET);
					setState(76);
					method();
					setState(77);
					match(RBRACKET);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				innerSelect();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(83);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(82);
					alias();
					}
				}

				setState(85);
				match(STAR);
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

	public static class PackagesContext extends ParserRuleContext {
		public List<PackageLinkContext> packageLink() {
			return getRuleContexts(PackageLinkContext.class);
		}
		public PackageLinkContext packageLink(int i) {
			return getRuleContext(PackageLinkContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(queryParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(queryParser.COMMA, i);
		}
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
		enterRule(_localctx, 8, RULE_packages);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			packageLink();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(89);
				match(COMMA);
				setState(90);
				packageLink();
				}
				}
				setState(95);
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

	public static class PackageLinkContext extends ParserRuleContext {
		public List<PackageNameContext> packageName() {
			return getRuleContexts(PackageNameContext.class);
		}
		public PackageNameContext packageName(int i) {
			return getRuleContext(PackageNameContext.class,i);
		}
		public List<TerminalNode> JOIN() { return getTokens(queryParser.JOIN); }
		public TerminalNode JOIN(int i) {
			return getToken(queryParser.JOIN, i);
		}
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public TerminalNode STAR() { return getToken(queryParser.STAR, 0); }
		public PackageLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterPackageLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitPackageLink(this);
		}
	}

	public final PackageLinkContext packageLink() throws RecognitionException {
		PackageLinkContext _localctx = new PackageLinkContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_packageLink);
		int _la;
		try {
			setState(111);
			switch (_input.LA(1)) {
			case LPAREN:
			case EXCLAMANTION:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				packageName();
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==JOIN) {
					{
					{
					setState(97);
					match(JOIN);
					setState(98);
					packageName();
					}
					}
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(104);
					as();
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(STAR);
				setState(109);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(108);
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

	public static class PackageNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
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
			setState(118);
			switch (_input.LA(1)) {
			case EXCLAMANTION:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				_la = _input.LA(1);
				if (_la==EXCLAMANTION) {
					{
					setState(113);
					match(EXCLAMANTION);
					}
				}

				setState(116);
				match(STRING);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
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
		public TerminalNode NAME_DOT() { return getToken(queryParser.NAME_DOT, 0); }
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
		enterRule(_localctx, 14, RULE_alias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(NAME_DOT);
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
		public TerminalNode AS() { return getToken(queryParser.AS, 0); }
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
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
		enterRule(_localctx, 16, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(AS);
			setState(123);
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
		enterRule(_localctx, 18, RULE_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			cond();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(126);
				match(AND);
				setState(127);
				cond();
				}
				}
				setState(132);
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
		public InnerSelectContext innerSelect() {
			return getRuleContext(InnerSelectContext.class,0);
		}
		public TerminalNode EXIST() { return getToken(queryParser.EXIST, 0); }
		public TerminalNode NOT_EXIST() { return getToken(queryParser.NOT_EXIST, 0); }
		public TerminalNode OPERATORS() { return getToken(queryParser.OPERATORS, 0); }
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
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
		enterRule(_localctx, 20, RULE_cond);
		int _la;
		try {
			setState(150);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				equal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				_la = _input.LA(1);
				if ( !(_la==EXIST || _la==NOT_EXIST) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(135);
				innerSelect();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				innerSelect();
				setState(137);
				match(OPERATORS);
				setState(139);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(138);
					alias();
					}
				}

				setState(141);
				match(NAME);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				_la = _input.LA(1);
				if (_la==EXCLAMANTION) {
					{
					setState(143);
					match(EXCLAMANTION);
					}
				}

				setState(147);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(146);
					alias();
					}
				}

				setState(149);
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
		public TerminalNode METHOD() { return getToken(queryParser.METHOD, 0); }
		public TerminalNode LBRACKET() { return getToken(queryParser.LBRACKET, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(queryParser.RBRACKET, 0); }
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
		enterRule(_localctx, 22, RULE_equal);
		int _la;
		try {
			setState(177);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(152);
					alias();
					}
				}

				setState(155);
				match(NAME);
				setState(156);
				match(OPERATORS);
				setState(157);
				rightStatment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(158);
					alias();
					}
				}

				setState(161);
				annotated();
				setState(162);
				match(OPERATORS);
				setState(163);
				rightStatment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(165);
					alias();
					}
				}

				setState(168);
				annotated();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(169);
					alias();
					}
				}

				setState(172);
				match(METHOD);
				setState(173);
				match(LBRACKET);
				setState(174);
				method();
				setState(175);
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

	public static class RightStatmentContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public AliasContext alias() {
			return getRuleContext(AliasContext.class,0);
		}
		public AnnotatedContext annotated() {
			return getRuleContext(AnnotatedContext.class,0);
		}
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public TerminalNode PATTERN() { return getToken(queryParser.PATTERN, 0); }
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
		enterRule(_localctx, 24, RULE_rightStatment);
		int _la;
		try {
			setState(189);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(179);
					alias();
					}
				}

				setState(182);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				_la = _input.LA(1);
				if (_la==NAME_DOT) {
					{
					setState(183);
					alias();
					}
				}

				setState(186);
				annotated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(188);
				match(PATTERN);
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
		enterRule(_localctx, 26, RULE_innerSelect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(LPAREN);
			setState(192);
			selectStatment();
			setState(193);
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
		public TerminalNode METHOD() { return getToken(queryParser.METHOD, 0); }
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
		enterRule(_localctx, 28, RULE_annotated);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if (_la==METHOD) {
				{
				setState(195);
				match(METHOD);
				setState(196);
				match(LBRACKET);
				setState(197);
				method();
				setState(198);
				match(RBRACKET);
				setState(200);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(199);
					index();
					}
				}

				}
			}

			setState(204);
			annotatedStatment();
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
		public TerminalNode AT_NAME() { return getToken(queryParser.AT_NAME, 0); }
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
		enterRule(_localctx, 30, RULE_annotatedStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(AT_NAME);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==DOT_NAME) {
				{
				{
				setState(207);
				annotatedParams();
				}
				}
				setState(212);
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

	public static class AnnotatedParamsContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(queryParser.DOT, 0); }
		public TerminalNode AT_NAME() { return getToken(queryParser.AT_NAME, 0); }
		public TerminalNode DOT_NAME() { return getToken(queryParser.DOT_NAME, 0); }
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
		enterRule(_localctx, 32, RULE_annotatedParams);
		int _la;
		try {
			setState(219);
			switch (_input.LA(1)) {
			case DOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(213);
				match(DOT);
				setState(214);
				match(AT_NAME);
				}
				break;
			case DOT_NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(DOT_NAME);
				setState(217);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(216);
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
		enterRule(_localctx, 34, RULE_method);
		int _la;
		try {
			setState(235);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(STRING);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(NAME);
				setState(223);
				match(OPERATORS);
				setState(224);
				match(STRING);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(225);
					match(COMMA);
					setState(226);
					match(NAME);
					setState(227);
					match(OPERATORS);
					setState(228);
					match(STRING);
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
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
		enterRule(_localctx, 36, RULE_index);
		try {
			setState(243);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(LBRACKET);
				setState(238);
				match(INT);
				setState(239);
				match(RBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(LBRACKET);
				setState(241);
				match(STAR);
				setState(242);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\36\u00f8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\5\3-\n\3\3\3\3\3\5\3\61\n\3\3\3\3"+
		"\3\5\3\65\n\3\3\3\5\38\n\3\3\3\5\3;\n\3\3\4\3\4\3\4\7\4@\n\4\f\4\16\4"+
		"C\13\4\3\5\3\5\5\5G\n\5\3\5\3\5\5\5K\n\5\3\5\3\5\3\5\3\5\3\5\5\5R\n\5"+
		"\3\5\3\5\5\5V\n\5\3\5\5\5Y\n\5\3\6\3\6\3\6\7\6^\n\6\f\6\16\6a\13\6\3\7"+
		"\3\7\3\7\7\7f\n\7\f\7\16\7i\13\7\3\7\5\7l\n\7\3\7\3\7\5\7p\n\7\5\7r\n"+
		"\7\3\b\5\bu\n\b\3\b\3\b\5\by\n\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\7"+
		"\13\u0083\n\13\f\13\16\13\u0086\13\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u008e"+
		"\n\f\3\f\3\f\3\f\5\f\u0093\n\f\3\f\5\f\u0096\n\f\3\f\5\f\u0099\n\f\3\r"+
		"\5\r\u009c\n\r\3\r\3\r\3\r\3\r\5\r\u00a2\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a9"+
		"\n\r\3\r\3\r\5\r\u00ad\n\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b4\n\r\3\16\5\16"+
		"\u00b7\n\16\3\16\3\16\5\16\u00bb\n\16\3\16\3\16\3\16\5\16\u00c0\n\16\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5\20\u00cb\n\20\5\20\u00cd"+
		"\n\20\3\20\3\20\3\21\3\21\7\21\u00d3\n\21\f\21\16\21\u00d6\13\21\3\22"+
		"\3\22\3\22\3\22\5\22\u00dc\n\22\5\22\u00de\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\7\23\u00e8\n\23\f\23\16\23\u00eb\13\23\3\23\5\23\u00ee"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00f6\n\24\3\24\2\2\25\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\3\3\2\7\b\u0114\2(\3\2\2\2\4"+
		",\3\2\2\2\6<\3\2\2\2\bX\3\2\2\2\nZ\3\2\2\2\fq\3\2\2\2\16x\3\2\2\2\20z"+
		"\3\2\2\2\22|\3\2\2\2\24\177\3\2\2\2\26\u0098\3\2\2\2\30\u00b3\3\2\2\2"+
		"\32\u00bf\3\2\2\2\34\u00c1\3\2\2\2\36\u00cc\3\2\2\2 \u00d0\3\2\2\2\"\u00dd"+
		"\3\2\2\2$\u00ed\3\2\2\2&\u00f5\3\2\2\2()\5\4\3\2)\3\3\2\2\2*+\7\3\2\2"+
		"+-\5\6\4\2,*\3\2\2\2,-\3\2\2\2-\60\3\2\2\2./\7\4\2\2/\61\5\n\6\2\60.\3"+
		"\2\2\2\60\61\3\2\2\2\61\64\3\2\2\2\62\63\7\5\2\2\63\65\5\24\13\2\64\62"+
		"\3\2\2\2\64\65\3\2\2\2\65\67\3\2\2\2\668\7\f\2\2\67\66\3\2\2\2\678\3\2"+
		"\2\28:\3\2\2\29;\7\r\2\2:9\3\2\2\2:;\3\2\2\2;\5\3\2\2\2<A\5\b\5\2=>\7"+
		"\16\2\2>@\5\b\5\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2B\7\3\2\2\2C"+
		"A\3\2\2\2DF\7\23\2\2EG\5\20\t\2FE\3\2\2\2FG\3\2\2\2GH\3\2\2\2HY\7\33\2"+
		"\2IK\5\20\t\2JI\3\2\2\2JK\3\2\2\2KL\3\2\2\2LQ\7\33\2\2MN\7\17\2\2NO\5"+
		"$\23\2OP\7\20\2\2PR\3\2\2\2QM\3\2\2\2QR\3\2\2\2RY\3\2\2\2SY\5\34\17\2"+
		"TV\5\20\t\2UT\3\2\2\2UV\3\2\2\2VW\3\2\2\2WY\7\24\2\2XD\3\2\2\2XJ\3\2\2"+
		"\2XS\3\2\2\2XU\3\2\2\2Y\t\3\2\2\2Z_\5\f\7\2[\\\7\16\2\2\\^\5\f\7\2][\3"+
		"\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\13\3\2\2\2a_\3\2\2\2bg\5\16\b\2"+
		"cd\7\n\2\2df\5\16\b\2ec\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2hk\3\2\2"+
		"\2ig\3\2\2\2jl\5\22\n\2kj\3\2\2\2kl\3\2\2\2lr\3\2\2\2mo\7\24\2\2np\5\22"+
		"\n\2on\3\2\2\2op\3\2\2\2pr\3\2\2\2qb\3\2\2\2qm\3\2\2\2r\r\3\2\2\2su\7"+
		"\23\2\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2vy\7\35\2\2wy\5\34\17\2xt\3\2\2\2"+
		"xw\3\2\2\2y\17\3\2\2\2z{\7\27\2\2{\21\3\2\2\2|}\7\31\2\2}~\7\33\2\2~\23"+
		"\3\2\2\2\177\u0084\5\26\f\2\u0080\u0081\7\6\2\2\u0081\u0083\5\26\f\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\25\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0099\5\30\r\2\u0088\u0089"+
		"\t\2\2\2\u0089\u0099\5\34\17\2\u008a\u008b\5\34\17\2\u008b\u008d\7\13"+
		"\2\2\u008c\u008e\5\20\t\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0090\7\33\2\2\u0090\u0099\3\2\2\2\u0091\u0093\7"+
		"\23\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094"+
		"\u0096\5\20\t\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3"+
		"\2\2\2\u0097\u0099\7\33\2\2\u0098\u0087\3\2\2\2\u0098\u0088\3\2\2\2\u0098"+
		"\u008a\3\2\2\2\u0098\u0092\3\2\2\2\u0099\27\3\2\2\2\u009a\u009c\5\20\t"+
		"\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e"+
		"\7\33\2\2\u009e\u009f\7\13\2\2\u009f\u00b4\5\32\16\2\u00a0\u00a2\5\20"+
		"\t\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\5\36\20\2\u00a4\u00a5\7\13\2\2\u00a5\u00a6\5\32\16\2\u00a6\u00b4"+
		"\3\2\2\2\u00a7\u00a9\5\20\t\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2"+
		"\u00a9\u00aa\3\2\2\2\u00aa\u00b4\5\36\20\2\u00ab\u00ad\5\20\t\2\u00ac"+
		"\u00ab\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\7\t"+
		"\2\2\u00af\u00b0\7\17\2\2\u00b0\u00b1\5$\23\2\u00b1\u00b2\7\20\2\2\u00b2"+
		"\u00b4\3\2\2\2\u00b3\u009b\3\2\2\2\u00b3\u00a1\3\2\2\2\u00b3\u00a8\3\2"+
		"\2\2\u00b3\u00ac\3\2\2\2\u00b4\31\3\2\2\2\u00b5\u00b7\5\20\t\2\u00b6\u00b5"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00c0\7\33\2\2"+
		"\u00b9\u00bb\5\20\t\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\u00c0\5\36\20\2\u00bd\u00c0\7\35\2\2\u00be\u00c0\7\34\2"+
		"\2\u00bf\u00b6\3\2\2\2\u00bf\u00ba\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\33\3\2\2\2\u00c1\u00c2\7\21\2\2\u00c2\u00c3\5\4\3\2\u00c3"+
		"\u00c4\7\22\2\2\u00c4\35\3\2\2\2\u00c5\u00c6\7\t\2\2\u00c6\u00c7\7\17"+
		"\2\2\u00c7\u00c8\5$\23\2\u00c8\u00ca\7\20\2\2\u00c9\u00cb\5&\24\2\u00ca"+
		"\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00c5\3\2"+
		"\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\5 \21\2\u00cf"+
		"\37\3\2\2\2\u00d0\u00d4\7\25\2\2\u00d1\u00d3\5\"\22\2\u00d2\u00d1\3\2"+
		"\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"!\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7\26\2\2\u00d8\u00de\7\25\2"+
		"\2\u00d9\u00db\7\30\2\2\u00da\u00dc\5&\24\2\u00db\u00da\3\2\2\2\u00db"+
		"\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00d7\3\2\2\2\u00dd\u00d9\3\2"+
		"\2\2\u00de#\3\2\2\2\u00df\u00ee\7\35\2\2\u00e0\u00e1\7\33\2\2\u00e1\u00e2"+
		"\7\13\2\2\u00e2\u00e9\7\35\2\2\u00e3\u00e4\7\16\2\2\u00e4\u00e5\7\33\2"+
		"\2\u00e5\u00e6\7\13\2\2\u00e6\u00e8\7\35\2\2\u00e7\u00e3\3\2\2\2\u00e8"+
		"\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ee\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\7\24\2\2\u00ed\u00df\3\2\2\2\u00ed"+
		"\u00e0\3\2\2\2\u00ed\u00ec\3\2\2\2\u00ee%\3\2\2\2\u00ef\u00f0\7\17\2\2"+
		"\u00f0\u00f1\7\32\2\2\u00f1\u00f6\7\20\2\2\u00f2\u00f3\7\17\2\2\u00f3"+
		"\u00f4\7\24\2\2\u00f4\u00f6\7\20\2\2\u00f5\u00ef\3\2\2\2\u00f5\u00f2\3"+
		"\2\2\2\u00f6\'\3\2\2\2),\60\64\67:AFJQUX_gkoqtx\u0084\u008d\u0092\u0095"+
		"\u0098\u009b\u00a1\u00a8\u00ac\u00b3\u00b6\u00ba\u00bf\u00ca\u00cc\u00d4"+
		"\u00db\u00dd\u00e9\u00ed\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}