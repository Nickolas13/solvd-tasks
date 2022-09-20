package com.solvd.parsing.xml.jaxb;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class UnMarshal {
    public static void main(String[] args) throws JAXBException {
        File file = new File("src/main/resources/xml/students.xml");
        JAXBContext context = JAXBContext.newInstance(Students.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Students student = (Students) unmarshaller.unmarshal(file);
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        System.out.println(student.getAge());
        System.out.println(student.getYear());
    }
}
