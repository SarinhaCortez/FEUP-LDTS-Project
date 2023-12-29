package com.l03gr06.sagabi.factories

import com.l03gr06.sagabi.factories.ReadFile
import spock.lang.Specification
import spock.lang.TempDir

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class ReadFileTest extends Specification {

    @TempDir
    File tempDir

    def "test ReadFile with a file"() {
        given: "a file with some lines"
        Path filePath = Files.createFile(tempDir.toPath().resolve("test.txt"))
        Files.write(filePath, ["line1", "line2", "line3"])

        when: "ReadFile is created with the file and splitInLines is called"
        ReadFile readFile = new ReadFile(filePath.toFile())
        List<String> lines = readFile.splitInLines()

        then: "the lines are read correctly"
        lines == ["line1", "line2", "line3"]
    }

    def "test ReadFile with a file name"() {
        given: "a file in the classpath with some lines"
        String fileName = "test.txt"  // This file should exist in your project's resources directory

        when: "ReadFile is created with the file name and splitInLines is called"
        ReadFile readFile = new ReadFile(fileName)
        List<String> lines = readFile.splitInLines()

        then: "the lines are read correctly"
        lines == ["line1", "line2", "line3"]
    }
}