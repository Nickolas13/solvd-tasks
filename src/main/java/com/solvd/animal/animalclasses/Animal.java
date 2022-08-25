package com.solvd.animal.animalclasses;

import com.solvd.animal.interfaces.IAnimal;

import java.util.Objects;

abstract class Animal implements IAnimal {
    private String animalName;
    private String animalType;
    private int age = 0;
    private int weight = 0;
    private int foodCost = 0;

    public Animal(String animalName, String animalType, int foodCost,int weight, int age){
        this.animalType = animalType;
        this.animalName = animalName;
        this.weight = weight;
        this.age = age;
        this.foodCost = foodCost;
    }
    public Animal(String animalName, int foodCost, int weight, int age){
        this.animalName = animalName;
        this.foodCost = foodCost;
        this.weight = weight;
        this.age = age;
    }

    //Getters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAnimalType() {
        return animalType;
    }

    //Setters

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public int getFoodCost() {
        return foodCost;
    }

    public void setName(String name) {
        this.animalName = name;
    }

    //animal say
    public void makeSound(){
        System.out.println("Make sound!!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age
                && weight == animal.weight
                && foodCost == animal.foodCost
                && Objects.equals(animalName, animal.animalName)
                && Objects.equals(animalType, animal.animalType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, animalType, age, weight, foodCost);
    }

    @Override
    public String toString() {
        return "Animal Name: " + animalName
                + "\nAnimal Type: " + animalType
                + "\nAnimal Weight: " + weight
                + "\nAnimal Age: " + age;
    }
}
