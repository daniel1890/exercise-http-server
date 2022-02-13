package nl.han.dea.http;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HtmlPageReader {

    public FileInfo readFile(String filename) throws IOException {
        var fullFileName = "pages/".concat(filename);
        var classLoader = getClass().getClassLoader();
        try {
            var file = new File(classLoader.getResource(fullFileName).getFile()).toPath();
            var fileAsString = new String(Files.readAllBytes(file));
            var fileInfo = new FileInfo(fileAsString);
            return fileInfo;
        } catch (NullPointerException n){
            System.out.println();
            throw new A404Exception("Bestand niet gevonden: " + fullFileName, n);
        }
    }
}
