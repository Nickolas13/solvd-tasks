package com.solvd.animal.animalclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZooTest {
    Zoo zoo = new Zoo(3000,"California");
    @Test
    void getArea() {
        assertEquals(3000,zoo.getArea());
    }

    @Test
    void getAddress() {
        assertEquals("California",zoo.getAddress());
    }


}