package com.solvd.animal.animalclasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Vivarium {
    private static final Logger logger = LogManager.getLogger(Main.class);
    final private int area;
    final private String animalType;
    private ArrayList<Animal> animals = new ArrayList<>();
    private int animalQuantity = 0;

    public Vivarium(int area, ArrayList<Animal> animals, String animalType){
        this.area = area;
        this.animals = animals;
        this.animalType = animalType;
        this.animalQuantity = animals.size();
    }

    //Constructor in case of having empty vivaria
    public Vivarium(int area, String animalType){
        this.area = area;
        this.animalType = animalType;
    }

    //Getters

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    //Set AnimalClasses.Animal
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public String getAnimalType() {
        return animalType;
    }

    public int getAnimalQuantity() {
        return animalQuantity;
    }

    public void setAnimalQuantity(int animalQuantity) {
        this.animalQuantity = animalQuantity;
    }

    public int getArea() {
        return area;
    }

    public int getFoodCosts(){
        int result = 0;
        for(Animal a : animals){
            result += a.getFoodCost();
        }
        return result;
    }

    //Remove animal from vivarium

    public boolean removeAnimal(Animal animal){
        if(animalQuantity == 0) {
            logger.error("Vivarium is Empty");
            return false;
        }
        if (animals.remove(animal)) {
            animalQuantity--;
            return true;
        }
        return false;
    }

    //Add animal to vivarium
    public void addAnimal(Animal animal){
        if(animal.getAnimalType() != animalType){
            logger.error("Can't Place Different Animals in Same Vivarium");
            return;
        }
        animals.add(animal);
        animalQuantity++;
    }

    @Override
    public String toString(){
        String result = "Vivarium Area: " + area + "\nList Of Animals: \n\n";
        for (Animal animal : animals) {
            result += "Animal Name: " + animal.getAnimalName()
                    + "\nAnimal Type: " + animal.getAnimalType()
                    + "\n ----------------\n";
        }
        return result;
    }


}
