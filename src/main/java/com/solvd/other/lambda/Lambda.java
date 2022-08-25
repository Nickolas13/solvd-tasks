package com.solvd.other.lambda;

import com.solvd.other.lambda.interfaces.ICheckPlate;
import com.solvd.other.lambda.interfaces.ICountry;
import com.solvd.other.lambda.interfaces.IWatchVideo;
import com.solvd.other.lambda.interfaces.Startable;

public class Lambda {

    public static void main(String[] args) {

        //start a car
        Startable car = x -> System.out.println("started car, moving " + x);
        startMoving(car);

        //check plate
        ICheckPlate plate = n -> System.out.println("car's plate number is: " + n);
        checkPlate(plate);

        //get video name
        IWatchVideo playing = (video) -> System.out.println("Playing: " + video);
        playing.run("National Geographic");

        ICountry country = ((name, area, population) -> System.out.println("country name: " + name + "\ncountry area: " + area + "\ncountry's population: " + population));
        getInfo(country);

        //passing lambda declaration as argument
        getInfo((name, area, population) -> System.out.println("country name: " + name.toUpperCase() + "\ncountry area: " + area + "\ncountry's population: " + population));
    }

    private static void getInfo(ICountry country) {
        System.out.println("----------------------------");
        country.run("italy", 54545, 3131556);
        System.out.println("----------------------------");
        country.run("iceland", 5454, 62646);
    }

    private static void startMoving(Startable car) {
        car.start("fast");
    }

    private static void checkPlate(ICheckPlate car) {
        car.check(451236);
    }
}
