package com.solvd.other.enums;

public enum Animals {
    PARROT(45),
    PENGUIN(20),
    ELEPHANT(36),
    COW(3);
    private final int age;
    Animals(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
