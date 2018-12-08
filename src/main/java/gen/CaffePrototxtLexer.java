package gen;// Generated from /Users/saurabh/IdeaProjects/wootz/src/main/java/CaffePrototxt.g4 by ANTLR 4.7

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CaffePrototxtLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, COLON=3, NUMBER=4, ID=5, STRING=6, WS=7, NL=8, COMMENT=9, 
		CAFFE2MXNET=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LPAREN", "RPAREN", "COLON", "NUMBER", "DIGIT", "Exponent", "ID", "LETTER", 
		"STRING", "WS", "NL", "COMMENT", "CAFFE2MXNET"
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


	public CaffePrototxtLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "grammars/CaffePrototxt.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return COMMENT_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean COMMENT_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return !getText().startsWith("#CaffeToMXNet");
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f\u0093\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\4\3\4\3\5\5\5%\n\5\3"+
		"\5\3\5\6\5)\n\5\r\5\16\5*\3\5\6\5.\n\5\r\5\16\5/\3\5\3\5\7\5\64\n\5\f"+
		"\5\16\5\67\13\5\5\59\n\5\5\5;\n\5\3\5\5\5>\n\5\3\6\3\6\3\7\3\7\5\7D\n"+
		"\7\3\7\6\7G\n\7\r\7\16\7H\3\b\3\b\3\b\7\bN\n\b\f\b\16\bQ\13\b\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\7\nY\n\n\f\n\16\n\\\13\n\3\n\3\n\3\n\3\n\3\n\7\nc\n\n"+
		"\f\n\16\nf\13\n\3\n\5\ni\n\n\3\13\6\13l\n\13\r\13\16\13m\3\13\3\13\3\f"+
		"\6\fs\n\f\r\f\16\ft\3\f\3\f\3\r\3\r\7\r{\n\r\f\r\16\r~\13\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\4Zd\2\17\3\3\5\4\7\5\t\6\13\2\r\2\17\7\21\2\23\b\25\t"+
		"\27\n\31\13\33\f\3\2\b\3\2\62;\4\2GGgg\4\2--//\6\2C\\aac|\u0082\u0101"+
		"\4\2\13\13\"\"\4\2\f\f\17\17\2\u00a2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\17\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7!\3\2\2\2\t$\3\2\2\2"+
		"\13?\3\2\2\2\rA\3\2\2\2\17J\3\2\2\2\21R\3\2\2\2\23h\3\2\2\2\25k\3\2\2"+
		"\2\27r\3\2\2\2\31x\3\2\2\2\33\u0083\3\2\2\2\35\36\7}\2\2\36\4\3\2\2\2"+
		"\37 \7\177\2\2 \6\3\2\2\2!\"\7<\2\2\"\b\3\2\2\2#%\7/\2\2$#\3\2\2\2$%\3"+
		"\2\2\2%:\3\2\2\2&(\7\60\2\2\')\5\13\6\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2"+
		"*+\3\2\2\2+;\3\2\2\2,.\5\13\6\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2"+
		"\2\2\608\3\2\2\2\61\65\7\60\2\2\62\64\5\13\6\2\63\62\3\2\2\2\64\67\3\2"+
		"\2\2\65\63\3\2\2\2\65\66\3\2\2\2\669\3\2\2\2\67\65\3\2\2\28\61\3\2\2\2"+
		"89\3\2\2\29;\3\2\2\2:&\3\2\2\2:-\3\2\2\2;=\3\2\2\2<>\5\r\7\2=<\3\2\2\2"+
		"=>\3\2\2\2>\n\3\2\2\2?@\t\2\2\2@\f\3\2\2\2AC\t\3\2\2BD\t\4\2\2CB\3\2\2"+
		"\2CD\3\2\2\2DF\3\2\2\2EG\4\62;\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2"+
		"\2I\16\3\2\2\2JO\5\21\t\2KN\5\21\t\2LN\5\13\6\2MK\3\2\2\2ML\3\2\2\2NQ"+
		"\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\20\3\2\2\2QO\3\2\2\2RS\t\5\2\2S\22\3\2\2"+
		"\2TZ\7$\2\2UV\7^\2\2VY\7$\2\2WY\13\2\2\2XU\3\2\2\2XW\3\2\2\2Y\\\3\2\2"+
		"\2Z[\3\2\2\2ZX\3\2\2\2[]\3\2\2\2\\Z\3\2\2\2]i\7$\2\2^d\7)\2\2_`\7^\2\2"+
		"`c\7)\2\2ac\13\2\2\2b_\3\2\2\2ba\3\2\2\2cf\3\2\2\2de\3\2\2\2db\3\2\2\2"+
		"eg\3\2\2\2fd\3\2\2\2gi\7)\2\2hT\3\2\2\2h^\3\2\2\2i\24\3\2\2\2jl\t\6\2"+
		"\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2\2op\b\13\2\2p\26\3"+
		"\2\2\2qs\t\7\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2vw\b"+
		"\f\2\2w\30\3\2\2\2x|\7%\2\2y{\n\7\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}"+
		"\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0080\6\r\2\2\u0080\u0081\3\2\2\2"+
		"\u0081\u0082\b\r\3\2\u0082\32\3\2\2\2\u0083\u0084\7%\2\2\u0084\u0085\7"+
		"E\2\2\u0085\u0086\7c\2\2\u0086\u0087\7h\2\2\u0087\u0088\7h\2\2\u0088\u0089"+
		"\7g\2\2\u0089\u008a\7V\2\2\u008a\u008b\7q\2\2\u008b\u008c\7O\2\2\u008c"+
		"\u008d\7Z\2\2\u008d\u008e\7P\2\2\u008e\u008f\7g\2\2\u008f\u0090\7v\2\2"+
		"\u0090\u0091\3\2\2\2\u0091\u0092\b\16\3\2\u0092\34\3\2\2\2\26\2$*/\65"+
		"8:=CHMOXZbdhmt|\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}