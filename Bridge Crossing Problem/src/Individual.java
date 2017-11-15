
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
    
    private Kromosom[] kromosom;
    private int individuals;
    
    public Individual(int individuals, int persons, int[] personTimes) {
        this.individuals = individuals;
        this.kromosom = new Kromosom[individuals];
        generateKromosom(persons, personTimes);
    }
    
    private void generateKromosom(int persons, int[] personTimes) {
        for(int i = 0;i<this.individuals;i++) {
            this.kromosom[i] = new Kromosom(persons, personTimes);
        }
    }
    
    public Kromosom[] getIndividuals() {
        return this.kromosom;
    }
    
    public int size() {
        return this.kromosom.length;
    }
    
    public String printIndividu() {
        StringBuilder result = new StringBuilder();
        String print = "";
        for(int i = 0;i<this.individuals-1;i++) {
            print = this.kromosom[i].printKromosom();
            result.append("Kromosom ").append(i+1).append(" : ").append(print).append("\n");
        }
        print = this.kromosom[this.individuals-1].printKromosom();
        result.append("Kromosom ").append(this.individuals).append(" : ").append(print);
        return result.toString();
    }
}