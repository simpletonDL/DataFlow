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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, SingleLineComment=9, 
		MultiLineComment=10, IF=11, WHILE=12, ID=13, TYPE_ID=14, CONST=15, ENDLINE=16, 
		LPAREN=17, RPAREN=18, LBRACE=19, RBRACE=20, WS=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "SingleLineComment", 
			"MultiLineComment", "IF", "WHILE", "ID", "TYPE_ID", "CONST", "ENDLINE", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "'='", "'fun'", "','", "'return'", "'else'", "'=='", 
			null, null, "'if'", "'while'", null, null, null, "';'", "'('", "')'", 
			"'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "SingleLineComment", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u0090\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\nO\n\n\f\n\16\nR\13\n\3\13\3"+
		"\13\3\13\3\13\7\13X\n\13\f\13\16\13[\13\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\6\16j\n\16\r\16\16\16k\3\16\7\16o\n\16\f"+
		"\16\16\16r\13\16\3\17\3\17\7\17v\n\17\f\17\16\17y\13\17\3\20\6\20|\n\20"+
		"\r\20\16\20}\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\6"+
		"\26\u008b\n\26\r\26\16\26\u008c\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27\3\2\7\4\2\f\f\17\17\3\2c|\3\2\62;\3\2C\\\5\2\13\f\17\17\"\"\2"+
		"\u0096\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5"+
		"\61\3\2\2\2\7\63\3\2\2\2\t\65\3\2\2\2\139\3\2\2\2\r;\3\2\2\2\17B\3\2\2"+
		"\2\21G\3\2\2\2\23J\3\2\2\2\25S\3\2\2\2\27_\3\2\2\2\31b\3\2\2\2\33i\3\2"+
		"\2\2\35s\3\2\2\2\37{\3\2\2\2!\177\3\2\2\2#\u0081\3\2\2\2%\u0083\3\2\2"+
		"\2\'\u0085\3\2\2\2)\u0087\3\2\2\2+\u008a\3\2\2\2-.\7x\2\2./\7c\2\2/\60"+
		"\7t\2\2\60\4\3\2\2\2\61\62\7<\2\2\62\6\3\2\2\2\63\64\7?\2\2\64\b\3\2\2"+
		"\2\65\66\7h\2\2\66\67\7w\2\2\678\7p\2\28\n\3\2\2\29:\7.\2\2:\f\3\2\2\2"+
		";<\7t\2\2<=\7g\2\2=>\7v\2\2>?\7w\2\2?@\7t\2\2@A\7p\2\2A\16\3\2\2\2BC\7"+
		"g\2\2CD\7n\2\2DE\7u\2\2EF\7g\2\2F\20\3\2\2\2GH\7?\2\2HI\7?\2\2I\22\3\2"+
		"\2\2JK\7\61\2\2KL\7\61\2\2LP\3\2\2\2MO\n\2\2\2NM\3\2\2\2OR\3\2\2\2PN\3"+
		"\2\2\2PQ\3\2\2\2Q\24\3\2\2\2RP\3\2\2\2ST\7\61\2\2TU\7,\2\2UY\3\2\2\2V"+
		"X\13\2\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3\2\2\2[Y\3\2\2"+
		"\2\\]\7,\2\2]^\7\61\2\2^\26\3\2\2\2_`\7k\2\2`a\7h\2\2a\30\3\2\2\2bc\7"+
		"y\2\2cd\7j\2\2de\7k\2\2ef\7n\2\2fg\7g\2\2g\32\3\2\2\2hj\t\3\2\2ih\3\2"+
		"\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2lp\3\2\2\2mo\t\4\2\2nm\3\2\2\2or\3\2"+
		"\2\2pn\3\2\2\2pq\3\2\2\2q\34\3\2\2\2rp\3\2\2\2sw\t\5\2\2tv\t\3\2\2ut\3"+
		"\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\36\3\2\2\2yw\3\2\2\2z|\t\4\2\2{"+
		"z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~ \3\2\2\2\177\u0080\7=\2\2\u0080"+
		"\"\3\2\2\2\u0081\u0082\7*\2\2\u0082$\3\2\2\2\u0083\u0084\7+\2\2\u0084"+
		"&\3\2\2\2\u0085\u0086\7}\2\2\u0086(\3\2\2\2\u0087\u0088\7\177\2\2\u0088"+
		"*\3\2\2\2\u0089\u008b\t\6\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f"+
		"\b\26\2\2\u008f,\3\2\2\2\n\2PYkpw}\u008c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}