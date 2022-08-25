package com.solvd.other.enums;

public enum DaysOfTheWeek {
    SUNDAY("meh"),
    MONDAY("terrible"),
    TUESDAY("lazy day"),
    WEDNESDAY("weird day"),
    THURSDAY("normal"),
    FRIDAY("such a lovely day"),
    SATURDAY("normal");
    private final String qualityOfDay;
    DaysOfTheWeek(String qualityOfDay){
        this.qualityOfDay = qualityOfDay;
    }

    public String getQualityOfDay() {
        return qualityOfDay;
    }
}

