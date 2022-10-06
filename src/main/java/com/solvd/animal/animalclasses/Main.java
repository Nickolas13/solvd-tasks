package com.solvd.animal.animalclasses;
//animals theme: animal class, zoo, zoo employee,
// the zoo consists of aviaries,
// the employee feeds the animals and
// can transfer animals from vaivary to vaivary

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        AnimalFactory factory = new AnimalFactory();
        Animal parrot = factory.getAnimal("parrot");
        parrot.setName("billy");
        parrot.setAge(45);
        parrot.setWeight(410);
        parrot.setAnimalType("parrot");
        System.out.println(parrot);
    }
}

//        logger.error("Entering Application: ");
//        logger.trace(Main.class);
//        logger.trace(Animal.class);

//        //creating animal objects from classes which extend Animal
//        Cow alfons = new Cow("Alfons",100,500,6);
//        Parrot john = new Parrot("john",400,20,40);
//        Penguin bob = new Penguin("bob",250,40,60);
//        //Vivaria
//        Vivarium parrotsVivarium = new Vivarium(300,"Parrot");
//        Vivarium cowsVivarium = new Vivarium(2700,"Cow");
//        Vivarium penguinsVivarium = new Vivarium(400,"Penguin");
//
//        //Adding animals to vivaria
//        parrotsVivarium.addAnimal(john);
//        cowsVivarium.addAnimal(alfons);
//        penguinsVivarium.addAnimal(bob);
//
//        //Creating AnimalClasses.Zoo
//        Zoo zoo = new Zoo(3000,"California");
//        zoo.addVivarium(parrotsVivarium);
//        zoo.addVivarium(penguinsVivarium);
//        zoo.addVivarium(cowsVivarium);
//
//
//
//        Printer<Parrot> printer = new Printer<>(new Parrot("nick","airplane",500,45,45));
//        printer.print();
