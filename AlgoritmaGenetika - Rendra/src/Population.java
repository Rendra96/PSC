/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ASUS
 */
public class Population {

    Individual[] individuals;
    int[] arrays;
    int[] solusi;
    /*
     * Constructors
     */
    // Create a population
    public Population(int populationSize, boolean initialise,int geneLength,int[] arrayOfChromosome,int[] solusi) {
        individuals = new Individual[populationSize];
        this.arrays = arrayOfChromosome;
        this.solusi=solusi;
        // Initialise population
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual(geneLength,this.solusi);
                newIndividual.generateIndividual(arrayOfChromosome);
                saveIndividual(i, newIndividual);
            }
        }
    }

    /* Getters */
    public Individual getIndividual(int index) {
        return individuals[index];
    }
    
    public int[] getArrayIndividuals(){
        return this.arrays;
    }
    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
                //System.out.println("fittest " + fittest);
            }
        }
        return fittest;
    }

    /* Public methods */
    // Get population size
    public int size() {
        return individuals.length;
    }
     public int getIndividualSize() {
        return individuals[0].size();
    }
    // Save individual
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }
    
    public int[] getSolution(){
        return this.solusi;
    }
}