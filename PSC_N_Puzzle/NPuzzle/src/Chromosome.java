

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
// kromosom adalah sekumpulan gen
public class Chromosome{

    private int length, score;
    private Gen[] arrayGen;

    // panjang kromosom = 40
    public Chromosome() {
        this.length = 40;
        this.arrayGen = new Gen[length];
        this.score = 0;
    }

    //generate kromosom secara acak
    public void generateChromosome() {
        for (int i = 0; i < length; i++) {
            this.arrayGen[i] = new Gen();
        }
    }

    public int getLength() {
        return this.length;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
    
    public Gen[] getArrayGen(){
        return this.arrayGen;
    }
}
