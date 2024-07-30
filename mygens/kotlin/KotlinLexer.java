package kotlin;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class KotlinLexer {
	InputStream is;
	int curChar;
	int curPos;
	KotlinToken curToken;
	StringBuilder curString;

	boolean tr = true;
	public KotlinLexer(InputStream is) throws ParseException {
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
		if (curToken == KotlinToken.END) {
			throw new ParseException("qqq", curChar);
		}
		if (curChar == -1) {
			curToken = KotlinToken.END;
			return;
		}
		curString = new StringBuilder();
		var token = KotlinToken.END;
		curToken = KotlinToken.END;
		while (curToken == KotlinToken.END) {
			curString.append((char) curChar);
			switch (curString.toString()) {
				case "," -> {
					nextChar();
					curToken = KotlinToken.COMMA;
				}
				case "&" -> {
					nextChar();
					curToken = KotlinToken.AMP;
				}
				case "var" -> {
					nextChar();
					curToken = KotlinToken.VAR;
				}
				case ";" -> {
					nextChar();
					curToken = KotlinToken.SEMICOLON;
				}
				case ">" -> {
					nextChar();
					curToken = KotlinToken.GREATER;
				}
				case ":" -> {
					nextChar();
					curToken = KotlinToken.COLON;
				}
				case "<" -> {
					nextChar();
					curToken = KotlinToken.LESS;
				}
				default -> {
					if (curString.toString().matches("[a-zA-Z][a-zA-Z0-9]*")) {
						nextChar();
						curToken = KotlinToken.NAME;
					}
					else if (curChar == -1 && token == KotlinToken.END){
						throw new ParseException("Unexpected symbol", curChar);
					}
				}
			}
			if (curToken == KotlinToken.END) {
				if (token != KotlinToken.END) {
					curString.delete(curString.length() - 1, curString.length());
					curToken = token;
				} else {
					nextChar();
				}
			} else {
				token = curToken;
				curToken = KotlinToken.END;
			}
		}
	}
}