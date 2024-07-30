package calculator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

import static calculator.CalculatorToken.*;

public class CalculatorParser {
	public CalculatorLexer la;

	private void assertToken(CalculatorToken token) throws ParseException {
		if (la.curToken != token) {
			throw new ParseException(String.format("Wrong token: %s!", token), 0);
		}
	}

	private double exprStart() throws ParseException {
		double value;
		switch(la.curToken) {
			case MINUS -> {
				double e = e();
				value = e;
			}
			case NUMBER -> {
				double e = e();
				value = e;
			}
			case LPAREN -> {
				double e = e();
				value = e;
			}
			case PLUS -> {
				double e = e();
				value = e;
			}
			case END -> {
				value = 0;
			}
			default -> throw new AssertionError();
		}
		assertToken(END);
		return value;
	}

	private double e() throws ParseException {
		double value;
		switch(la.curToken) {
			case MINUS -> {
				double t = t();
				double esup = esup(t);
				value = esup;
			}
			case NUMBER -> {
				double t = t();
				double esup = esup(t);
				value = esup;
			}
			case LPAREN -> {
				double t = t();
				double esup = esup(t);
				value = esup;
			}
			case PLUS -> {
				double t = t();
				double esup = esup(t);
				value = esup;
			}
			case RPAREN, END -> {
				value = 0;
			}
			default -> throw new AssertionError();
		}
		return value;
	}

	private double esup(double a) throws ParseException {
		double value;
		switch(la.curToken) {
			case MINUS -> {
				assertToken(MINUS);
				la.nextToken();
				double t = t();
				double esup = esup(a - t);
				value = esup;
			}
			case PLUS -> {
				assertToken(PLUS);
				la.nextToken();
				double t = t();
				double esup = esup(a + t);
				value = esup;
			}
			case RPAREN, END -> {
				value = a;
			}
			default -> throw new AssertionError();
		}
		return value;
	}

	private double t() throws ParseException {
		double value;
		switch(la.curToken) {
			case NUMBER -> {
				double f = f();
				double tsup = tsup(f);
				value = tsup;
			}
			case LPAREN -> {
				double f = f();
				double tsup = tsup(f);
				value = tsup;
			}
			case MINUS, RPAREN, END, PLUS -> {
				value = 0;
			}
			default -> throw new AssertionError();
		}
		return value;
	}

	private double tsup(double a) throws ParseException {
		double value;
		switch(la.curToken) {
			case SLASH -> {
				assertToken(SLASH);
				la.nextToken();
				double f = f();
				double tsup = tsup(a / f);
				value = tsup;
			}
			case ASTERISK -> {
				assertToken(ASTERISK);
				la.nextToken();
				double f = f();
				double tsup = tsup(a * f);
				value = tsup;
			}
			case MINUS, RPAREN, END, PLUS -> {
				value = a;
			}
			default -> throw new AssertionError();
		}
		return value;
	}

	private double f() throws ParseException {
		double value;
		switch(la.curToken) {
			case NUMBER -> {
				value = Integer.parseInt(la.curString.toString());
				assertToken(NUMBER);
				la.nextToken();
			}
			case LPAREN -> {
				assertToken(LPAREN);
				la.nextToken();
				double e = e();
				assertToken(RPAREN);
				la.nextToken();
				value = e;
			}
			default -> throw new AssertionError();
		}
		return value;
	}

	public double parse(String str) throws ParseException {
		InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
		la = new CalculatorLexer(is);
		la.nextToken();
		return exprStart();
	}
}