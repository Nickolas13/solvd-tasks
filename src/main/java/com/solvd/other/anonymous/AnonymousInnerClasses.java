package com.solvd.other.anonymous;

public class AnonymousInnerClasses {
    public static void main(String[] args) {

        Human josh = new Human() {
            @Override
            public void talk() {
                System.out.println("Ooooooooo");
            }
        };

        Human bob = new Human() {
            @Override
            public void eat() {
                System.out.println("tasty");
            }
        };


    }
}
