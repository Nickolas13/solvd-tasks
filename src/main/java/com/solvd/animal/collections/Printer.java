package com.solvd.animal.collections;

import com.solvd.animal.animalclasses.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Printer<T> {
    private static final Logger logger = LogManager.getLogger(Main.class);
    T input;
    public Printer(T input){
        this.input = input;
    }

    public void print(){
        logger.trace(input);
        System.out.println();;
    }
}
