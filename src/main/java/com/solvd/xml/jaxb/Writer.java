package com.solvd.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Writer {
    public static void main(String[] args) throws JAXBException {
        Students student = new Students();
        student.setId(1);
        student.setFirstname("bob");
        student.setLastname("smith");
        student.setAge(15);
        student.setAge(1);

        File file = new File("src/main/resources/xml/students.xml");
        JAXBContext context = JAXBContext.newInstance(Students.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(student, file);
        marshaller.marshal(student, System.out);

    }
}
