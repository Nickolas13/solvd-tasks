package com.solvd.other.fileutils;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountUniqueWords {

    public static void main(String[] args){
        try {

            Map<String, Integer> wordMap = new HashMap<>();

            //reading file and storing each word separated by space in string array with split
            String[] words = FileUtils.readFileToString(
                    new File("src/main/resources/filename.txt"),
                    StandardCharsets.UTF_8.name()).split("[\\s,():]+");

            for (String w : words) {
                if (wordMap.containsKey(w)) {
                    wordMap.put(w, wordMap.get(w) + 1);
                } else {
                    wordMap.put(w, 1);
                }
            }


            //printing out key value pairs
            wordMap.forEach((key, value) -> System.out.println(key + " " + value));


            //storing result in separate text file
            File file = new File("src/main/resources/word-count.txt");
            String result = "";
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                result += key + " : " + value + "\n";
            }
            FileUtils.writeStringToFile(file, result, StandardCharsets.UTF_8.name());

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
