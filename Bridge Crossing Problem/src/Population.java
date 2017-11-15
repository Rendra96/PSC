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
    private int populationSize;
    private Individual[] population;

    public Population(int populationSize, int individualSize, int persons, int[] timePersons) {
        this.populationSize = populationSize;
        this.population = new Individual[populationSize];
        generatePopulation(individualSize, persons, timePersons);
    }
    
    private void generatePopulation(int individualSize, int persons, int[] timePersons) {
        for(int i = 0;i<this.populationSize;i++) {
            this.population[i] = new Individual(individualSize, persons, timePersons);
        }
    }
    
    public Individual getIndividual(int index) {
        return population[index];
    }

    public String printPopulation() {
        StringBuilder result = new StringBuilder();
        String print = "";
        for(int i = 0;i<this.populationSize-1;i++) {
            print = this.population[i].printIndividu();
            result.append("Individu ").append(i+1).append(" :\n").append(print).append("\n");
            result.append("\n");
        }
        print = this.population[this.populationSize-1].printIndividu();
        result.append("Individu ").append(this.populationSize).append(" :\n").append(print);
        return result.toString();
    }
    
    /*public Individual getFittest() {
        Individual fittest = population[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < this.population.length; i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }*/
}