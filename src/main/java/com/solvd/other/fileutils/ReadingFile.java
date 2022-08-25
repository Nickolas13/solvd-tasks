package com.solvd.other.fileutils;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadingFile {
    public static void main(String[] args) throws IOException {
        //write to file
        String string = "Bob Billy John Alex Bob Fred";
        File file = new File("src/main/resources/filename.txt");
        FileUtils.writeStringToFile(file,string,StandardCharsets.UTF_8.name());

        //read file
        File newFile = new File("src/main/resources/filename.txt");
        String fileContent = FileUtils.readFileToString(newFile, StandardCharsets.UTF_8.name());
        System.out.println(fileContent);

    }
}
