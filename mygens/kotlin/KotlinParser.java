package kotlin;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

import static kotlin.KotlinToken.*;

public class KotlinParser {
	public KotlinLexer la;

	private void assertToken(KotlinToken token) throws ParseException {
		if (la.curToken != token) {
			throw new ParseException(String.format("Wrong token: %s!", token), 0);
		}
	}

	private Tree e() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case VAR -> {
				Tree v = v();
				assertToken(COLON);
				la.nextToken();
				Tree a = a();
				assertToken(SEMICOLON);
				la.nextToken();
				tree = new Tree("e", v, new Tree(":"), a, new Tree(";"));
			}
			case END -> {
				tree = new Tree("e", new Tree("ε"));
			}
			default -> throw new AssertionError();
		}
		assertToken(END);
		return tree;
	}

	private Tree v() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case VAR -> {
				tree = new Tree("v", new Tree(la.curString.toString()));
				assertToken(VAR);
				la.nextToken();
				tree.addChild(new Tree(la.curString.toString()));
				assertToken(NAME);
				la.nextToken();
			}
			default -> throw new AssertionError();
		}
		return tree;
	}

	private Tree a() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case NAME -> {
				Tree t = t();
				Tree at = at();
				tree = new Tree("a", t, at);
			}
			default -> throw new AssertionError();
		}
		return tree;
	}

	private Tree at() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case LESS -> {
				assertToken(LESS);
				la.nextToken();
				Tree tt = tt();
				Tree atcont = atcont();
				assertToken(GREATER);
				la.nextToken();
				tree = new Tree("at", new Tree("<"), tt, atcont, new Tree(">"));
			}
			default -> throw new AssertionError();
		}
		return tree;
	}

	private Tree atcont() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case COMMA -> {
				assertToken(COMMA);
				la.nextToken();
				Tree tt = tt();
				Tree atcont = atcont();
				tree = new Tree("atcont", new Tree(","), tt, atcont);
			}
			case GREATER -> {
				tree = new Tree("atcont", new Tree("ε"));
			}
			default -> throw new AssertionError();
		}
		return tree;
	}

	private Tree tt() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case NAME -> {
				Tree t = t();
				Tree ttt = ttt();
				Tree ampt = ampt();
				tree = new Tree("tt", t, ttt, ampt);
			}
			default -> throw new AssertionError();
		}
		return tree;
	}

	private Tree ampt() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case AMP -> {
				assertToken(AMP);
				la.nextToken();
				Tree tt = tt();
				tree = new Tree("ampt", new Tree("&"), tt);
			}
			case COMMA, GREATER -> {
				tree = new Tree("ampt", new Tree("ε"));
			}
			default -> throw new AssertionError();
		}
		return tree;
	}

	private Tree ttt() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case LESS -> {
				Tree at = at();
				tree = new Tree("ttt", at);
			}
			case COMMA, AMP, GREATER -> {
				tree = new Tree("ttt", new Tree("ε"));
			}
			default -> throw new AssertionError();
		}
		return tree;
	}

	private Tree t() throws ParseException {
		Tree tree;
		switch(la.curToken) {
			case NAME -> {
				tree = new Tree(la.curString.toString());
				assertToken(NAME);
				la.nextToken();
			}
			default -> throw new AssertionError();
		}
		return tree;
	}

	public Tree parse(String str) throws ParseException {
		InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
		la = new KotlinLexer(is);
		la.nextToken();
		return e();
	}
}