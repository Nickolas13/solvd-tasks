package com.solvd.animal.collections;

import com.solvd.animal.animalclasses.Employee;
import com.solvd.animal.animalclasses.Parrot;
import com.solvd.animal.animalclasses.Vivarium;


import java.util.*;

public class Lists {


    public static void main(String[] args) {
        Set<Integer> set = new TreeSet();
        set.add(50);
        set.add(70);
        set.add(20);
        set.add(60);

        Set<Parrot> parrots = new HashSet<>();
        parrots.add(new Parrot("john",45,45,60));
        parrots.add(new Parrot("wick",45,78,80));

        List<Employee> employees = new LinkedList();
        employees.add(new Employee("bratt"));
        employees.add(new Employee("Edward"));

        Queue<Double> doubles = new PriorityQueue<>();
        doubles.add(2.0);
        doubles.add(5.7);

        List<Printer> printers = new ArrayList();
        printers.add(new Printer(45));
        printers.add(new Printer("ABCD"));
        printers.add(new Printer(new Vivarium(500,"Eagle")));


        Printer printer = new Printer(employees);
        printer.print();

    }

}
