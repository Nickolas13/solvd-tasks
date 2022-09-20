package com.solvd.parsing.xml.jaxb.list;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class List {
    static Movies movies = new Movies();

    static {
        movies.setMovies(new ArrayList<Movie>());
        Movie ironman = new Movie();
        ironman.setName("iron man");
        ironman.setDirector("someone");
        ironman.setReleaseYear(2002);

        Movie godfather = new Movie();
        godfather.setName("godfather");
        godfather.setDirector("francis coppola");
        godfather.setReleaseYear(1972);
        movies.getMovies().add(ironman);
        movies.getMovies().add(godfather);
    }

    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Movies.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(movies, System.out);
        marshaller.marshal(movies, new File("src/main/resources/xml/listofmovies.xml"));
    }
}
