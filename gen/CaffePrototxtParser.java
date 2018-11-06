// Generated from /Users/saurabh/IdeaProjects/wootz/src/main/java/CaffePrototxt.g4 by ANTLR 4.7

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CaffePrototxtParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            LPAREN = 1, RPAREN = 2, COLON = 3, NUMBER = 4, ID = 5, STRING = 6, WS = 7, NL = 8, COMMENT = 9,
            CAFFE2MXNET = 10;
    public static final int
            RULE_prototxt = 0, RULE_solver = 1, RULE_name = 2, RULE_layer = 3, RULE_pair = 4,
            RULE_value = 5, RULE_object = 6;
    public static final String[] ruleNames = {
            "prototxt", "solver", "name", "layer", "pair", "value", "object"
    };

    private static final String[] _LITERAL_NAMES = {
            null, "'{'", "'}'", "':'", null, null, null, null, null, null, "'#CaffeToMXNet'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, "LPAREN", "RPAREN", "COLON", "NUMBER", "ID", "STRING", "WS", "NL",
            "COMMENT", "CAFFE2MXNET"
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
    public String getGrammarFileName() {
        return "CaffePrototxt.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public CaffePrototxtParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class PrototxtContext extends ParserRuleContext {
        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public List<LayerContext> layer() {
            return getRuleContexts(LayerContext.class);
        }

        public LayerContext layer(int i) {
            return getRuleContext(LayerContext.class, i);
        }

        public PrototxtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prototxt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).enterPrototxt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).exitPrototxt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CaffePrototxtVisitor)
                return ((CaffePrototxtVisitor<? extends T>) visitor).visitPrototxt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PrototxtContext prototxt() throws RecognitionException {
        PrototxtContext _localctx = new PrototxtContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prototxt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(14);
                name();
                setState(16);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(15);
                            layer();
                        }
                    }
                    setState(18);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SolverContext extends ParserRuleContext {
        public List<PairContext> pair() {
            return getRuleContexts(PairContext.class);
        }

        public PairContext pair(int i) {
            return getRuleContext(PairContext.class, i);
        }

        public SolverContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_solver;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).enterSolver(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).exitSolver(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CaffePrototxtVisitor)
                return ((CaffePrototxtVisitor<? extends T>) visitor).visitSolver(this);
            else return visitor.visitChildren(this);
        }
    }

    public final SolverContext solver() throws RecognitionException {
        SolverContext _localctx = new SolverContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_solver);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(21);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(20);
                            pair();
                        }
                    }
                    setState(23);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NameContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(CaffePrototxtParser.ID, 0);
        }

        public TerminalNode COLON() {
            return getToken(CaffePrototxtParser.COLON, 0);
        }

        public TerminalNode STRING() {
            return getToken(CaffePrototxtParser.STRING, 0);
        }

        public NameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).enterName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).exitName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CaffePrototxtVisitor)
                return ((CaffePrototxtVisitor<? extends T>) visitor).visitName(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NameContext name() throws RecognitionException {
        NameContext _localctx = new NameContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(25);
                match(ID);
                setState(26);
                match(COLON);
                setState(27);
                match(STRING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class LayerContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(CaffePrototxtParser.ID, 0);
        }

        public ObjectContext object() {
            return getRuleContext(ObjectContext.class, 0);
        }

        public LayerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_layer;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).enterLayer(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).exitLayer(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CaffePrototxtVisitor)
                return ((CaffePrototxtVisitor<? extends T>) visitor).visitLayer(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LayerContext layer() throws RecognitionException {
        LayerContext _localctx = new LayerContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_layer);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(29);
                match(ID);
                setState(30);
                object();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PairContext extends ParserRuleContext {
        public TerminalNode ID() {
            return getToken(CaffePrototxtParser.ID, 0);
        }

        public ValueContext value() {
            return getRuleContext(ValueContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(CaffePrototxtParser.COLON, 0);
        }

        public PairContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pair;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).enterPair(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).exitPair(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CaffePrototxtVisitor)
                return ((CaffePrototxtVisitor<? extends T>) visitor).visitPair(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PairContext pair() throws RecognitionException {
        PairContext _localctx = new PairContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_pair);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(32);
                match(ID);
                setState(34);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(33);
                        match(COLON);
                    }
                }

                setState(36);
                value();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ValueContext extends ParserRuleContext {
        public ValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_value;
        }

        public ValueContext() {
        }

        public void copyFrom(ValueContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ValueObjectContext extends ValueContext {
        public ObjectContext object() {
            return getRuleContext(ObjectContext.class, 0);
        }

        public ValueObjectContext(ValueContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).enterValueObject(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).exitValueObject(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CaffePrototxtVisitor)
                return ((CaffePrototxtVisitor<? extends T>) visitor).visitValueObject(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class ValueLeafContext extends ValueContext {
        public TerminalNode STRING() {
            return getToken(CaffePrototxtParser.STRING, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(CaffePrototxtParser.NUMBER, 0);
        }

        public TerminalNode ID() {
            return getToken(CaffePrototxtParser.ID, 0);
        }

        public ValueLeafContext(ValueContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).enterValueLeaf(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).exitValueLeaf(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CaffePrototxtVisitor)
                return ((CaffePrototxtVisitor<? extends T>) visitor).visitValueLeaf(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ValueContext value() throws RecognitionException {
        ValueContext _localctx = new ValueContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_value);
        int _la;
        try {
            setState(40);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case LPAREN:
                    _localctx = new ValueObjectContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(38);
                    object();
                }
                break;
                case NUMBER:
                case ID:
                case STRING:
                    _localctx = new ValueLeafContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(39);
                    _la = _input.LA(1);
                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << ID) | (1L << STRING))) != 0))) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ObjectContext extends ParserRuleContext {
        public TerminalNode LPAREN() {
            return getToken(CaffePrototxtParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(CaffePrototxtParser.RPAREN, 0);
        }

        public List<PairContext> pair() {
            return getRuleContexts(PairContext.class);
        }

        public PairContext pair(int i) {
            return getRuleContext(PairContext.class, i);
        }

        public ObjectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_object;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).enterObject(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof CaffePrototxtListener) ((CaffePrototxtListener) listener).exitObject(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof CaffePrototxtVisitor)
                return ((CaffePrototxtVisitor<? extends T>) visitor).visitObject(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ObjectContext object() throws RecognitionException {
        ObjectContext _localctx = new ObjectContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_object);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(42);
                match(LPAREN);
                setState(44);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(43);
                            pair();
                        }
                    }
                    setState(46);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == ID);
                setState(48);
                match(RPAREN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\f\65\4\2\t\2\4\3" +
                    "\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\6\2\23\n\2\r\2\16" +
                    "\2\24\3\3\6\3\30\n\3\r\3\16\3\31\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\5" +
                    "\6%\n\6\3\6\3\6\3\7\3\7\5\7+\n\7\3\b\3\b\6\b/\n\b\r\b\16\b\60\3\b\3\b" +
                    "\3\b\2\2\t\2\4\6\b\n\f\16\2\3\3\2\6\b\2\62\2\20\3\2\2\2\4\27\3\2\2\2\6" +
                    "\33\3\2\2\2\b\37\3\2\2\2\n\"\3\2\2\2\f*\3\2\2\2\16,\3\2\2\2\20\22\5\6" +
                    "\4\2\21\23\5\b\5\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2" +
                    "\2\2\25\3\3\2\2\2\26\30\5\n\6\2\27\26\3\2\2\2\30\31\3\2\2\2\31\27\3\2" +
                    "\2\2\31\32\3\2\2\2\32\5\3\2\2\2\33\34\7\7\2\2\34\35\7\5\2\2\35\36\7\b" +
                    "\2\2\36\7\3\2\2\2\37 \7\7\2\2 !\5\16\b\2!\t\3\2\2\2\"$\7\7\2\2#%\7\5\2" +
                    "\2$#\3\2\2\2$%\3\2\2\2%&\3\2\2\2&\'\5\f\7\2\'\13\3\2\2\2(+\5\16\b\2)+" +
                    "\t\2\2\2*(\3\2\2\2*)\3\2\2\2+\r\3\2\2\2,.\7\3\2\2-/\5\n\6\2.-\3\2\2\2" +
                    "/\60\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\4\2\2\63" +
                    "\17\3\2\2\2\7\24\31$*\60";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}