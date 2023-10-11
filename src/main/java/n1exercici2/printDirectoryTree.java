package n1exercici2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class printDirectoryTree {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: printDirectory path");
        }
        else {
           printSubdirectory(Paths.get(args[0]).toAbsolutePath(), 0);
        }
    }

    public static void printSubdirectory(Path directory, int depth) {
        ArrayList<Path> dirPaths = new ArrayList<>();
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
                    for (int i = 1; i <= depth; i++) {
                        System.out.print("--");
                    }
                    System.out.println("(F) " + file.getFileName() +
                            " - Data de modificació: " + Files.getLastModifiedTime(file));
                } catch (IOException e) {
                    System.err.println("IOException");
                }
            } else if (Files.isDirectory(file)) {
                try {
                    for (int i = 1; i <= depth; i++) {
                        System.out.print("--");
                    }
                    System.out.println("(D) " + file.getFileName() +
                            " - Data de modificació: " + Files.getLastModifiedTime(file));
                    printSubdirectory(file, depth + 1);
                } catch (IOException e) {
                    System.err.println("IOException");
                }
            }
        }
    }
}
