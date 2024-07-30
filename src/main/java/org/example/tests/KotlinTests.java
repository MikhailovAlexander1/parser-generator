package org.example.tests;

import kotlin.KotlinParser;
import kotlin.Tree;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;

public class KotlinTests {
    private static class ANSI {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        private static final String GREEN = "\u001B[32m";
    }
    private static final String[] expressionTest = {
            /*1*/"", // E -> ε (успешно)
            /*2*/"_", // E -> ε (неверный ввод)
            /*3*/"var a: Array<Int>;", // E -> V : A ; (успешно)
            /*4*/": Array<Int>;", // E -> V : A ; (отсутствие V)
            /*5*/"var a Array<Int>;", // E -> V : A ; (отсутствие :)
            /*6*/"var b: ;", // E -> V : A ; (отсутствие A)
            /*7*/"var a: Array<Int>", // E -> V : A ; (отсутствие ;)
            /*8*/"var a: Array<Int>; Int"}; // E -> V : A ; (продолжение после конца строки)
    private static final int[] expressionTestCheck = {0, 1, 0, 1, 1, 1, 1, 1};

    private static final String[] variableNameTest = {
            /*1*/"var arrayForFloats: Array<Float>;", // V -> var name (успешно)
            /*2*/"var _: Array<Int>;", // V -> var name (неверный name)
            /*3*/"var 1: Array<Double>", // V -> var name (неверный name)
            /*4*/"var 11f1: Array<Float>", // V -> var name (неверный name)
            /*5*/"var STATIC: Array<Document>;", // V -> var name (успешно)
            /*6*/"a: Array<Int>;", // V -> var name (отсутствие var)
            /*7*/"var: Array<Int>;"}; // V -> var name (отсутствие name)
    private static final int[] variableNameTestCheck = {0, 1, 1, 1, 0, 1, 1};

    private static final String[] arrayTypeTest = {
            /*1*/"var a: Array<MyUniqueType>;", // A -> T AT (успешно)
            /*2*/"var a: <Int>;", // A -> T AT (отсутствие T)
            /*3*/"var a: 111aaa<Int>;", // A -> T AT (неверный T)
            /*4*/"var a: Array<1nt>;", // A -> T AT (неверный T)
            /*5*/"var a: Array;"}; // A -> T AT (отсутствие AT)
    private static final int[] arrayTypeTestCheck = {0, 1, 1, 1, 1};

    private static final String[] ATTest = {
            /*1*/"var a: Array<Int>;", // AT -> < TT > (успешно)
            /*2*/"var a: ArrayInt>;", // AT -> < TT > (отсутствие '<')
            /*3*/"var a: Array<Int;", // AT -> < TT > (отсутствие '>')
            /*4*/"var a: Array<>;"}; // AT -> < TT > (отсутствие TT)
    private static final int[] ATTestCheck = {0, 1, 1, 1};

    private static final String[] TTTest = {
            /*1*/"var a: Array<Int>;", // TT -> T TTT (успешно)
            /*2*/"var a: Array<Array<Int>>;", // TT -> T TTT -> T AT -> ... -> T < T < T ε > > (успешно)
            /*3*/"var a: Array<<Int>>;", // TT -> T TTT (отсутствие T)
            /*4*/"var a: Array<Array<>>;", // TT -> T TTT (отсутствие TTT)
            /*5*/"var a: Array<Document<Note>>>;", // TT -> T TTT (лишняя '>' в TTT -> AT -> < TT >)
            /*6*/"var a: Array<Document<<>>;"}; // TT -> T TTT -> ... -> T < T ε > (неверный T - "<")
    private static final int[] TTTestCheck = {0, 0, 1, 1, 1, 1};

