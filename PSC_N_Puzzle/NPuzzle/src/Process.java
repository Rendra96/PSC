
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ihsan Fajari	2014730018 Nadhila Larasati	2014730035 Ellena Angelica
 * 2015730029 Evelyn Wijaya	2015730030 Tegar Muhammad	2015730046
 */
public class Process {

    public static void main(String[] args) throws IOException {
        for (int idx = 1; idx <  26; idx++) {
            int N;
            String[] init, goal;
            File file = new File("TestCase/TestCase" + idx + ".txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader readFile = new BufferedReader(fileReader);
            String line = readFile.readLine();
            N = Integer.parseInt(line);
            line = readFile.readLine();
            init = line.split(" ", N+1);
            line = readFile.readLine();
            goal = line.split(" ", N+1);

            int[] initialState = new int[init.length];
            for (int i = 0; i < init.length; i++) {
                initialState[i] = Integer.parseInt(init[i]);
            }
            int[] goalState = new int[goal.length];
            for (int i = 0; i < goal.length; i++) {
                goalState[i] = Integer.parseInt(goal[i]);
            }
            // batas pencarian solusi
            // bkin populasi baru, cek masing2 fitness populasi awal
            // diganti
            int counter = 0;
            int jumlahAnak = 0;

            Population populasi = new Population();
            populasi.generatePopulasiAwal();

            while (counter < 500) {
                Population newPopulasi = new Population();
                GeneticAlgorithm2 ga = new GeneticAlgorithm2(populasi, initialState, goalState);

                for (int i = 0; i < populasi.getPopulationLength(); i++) {
                    ga.fitness(populasi.getPopulation()[i]);
                }
                ga.sortFitness();

                // kalo hasilnya sudsh maksimal
                if (populasi.getPopulation()[0].getScore() == 9) {
                    break;
                }

                for (int i = 0; i < populasi.getPopulationLength(); i++) {
                    Chromosome parent1 = ga.selection();
                    Chromosome parent2 = ga.selection();
                    Chromosome[] anak = ga.crossOver(parent1, parent2);

                    ga.mutate(anak[0]);
                    ga.mutate(anak[1]);

                    ga.fitness(anak[0]);
                    ga.fitness(anak[1]);

                    if (jumlahAnak >= newPopulasi.getPopulationLength()) {
                        ga.sortFitness();
                        
                        if (anak[0].getScore() > newPopulasi.getPopulation()[199].getScore()) {
                            newPopulasi.getPopulation()[199] = anak[0];
                        }
                        if (anak[1].getScore() > newPopulasi.getPopulation()[198].getScore()) {
                            newPopulasi.getPopulation()[198] = anak[1];
                        }
                           
                    } 
                    else {
                        newPopulasi.getPopulation()[jumlahAnak] = anak[0];
                        jumlahAnak++;
                        newPopulasi.getPopulation()[jumlahAnak] = anak[1];
                        jumlahAnak++;
                    }

                }
                populasi = newPopulasi;
                counter++;
            }

//        Mengeluarkan output
            String output = "";
            FileWriter fileWriter = new FileWriter("HasilTestCase/HasilTestCase" + idx + ".txt");
            BufferedWriter writeFile = new BufferedWriter(fileWriter);

            // prunning gen-gen solusi yang tidak valid
            // gen yg tidak valid dibuang/dihapus
            if (populasi.getPopulation()[0].getScore() == 9) {
                System.out.println("Solusinya adalah  : ");

                int space = 0;
                Chromosome kromosom = populasi.getPopulation()[0];

                for (int i = 0; i < kromosom.getLength(); i++) {

                    for (int j = 0; j < initialState.length; j++) {
                        if (initialState[j] == 0) {
                            space = j;
                            break;
                        }
                    }

                    switch (space) {
                        case 0:
                            //move left
                            if (space != 2 && space != 5 && space != 8) {
                                initialState[space] = initialState[space + 1];
                                initialState[space + 1] = 0;
                                output += "0 ";
                                System.out.print("L ");
                            }

                        case 1:
                            //move right
                            if (space != 0 && space != 3 && space != 6) {
                                initialState[space] = initialState[space - 1];
                                initialState[space - 1] = 0;
                                System.out.print("R ");
                                output += "1 ";
                            }

                        case 2:
                            //move down
                            if (space != 0 && space != 1 && space != 2) {
                                initialState[space] = initialState[space - 3];
                                initialState[space - 3] = 0;
                                System.out.print("D ");
                                output += "2 ";
                            }

                        case 3:
                            //move up
                            if (space != 6 && space != 7 && space != 8) {
                                initialState[space] = initialState[space + 3];
                                initialState[space + 3] = 0;
                                System.out.print("U ");
                                output += "3 ";
                            }
                    }
                }
            } else {
                System.out.println("Tidak ada solusi");
            }
            writeFile.write(output);
            writeFile.close();
        }
    }
}
