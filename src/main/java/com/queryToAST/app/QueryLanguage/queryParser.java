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
		SELECT=1, FROM=2, WHERE=3, AND=4, OPERATORS=5, MM=6, COLON=7, COMMA=8, 
		LBRACKET=9, RBRACKET=10, LPAREN=11, RPAREN=12, EXCLAMANTION=13, STAR=14, 
		AT=15, DOT=16, ID_DOLLAR=17, ID_SLASH=18, INT=19, NAME=20, STRING=21, 
		WS=22;
	public static final int
		RULE_program = 0, RULE_selectStatment = 1, RULE_paramSelect = 2, RULE_paramName = 3, 
		RULE_packages = 4, RULE_packageName = 5, RULE_conditions = 6, RULE_cond = 7, 
		RULE_equal = 8, RULE_assignment = 9, RULE_innerSelect = 10, RULE_annotated = 11, 
		RULE_method = 12, RULE_index = 13, RULE_annotatedStatment = 14, RULE_annotatedName = 15, 
		RULE_annotatedParams = 16;
	public static final String[] ruleNames = {
		"program", "selectStatment", "paramSelect", "paramName", "packages", "packageName", 
		"conditions", "cond", "equal", "assignment", "innerSelect", "annotated", 
		"method", "index", "annotatedStatment", "annotatedName", "annotatedParams"
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
			setState(34);
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
			setState(38);
			_la = _input.LA(1);
			if (_la==SELECT) {
				{
				setState(36);
				match(SELECT);
				setState(37);
				paramSelect();
				}
			}

			setState(42);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(40);
				match(FROM);
				setState(41);
				packages();
				}
			}

			setState(46);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(44);
				match(WHERE);
				setState(45);
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
			setState(48);
			paramName();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(49);
				match(COMMA);
				setState(50);
				paramName();
				}
				}
				setState(55);
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
		public TerminalNode LBRACKET() { return getToken(queryParser.LBRACKET, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(queryParser.RBRACKET, 0); }
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
			setState(66);
			switch (_input.LA(1)) {
			case EXCLAMANTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(EXCLAMANTION);
				setState(57);
				match(NAME);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(NAME);
				setState(63);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(59);
					match(LBRACKET);
					setState(60);
					method();
					setState(61);
					match(RBRACKET);
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
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

	public static class PackagesContext extends ParserRuleContext {
		public List<PackageNameContext> packageName() {
			return getRuleContexts(PackageNameContext.class);
		}
		public PackageNameContext packageName(int i) {
			return getRuleContext(PackageNameContext.class,i);
		}
		public TerminalNode STAR() { return getToken(queryParser.STAR, 0); }
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
			setState(77);
			switch (_input.LA(1)) {
			case EXCLAMANTION:
			case STRING:
				{
				setState(68);
				packageName();
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(69);
					match(COMMA);
					setState(70);
					packageName();
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				{
				setState(76);
				match(STAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PackageNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public TerminalNode EXCLAMANTION() { return getToken(queryParser.EXCLAMANTION, 0); }
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
		enterRule(_localctx, 10, RULE_packageName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(79);
				match(STRING);
				}
				break;
			case EXCLAMANTION:
				{
				setState(80);
				match(EXCLAMANTION);
				setState(81);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 12, RULE_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			cond();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(85);
				match(AND);
				setState(86);
				cond();
				}
				}
				setState(91);
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
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public InnerSelectContext innerSelect() {
			return getRuleContext(InnerSelectContext.class,0);
		}
		public TerminalNode OPERATORS() { return getToken(queryParser.OPERATORS, 0); }
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
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
		enterRule(_localctx, 14, RULE_cond);
		try {
			setState(102);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				equal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				innerSelect();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(95);
				innerSelect();
				setState(96);
				match(OPERATORS);
				setState(97);
				match(NAME);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(99);
				match(EXCLAMANTION);
				setState(100);
				match(NAME);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(101);
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
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public TerminalNode ID_SLASH() { return getToken(queryParser.ID_SLASH, 0); }
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
		enterRule(_localctx, 16, RULE_equal);
		try {
			setState(119);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(NAME);
				setState(105);
				match(OPERATORS);
				setState(106);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(NAME);
				setState(108);
				match(OPERATORS);
				setState(109);
				match(ID_SLASH);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				annotated();
				setState(111);
				match(OPERATORS);
				setState(112);
				match(STRING);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				annotated();
				setState(115);
				match(OPERATORS);
				setState(116);
				match(ID_SLASH);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(118);
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID_DOLLAR() { return getToken(queryParser.ID_DOLLAR, 0); }
		public TerminalNode COLON() { return getToken(queryParser.COLON, 0); }
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public AnnotatedContext annotated() {
			return getRuleContext(AnnotatedContext.class,0);
		}
		public TerminalNode ID_SLASH() { return getToken(queryParser.ID_SLASH, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			setState(130);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(ID_DOLLAR);
				setState(122);
				match(COLON);
				setState(123);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(ID_DOLLAR);
				setState(125);
				match(COLON);
				setState(126);
				annotated();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				match(ID_DOLLAR);
				setState(128);
				match(COLON);
				setState(129);
				match(ID_SLASH);
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
		enterRule(_localctx, 20, RULE_innerSelect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(LPAREN);
			setState(133);
			selectStatment();
			setState(134);
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
		enterRule(_localctx, 22, RULE_annotated);
		int _la;
		try {
			setState(146);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				annotatedStatment();
				}
				break;
			case MM:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(MM);
				setState(138);
				match(LBRACKET);
				setState(139);
				method();
				setState(140);
				match(RBRACKET);
				setState(142);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(141);
					index();
					}
				}

				setState(144);
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
		public List<TerminalNode> COLON() { return getTokens(queryParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(queryParser.COLON, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(queryParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(queryParser.COMMA, i);
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
		enterRule(_localctx, 24, RULE_method);
		int _la;
		try {
			setState(161);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				match(STRING);
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(NAME);
				setState(150);
				match(COLON);
				setState(151);
				match(STRING);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(152);
					match(COMMA);
					setState(153);
					match(NAME);
					setState(154);
					match(COLON);
					setState(155);
					match(STRING);
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class IndexContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(queryParser.LBRACKET, 0); }
		public TerminalNode INT() { return getToken(queryParser.INT, 0); }
		public TerminalNode RBRACKET() { return getToken(queryParser.RBRACKET, 0); }
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
		enterRule(_localctx, 26, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(LBRACKET);
			setState(164);
			match(INT);
			setState(165);
			match(RBRACKET);
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
		enterRule(_localctx, 28, RULE_annotatedStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			annotatedName();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(168);
				match(DOT);
				setState(169);
				annotatedParams();
				}
				}
				setState(174);
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
		enterRule(_localctx, 30, RULE_annotatedName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(AT);
			setState(176);
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
		enterRule(_localctx, 32, RULE_annotatedParams);
		int _la;
		try {
			setState(183);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				annotatedName();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(NAME);
				setState(181);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(180);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\u00bc\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\5\3)\n\3\3\3\3\3\5\3-\n\3\3\3\3\3\5\3\61\n\3\3\4\3\4"+
		"\3\4\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3"+
		"\5\5\5E\n\5\3\6\3\6\3\6\7\6J\n\6\f\6\16\6M\13\6\3\6\5\6P\n\6\3\7\3\7\3"+
		"\7\5\7U\n\7\3\b\3\b\3\b\7\bZ\n\b\f\b\16\b]\13\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\5\ti\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\5\nz\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u0085\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0091"+
		"\n\r\3\r\3\r\5\r\u0095\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u009f\n\16\f\16\16\16\u00a2\13\16\5\16\u00a4\n\16\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\7\20\u00ad\n\20\f\20\16\20\u00b0\13\20\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\5\22\u00b8\n\22\5\22\u00ba\n\22\3\22\2\2\23\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"\2\2\u00c7\2$\3\2\2\2\4(\3\2\2\2\6\62"+
		"\3\2\2\2\bD\3\2\2\2\nO\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20h\3\2\2\2\22y"+
		"\3\2\2\2\24\u0084\3\2\2\2\26\u0086\3\2\2\2\30\u0094\3\2\2\2\32\u00a3\3"+
		"\2\2\2\34\u00a5\3\2\2\2\36\u00a9\3\2\2\2 \u00b1\3\2\2\2\"\u00b9\3\2\2"+
		"\2$%\5\4\3\2%\3\3\2\2\2&\'\7\3\2\2\')\5\6\4\2(&\3\2\2\2()\3\2\2\2),\3"+
		"\2\2\2*+\7\4\2\2+-\5\n\6\2,*\3\2\2\2,-\3\2\2\2-\60\3\2\2\2./\7\5\2\2/"+
		"\61\5\16\b\2\60.\3\2\2\2\60\61\3\2\2\2\61\5\3\2\2\2\62\67\5\b\5\2\63\64"+
		"\7\n\2\2\64\66\5\b\5\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2"+
		"\2\28\7\3\2\2\29\67\3\2\2\2:;\7\17\2\2;E\7\26\2\2<A\7\26\2\2=>\7\13\2"+
		"\2>?\5\32\16\2?@\7\f\2\2@B\3\2\2\2A=\3\2\2\2AB\3\2\2\2BE\3\2\2\2CE\7\20"+
		"\2\2D:\3\2\2\2D<\3\2\2\2DC\3\2\2\2E\t\3\2\2\2FK\5\f\7\2GH\7\n\2\2HJ\5"+
		"\f\7\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LP\3\2\2\2MK\3\2\2\2NP\7"+
		"\20\2\2OF\3\2\2\2ON\3\2\2\2P\13\3\2\2\2QU\7\27\2\2RS\7\17\2\2SU\7\27\2"+
		"\2TQ\3\2\2\2TR\3\2\2\2U\r\3\2\2\2V[\5\20\t\2WX\7\6\2\2XZ\5\20\t\2YW\3"+
		"\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\17\3\2\2\2][\3\2\2\2^i\5\22\n"+
		"\2_i\5\24\13\2`i\5\26\f\2ab\5\26\f\2bc\7\7\2\2cd\7\26\2\2di\3\2\2\2ef"+
		"\7\17\2\2fi\7\26\2\2gi\7\26\2\2h^\3\2\2\2h_\3\2\2\2h`\3\2\2\2ha\3\2\2"+
		"\2he\3\2\2\2hg\3\2\2\2i\21\3\2\2\2jk\7\26\2\2kl\7\7\2\2lz\7\27\2\2mn\7"+
		"\26\2\2no\7\7\2\2oz\7\24\2\2pq\5\30\r\2qr\7\7\2\2rs\7\27\2\2sz\3\2\2\2"+
		"tu\5\30\r\2uv\7\7\2\2vw\7\24\2\2wz\3\2\2\2xz\5\30\r\2yj\3\2\2\2ym\3\2"+
		"\2\2yp\3\2\2\2yt\3\2\2\2yx\3\2\2\2z\23\3\2\2\2{|\7\23\2\2|}\7\t\2\2}\u0085"+
		"\7\26\2\2~\177\7\23\2\2\177\u0080\7\t\2\2\u0080\u0085\5\30\r\2\u0081\u0082"+
		"\7\23\2\2\u0082\u0083\7\t\2\2\u0083\u0085\7\24\2\2\u0084{\3\2\2\2\u0084"+
		"~\3\2\2\2\u0084\u0081\3\2\2\2\u0085\25\3\2\2\2\u0086\u0087\7\r\2\2\u0087"+
		"\u0088\5\4\3\2\u0088\u0089\7\16\2\2\u0089\27\3\2\2\2\u008a\u0095\5\36"+
		"\20\2\u008b\u008c\7\b\2\2\u008c\u008d\7\13\2\2\u008d\u008e\5\32\16\2\u008e"+
		"\u0090\7\f\2\2\u008f\u0091\5\34\17\2\u0090\u008f\3\2\2\2\u0090\u0091\3"+
		"\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\5\36\20\2\u0093\u0095\3\2\2\2\u0094"+
		"\u008a\3\2\2\2\u0094\u008b\3\2\2\2\u0095\31\3\2\2\2\u0096\u00a4\7\27\2"+
		"\2\u0097\u0098\7\26\2\2\u0098\u0099\7\t\2\2\u0099\u00a0\7\27\2\2\u009a"+
		"\u009b\7\n\2\2\u009b\u009c\7\26\2\2\u009c\u009d\7\t\2\2\u009d\u009f\7"+
		"\27\2\2\u009e\u009a\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u0096\3\2"+
		"\2\2\u00a3\u0097\3\2\2\2\u00a4\33\3\2\2\2\u00a5\u00a6\7\13\2\2\u00a6\u00a7"+
		"\7\25\2\2\u00a7\u00a8\7\f\2\2\u00a8\35\3\2\2\2\u00a9\u00ae\5 \21\2\u00aa"+
		"\u00ab\7\22\2\2\u00ab\u00ad\5\"\22\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3"+
		"\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\37\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b1\u00b2\7\21\2\2\u00b2\u00b3\7\26\2\2\u00b3!\3\2\2"+
		"\2\u00b4\u00ba\5 \21\2\u00b5\u00b7\7\26\2\2\u00b6\u00b8\5\34\17\2\u00b7"+
		"\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b4\3\2"+
		"\2\2\u00b9\u00b5\3\2\2\2\u00ba#\3\2\2\2\26(,\60\67ADKOT[hy\u0084\u0090"+
		"\u0094\u00a0\u00a3\u00ae\u00b7\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}