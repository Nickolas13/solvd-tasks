package com.solvd.animal.animalclasses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VivariumTest {
    Vivarium penguinsVivarium = new Vivarium(300,"Penguin");

    @Test
    void getAnimalType() {
        assertEquals("Penguin",penguinsVivarium.getAnimalType());
    }

    @Test
    void getArea() {
        assertEquals(300,penguinsVivarium.getArea());
    }


}