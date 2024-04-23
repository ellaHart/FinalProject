package week15FinalProject;

import java.io.Serializable;
import java.util.*;

public class Tree implements Serializable {

    // make an enum that will hole the different TreeSpecies
    public enum TreeSpecies {
        BIRCH("BIRCH"),
        MAPLE("MAPLE"),
        FIR("FIR");

        private final String name;
        TreeSpecies(String name) {
            this.name = name;
        }

    }// end of TreeSpecies

    // instance variables
    private TreeSpecies species;
    private int yearPlanted;
    private double height;
    private double growthRate;

    // constant variables
    final static double GROWTH_MIN = 10.0;
    final static double GROWTH_MAX = 20.0;
    final static double START_HEIGHT = 10;
    final static int RANDOM_HEIGHT = 11;
    final static int BASE_YEAR = 2000;
    final static int MAX_YEAR_PLANTED = 25;

    public Tree(TreeSpecies species, int yearPlanted, double height, double growthRate) {
        this.species = species;
        this.yearPlanted = yearPlanted;
        this.height = height;
        this.growthRate = growthRate;
    } //constructor

    public static Tree makeRandomTree() {
        Random random = new Random();
        TreeSpecies species = TreeSpecies.values()[random.nextInt(TreeSpecies.values().length)];
        int yearPlanted = random.nextInt(MAX_YEAR_PLANTED) + BASE_YEAR; // Years from 2000 to 2024
        double height = random.nextInt(RANDOM_HEIGHT) + START_HEIGHT; // Heights from 10' to 20'
        double growthRate = GROWTH_MIN + random.nextDouble() * (GROWTH_MAX - GROWTH_MIN); // Growth rates from 10% to 20%
        return new Tree(species, yearPlanted, height, growthRate);
    }//random tree "constructor"

    //getter methods
    public TreeSpecies getSpecies() {
        return species;
    }// end of getSpecies method

    public int getYearPlanted() {
        return yearPlanted;
    }// end of getYearPlanted method

    public double getHeight() {
        return height;
    }// end of getHeight method

    public double getGrowthRate() {
        return growthRate;
    }// end of getGrowthRate method

    //setter methods
    public void setHeight(double height) {
        this.height = height;
    }// end of setHeight method

    //override the toString method, so it can then be used in the print method of Forest
    @Override
    public String toString() {
        return String.format("%-7s %6d %7.2f' %6.1f%%",
                species.toString(), yearPlanted, height, growthRate);
    }
}