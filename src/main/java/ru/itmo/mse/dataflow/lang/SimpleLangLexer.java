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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, SingleLineComment=7, MultiLineComment=8, 
		IF=9, WHILE=10, ID=11, TYPE_ID=12, CONST=13, ENDLINE=14, LPAREN=15, RPAREN=16, 
		LBRACE=17, RBRACE=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "SingleLineComment", 
			"MultiLineComment", "IF", "WHILE", "ID", "TYPE_ID", "CONST", "ENDLINE", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "':'", "'='", "'fun'", "','", "'return'", null, null, 
			"'if'", "'while'", null, null, null, "';'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "SingleLineComment", "MultiLineComment", 
			"IF", "WHILE", "ID", "TYPE_ID", "CONST", "ENDLINE", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0084\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bC\n\b\f\b"+
		"\16\bF\13\b\3\t\3\t\3\t\3\t\7\tL\n\t\f\t\16\tO\13\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\6\f^\n\f\r\f\16\f_\3\f\7\fc\n"+
		"\f\f\f\16\ff\13\f\3\r\3\r\7\rj\n\r\f\r\16\rm\13\r\3\16\6\16p\n\16\r\16"+
		"\16\16q\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\6\24\177"+
		"\n\24\r\24\16\24\u0080\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\7\4"+
		"\2\f\f\17\17\3\2c|\3\2\62;\3\2C\\\5\2\13\f\17\17\"\"\2\u008a\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\3)\3\2\2\2\5-\3\2\2\2\7/\3\2\2\2\t\61\3\2\2\2\13\65\3"+
		"\2\2\2\r\67\3\2\2\2\17>\3\2\2\2\21G\3\2\2\2\23S\3\2\2\2\25V\3\2\2\2\27"+
		"]\3\2\2\2\31g\3\2\2\2\33o\3\2\2\2\35s\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#y"+
		"\3\2\2\2%{\3\2\2\2\'~\3\2\2\2)*\7x\2\2*+\7c\2\2+,\7t\2\2,\4\3\2\2\2-."+
		"\7<\2\2.\6\3\2\2\2/\60\7?\2\2\60\b\3\2\2\2\61\62\7h\2\2\62\63\7w\2\2\63"+
		"\64\7p\2\2\64\n\3\2\2\2\65\66\7.\2\2\66\f\3\2\2\2\678\7t\2\289\7g\2\2"+
		"9:\7v\2\2:;\7w\2\2;<\7t\2\2<=\7p\2\2=\16\3\2\2\2>?\7\61\2\2?@\7\61\2\2"+
		"@D\3\2\2\2AC\n\2\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\20\3\2\2"+
		"\2FD\3\2\2\2GH\7\61\2\2HI\7,\2\2IM\3\2\2\2JL\13\2\2\2KJ\3\2\2\2LO\3\2"+
		"\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7,\2\2QR\7\61\2\2R\22\3"+
		"\2\2\2ST\7k\2\2TU\7h\2\2U\24\3\2\2\2VW\7y\2\2WX\7j\2\2XY\7k\2\2YZ\7n\2"+
		"\2Z[\7g\2\2[\26\3\2\2\2\\^\t\3\2\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`d\3\2\2\2ac\t\4\2\2ba\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2e\30"+
		"\3\2\2\2fd\3\2\2\2gk\t\5\2\2hj\t\3\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2k"+
		"l\3\2\2\2l\32\3\2\2\2mk\3\2\2\2np\t\4\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2"+
		"\2qr\3\2\2\2r\34\3\2\2\2st\7=\2\2t\36\3\2\2\2uv\7*\2\2v \3\2\2\2wx\7+"+
		"\2\2x\"\3\2\2\2yz\7}\2\2z$\3\2\2\2{|\7\177\2\2|&\3\2\2\2}\177\t\6\2\2"+
		"~}\3\2\2\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0083\b\24\2\2\u0083(\3\2\2\2\n\2DM_dkq\u0080\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}