package com.solvd.other.enums;

public enum Salary {
    JUNIOR("Junior"),
    SENIOR("Senior"),
    EXPERT("Expert");

    private final String level;
    Salary(String level){
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
