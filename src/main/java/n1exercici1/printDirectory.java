package n1exercici1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.Arrays;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class printDirectory {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: printDirectory path");
        }
        else {
            Path directory = Paths.get(args[0]);
            ArrayList<Path> dirPaths = new ArrayList<>();
            try(DirectoryStream<Path> stream = Files.newDirectoryStream(directory)) {
                for (Path file: stream) {
                    dirPaths.add(file);
                }
            } catch (IOException e) {
                System.out.println("IOException");
            }
            Collections.sort(dirPaths);
            for (Path file: dirPaths) {
                System.out.println(file.getFileName());
            }
        }
    }
}
