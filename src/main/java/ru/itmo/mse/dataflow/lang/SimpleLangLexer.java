// Generated from SimpleLang.g4 by ANTLR 4.9.3

    package ru.itmo.mse.dataflow.lang;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		SingleLineComment=10, MultiLineComment=11, IF=12, WHILE=13, ID=14, TYPE_ID=15, 
		CONST=16, ENDLINE=17, LPAREN=18, RPAREN=19, LBRACE=20, RBRACE=21, WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"SingleLineComment", "MultiLineComment", "IF", "WHILE", "ID", "TYPE_ID", 
			"CONST", "ENDLINE", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "'='", "'fun'", "','", "'return'", "'else'", "'=='", 
			"'random'", null, null, "'if'", "'while'", null, null, null, "';'", "'('", 
			"')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "SingleLineComment", 
			"MultiLineComment", "IF", "WHILE", "ID", "TYPE_ID", "CONST", "ENDLINE", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public SimpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u0099\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\7\13X\n\13\f\13\16\13[\13\13\3\f\3\f\3\f\3\f\7\fa\n\f\f\f\16"+
		"\fd\13\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\6"+
		"\17s\n\17\r\17\16\17t\3\17\7\17x\n\17\f\17\16\17{\13\17\3\20\3\20\7\20"+
		"\177\n\20\f\20\16\20\u0082\13\20\3\21\6\21\u0085\n\21\r\21\16\21\u0086"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\6\27\u0094\n\27"+
		"\r\27\16\27\u0095\3\27\3\27\2\2\30\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"\3\2\7\4\2\f\f\17\17\3\2c|\3\2\62;\3\2C\\\5\2\13\f\17\17\"\"\2\u009f\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2"+
		"\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17D\3\2"+
		"\2\2\21I\3\2\2\2\23L\3\2\2\2\25S\3\2\2\2\27\\\3\2\2\2\31h\3\2\2\2\33k"+
		"\3\2\2\2\35r\3\2\2\2\37|\3\2\2\2!\u0084\3\2\2\2#\u0088\3\2\2\2%\u008a"+
		"\3\2\2\2\'\u008c\3\2\2\2)\u008e\3\2\2\2+\u0090\3\2\2\2-\u0093\3\2\2\2"+
		"/\60\7x\2\2\60\61\7c\2\2\61\62\7t\2\2\62\4\3\2\2\2\63\64\7<\2\2\64\6\3"+
		"\2\2\2\65\66\7?\2\2\66\b\3\2\2\2\678\7h\2\289\7w\2\29:\7p\2\2:\n\3\2\2"+
		"\2;<\7.\2\2<\f\3\2\2\2=>\7t\2\2>?\7g\2\2?@\7v\2\2@A\7w\2\2AB\7t\2\2BC"+
		"\7p\2\2C\16\3\2\2\2DE\7g\2\2EF\7n\2\2FG\7u\2\2GH\7g\2\2H\20\3\2\2\2IJ"+
		"\7?\2\2JK\7?\2\2K\22\3\2\2\2LM\7t\2\2MN\7c\2\2NO\7p\2\2OP\7f\2\2PQ\7q"+
		"\2\2QR\7o\2\2R\24\3\2\2\2ST\7\61\2\2TU\7\61\2\2UY\3\2\2\2VX\n\2\2\2WV"+
		"\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\26\3\2\2\2[Y\3\2\2\2\\]\7\61\2"+
		"\2]^\7,\2\2^b\3\2\2\2_a\13\2\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2"+
		"\2ce\3\2\2\2db\3\2\2\2ef\7,\2\2fg\7\61\2\2g\30\3\2\2\2hi\7k\2\2ij\7h\2"+
		"\2j\32\3\2\2\2kl\7y\2\2lm\7j\2\2mn\7k\2\2no\7n\2\2op\7g\2\2p\34\3\2\2"+
		"\2qs\t\3\2\2rq\3\2\2\2st\3\2\2\2tr\3\2\2\2tu\3\2\2\2uy\3\2\2\2vx\t\4\2"+
		"\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\36\3\2\2\2{y\3\2\2\2|\u0080"+
		"\t\5\2\2}\177\t\3\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081 \3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\t\4\2\2"+
		"\u0084\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087\"\3\2\2\2\u0088\u0089\7=\2\2\u0089$\3\2\2\2\u008a\u008b"+
		"\7*\2\2\u008b&\3\2\2\2\u008c\u008d\7+\2\2\u008d(\3\2\2\2\u008e\u008f\7"+
		"}\2\2\u008f*\3\2\2\2\u0090\u0091\7\177\2\2\u0091,\3\2\2\2\u0092\u0094"+
		"\t\6\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\27\2\2\u0098.\3\2\2\2"+
		"\n\2Ybty\u0080\u0086\u0095\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}