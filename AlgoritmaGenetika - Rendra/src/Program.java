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
    private int[] solusi;
    private int panjang;
    private int tmp;

    public Program() {
        tmp = 0;
        solusi = new int[tmp];
    }

    public int TotalTime(int[] band, int n) {
        if (solusi.length == 0) {
            
            this.panjang = 2*(n-1)-1;
            this.solusi = new int[panjang];
        }
        if (n < 3) {
            int temp = band[n - 1];
////            System.out.println("yang terakhir " + band[1] + " and " + band[0]);
            this.solusi[panjang - 1] = band[1];
            return temp;
        } else if (n == 3) {
            int temp = band[0] + band[1] + band[2];
            this.solusi[panjang - 3] = band[2];
            this.solusi[panjang - 2] = band[0];
            this.solusi[panjang - 1] = band[1];
//            System.out.println("GO " + band[2] + " and " + band[0]);
//            System.out.println("balik lagi " + band[0]);
//            System.out.println("GO " + band[1] + " and " + band[0]);
            return temp;
        } else {
            int temp1 = band[n - 1] + band[0] + band[n - 2] + band[0];
            int temp2 = band[1] + band[0] + band[n - 1] + band[1];

            if (temp1 <= temp2) {
                this.solusi[tmp]=band[1];
                this.solusi[tmp+1]=band[0];
                this.solusi[tmp+2]=band[n-1];
                this.solusi[tmp+3]=band[1];
                tmp+=4;
//                System.out.println("GO " + band[1] + " and " + band[0]);
//                System.out.println("balik lagi " + band[0]);
//                System.out.println("GO " + band[n - 1] + " and " + band[n - 2]);
//                System.out.println("balik lagi " + band[1]);

                return temp1 + TotalTime(band, n - 2);
            } else {
                this.solusi[tmp]=band[1];
                this.solusi[tmp+1]=band[0];
                this.solusi[tmp+2]=band[n-1];
                this.solusi[tmp+3]=band[1];
                tmp+=4;
//                System.out.println("GO " + band[1] + " and " + band[0]);
//                System.out.println("balik lagi " + band[0]);
//                System.out.println("GO " + band[n - 1] + " and " + band[n - 2]);
//                System.out.println("balik lagi " + band[1]);

                return temp2 + TotalTime(band, n - 2);
            }
        }
    }
    
    //buat test isi solusi
    public int[] getArray(){
        return this.solusi;
    }
}
