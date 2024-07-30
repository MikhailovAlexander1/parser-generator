package org.example;

import grammarrulesgen.*;
import myvisitors.GrammarMyVisitor;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.checkers.FirstFollowChecker;
import org.example.generator.Generator;
import org.example.tests.CalculatorTests;
import org.example.tests.KotlinTests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public class App {
    private static void runTest(String testName) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException, ParseException, IOException {
        if (testName.equals("calculator")) {
            CalculatorTests.run(calculator.CalculatorParser.class);
        } else {
            KotlinTests.run();
        }
    }

    private static GrammarMyVisitor getParsedGrammar(String grammarFile) throws IOException {
        Lexer lexer = new GrammarRulesLexer(CharStreams.fromFileName(grammarFile));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        GrammarRulesParser parser = new GrammarRulesParser(tokenStream);
        ParseTree tree = parser.rules();
        GrammarMyVisitor myVisitor = new GrammarMyVisitor();
        myVisitor.visit(tree);
        return myVisitor;
    }

    public static void main(String[] args) throws IOException, NoSuchMethodException, InstantiationException, InvocationTargetException, IllegalAccessException, ParseException {
//        GrammarMyVisitor myVisitor = getParsedGrammar("calculatorGrammar.txt");
        GrammarMyVisitor myVisitor = getParsedGrammar("kotlinGrammar.txt");

        FirstFollowChecker checker = new FirstFollowChecker(myVisitor.getParserRules());
        checker.constructFIRST();
        checker.constructFOLLOW();

        checker.printSet("FIRST");
        System.out.println("___________________________________");
        checker.printSet("FOLLOW");

        boolean isLL1 = checker.isLL1();
        System.out.println("___________________________________");
        System.out.println("Is the grammar LL1? - " + isLL1 + "\n");
        if (isLL1) {
//            Generator generator = new Generator("myGens/calculator", "calculator", myVisitor, checker);
            Generator generator = new Generator("myGens/kotlin", "kotlin", myVisitor, checker);
            generator.gen();
//                    runTest("calculator");
            runTest("kotlin");
        }
    }
}
