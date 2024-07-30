package org.example.generator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class SupportClassesGenerator {
    private final ArrayList<String> classes;
    private final String packageName;
    private final String pathToGen;
    public SupportClassesGenerator(ArrayList<String> supportClasses, String pathToGen, String packageToGen) {
        this.classes = supportClasses;
        this.packageName = packageToGen;
        this.pathToGen = pathToGen;
    }

    public void generate() throws IOException {
        for (String supportClass: classes) {
            String supportClassName = Arrays.stream(supportClass.split("\n+"))
                    .filter(x -> !x.startsWith("import")).findFirst().orElse("").split("\\s+")[2];
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(pathToGen, "/", supportClassName + ".java"))) {
                if (!packageName.isEmpty()) {
                    writer.write(C.PACKAGE + C.SPACE + this.packageName +
                            C.SEMICOLON + C.NEWLINE + C.NEWLINE);
                }
                writer.write(supportClass);
                writer.flush();
            }
        }
    }
}
