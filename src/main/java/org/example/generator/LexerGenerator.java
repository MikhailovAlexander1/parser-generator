package org.example.generator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class LexerGenerator {

    private final HashMap<String, String> tokens, regexp;
    private final StringBuilder sb = new StringBuilder();
    private final String packageName;
    private final String fileName;
    private final Path saveTo;

    private void addString(int tab, int lineSeparatorsCount, String str) {
        sb.append(C.TAB.repeat(Math.max(0, tab)));
        sb.append(str);
        sb.append(C.NEWLINE.repeat(Math.max(0, lineSeparatorsCount)));
    }

    private void printPackage() {
        if (!this.packageName.isEmpty()) {
            sb.append(C.PACKAGE).append(C.SPACE).append(this.packageName)
                    .append(C.SEMICOLON).append(C.NEWLINE).append(C.NEWLINE);
        }
    }

    private void printImports() {
        addString(0, 1, "import java.io.IOException;");
        addString(0, 1, "import java.io.InputStream;");
        addString(0, 2, "import java.text.ParseException;");
    }

    private void printClass() {
        sb.append(C.PUBLIC).append(C.SPACE).append(C.CLASS).append(C.SPACE)
                .append(String.format("%sLexer {\n", fileName));
        printFields();
        printMethods();
        sb.append(C.CLOSE_BRACE);
    }

    private void printFields() {
        addString(1, 1, "InputStream is;");
        addString(1, 1, "int curChar;");
        addString(1, 1, "int curPos;");
        addString(1, 1, String.format("%sToken curToken;", fileName));
        addString(1, 2, "StringBuilder curString;");
        addString(1, 1, "boolean tr = true;");
    }

    private void printMethods() {
        printConstructor();
        printNextChar();
        printSkipWs();
        printNextToken();
    }

    private void printConstructor() {
        addString(1, 1, String.format("public %sLexer(InputStream is) throws ParseException {", fileName));
        addString(2, 1, "this.is = is;");
        addString(2, 1, "curPos = 0;");
        addString(2, 1, "nextChar();");
        addString(1, 2, "}");
    }

    private void printNextChar() {
        addString(1, 1, "private void nextChar() throws ParseException {");
        addString(2, 1, "curPos++;");
        addString(2, 1, "try {");
        addString(3, 1, "curChar = is.read();");
        addString(2, 1, "} catch (IOException e) {");
        addString(3, 1, "throw new ParseException(e.getMessage(), curPos);");
        addString(2, 1, "};");
        addString(1, 2, "};");
    }

    private void printSkipWs() {
        addString(1, 1, "private void skipWhiteSpace() throws ParseException {");
        addString(2, 1, "while (Character.isWhitespace(curChar)) {");
        addString(3, 1, "nextChar();");
        addString(2, 1, "}");
        addString(1, 2, "}");
    }

    private void printNextToken() {
        addString(1, 1, "public void nextToken() throws ParseException {");
        addString(2, 1, "skipWhiteSpace();");
        addString(2, 1, String.format("if (curToken == %sToken.END) {", fileName));
        addString(3, 1, "throw new ParseException(\"qqq\", curChar);");
        addString(2, 1, "}");
        addString(2, 1, "if (curChar == -1) {");
        addString(3, 1, String.format("curToken = %sToken.END;", fileName));
        addString(3, 1, "return;");
        addString(2, 1, "}");
        addString(2, 1, "curString = new StringBuilder();");
        addString(2, 1, String.format("var token = %sToken.END;", fileName));
        addString(2, 1, String.format("curToken = %sToken.END;", fileName));
        addString(2, 1, String.format("while (curToken == %sToken.END) {", fileName));
        addString(3, 1, "curString.append((char) curChar);");
        addString(3, 1, "switch (curString.toString()) {");
        for (Map.Entry<String, String> map : tokens.entrySet()) {
            addString(4, 1, String.format("case \"%s\" -> {", map.getValue()));
            addString(5, 1, "nextChar();");
            addString(5, 1, String.format("curToken = %sToken.%s;", fileName, map.getKey()));
            addString(4, 1, "}");
        }
        addString(4, 1, "default -> {");
        boolean b = true;
        for (Map.Entry<String, String> reg : regexp.entrySet()) {
            String s = b ? "if" : "else if";
            b = false;
            addString(5, 1, String.format("%s (curString.toString().matches(\"%s\")) {", s, reg.getValue()));
            addString(6, 1, "nextChar();");
            addString(6, 1, String.format("curToken = %sToken.%s;", fileName, reg.getKey()));
            addString(5, 1, "}");
        }
        if (regexp.isEmpty()) {
            addString(5, 1, String.format("if (curChar == -1 && token == %sToken.END){", fileName));
        } else {
            addString(5, 1, String.format("else if (curChar == -1 && token == %sToken.END){", fileName));
        }
        addString(6, 1, "throw new ParseException(\"Unexpected symbol\", curChar);");
        addString(5, 1, "}");
        addString(4, 1, "}");
        addString(3, 1, "}");
        addString(3, 1, String.format("if (curToken == %sToken.END) {", fileName));
        addString(4, 1, String.format("if (token != %sToken.END) {", fileName));
        addString(5, 1, "curString.delete(curString.length() - 1, curString.length());");
        addString(5, 1, "curToken = token;");
        addString(4, 1, "} else {");
        addString(5, 1, "nextChar();");
        addString(4, 1, "}");
        addString(3, 1, "} else {");
        addString(4, 1, "token = curToken;");
        addString(4, 1, String.format("curToken = %sToken.END;", fileName));
        addString(3, 1, "}");
        addString(2, 1, "}");
        addString(1, 1, "}");
    }

    public LexerGenerator(HashMap<String, String> tokens, HashMap<String, String> regexp,
                          String pathToGen, String packageToGen, String taskName) {
        this.tokens = tokens;
        this.regexp = regexp;
        this.fileName = Character.toUpperCase(taskName.charAt(0)) + taskName.substring(1);
        this.packageName = packageToGen;
        this.saveTo = Paths.get(pathToGen, fileName + "Lexer.java");
    }

    public void generate() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(saveTo)) {
            printPackage();
            printImports();
            printClass();
            writer.write(sb.toString());
            writer.flush();
        }
    }
}