    private static final String[] TTTTTest = {
            /*1*/"var a224 : Array<Array<HashMap<Int, String>>>;",
            /*2*/"var hello : Array<HashMap<Int, String>>;",
            /*3*/"var a224 : Array<HashMap<Int, Array<Document>>>;",
            /*4*/"var a224 : Array<Array<MyClass<A, B, C, D>>>;",
            /*5*/"var a224 : Array<HashMap<Array<MyClass<A, B, C, D>>, Array<HashMap<Int, String>>>>;",
            /*6*/"var a224 : Array<A, B, C<Int>>;",
            /*7*/"var a224 : Array<A, B<A, V<Array<Int>>>, C<Int>>;"};
    private static final int[] TTTTTestCheck = {0, 0, 0, 0, 0, 0, 0};
    private static final String[] AMPTest = {
            /*1*/"var a224 : Array<A & B>;",
            /*2*/"var hello : Array<HashMap<B & C, V>>;",
            /*3*/"var a224 : Array<A & B & C<Int>>;",
            /*4*/"var a224 : Array<A & B<HashMap<A, V>> & C<Int>>;",
            /*5*/"var a224 : Array<HashMap<Array<MyClass<A & B & C & D>>, Array<HashMap<A & C, A<B & Y>>>>>;"};
    private static final int[] AMPTestCheck = {0, 0, 0, 0, 0};

    private static void makeTestFolder(String folderName) throws IOException {
        File folder = new File(folderName);
        if (!folder.mkdir() && !folder.exists()) {
            String[] pathParts = folder.toString().split("/");
            throw new IOException(String.format("Can not create folder for test - \"%s\".", pathParts[pathParts.length - 1]));
        }
    }

    public static void run() throws IOException, IllegalAccessException {
        Field[] tests = KotlinTests.class.getDeclaredFields();

        for (int i = 0; i < tests.length; i += 2) {
            String testFolder = String.format("/Users/admikhailov/IdeaProjects/parserGen/src/main/java/org/example/tests/%s", tests[i].getName());
            makeTestFolder(testFolder);
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("========================%s========================%n", tests[i].getName()));
            int fails = 0;
            int result;
            String[] inputs = (String[]) tests[i].get(KotlinTests.class);
            int[] expectedResults = (int[]) tests[i + 1].get(KotlinTests.class);
            for (int j = 0; j < inputs.length; j++) {
                sb.append(String.format("%n%d.  ", j + 1)).append(String.format("input: \"%s\"%n", inputs[j]));
                if (expectedResults[j] == 0) {
                    sb.append(String.format("\t%sEXPECTED: Success%s%n", ANSI.GREEN, ANSI.RESET));
                } else {
                    sb.append(String.format("\t%sEXPECTED: ParseException%s%n", ANSI.RED, ANSI.RESET));
                }
                try {
                    KotlinParser parser = new KotlinParser();
                    Tree parseResult = parser.parse(inputs[j]);
                    String graphDeclaration = String.format("/%s/gr%d", testFolder, j);
                    String outputFile = String.format("/%s/png%d.png", testFolder, j);
                    GraphvizSupporter graphvizSupporter = new GraphvizSupporter(graphDeclaration);
                    graphvizSupporter.printGraph(parseResult, graphDeclaration, outputFile);
                    sb.append(String.format("\t%sACTUAL:   Success%s%n", ANSI.GREEN, ANSI.RESET));
                    result = 0;
                } catch (ParseException | AssertionError e) {
                    String error = String.format("\tACTUAL:   %s", "ParseException");
                    sb.append(String.format("%s%s%s%n", ANSI.RED, error, ANSI.RESET));
                    result = 1;
                }
                if (result != expectedResults[j]) {
                    fails++;
                }
            }
            if (fails == 0) {
                sb.append(String.format("%n____%s PASSED____", tests[i].getName()));
            } else {
                sb.append(String.format("%n____%s FAILED; ok: %d failed: %d____",
                        tests[i].getName(), inputs.length - fails, fails));
            }
            System.out.println(sb.append('\n'));
        }
    }
}
