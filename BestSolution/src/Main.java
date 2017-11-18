
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Samuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // change the no of people crossing the bridge
        // add or remove corresponding time to the list
        Scanner sc = new Scanner(System.in);
        System.out.print("Banyak orang yang ingin menyeberang : ");
        int n = sc.nextInt();
        
        System.out.println("Waktu menyeberang setiap orang :");
        int[] band = new int[n];
        for(int i = 0;i<band.length;i++) {
            band[i] = sc.nextInt();
        }
        Program p = new Program();
        System.out.println("The total time taken to cross the bridge is: " + p.TotalTime(band, n));
        p.getArray();
    }
}
