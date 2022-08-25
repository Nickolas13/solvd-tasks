package com.solvd.animal.animalclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CowTest {
    Cow john = new Cow("John",100,500,6);

    @Test
    public void getWeight(){
        assertEquals(500,john.getWeight());
    }

    @Test
    public void getAge(){
        assertEquals(6,john.getAge());
    }

    @Test
    public void getAnimalName(){
        assertEquals("John",john.getAnimalName());
    }

    @Test
    public void getFoodCost(){
        assertEquals(150,john.getFoodCost());
    }
}