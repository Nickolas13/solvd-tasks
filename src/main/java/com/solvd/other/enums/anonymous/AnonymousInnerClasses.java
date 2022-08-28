package com.solvd.other.enums.anonymous;

import com.solvd.other.enums.anonymous.interfaces.Eat;

public class AnonymousInnerClasses {
    public static void main(String[] args) {

        Eat josh = new Human() {
            @Override
            public void talk() {
                System.out.println("Ooooooooo");
            }
        };

        Eat bob = new Human() {
            @Override
            public void eat() {
                System.out.println("tasty");
            }
        };


    }
}
