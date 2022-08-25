package com.solvd.animal.animalclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PenguinTest {

    Penguin lucy = new Penguin("Lucy",700,80,12);

    @Test
    public void getWeight(){
        assertEquals(80,lucy.getWeight());
    }

    @Test
    public void getAge(){
        assertEquals(12,lucy.getAge());
    }

    @Test
    public void getAnimalName(){
        assertEquals("Lucy",lucy.getAnimalName());
    }

    @Test
    public void getFoodCost(){
        assertEquals(700,lucy.getFoodCost());
    }
}