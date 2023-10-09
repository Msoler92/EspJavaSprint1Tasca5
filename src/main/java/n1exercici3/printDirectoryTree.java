package n1exercici3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class printDirectoryTree {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: printDirectory path");
        }
        else {
            Path outputFile = Paths.get("n1exercici3/directoryTree.txt");
            if (Files.exists(outputFile)) {
                try {
                    Files.write(outputFile, List.of("CONTENTS OF " + args[0]));
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
            printSubdirectory(Paths.get(args[0]), outputFile,0);
        }
    }

    public static void printSubdirectory(Path directory, Path outputFile, int depth) {
        ArrayList<Path> dirPaths = new ArrayList<>();
        String line;
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file: stream) {
                dirPaths.add(file);
            }
        } catch (IOException e) {
            System.err.println("IOException");
        }
        Collections.sort(dirPaths);
        for (Path file: dirPaths) {
            if (Files.isRegularFile(file) || Files.isSymbolicLink(file)) {
                try {
                    line = "--".repeat(depth);
                    line += " (F) " + file.getFileName() +
                            " - Data de modificació: " + Files.getLastModifiedTime(file);
                    Files.write(outputFile, List.of(line), CREATE, APPEND);
                } catch (IOException e) {
                    System.err.println(e);
                }
            } else if (Files.isDirectory(file)) {
                try {
                    line = "--".repeat(depth);
                    line +=  " (D) " + file.getFileName() +
                            " - Data de modificació: " + Files.getLastModifiedTime(file);
                    Files.write(outputFile, List.of(line), CREATE, APPEND);
                    printSubdirectory(file, outputFile, depth + 1);
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
