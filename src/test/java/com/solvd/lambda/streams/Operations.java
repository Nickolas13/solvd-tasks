package com.solvd.lambda.streams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Operations {
    private static final Logger logger = LogManager.getLogger(Operations.class);

    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(7, 5, 6, 7, 8, 2, 1, 6);
        List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
        square.forEach(x -> logger.info(x));

        List<String> countries = new ArrayList();
        countries.add("Madagascar");
        countries.add("Germany");
        countries.add("Italy");
        countries.add("France");

        List<String> sorted = countries.stream().sorted().collect(Collectors.toList());
        sorted.forEach(c -> logger.info(c));


        List<Student> students = getStudents();

        //filter by status
        List<Student> inactiveStudents = students.stream()
                .filter(student -> student.getStatus().equals(Status.INACTIVE))
                .collect(Collectors.toList());

        inactiveStudents.forEach(student -> logger.info(student.getName() + ", " + student.getAge() + ", " + student.getStatus()));

        //Sort by age
        List<Student> result = students.stream()
                .sorted(Comparator.comparing(Student::getAge))
                .collect(Collectors.toList());

        result.forEach(student -> logger.info(student.getName() + ", " + student.getAge() + ", " + student.getStatus()));

        List<Integer> ages = new ArrayList();
        for (Student student : students) {
            ages.add(student.getAge());
        }

        //sum of ages
        Integer reduced = ages.stream().reduce(0, (a, b) -> a + b);
        logger.trace(reduced);

    }

    public static List<Student> getStudents() {
        return List.of(
                new Student("Nick", 19, Status.ACTIVE),
                new Student("Bob", 22, Status.ACTIVE),
                new Student("John", 15, Status.INACTIVE),
                new Student("Eliana", 13, Status.ACTIVE),
                new Student("Alex", 19, Status.ACTIVE),
                new Student("Bob", 35, Status.INACTIVE),
                new Student("Arinna", 15, Status.ACTIVE)
        );
    }
}
