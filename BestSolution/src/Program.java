/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */

import java.util.List;

class Program {
////    private int counter;
////    public Program(){
////        this.counter=0;
////    }
    
    public int TotalTime(int[] band, int n) {
        if (n < 3) {
            int temp = band[n - 1];
            System.out.println("yang terakhir " + band[1] + " and " + band[0]);
            return temp;
        } else if (n == 3) {
            int temp = band[0] + band[1] + band[2];
            System.out.println("GO "+ band[2] + " and " + band[0]);
            System.out.println("balik lagi " + band[0] );
            System.out.println("GO "+ band[1] + " and "+band[0]);
            return temp;
        } else {
            int temp1 = band[n - 1] + band[0] + band[n - 2] + band[0];
            int temp2 = band[1] + band[0] + band[n - 1] + band[1];
            
            if (temp1 <= temp2) {
                System.out.println("GO " + band[1] + " and " + band[0]);
                System.out.println("balik lagi " + band[0]);
                System.out.println("GO " + band[n-1] + " and " + band[n-2]);
                System.out.println("balik lagi " + band[1]);
                
                return temp1 + TotalTime(band, n - 2);
            } else{
                System.out.println("GO " + band[1] + " and " + band[0]);
                System.out.println("balik lagi " + band[0]);
                System.out.println("GO " + band[n - 1] + " and " + band[n-2]);
                System.out.println("balik lagi " + band[1]);
                
                return temp2 + TotalTime(band, n - 2);
            }
        }
    }
}
