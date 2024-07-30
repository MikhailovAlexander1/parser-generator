package calculator;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class CalculatorLexer {
	InputStream is;
	int curChar;
	int curPos;
	CalculatorToken curToken;
	StringBuilder curString;

	boolean tr = true;
	public CalculatorLexer(InputStream is) throws ParseException {
		this.is = is;
		curPos = 0;
		nextChar();
	}

	private void nextChar() throws ParseException {
		curPos++;
		try {
			curChar = is.read();
		} catch (IOException e) {
			throw new ParseException(e.getMessage(), curPos);
		};
	};

	private void skipWhiteSpace() throws ParseException {
		while (Character.isWhitespace(curChar)) {
			nextChar();
		}
	}

	public void nextToken() throws ParseException {
		skipWhiteSpace();
		if (curToken == CalculatorToken.END) {
			throw new ParseException("qqq", curChar);
		}
		if (curChar == -1) {
			curToken = CalculatorToken.END;
			return;
		}
		curString = new StringBuilder();
		var token = CalculatorToken.END;
		curToken = CalculatorToken.END;
		while (curToken == CalculatorToken.END) {
			curString.append((char) curChar);
			switch (curString.toString()) {
				case "/" -> {
					nextChar();
					curToken = CalculatorToken.SLASH;
				}
				case "(" -> {
					nextChar();
					curToken = CalculatorToken.LPAREN;
				}
				case "*" -> {
					nextChar();
					curToken = CalculatorToken.ASTERISK;
				}
				case ")" -> {
					nextChar();
					curToken = CalculatorToken.RPAREN;
				}
				case "-" -> {
					nextChar();
					curToken = CalculatorToken.MINUS;
				}
				case "+" -> {
					nextChar();
					curToken = CalculatorToken.PLUS;
				}
				default -> {
					if (curString.toString().matches("[1-9][0-9]*")) {
						nextChar();
						curToken = CalculatorToken.NUMBER;
					}
					else if (curChar == -1 && token == CalculatorToken.END){
						throw new ParseException("Unexpected symbol", curChar);
					}
				}
			}
			if (curToken == CalculatorToken.END) {
				if (token != CalculatorToken.END) {
					curString.delete(curString.length() - 1, curString.length());
					curToken = token;
				} else {
					nextChar();
				}
			} else {
				token = curToken;
				curToken = CalculatorToken.END;
			}
		}
	}
}