package me.josecoelho.adventofcode2022.utils;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class FileUtils {

    public static List<String> getFileAsStringList(String fileName)  {
        final ClassLoader classLoader = FileUtils.class.getClassLoader();
        final URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        }
        try {
            final File file = new File(resource.toURI());
            return Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("unexpected error: ", e);
        }
    }
}
