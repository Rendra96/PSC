/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class GA {

    public static void main(String[] args) throws IOException {
        //lokasi folder yang berisi file-file testcase
        File folder = new File("D:\\Data\\Rendra\\Kuliah\\Rendra\\Pengantar Sistem Cerdas\\Tugas\\Program\\Program\\Data Testcase");
        
        //mengambil semua file dan dimasukkan ke dalam array
        File[] listOfFiles = folder.listFiles();
        InputOutput inputOutput = new InputOutput();

        for (int i = 0; i < listOfFiles.length; i++) {
            //membaca file
            inputOutput.read(listOfFiles[i]);
            
            //banyaknya orang yang akan menyeberang
            int persons = inputOutput.getPersons();
            System.out.println("Banyak Orang : " + persons);
            //waktu yang dibutuhkan oleh setiap orang untuk menyeberang
            int[] timePersons = inputOutput.getTimePersons();
            System.out.println("Waktu setiap orang untuk menyeberang");
            for (int j = 0; j < timePersons.length-1; j++) {
                int angka = timePersons[j];
                System.out.print(angka + ", ");
            }
            System.out.println(timePersons[persons - 1]);
            System.out.println();

            //jumlah langkah agar semua orang dapat menyeberang
            int geneLength = 2 * (persons - 1) - 1;
            int[] solusi = new int[geneLength];
            
            //proses mencari solusi
            Program p = new Program();
            int totalTime = p.TotalTime(timePersons, persons);
            solusi = p.getArray();
            System.out.println("solusi terbaik ");
            for (int j = 0; j < geneLength - 1; j++) {
                System.out.print(solusi[j] + ", ");
            }
            System.out.println(solusi[geneLength - 1]);
            System.out.println();
            System.out.println("total waktu yang dibutuhkan :" + totalTime);
            System.out.println();

            FitnessCalc f = new FitnessCalc(geneLength);

            // Create an initial population
            Population myPop = new Population(50, true, geneLength, timePersons, solusi);

            // Evolve our population until we reach an optimum solution
            int generationCount = 0;
            Algorithm a = new Algorithm();
            while (myPop.getFittest().getFitness() < f.getMaxFitness()) {
                generationCount++;
                System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());

                myPop = a.evolvePopulation(myPop);
                System.out.println();
            }
            System.out.println("Solution found!");
            System.out.println("Generation: " + generationCount);
            System.out.println("Genes:");
            System.out.println(myPop.getFittest());

            int[] bestSolutionGA = new int[geneLength];
            for (int j = 0; j < geneLength; j++) {
                bestSolutionGA[j] = myPop.getFittest().getGene(j);
            }
            
            StringBuilder result = new StringBuilder();
            for (int j = 0; j < geneLength; j++) {
                int b = bestSolutionGA[j];
                for (int k = 0; k< persons; k++) {
                    if (timePersons[k] == b) {
                        if (j % 2 == 0) {
                            result.append(timePersons[k]).append(" and ").append(timePersons[k-1]).append("\n");
                            System.out.println(timePersons[k] + " and " + timePersons[k - 1]);
                        } else {
                            result.append(timePersons[k]).append("\n");
                            System.out.println(timePersons[k]);
                        }
                    }
                }
            }
            inputOutput.writer(result.toString(), listOfFiles[i]);
        }
    }
}
