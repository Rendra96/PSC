/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ASUS
 */
public class FitnessCalc {

    private int[] solution;
    
    public FitnessCalc(int geneLength){
        solution = new int[geneLength];
    }
    /* Public methods */
    // Set a candidate solution as a byte array
    public  void setSolution(int[] newSolution) {
       for(int i=0;i<solution.length;i++){
           solution[i]= newSolution[i];
//           System.out.println("aaaaaaaaaaaa" + solution[i]);
       }
    }

//    // To make it easier we can use this method to set our candidate solution 
//    // with string of 0s and 1s
//    public void setSolution(int[] newSolution) {
//        solution = new int[newSolution.length];
//        // Loop through each character of our string and save it in our byte 
//        // array
//        for (int i = 0; i < newSolution.length(); i++) {
//          solution[i] = newSolution[i];
//        }
//    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    public int getFitness(Individual individual) {
        int fitness = 0;
        // Loop through our individuals genes and compare them to our cadidates
        for (int i = 0; i < individual.size(); i++) {
             //System.out.print(this.solution[i]);
            if (individual.getGene(i) == this.solution[i]) {
              
                fitness++;
            }
        }
        return fitness;
    }
    
    // Get optimum fitness
    public int getMaxFitness() {
        int maxFitness = solution.length;
        return maxFitness;
    }
}