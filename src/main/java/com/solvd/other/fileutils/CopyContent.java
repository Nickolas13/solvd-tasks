package com.solvd.other.fileutils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CopyContent {
    public static void main(String[] args) throws IOException {
        File copyFrom = new File("src/main/resources/copyFrom.txt");
        File copyTo = new File("src/main/resources/copyTo.txt");
        FileUtils.copyFile(copyFrom,copyTo);
        if(FileUtils.contentEquals(copyFrom,copyTo)){
            System.out.println("Files are equal");
        }else{
            System.out.println("Contents Don't Match");
        }
        File result = new File("src/main/resources/result");
        FileUtils.forceMkdir(result);
        FileUtils.moveFileToDirectory(copyTo,result, false);
    }
}
