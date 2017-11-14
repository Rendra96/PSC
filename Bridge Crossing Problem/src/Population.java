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
public class Population {
    private Individual[] population;

    public Population(int populationSize, int persons, int[] timePersons) {
        this.population = new Individual[populationSize];
        for (int i = 0; i < populationSize; i++) {
            this.population[i] = new Individual(persons, timePersons);
        }
    }
    
    public Individual getIndividual(int index) {
        return population[index];
    }

    //belum ngerti ini buat apa!?
    public Individual getFittest() {
        Individual fittest = population[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < this.population.length; i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }
}