/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra_2
 */
public class Tester {
    public static void main(String[] args) {
        // change the no of people crossing the bridge
        // add or remove corresponding time to the list
        int n = 4; 

        int[] band = { 1, 2, 5, 10 };
        

        //band.Sort();

        System.out.println("The total time taken to cross the bridge is: " + Program.TotalTime(band, n));
    }
}