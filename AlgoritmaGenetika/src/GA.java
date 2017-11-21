/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class GA {

    public static void main(String[] args) {

        // Set a candidate solution
        //  FitnessCalc.setSolution("1111000000000000000000000000000000000000000000000000000000001111");
        Scanner sc = new Scanner(System.in);

        int banyakOrang = sc.nextInt();
        int[] orang = new int[banyakOrang];
        for (int i = 0; i < banyakOrang; i++) {
            orang[i] = sc.nextInt();
        }

        int geneLength = 2 * (banyakOrang - 1) - 1;

        int[] solusi = new int[geneLength];
        Program p = new Program();
        int totalTime = p.TotalTime(orang, banyakOrang);
        solusi = p.getArray();
        System.out.println("solusi terbaik ");
        for (int i = 0; i < geneLength; i++) {
            System.out.print(solusi[i]);
        }
        System.out.println("");
        System.out.println("total waktu yang dibutuhkan :" + totalTime);

//        for (int i = 0; i < geneLength; i++) {
//            solusi[i] = sc.nextInt();
//        }
        FitnessCalc f = new FitnessCalc(geneLength);

        // Create an initial population
        Population myPop = new Population(50, true, geneLength, orang, solusi);

        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        Algorithm a = new Algorithm();
        while (myPop.getFittest().getFitness() < f.getMaxFitness()) {
            // System.out.println(f.getMaxFitness());
            generationCount++;
            System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());

            myPop = a.evolvePopulation(myPop);
        }
        // System.out.print("getmax " +f.getMaxFitness());
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());
        // Individual a = myPop.getFittest();
        
        int[] bestSolutionGA = new int[geneLength];
        for (int i = 0; i < geneLength; i++) {
          bestSolutionGA[i] =  myPop.getFittest().getGene(i);
        }

       
        
        for(int i = 0;i<geneLength;i++){
            int b = bestSolutionGA[i];
            for(int j=0;j<banyakOrang;j++){
                if(orang[j]==b){
                   if(i%2==0){
                       System.out.println(orang[j] +" and "+orang[j-1]);
                   }
                   else{
                       System.out.println(orang[j]);
                   }
                }
            }
        }
        
    }
}
