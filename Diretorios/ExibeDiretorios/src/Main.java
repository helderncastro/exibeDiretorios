import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> diretorios = new ArrayList<String>();

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
            diretorios.add(String.valueOf(path));
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) {
        Path source = Paths.get("/home/helder/Documentos");
        try {
            Files.walkFileTree(source, new MyFileVisitor());
        } catch ( IOException e) {
            e.printStackTrace();
        }

        if (!diretorios.isEmpty()) {
            for (String pasta : diretorios) {
                System.out.println(pasta);
            }
        }


    }
}