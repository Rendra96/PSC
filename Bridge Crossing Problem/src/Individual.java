
import java.util.Arrays;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 14 November 2017
 * 
 */
public class Individual {
    private int persons;
    private int[] kromosom;
    private int fitness;
    private int[] timePersons;
    
    public Individual(int persons, int[] timePersons) {
        this.persons = persons;
        this.kromosom = new int[persons];
        this.timePersons = timePersons;
        this.fitness = 0;
        generateKromosom();
    }
    
    public void generateKromosom() {
        Random r = new Random();
        for (int i = 0; i < getStep(); i++) {
            int gen = r.nextInt(this.persons);
            kromosom[i] = gen;
        }
    }
    
    public int getKromosom(int index) {
        return this.kromosom[index];
    }

    public void setGen(int index, int value) {
        this.kromosom[index] = value;
    }

    public int getFitness() {
        if (this.fitness == 0) {
            this.fitness = FitnessCalc.getFitness(this);
        }
        return this.fitness;
    }

    public int getStep() {
        return 2*(this.persons-1)-1;
    }
    
    public int size() {
        return this.kromosom.length;
    }
    
    //nanti lagi aja, pusing, ngantuk
    @Override
    public String toString() {
        Arrays.sort(this.kromosom);
        String genString = "";
        for (int i = 0; i < getStep(); i++) {
            genString += 0;
        }
        return genString;
    }
}