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
		SELECT=1, FROM=2, WHERE=3, AND=4, OPERATORS=5, ORDER_BY=6, CC=7, MM=8, 
		PP=9, COLON=10, COMMA=11, LBRACKET=12, RBRACKET=13, LPAREN=14, RPAREN=15, 
		LBRACE=16, RBRACE=17, EXCLAMANTION=18, STAR=19, AT=20, DOT=21, INT=22, 
		NAME=23, STRING=24, WS=25;
	public static final int
		RULE_program = 0, RULE_selectStatment = 1, RULE_paramSelect = 2, RULE_paramName = 3, 
		RULE_packages = 4, RULE_packageName = 5, RULE_conditions = 6, RULE_cond = 7, 
		RULE_innerSelect = 8, RULE_annotated = 9, RULE_method = 10, RULE_index = 11, 
		RULE_annotatedStatment = 12, RULE_annotatedParams = 13, RULE_paramAnnptated = 14;
	public static final String[] ruleNames = {
		"program", "selectStatment", "paramSelect", "paramName", "packages", "packageName", 
		"conditions", "cond", "innerSelect", "annotated", "method", "index", "annotatedStatment", 
		"annotatedParams", "paramAnnptated"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "':'", "','", 
		"'['", "']'", "'('", "')'", "'{'", "'}'", "'!'", "'*'", "'@'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SELECT", "FROM", "WHERE", "AND", "OPERATORS", "ORDER_BY", "CC", 
		"MM", "PP", "COLON", "COMMA", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "EXCLAMANTION", "STAR", "AT", "DOT", "INT", "NAME", 
		"STRING", "WS"
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
			setState(30);
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
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
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
			setState(34);
			_la = _input.LA(1);
			if (_la==SELECT) {
				{
				setState(32);
				match(SELECT);
				setState(33);
				paramSelect();
				}
			}

			setState(38);
			_la = _input.LA(1);
			if (_la==FROM) {
				{
				setState(36);
				match(FROM);
				setState(37);
				packages();
				}
			}

			setState(42);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(40);
				match(WHERE);
				setState(41);
				conditions();
				}
			}

			setState(46);
			_la = _input.LA(1);
			if (_la==ORDER_BY) {
				{
				setState(44);
				match(ORDER_BY);
				setState(45);
				match(STRING);
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
			setState(72);
			switch (_input.LA(1)) {
			case EXCLAMANTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				match(EXCLAMANTION);
				setState(57);
				match(NAME);
				setState(62);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(58);
					match(LBRACKET);
					setState(59);
					method();
					setState(60);
					match(RBRACKET);
					}
				}

				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(NAME);
				setState(69);
				_la = _input.LA(1);
				if (_la==LBRACKET) {
					{
					setState(65);
					match(LBRACKET);
					setState(66);
					method();
					setState(67);
					match(RBRACKET);
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(71);
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
			setState(83);
			switch (_input.LA(1)) {
			case EXCLAMANTION:
			case STRING:
				{
				setState(74);
				packageName();
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(75);
					match(COMMA);
					setState(76);
					packageName();
					}
					}
					setState(81);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case STAR:
				{
				setState(82);
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
			setState(88);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(85);
				match(STRING);
				}
				break;
			case EXCLAMANTION:
				{
				setState(86);
				match(EXCLAMANTION);
				setState(87);
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
			setState(90);
			cond();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(91);
				match(AND);
				setState(92);
				cond();
				}
				}
				setState(97);
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
		public TerminalNode NAME() { return getToken(queryParser.NAME, 0); }
		public TerminalNode OPERATORS() { return getToken(queryParser.OPERATORS, 0); }
		public List<TerminalNode> STRING() { return getTokens(queryParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(queryParser.STRING, i);
		}
		public InnerSelectContext innerSelect() {
			return getRuleContext(InnerSelectContext.class,0);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(queryParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(queryParser.LBRACKET, i);
		}
		public AnnotatedContext annotated() {
			return getRuleContext(AnnotatedContext.class,0);
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
		enterRule(_localctx, 14, RULE_cond);
		int _la;
		try {
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(NAME);
				{
				setState(99);
				match(OPERATORS);
				setState(100);
				match(STRING);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(NAME);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACKET) {
					{
					{
					setState(102);
					match(LBRACKET);
					setState(103);
					match(STRING);
					setState(104);
					match(LBRACKET);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(OPERATORS);
				setState(111);
				innerSelect();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(EXCLAMANTION);
				setState(113);
				match(NAME);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				match(NAME);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
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
		enterRule(_localctx, 16, RULE_innerSelect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			match(LPAREN);
			setState(119);
			selectStatment();
			setState(120);
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
		public TerminalNode CC() { return getToken(queryParser.CC, 0); }
		public TerminalNode AT() { return getToken(queryParser.AT, 0); }
		public AnnotatedStatmentContext annotatedStatment() {
			return getRuleContext(AnnotatedStatmentContext.class,0);
		}
		public TerminalNode MM() { return getToken(queryParser.MM, 0); }
		public TerminalNode LBRACKET() { return getToken(queryParser.LBRACKET, 0); }
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(queryParser.RBRACKET, 0); }
		public TerminalNode PP() { return getToken(queryParser.PP, 0); }
		public TerminalNode DOT() { return getToken(queryParser.DOT, 0); }
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
		enterRule(_localctx, 18, RULE_annotated);
		try {
			setState(141);
			switch (_input.LA(1)) {
			case CC:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(CC);
				setState(123);
				match(AT);
				setState(124);
				annotatedStatment();
				}
				break;
			case MM:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(MM);
				setState(126);
				match(LBRACKET);
				setState(127);
				method();
				setState(128);
				match(RBRACKET);
				setState(129);
				match(AT);
				setState(130);
				annotatedStatment();
				}
				break;
			case PP:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				match(PP);
				setState(133);
				match(LBRACKET);
				setState(134);
				method();
				setState(135);
				match(RBRACKET);
				setState(136);
				match(DOT);
				setState(137);
				index();
				setState(138);
				match(AT);
				setState(139);
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
		enterRule(_localctx, 20, RULE_method);
		int _la;
		try {
			setState(156);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(STRING);
				setState(145);
				match(COLON);
				setState(146);
				match(STRING);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(147);
					match(COMMA);
					setState(148);
					match(STRING);
					setState(149);
					match(COLON);
					setState(150);
					match(STRING);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
		enterRule(_localctx, 22, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(LBRACKET);
			setState(159);
			match(INT);
			setState(160);
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
		public List<TerminalNode> LBRACKET() { return getTokens(queryParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(queryParser.LBRACKET, i);
		}
		public TerminalNode STRING() { return getToken(queryParser.STRING, 0); }
		public List<TerminalNode> RBRACKET() { return getTokens(queryParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(queryParser.RBRACKET, i);
		}
		public TerminalNode DOT() { return getToken(queryParser.DOT, 0); }
		public AnnotatedParamsContext annotatedParams() {
			return getRuleContext(AnnotatedParamsContext.class,0);
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
		enterRule(_localctx, 24, RULE_annotatedStatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(LBRACKET);
			setState(163);
			match(STRING);
			setState(164);
			match(RBRACKET);
			setState(170);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(165);
				match(DOT);
				setState(166);
				match(LBRACKET);
				setState(167);
				annotatedParams();
				setState(168);
				match(RBRACKET);
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

	public static class AnnotatedParamsContext extends ParserRuleContext {
		public List<ParamAnnptatedContext> paramAnnptated() {
			return getRuleContexts(ParamAnnptatedContext.class);
		}
		public ParamAnnptatedContext paramAnnptated(int i) {
			return getRuleContext(ParamAnnptatedContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(queryParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(queryParser.COMMA, i);
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
		enterRule(_localctx, 26, RULE_annotatedParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			paramAnnptated();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(173);
				match(COMMA);
				setState(174);
				paramAnnptated();
				}
				}
				setState(179);
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

	public static class ParamAnnptatedContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(queryParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(queryParser.STRING, i);
		}
		public TerminalNode COLON() { return getToken(queryParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(queryParser.LBRACE, 0); }
		public AnnotatedParamsContext annotatedParams() {
			return getRuleContext(AnnotatedParamsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(queryParser.RBRACE, 0); }
		public AnnotatedStatmentContext annotatedStatment() {
			return getRuleContext(AnnotatedStatmentContext.class,0);
		}
		public ParamAnnptatedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramAnnptated; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).enterParamAnnptated(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof queryListener ) ((queryListener)listener).exitParamAnnptated(this);
		}
	}

	public final ParamAnnptatedContext paramAnnptated() throws RecognitionException {
		ParamAnnptatedContext _localctx = new ParamAnnptatedContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_paramAnnptated);
		try {
			setState(194);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				match(STRING);
				setState(182);
				match(COLON);
				setState(183);
				match(STRING);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				match(STRING);
				setState(185);
				match(COLON);
				setState(186);
				match(LBRACE);
				setState(187);
				annotatedParams();
				setState(188);
				match(RBRACE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				match(STRING);
				setState(191);
				match(COLON);
				setState(192);
				annotatedStatment();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(193);
				annotatedStatment();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u00c7\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\3\3\3\5"+
		"\3%\n\3\3\3\3\3\5\3)\n\3\3\3\3\3\5\3-\n\3\3\3\3\3\5\3\61\n\3\3\4\3\4\3"+
		"\4\7\4\66\n\4\f\4\16\49\13\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5A\n\5\3\5\3\5"+
		"\3\5\3\5\3\5\5\5H\n\5\3\5\5\5K\n\5\3\6\3\6\3\6\7\6P\n\6\f\6\16\6S\13\6"+
		"\3\6\5\6V\n\6\3\7\3\7\3\7\5\7[\n\7\3\b\3\b\3\b\7\b`\n\b\f\b\16\bc\13\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tl\n\t\f\t\16\to\13\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\5\tw\n\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0090\n\13"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u009a\n\f\f\f\16\f\u009d\13\f\5\f"+
		"\u009f\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00ad\n\16\3\17\3\17\3\17\7\17\u00b2\n\17\f\17\16\17\u00b5\13\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00c5\n\20\3\20\2\2\21\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\2\u00d3"+
		"\2 \3\2\2\2\4$\3\2\2\2\6\62\3\2\2\2\bJ\3\2\2\2\nU\3\2\2\2\fZ\3\2\2\2\16"+
		"\\\3\2\2\2\20v\3\2\2\2\22x\3\2\2\2\24\u008f\3\2\2\2\26\u009e\3\2\2\2\30"+
		"\u00a0\3\2\2\2\32\u00a4\3\2\2\2\34\u00ae\3\2\2\2\36\u00c4\3\2\2\2 !\5"+
		"\4\3\2!\3\3\2\2\2\"#\7\3\2\2#%\5\6\4\2$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2"+
		"&\'\7\4\2\2\')\5\n\6\2(&\3\2\2\2()\3\2\2\2),\3\2\2\2*+\7\5\2\2+-\5\16"+
		"\b\2,*\3\2\2\2,-\3\2\2\2-\60\3\2\2\2./\7\b\2\2/\61\7\32\2\2\60.\3\2\2"+
		"\2\60\61\3\2\2\2\61\5\3\2\2\2\62\67\5\b\5\2\63\64\7\r\2\2\64\66\5\b\5"+
		"\2\65\63\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\7\3\2\2\29\67"+
		"\3\2\2\2:;\7\24\2\2;@\7\31\2\2<=\7\16\2\2=>\5\26\f\2>?\7\17\2\2?A\3\2"+
		"\2\2@<\3\2\2\2@A\3\2\2\2AK\3\2\2\2BG\7\31\2\2CD\7\16\2\2DE\5\26\f\2EF"+
		"\7\17\2\2FH\3\2\2\2GC\3\2\2\2GH\3\2\2\2HK\3\2\2\2IK\7\25\2\2J:\3\2\2\2"+
		"JB\3\2\2\2JI\3\2\2\2K\t\3\2\2\2LQ\5\f\7\2MN\7\r\2\2NP\5\f\7\2OM\3\2\2"+
		"\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RV\3\2\2\2SQ\3\2\2\2TV\7\25\2\2UL\3\2"+
		"\2\2UT\3\2\2\2V\13\3\2\2\2W[\7\32\2\2XY\7\24\2\2Y[\7\32\2\2ZW\3\2\2\2"+
		"ZX\3\2\2\2[\r\3\2\2\2\\a\5\20\t\2]^\7\6\2\2^`\5\20\t\2_]\3\2\2\2`c\3\2"+
		"\2\2a_\3\2\2\2ab\3\2\2\2b\17\3\2\2\2ca\3\2\2\2de\7\31\2\2ef\7\7\2\2fw"+
		"\7\32\2\2gm\7\31\2\2hi\7\16\2\2ij\7\32\2\2jl\7\16\2\2kh\3\2\2\2lo\3\2"+
		"\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\7\2\2qw\5\22\n\2rs\7"+
		"\24\2\2sw\7\31\2\2tw\7\31\2\2uw\5\24\13\2vd\3\2\2\2vg\3\2\2\2vr\3\2\2"+
		"\2vt\3\2\2\2vu\3\2\2\2w\21\3\2\2\2xy\7\20\2\2yz\5\4\3\2z{\7\21\2\2{\23"+
		"\3\2\2\2|}\7\t\2\2}~\7\26\2\2~\u0090\5\32\16\2\177\u0080\7\n\2\2\u0080"+
		"\u0081\7\16\2\2\u0081\u0082\5\26\f\2\u0082\u0083\7\17\2\2\u0083\u0084"+
		"\7\26\2\2\u0084\u0085\5\32\16\2\u0085\u0090\3\2\2\2\u0086\u0087\7\13\2"+
		"\2\u0087\u0088\7\16\2\2\u0088\u0089\5\26\f\2\u0089\u008a\7\17\2\2\u008a"+
		"\u008b\7\27\2\2\u008b\u008c\5\30\r\2\u008c\u008d\7\26\2\2\u008d\u008e"+
		"\5\32\16\2\u008e\u0090\3\2\2\2\u008f|\3\2\2\2\u008f\177\3\2\2\2\u008f"+
		"\u0086\3\2\2\2\u0090\25\3\2\2\2\u0091\u009f\7\32\2\2\u0092\u0093\7\32"+
		"\2\2\u0093\u0094\7\f\2\2\u0094\u009b\7\32\2\2\u0095\u0096\7\r\2\2\u0096"+
		"\u0097\7\32\2\2\u0097\u0098\7\f\2\2\u0098\u009a\7\32\2\2\u0099\u0095\3"+
		"\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u0091\3\2\2\2\u009e\u0092\3\2"+
		"\2\2\u009f\27\3\2\2\2\u00a0\u00a1\7\16\2\2\u00a1\u00a2\7\30\2\2\u00a2"+
		"\u00a3\7\17\2\2\u00a3\31\3\2\2\2\u00a4\u00a5\7\16\2\2\u00a5\u00a6\7\32"+
		"\2\2\u00a6\u00ac\7\17\2\2\u00a7\u00a8\7\27\2\2\u00a8\u00a9\7\16\2\2\u00a9"+
		"\u00aa\5\34\17\2\u00aa\u00ab\7\17\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a7"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\33\3\2\2\2\u00ae\u00b3\5\36\20\2\u00af"+
		"\u00b0\7\r\2\2\u00b0\u00b2\5\36\20\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3"+
		"\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\35\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b6\u00c5\7\32\2\2\u00b7\u00b8\7\32\2\2\u00b8\u00b9\7"+
		"\f\2\2\u00b9\u00c5\7\32\2\2\u00ba\u00bb\7\32\2\2\u00bb\u00bc\7\f\2\2\u00bc"+
		"\u00bd\7\22\2\2\u00bd\u00be\5\34\17\2\u00be\u00bf\7\23\2\2\u00bf\u00c5"+
		"\3\2\2\2\u00c0\u00c1\7\32\2\2\u00c1\u00c2\7\f\2\2\u00c2\u00c5\5\32\16"+
		"\2\u00c3\u00c5\5\32\16\2\u00c4\u00b6\3\2\2\2\u00c4\u00b7\3\2\2\2\u00c4"+
		"\u00ba\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\37\3\2\2"+
		"\2\26$(,\60\67@GJQUZamv\u008f\u009b\u009e\u00ac\u00b3\u00c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}