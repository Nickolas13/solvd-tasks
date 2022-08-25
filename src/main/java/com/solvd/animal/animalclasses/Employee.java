package com.solvd.animal.animalclasses;

import com.solvd.animal.interfaces.Transferable;
import com.solvd.animal.interfaces.ISalary;

public class Employee implements Transferable<Vivarium,Animal>, ISalary {
    public String name;
    public Employee(String name){
        this.name = name;
    }
    public void feedAnimals(Animal animal){
        System.out.println("Animal " + animal.getAnimalName() + " Has Successfully been fed!");
    }

    public boolean transfer(Vivarium from, Vivarium to, Animal animal){
        if (from.removeAnimal(animal)){
            to.addAnimal(animal);
            return true;
        }
        return false;
    }
    public void cashOut(){
        System.out.println("Takes out money from ATM");
    }


    public void cashIn() {
        System.out.println("Puts cash in Bank account");
    }

    @Override
    public String toString() {
        return name;
    }
}
