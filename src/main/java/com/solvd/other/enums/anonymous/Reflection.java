package com.solvd.other.enums.anonymous;

import com.solvd.animal.animalclasses.Vivarium;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Reflection {
    public static void main(String[] args) {
        //reflecting classes
        Class reflection = Human.class;
        Class vivariaReflection = Vivarium.class;

        //reflecting super class
        Class classSuper = reflection.getSuperclass();
        System.out.println(classSuper.getSimpleName());

        //reflecting interfaces and methods
        Class[] interfaces = reflection.getInterfaces();
        Method[] reflect = reflection.getDeclaredMethods();


        //get method names
        for (Method m : reflect) {
            System.out.println(m.getName());
        }


        //get interface simple names
        for (Class i : interfaces) {
            System.out.println(i.getSimpleName());
        }


        //getting constructors
        Constructor[] constructors = vivariaReflection.getConstructors();

        for (Constructor constructor : constructors) {
            System.out.println("Constructor name: " + constructor.getName());
            System.out.println("-----parameters------");
            if (constructor.getParameterCount() == 0) {
                System.out.println("without arguments");
            } else {
                Parameter[] parameters = constructor.getParameters();
                for (Parameter parameter : parameters) {
                    System.out.println(parameter.getName() + " : " + parameter.getType());
                }
            }
        }

        //getting methods
        Method[] methods = vivariaReflection.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Method N" + (i + 1) + " " + methods[i].getName());
        }

        //getting fields
        Field[] fields = vivariaReflection.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Field N" + (i + 1) + " " + fields[i].getName());
        }
    }
}
