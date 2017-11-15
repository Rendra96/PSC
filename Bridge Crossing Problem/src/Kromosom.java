
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 15 November 2017
 * 
 */
public class Kromosom {
    private Gen[] gens;
    private int lengthKromosom;
    private int persons;
    private int[] personTimes;
    private int fitness;
    
    public Kromosom(int persons, int[] personTimes) {
        this.persons = persons;
        this.lengthKromosom = 2*(persons - 1) - 1;
        this.personTimes = personTimes;
        this.gens = new Gen[this.lengthKromosom];
        this.fitness = 0;
        generateKromosom();
    }
    
    private void generateKromosom() {
        Random r = new Random();
        for (int i = 0; i < this.lengthKromosom; i++) {
            int time = r.nextInt(this.persons);
            gens[i] = new Gen(this.personTimes[time]);
        }
    }
    
    public Gen[] getKromosom() {
        return this.gens;
    }
    
    public int getFitness() {
        if (this.fitness == 0) {
            //this.fitness = FitnessCalc.getFitness(this);
        }
        return this.fitness;
    }
    
    public String printKromosom() {
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<this.lengthKromosom-1;i++) {
            result.append(this.gens[i].getGen());
            result.append(" ");
        }
        result.append(this.gens[this.lengthKromosom-1].getGen());
        return result.toString();
    }
}