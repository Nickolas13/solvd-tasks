package com.solvd.animal.interfaces;
import com.solvd.animal.animalclasses.Vivarium;
public interface IZoo {
    public int getCosts();
    public void addVivarium(Vivarium vivaria);
    public void removeVivarium(Vivarium vivaria);
}
