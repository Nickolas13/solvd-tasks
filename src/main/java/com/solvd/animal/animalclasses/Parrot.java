package com.solvd.animal.animalclasses;

import com.solvd.animal.interfaces.IFly;

public class Parrot extends Animal implements IFly {


    public Parrot(String animalName, String animalType, int foodCost, int weight, int age) {
        super(animalName, animalType, foodCost, weight, age);
    }

    public Parrot(String animalName, int foodCost, int weight, int age) {
        super(animalName, foodCost, weight, age);
    }

    public Parrot() {

    }


    public int getAge() {
        return super.getAge();
    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public int getWeight() {
        return super.getWeight();
    }

    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    public String getAnimalType() {
        return super.getAnimalType();
    }

    public void setAnimalType(String animalType) {
        super.setAnimalType(animalType);
    }

    public String getAnimalName() {
        return super.getAnimalName();
    }

    public int getFoodCost() {
        return super.getFoodCost();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void makeSound() {
        System.out.println("Hello World");
    }

    public boolean equals(Object o) {
        return super.equals(o);
    }

    public int hashCode() {
        return super.hashCode();
    }


    public String toString() {
        return super.toString();
    }

    @Override
    public void fly() {
        System.out.println("i Can Flyyyy!");
    }
}
