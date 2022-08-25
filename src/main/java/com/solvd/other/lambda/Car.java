package com.solvd.other.lambda;

import com.solvd.other.lambda.interfaces.ICheckPlate;
import com.solvd.other.lambda.interfaces.Startable;

public class Car implements Startable, ICheckPlate {
    public String model;
    public int plateNumber;

    public Car(String model, int plateNumber) {
        this.model = model;
        this.plateNumber = plateNumber;
    }

    @Override
    public void start(String s) {
        System.out.println("starting car");
    }

    @Override
    public void check(int plateNumber) {
        System.out.println(plateNumber);
    }
}
