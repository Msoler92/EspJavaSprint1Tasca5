package n1exercici4.utils;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class T5Utilities {
    public static void printHelp() {
        System.out.println("Refer to the readme for a list of available commands");
    }

    public static void recursiveDirLog(Path directory, Path outputFile, int depth) {
        ArrayList<Path> dirPaths = new ArrayList<>();
        String line;
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
            for (Path file: stream) {
                dirPaths.add(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
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
                    e.printStackTrace();
                }
            } else if (Files.isDirectory(file)) {
                try {
                    line = "--".repeat(depth);
                    line +=  " (D) " + file.getFileName() +
                            " - Data de modificació: " + Files.getLastModifiedTime(file);
                    Files.write(outputFile, List.of(line), CREATE, APPEND);
                    recursiveDirLog(file, outputFile, depth + 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
