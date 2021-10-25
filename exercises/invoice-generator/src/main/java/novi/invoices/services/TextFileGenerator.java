package novi.invoices.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

public class TextFileGenerator {
    String rootPath;

    public TextFileGenerator() {
        rootPath = FileSystems.getDefault().getPath("").toAbsolutePath().toString();
    }

    public void generateFile(String basePath, String name, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(buildFilePath(name + ".txt")));
        writer.write(content);
        writer.close();
    }

    private String buildFilePath(String filename) {
        return Paths.get(rootPath.toString(), "src", "main", "resources", filename).toString();
    }
}
