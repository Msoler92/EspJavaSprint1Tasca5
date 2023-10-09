package n1exercici2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;

import static java.nio.file.FileVisitResult.CONTINUE;

public class VisitFiles implements FileVisitor<Path> {
    ArrayList<Path> treeContents;
    public VisitFiles() {
        treeContents = new ArrayList<>();
    }
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {
                treeContents.add(file);
            }
        } catch (IOException e) {
            //TODO handle
        }
        Collections.sort(treeContents);
        return null;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {

        return null;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {

        return null;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {

        return null;
    }
}
