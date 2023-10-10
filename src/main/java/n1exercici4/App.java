package n1exercici4;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;

public class App {
    public static void main(String[] args) {
        int ccount = args.length;
        if (ccount == 0) {
            T5Utilities.printHelp();
        } else {
            switch(args[0].toLowerCase()) {
                case "log":
                    if (ccount > 2) {
                        try {
                            executeLogCommand(Paths.get(args[1]), Paths.get(args[2]));
                        } catch (InvalidPathException e) {
                            e.printStackTrace();
                            System.err.println("Invalid Path Exception: provided argument cannot be recognized as a path.");
                        }
                    }
                    break;
                case "read":
                    if (ccount > 1) {
                        try {
                            executeReadCommand(Paths.get(args[1]));
                        } catch (InvalidPathException e) {
                            e.printStackTrace();
                            System.err.println("Invalid Path Exception: provided argument cannot be recognized as a path.");
                        }
                    }
                    break;
                default:
                    System.out.println("Unrecognized command.");
                    T5Utilities.printHelp();
            }
        }
    }

    static void executeLogCommand(Path dir, Path outputFile) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        if (matcher.matches(outputFile.getFileName())) {
            try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
                writer.write("CONTENTS OF " + dir);
                T5Utilities.recursiveDirLog(dir, outputFile, 0);
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
        }
    }

    static void executeReadCommand(Path file) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");
        if (Files.isRegularFile(file) && matcher.matches(file.getFileName())) {
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
        } else {
            System.err.println("The output path provided is not a readable .txt file");
        }
    }

}
