
import java.util.Scanner;

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
public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Banyaknya orang yang ingin menyeberang : ");
        int persons = sc.nextInt();
        int[] personTimes = new int[persons];
        System.out.println("Waktu setiap orang untuk menyeberang : ");
        for(int i = 0;i<persons;i++) {
            int time = sc.nextInt();
            personTimes[i] = time;
        }
        
        //Kromosom kromosom = new Kromosom(persons, personTimes);
        //System.out.println(kromosom.printKromosom());

        /*System.out.print("Banyaknya kromosom yang akan dibuat : ");
        int individu = sc.nextInt();
        
        Individual individual = new Individual(individu, persons, personTimes);
        System.out.println("Hasil print kromosom di dalam individu :");
        System.out.println(individual.printIndividu());*/

        /*System.out.print("Banyak individu yang akan dibuat : ");
        int populationSize = sc.nextInt();
        Population population = new Population(populationSize, individu, persons, personTimes);
        System.out.println("Hasil print population :");
        System.out.println(population.printPopulation());*/
        
        System.out.println();
        Solution solution = new Solution();
        System.out.println("Best solution : " + solution.totalTime(personTimes, persons));
        System.out.println();
        
        //System.out.println("Kromosom best solution :");
        //System.out.println(solution.printKromosom());
        
        /*int[] test = new int[10];
        for(int i = 0;i<test.length;i++) {
            System.out.println(test[i]);
        }*/
    }
}