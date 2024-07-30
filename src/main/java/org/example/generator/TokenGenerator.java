package org.example.generator;

import myparserrulesinformation.Term;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class TokenGenerator {
    private static final String fileBegin = "public enum ";
    private final String packageName;
    private final Set<Term> termSet;
    private final String enumName;
    private final Path saveTo;

    public TokenGenerator(Set<Term> termSet, String pathToGen, String packageName, String taskName) {
        this.termSet = termSet;
        this.enumName = Character.toUpperCase(taskName.charAt(0)) + taskName.substring(1) + "Token";
        this.packageName = packageName;
        this.saveTo = Paths.get(pathToGen, enumName + ".java");
    }

    public void generate() throws IOException {
        StringBuilder sb = new StringBuilder();
        if (!packageName.isEmpty()) {
            sb.append(C.PACKAGE).append(C.SPACE).append(this.packageName)
                    .append(C.SEMICOLON).append(C.NEWLINE).append(C.NEWLINE);
        }
        sb.append(fileBegin).append(enumName).append(C.SPACE).append(C.OPEN_BRACE).append(C.NEWLINE).append(C.TAB);
        for (Term term: termSet) {
            sb.append(term.getName()).append(C.COMMA).append(C.SPACE);
        }
        sb.append("END").append(C.COMMA).append(C.NEWLINE).append(C.CLOSE_BRACE);
        try (BufferedWriter writer = Files.newBufferedWriter(saveTo)) {
            writer.write(sb.toString());
            writer.flush();
        }
    }
}
