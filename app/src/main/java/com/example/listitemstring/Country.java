package com.example.listitemstring;

public class Country {
    private String countryName;
    private String flagName;
    private int population;

    public Country(String countryName, String flagName, int population) {
        this.countryName = countryName;
        this.flagName = flagName;
        this.population = population;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString()  {
        return this.countryName+" (Population: "+ this.population+")";
    }
}
