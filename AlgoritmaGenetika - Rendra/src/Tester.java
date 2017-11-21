
import java.io.File;
import java.io.IOException;
//import java.util.Scanner;

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
public class Tester {

    public static void main(String[] args) throws IOException {
        File folder = new File("D:\\Data\\Rendra\\Kuliah\\Rendra\\Pengantar Sistem Cerdas\\Tugas\\Program\\Program\\Data Testcase");
        File[] listOfFiles = folder.listFiles();
        InputOutput inputOutput = new InputOutput();

        for (int i = 0; i < listOfFiles.length; i++) {
            inputOutput.read(listOfFiles[i]);
            System.out.println("Banyak Orang : " + inputOutput.getPersons());
            int[] timePersons = inputOutput.getTimePersons();
            System.out.println("Waktu setiap orang untuk menyeberang");
            for (int j = 0; j < timePersons.length; j++) {
                int angka = timePersons[j];
                System.out.println(angka);
            }
            System.out.println();
            /*String result = inputOutput.getPersons() + "";
            result += " Rendra";
            inputOutput.writer(result);*/
        }
    }
}
