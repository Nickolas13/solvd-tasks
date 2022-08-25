package com.solvd.other.fileutils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;

public class CreatingFile {
    public static void main(String[] args) {
        //create file
        File newFile = new File("filename.txt");
        try {
            FileUtils.touch(newFile);
            if(newFile.exists()) {
                System.out.println(newFile.getName() + " Exists");
            }else{
                System.out.println("File Doesnt Exist");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        //delete file
        FileUtils.deleteQuietly(newFile);
        if(newFile.exists()) {
            System.out.println(newFile.getName() + " Wasn't deleted");
        }else{
            System.out.println("File Successfully deleted");
        }



    }

}
