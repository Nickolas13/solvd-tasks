package com.solvd.animal.animalclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParrotTest {
    Parrot bob = new Parrot("Bob",50,60,50);

    @Test
    public void getWeight(){
        assertEquals(60,bob.getWeight());
    }

    @Test
    public void getAge(){
        assertEquals(50,bob.getAge());
    }

    @Test
    public void getAnimalName(){
        assertEquals("Bob",bob.getAnimalName());
    }

    @Test
    public void getFoodCost(){
        assertEquals(50,bob.getFoodCost());
    }
}