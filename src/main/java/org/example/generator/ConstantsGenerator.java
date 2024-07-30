package org.example.generator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ConstantsGenerator {
    private static final String FILE_NAME = "C";
    private static final String FILE_BEGIN =
            "package org.example.generator;\n" +
            "\n" +
            "public class " + FILE_NAME + " {\n";

    private static final String FILE_END = "}";
    private static final String CONSTANT_MODIFIERS = "public static final String ";
    private static final char SEMICOLON = ';';
    private static final char EQUAL = '=';
    private static final char TAB = '\t';
    private static final char SPACE = ' ';
    private static final char QUOTE = '\"';
    private static final char NEWLINE = '\n';

    private static final String[] keyWords = {
            "abstract",
            "assert",
            "boolean",
            "break",
            "byte",
            "case",
            "catch",
            "char",
            "class",
            "continue",
            "default",
            "do",
            "double",
            "else",
            "enum",
            "extends",
            "final",
            "finally",
            "float",
            "for",
            "if",
            "implements",
            "import",
            "instanceof",
            "int",
            "interface",
            "long",
            "native",
            "new",
            "package",
            "private",
            "protected",
            "public",
            "return",
            "short",
            "static",
            "strictfp",
            "super",
            "switch",
            "synchronized",
            "this",
            "throw",
            "throws",
            "transient",
            "try",
            "void",
            "volatile",
            "while",
    };

    private static String getConstsDeclarations() {
        StringBuilder sb = new StringBuilder();
        for (String keyWord: keyWords) {
            sb.append(TAB).append(CONSTANT_MODIFIERS).append(keyWord.toUpperCase()).append(SPACE).append(EQUAL)
                    .append(SPACE).append(QUOTE).append(keyWord).append(QUOTE).append(SEMICOLON).append(NEWLINE);
        }
        return sb.toString();
    }

    private static String getSingleCharsDeclarations() {
        HashMap<String, Character> map = new HashMap<>();
        map.put("SPACE", ' ');
        map.put("EXCLAMATION_MARK", '!');
        map.put("DOUBLE_QUOTE", '\"');
        map.put("HASH", '#');
        map.put("DOLLAR", '$');
        map.put("PERCENT", '%');
        map.put("AMPERSAND", '&');
        map.put("SINGLE_QUOTE", '\'');
        map.put("OPEN_PARENTHESIS", '(');
        map.put("CLOSE_PARENTHESIS", ')');
        map.put("ASTERISK", '*');
        map.put("PLUS", '+');
        map.put("COMMA", ',');
        map.put("MINUS", '-');
        map.put("PERIOD", '.');
        map.put("SLASH", '/');
        map.put("COLON", ':');
        map.put("SEMICOLON", ';');
        map.put("LESS_THAN", '<');
        map.put("EQUALS", '=');
        map.put("GREATER_THAN", '>');
        map.put("QUESTION_MARK", '?');
        map.put("AT", '@');
        map.put("OPEN_BRACKET", '[');
        map.put("BACKSLASH", '\\');
        map.put("CLOSE_BRACKET", ']');
        map.put("CARET", '^');
        map.put("UNDERSCORE", '_');
        map.put("GRAVE_ACCENT", '`');
        map.put("OPEN_BRACE", '{');
        map.put("VERTICAL_BAR", '|');
        map.put("CLOSE_BRACE", '}');
        map.put("TILDE", '~');
        map.put("NEWLINE", 'n');
        map.put("TAB", '\t');
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Character> entry: map.entrySet()) {
            String value = String.valueOf(entry.getValue());
            if (entry.getValue() == '\'' || entry.getValue() == '\"'
                    || entry.getValue() == '\\' || entry.getValue() == 'n') {
                value = "\\" + entry.getValue();
            }
            sb.append(TAB).append(CONSTANT_MODIFIERS).append(entry.getKey()).append(SPACE).append(EQUAL)
                    .append(SPACE).append(QUOTE).append(value).append(QUOTE).append(SEMICOLON).append(NEWLINE);
        }
        return sb.toString();
    }

    public static void genConstantFile() throws IOException {
        String packageName = "src/main/java/org/example/generator/";
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(packageName + FILE_NAME + ".java"))) {
            writer.write(FILE_BEGIN);
            writer.write(getConstsDeclarations());
            writer.write(getSingleCharsDeclarations());
            writer.write(FILE_END);
            writer.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        genConstantFile();
    }
}
