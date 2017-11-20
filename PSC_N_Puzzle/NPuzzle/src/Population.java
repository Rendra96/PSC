

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
public class Population {
    
    //populasi terdiri dari beberapa kromosom
    //max individu pd populasi 200 individu
    private Chromosome[] populasi;
    private int maxPop = 200;
    
    public Population(){
        populasi = new Chromosome[maxPop];
    }
    
    public void generatePopulasiAwal(){
        for (int i = 0; i < maxPop; i++) {
            Chromosome newChromosome = new Chromosome();
            newChromosome.generateChromosome();
            populasi[i] = newChromosome;
        }
    }
    
    
    public int getPopulationLength(){
        return this.maxPop;
    }
    
    public Chromosome[] getPopulation(){
        return this.populasi;
    }
}
