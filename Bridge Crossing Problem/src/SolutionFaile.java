
import java.util.Arrays;

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
public class SolutionFaile {

    private int[] personTimes;
    private int bestSolution;
    private int[] hasilKromosom;

    public SolutionFaile(int[] personTimes) {
        this.personTimes = personTimes;
        this.bestSolution = 0;
        bestSolution();
    }

    public int getFitness() {
        return this.bestSolution;
    }

    private void bestSolution() {
        Arrays.sort(this.personTimes);
        int[] awal = new int[this.personTimes.length];
        int[] seberang = new int[this.personTimes.length];
        awal = this.personTimes;
        int result = 0;
        int step = 2 * (this.personTimes.length - 1) - 1;
        this.hasilKromosom = new int[step * 2];
        boolean min = true;
        boolean max = false;
        int temp = Integer.MAX_VALUE;
        int counter = 0;
        for (int i = 0; i < step - 1; i++) {
            if (min) {
                seberang[0] = awal[0];
                seberang[1] = awal[1];

                result += awal[1];
                this.hasilKromosom[counter] = awal[1];
                counter++;

                awal[0] = 0;
                awal[1] = 0;
                if (counter != step) {
                    for (int j = 0; j < seberang.length; j++) {
                        if (seberang[j] > 0 && seberang[j] <= temp) {
                            temp = seberang[j];
                            this.hasilKromosom[counter] = temp;
                            counter++;
                            awal[j] = temp;
                            result += temp;
                            seberang[j] = 0;
                            break;
                        }
                    }

                    temp = Integer.MAX_VALUE;

                    min = false;
                    max = true;
                }
            } else if (max) {
                if (step - 1 == counter) {
                    result += awal[2];
                    this.hasilKromosom[counter] = awal[2];
                    awal[2] = 0;
                    awal[0] = 0;
                    counter++;
                    break;
                    /*if (counter != step) {
                        for (int j = 0; j < seberang.length; j++) {
                            if (seberang[j] > 0 && seberang[j] <= temp) {
                                temp = seberang[j];
                                this.hasilKromosom[counter] = temp;
                                counter++;
                                awal[j] = temp;
                                result += temp;
                                seberang[j] = 0;
                                break;
                            }
                        }

                        i += 1;
                        temp = Integer.MAX_VALUE;

                        min = true;
                        max = false;
                    }*/
                } else {
                    seberang[this.personTimes.length - i] = awal[this.personTimes.length - i];
                    seberang[this.personTimes.length - (i + 1)] = awal[this.personTimes.length - (i + 1)];

                    result += awal[this.personTimes.length - i];
                    this.hasilKromosom[counter] = awal[this.personTimes.length - i];
                    counter++;

                    awal[this.personTimes.length - i] = 0;
                    awal[this.personTimes.length - (i + 1)] = 0;

                    if (counter != step) {
                        for (int j = 0; j < seberang.length; j++) {
                            if (seberang[j] > 0 && seberang[j] <= temp) {
                                temp = seberang[j];
                                this.hasilKromosom[counter] = temp;
                                counter++;
                                awal[j] = temp;
                                result += temp;
                                seberang[j] = 0;
                                break;
                            }
                        }

                        i += 1;
                        temp = Integer.MAX_VALUE;

                        min = true;
                        max = false;
                    }
                }
            }
        }
        this.bestSolution = result;
    }

    public String printKromosom() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.hasilKromosom.length - 1; i++) {
            result.append(this.hasilKromosom[i]).append(" ");
        }
        return result.toString();
    }
}
