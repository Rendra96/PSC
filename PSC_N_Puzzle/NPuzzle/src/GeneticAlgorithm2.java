
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author
 *  Ihsan Fajari		2014730018
    Nadhila Larasati	2014730035
    Ellena Angelica	2015730029
    Evelyn Wijaya	2015730030
    Tegar Muhammad	2015730046
 */
public class GeneticAlgorithm2 {

    private int[] initialState, goalState;
    private Population populasi;

    public GeneticAlgorithm2(Population pop, int[] initial, int[] goal) {
        this.initialState = initial;
        this.goalState = goal;
        this.populasi = pop;
    }

    //mutasi gen pada kromosom
    //ngambil kromosom dari populasi secara acak lalu gen kromosom tersebut dimutasi
    //milih indexnya juga random
    public void mutate(Chromosome kromosom) {
        if (Math.random() < 0.5) {
            Random rand = new Random();
            int index = rand.nextInt(kromosom.getLength());
            int pergerakan = rand.nextInt(4);
            kromosom.getArrayGen()[index].setPergerakan(pergerakan);
        }
    }

    public Chromosome[] crossOver(Chromosome parent1, Chromosome parent2) {
        Random rand = new Random();
        int indexPemotongan = rand.nextInt(39) + 1;
        Chromosome[] anak = new Chromosome[2];

        Chromosome child1 = new Chromosome();
        Chromosome child2 = new Chromosome();
        
        child1.generateChromosome();
        child2.generateChromosome();

        for (int i = 0; i < indexPemotongan; i++) {
            int gerak1 = parent1.getArrayGen()[i].getPergerakan();
            int gerak2 = parent2.getArrayGen()[i].getPergerakan();
            
            child1.getArrayGen()[i].setPergerakan(gerak1);
            child2.getArrayGen()[i].setPergerakan(gerak2);
        }

        for (int i = indexPemotongan; i < parent1.getLength(); i++) {
            child1.getArrayGen()[i].setPergerakan(parent2.getArrayGen()[i].getPergerakan());
            child2.getArrayGen()[i].setPergerakan(parent1.getArrayGen()[i].getPergerakan());
        }

        anak[0] = child1;
        anak[1] = child2;

        return anak;
    }

    public Chromosome selection() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(populasi.getPopulationLength());
        
        int jumlah = fitnessPopulation();
        int pos = rand.nextInt(jumlah);
        int tempPostSkor = 0;
        
        for (int i = 0; i < populasi.getPopulationLength(); i++) {
            if(pos > tempPostSkor && pos <= (tempPostSkor+populasi.getPopulation()[i].getScore())){
                return this.populasi.getPopulation()[i];
            }
            tempPostSkor += this.populasi.getPopulation()[i].getScore();
        }
        return this.populasi.getPopulation()[randomIndex];
    }

    public void fitness(Chromosome kromosom) {
        int space = cariSpaceKosong();
        int[] tempInitial = initialState;

        for (int j = 0; j < kromosom.getLength(); j++) {
            //gerakan 0 isi puzzle
            switch (space) {
                case 0:
                    //move left
                    if (space != 2 && space != 5 && space != 8) {
                        tempInitial[space] = tempInitial[space + 1];
                        tempInitial[space + 1] = 0;
                    }

                case 1:
                    //move right
                    if (space != 0 && space != 3 && space != 6) {
                        tempInitial[space] = tempInitial[space - 1];
                        tempInitial[space - 1] = 0;
                    }

                case 2:
                    //move down
                    if (space != 0 && space != 1 && space != 2) {
                        tempInitial[space] = tempInitial[space - 3];
                        tempInitial[space - 3] = 0;
                    }

                case 3:
                    //move up
                    if (space != 6 && space != 7 && space != 8) {
                        tempInitial[space] = tempInitial[space + 3];
                        tempInitial[space + 3] = 0;
                    }

            }

            int score = compareInitialGoal(tempInitial, goalState);
            kromosom.setScore(score);
        }

    }

    public void sortFitness() {
        Chromosome temp;
        for (int i = 0; i < populasi.getPopulationLength(); i++) {
            for (int j = 0; j < populasi.getPopulationLength(); j++) {
                if (populasi.getPopulation()[i].getScore() < populasi.getPopulation()[j].getScore()) {
                    temp = populasi.getPopulation()[j];
                    populasi.getPopulation()[j] = populasi.getPopulation()[i];
                    populasi.getPopulation()[i] = temp;
                }
            }
        }
    }

    private int cariSpaceKosong() {
        int posisi = 0;
        for (int i = 0; i < initialState.length; i++) {
            if (initialState[i] == 0) {
                posisi = i;
                break;
            }
        }
        return posisi;
    }

    private int compareInitialGoal(int[] state, int[] goalState) {
        int score = 0;
        for (int i = 0; i < state.length; i++) {
            if (state[i] == goalState[i]) {
                score++;
            }
        }
        return score;
    }
    
    private int fitnessPopulation(){
        int sum = 0;
        for (int i = 0; i < populasi.getPopulationLength(); i++) {
            sum+= populasi.getPopulation()[i].getScore();
        }
        return sum;
    }
}
