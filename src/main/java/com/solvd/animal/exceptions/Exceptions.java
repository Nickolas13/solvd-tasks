package com.solvd.animal.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {

        //Trying to Access non-existent part of array
        int[] arr = {1,3,6,7,5};
        try{
            System.out.println(arr[5]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception: " + e);
        }
        finally{
            System.out.println("The End");
        }


        //Parsing String to Integer
        try{
            int J = Integer.parseInt("Hello World");
        }catch(NumberFormatException e){
            System.out.println("Exception: " + e);
            System.out.println("Can't parse String not containing numbers to Int");
        }
        System.out.println();


        //Throwing exceptions
        try{
            exampleMethod();
        }catch(Exception e){
            System.out.println("Exception: " + e);
            e.printStackTrace();
        }

        //FileNotFound Exception
        try (Scanner scanner = new Scanner(new File("example.txt"))){
            while(scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        }catch(FileNotFoundException f){
            f.printStackTrace();
        }

    }


    public static void exampleMethod() throws Exception{
        String Name = null;
        int a = Integer.parseInt(Name);
    }


}


