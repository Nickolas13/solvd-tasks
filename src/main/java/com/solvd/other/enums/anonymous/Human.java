package com.solvd.other.enums.anonymous;

import com.solvd.other.enums.anonymous.interfaces.Eat;
import com.solvd.other.enums.anonymous.interfaces.Talk;

public class Human implements Talk, Eat {

    private int x;

    public void talk() {
        System.out.println("hello hello");
    }

    public void eat() {
        System.out.println("yummy");
    }
}
