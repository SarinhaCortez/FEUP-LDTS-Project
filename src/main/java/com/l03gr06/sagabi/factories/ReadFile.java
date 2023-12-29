package com.l03gr06.sagabi.factories;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"Immutable","JavaLangClash"})
public class ReadFile {
    private final File file;
    public File getFile() {
        return file;
    }

    // get file from classpath, resources folder
    public ReadFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);

        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            file = new File(resource.getFile());
        }
    }
    public ReadFile(File file) {
        this.file=file;
    }

    public List<String> splitInLines() {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
             BufferedReader br =  new BufferedReader(reader)) {
             String line;
             while (null != (line = br.readLine())) { lines.add(line);
             }
            br.close();
            reader.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
        return lines;
    }
    

}