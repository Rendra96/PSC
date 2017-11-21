/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 *
 * @author ASUS
 */
public class Individual {

    private int defaultGeneLength;
    private int[] genes;
    private int[] solusi;
    // Cache
    private int fitness = 0;

    public Individual(int geneLength,int[] solusi) {
        this.defaultGeneLength = geneLength;
        genes = new int[defaultGeneLength];
        this.solusi=solusi;
    }

    // Create a random individual
    public void generateIndividual(int[] arrayOfChromosome) {
        for (int i = 0; i < size(); i++) {
            int gene = new Random().nextInt(arrayOfChromosome.length);

            genes[i] = arrayOfChromosome[gene];
            //System.out.println("generate " + genes[i]);
        }
    }

    /* Getters and setters */
    // Use this if you want to create individuals with different gene lengths
    public void setDefaultGeneLength(int length) {
        defaultGeneLength = length;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int value) {
        genes[index] = value;
        fitness = 0;
    }

    /* Public methods */
    public int size() {
        return genes.length;
    }

    public int getFitness() {
        if (fitness == 0) {
            FitnessCalc f = new FitnessCalc(defaultGeneLength);
            f.setSolution(this.solusi);
            fitness = f.getFitness(this);
        }
        return fitness;
    }

    @Override
    public String toString() {
        String geneString = "";
        for (int i = 0; i < size(); i++) {
            geneString += getGene(i);
        }
        return geneString;
    }
}
