package com.solvd.other.anonymous;

import com.solvd.other.anonymous.interfaces.Eat;
import com.solvd.other.anonymous.interfaces.Talk;

public class Human implements Talk, Eat {

    private int x;

    public void talk() {
        System.out.println("hello hello");
    }

    public void eat() {
        System.out.println("yummy");
    }
}
