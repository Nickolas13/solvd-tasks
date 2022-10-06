package com.solvd.animal.animalclasses;

public class AnimalFactory {
    public Animal getAnimal(String type){
        switch(type){
            case "cow":
                return new Cow();
            case "parrot":
                return new Parrot();
            case "penguin":
                return new Penguin();
        }
        return null;
    }
}
