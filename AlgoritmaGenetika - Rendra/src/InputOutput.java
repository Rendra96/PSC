
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rendra
 * @version 21 November 2017
 * 
 */
public class InputOutput {
    private int persons;
    private int[] timePersons;
    
    public void read(File file) throws FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader(file));
        String line = input.readLine();
        this.persons = Integer.parseInt(line);
        this.timePersons = new int[this.persons];
        //line = input.readLine();
        int i = 0;

        while (line != null && i<this.persons) {
            line = input.readLine();
            timePersons[i] = Integer.parseInt(line);
            i++;
        }
        
        input.close();
    }
    
    public void writer(String result, File file) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("Output " + file.getName() + ".txt"));
        out.write(result);
        out.close();
    }
    
    public int getPersons() {
        return this.persons;
    }
    
    public int[] getTimePersons() {
        Arrays.sort(this.timePersons);
        return this.timePersons;
    }
}