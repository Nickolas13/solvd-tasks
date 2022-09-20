package com.solvd.parsing.xml.jaxb.list;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "movie")
public class Movie {

    private String name;
    private String director;
    private int releaseYear;


    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    @XmlElement
    public void setDirector(String director) {
        this.director = director;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    @XmlAttribute
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
