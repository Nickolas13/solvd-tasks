package com.solvd.other.enums;

import com.solvd.animal.animalclasses.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EnumRunner {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("Entering application");
        //enums of days of the week
        DaysOfTheWeek day = DaysOfTheWeek.FRIDAY;
        for (DaysOfTheWeek myDay:DaysOfTheWeek.values()) {
//            System.out.println(myDay + " " +
//                    "mood of the day: "+ myDay.getQualityOfDay());
            logger.info(myDay + " " + myDay.getQualityOfDay());

        }



        //enums of Continents

        for (Continents continent: Continents.values()) {
            System.out.println(continent.name() + "\nArea: "
                    + continent.getArea() + "\nPopulation: "
                    + continent.getPopulation());
            System.out.println("----------------------------");
        }


        System.out.println("World Population: " + Continents.getWorldPopulation());

        //enums of Test automation engineers salary
        Salary salary = Salary.JUNIOR;
        switch (salary){
            case JUNIOR:
                System.out.println(salary.getLevel() + "s get payed: 80000$");
                break;
            case SENIOR:
                System.out.println(salary.getLevel() + "s get payed: 110000$");
                break;
            case EXPERT:
                System.out.println(salary.getLevel() + "s get payed: 150000+$");
                break;
        }

        Animals animals = Animals.ELEPHANT;
        System.out.println(animals.name() + " is " + animals.getAge() + " years old");
    }

}
