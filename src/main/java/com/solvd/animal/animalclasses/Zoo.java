package com.solvd.animal.animalclasses;

import com.solvd.animal.interfaces.IZoo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Zoo implements IZoo {
    private static final Logger logger = LogManager.getLogger(Main.class);
   private final int area;
   private final String address;
    private ArrayList<Vivarium> vivaria = new ArrayList<>();
   private int vivariaAmount = 0;

    public Zoo(int area, String address, ArrayList<Vivarium> vivaria){
        this.area = area;
        this.address = address;
        this.vivariaAmount = vivaria.size();
    }
    public Zoo(int area, String address){
        this.area = area;
        this.address = address;
    }

    //Getters
    public int getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    public int getVivariaAmount() {
        return vivariaAmount;
    }

    //Returns Sum of every AnimalClasses.Vivarium Food cost in AnimalClasses.Zoo
    public int getCosts(){
        int result = 0;
        for(Vivarium v : vivaria){
            result += v.getFoodCosts();
        }
        return result;
    }


    public void addVivarium(Vivarium vivaria){
        int sumArea = 0;
        for (Vivarium vivarium : this.vivaria) {
            sumArea += vivarium.getArea();
        }
        //Checks if There is enough Area to Add new Vivaria
        if(sumArea + vivaria.getArea() > this.area){
            logger.error("Not Enough Space To Add Vivaria");
        }else{
            this.vivaria.add(vivaria);
        }

        vivariaAmount++;
    }

    public void removeVivarium(Vivarium vivaria){
        this.vivaria.remove(vivaria);

    }


    @Override
    public String toString() {
        String result = "This Zoo Contains: \n";
        for(Vivarium v : vivaria){
            result += "Vivaria Of " + v.getAnimalType() +"'s"
                    + "\nVivaria Area: " + v.getArea()
                    +"\n---------\n";
        }
        return result;
    }
}
