package nl.han.dea.http;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HtmlPageReader {

    public String readFile(String filename) throws IOException {
        var fileAsString = new String(Files.readAllBytes(getPath(filename)));
        return fileAsString;
    }

    public String calculateContentLength(String filename) {
        if (filename.isEmpty()) {
            return "0";
        }

        var path = getPath(filename);
        var length = path.toFile().length();

        return Long.toString(length);
    }

    public Path getPath(String filename) {
        var fullFileName = "pages/".concat(filename);
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fullFileName).getFile()).toPath();
    }
}
