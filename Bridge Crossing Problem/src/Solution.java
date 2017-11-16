/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 16 November 2017
 * 
 */
public class Solution {
    public int totalTime(int[] personTimes, int persons) {
        if (persons < 3) {
            int temp = personTimes[persons - 1];
            
            //System.out.println("yang terakhir " + personTimes[1] + " and " + personTimes[0]);
            return temp;
        } else if (persons == 3) {
            int temp = personTimes[0] + personTimes[1] + personTimes[2];
            
//            System.out.println("GO "+ personTimes[2] + " and " + personTimes[0]);
//            System.out.println("balik lagi " + personTimes[0] );
//            System.out.println("GO "+ personTimes[1] + " and "+personTimes[0]);
            return temp;
        } else {
            int temp1 = personTimes[persons - 1] + personTimes[0] + personTimes[persons - 2] + personTimes[0];
            int temp2 = personTimes[1] + personTimes[0] + personTimes[persons - 1] + personTimes[1];
            
            if (temp1 <= temp2) {
//                System.out.println("GO " + personTimes[1] + " and " + personTimes[0]);
//                System.out.println("balik lagi " + personTimes[0]);
//                System.out.println("GO " + personTimes[persons-1] + " and " + personTimes[persons-2]);
//                System.out.println("balik lagi " + personTimes[1]);
                
                return temp1 + totalTime(personTimes, persons - 2);
            } else{
//                System.out.println("GO " + personTimes[1] + " and " + personTimes[0]);
//                System.out.println("balik lagi " + personTimes[0]);
//                System.out.println("GO " + personTimes[persons - 1] + " and " + personTimes[persons-2]);
//                System.out.println("balik lagi " + personTimes[1]);
                
                return temp2 + totalTime(personTimes, persons - 2);
            }
        }
    }
}