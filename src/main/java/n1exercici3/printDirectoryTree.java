package n1exercici3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeSet;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class printDirectoryTree {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: printDirectory path");
        }
        else {
            Path outputFile = Paths.get("directoryTree.txt");
            try {
                //Create or overwrite the file and write the header
                Files.write(outputFile, List.of("CONTENTS OF " + args[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            printSubdirectory(Paths.get(args[0]), outputFile,0);
        }
    }
    //Recursively visit directory tree, in alphabetical order and depth-first, and write the name, type and last
    //modified date to the outputFile.
    public static void printSubdirectory(Path directory, Path outputFile, int depth) {
        TreeSet<Path> dirPaths = new TreeSet<>();
        String line;
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file: stream) {
                dirPaths.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Path file: dirPaths) {
            if (Files.isRegularFile(file) || Files.isSymbolicLink(file)) {
                try {
                    line = "--".repeat(depth);
                    line += " (F) " + file.getFileName() +
                            " - Data de modificació: " + Files.getLastModifiedTime(file);
                    Files.write(outputFile, List.of(line), CREATE, APPEND);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (Files.isDirectory(file)) {
                try {
                    line = "--".repeat(depth);
                    line +=  " (D) " + file.getFileName() +
                            " - Data de modificació: " + Files.getLastModifiedTime(file);
                    Files.write(outputFile, List.of(line), CREATE, APPEND);
                    printSubdirectory(file, outputFile, depth + 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
