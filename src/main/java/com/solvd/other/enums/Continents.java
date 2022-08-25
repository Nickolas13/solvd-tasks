package com.solvd.other.enums;

public enum Continents {
    ASIA(44580000,4694576167L),
    AFRICA(30370000,1393676444),
    NORTH_AMERICA(24710000,376870696),
    SOUTH_AMERICA(17840000,438283108),
    ANTARCTICA(14200000,4490),
    EUROPE(10530000,446800000),
    AUSTRALIA(7688000,27100000);

    private final long area;
    private final long population;
    Continents(long area, long population){
        this.area = area;
        this.population = population;
    }

    public static long getWorldPopulation() {
        return ASIA.getPopulation()
                + AFRICA.getPopulation()
                + ANTARCTICA.getPopulation()
                + NORTH_AMERICA.getPopulation()
                + SOUTH_AMERICA.getPopulation()
                + AUSTRALIA.getPopulation()
                + EUROPE.getPopulation();
    }

    public long getArea() {
        return area;
    }

    public long getPopulation() {
        return population;
    }
}
