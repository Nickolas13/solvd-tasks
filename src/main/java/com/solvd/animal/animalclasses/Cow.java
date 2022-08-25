package com.solvd.animal.animalclasses;

public class Cow extends Animal{

    public Cow(String animalName, int foodCost, int weight, int age) {
        super(animalName, foodCost, weight, age);
    }


    public Cow(String animalName, String animalType, int foodCost, int weight, int age) {
        super(animalName, animalType, foodCost, weight, age);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public void makeSound(){
        System.out.println("Moo!!");
    }

    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    public int getFoodCost() {
        return super.getFoodCost();
    }

    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    public String getAnimalName() {
        return super.getAnimalName();
    }

    public String getAnimalType() {
        return super.getAnimalType();
    }

    @Override
    public void setAnimalType(String animalType) {
        super.setAnimalType(animalType);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
