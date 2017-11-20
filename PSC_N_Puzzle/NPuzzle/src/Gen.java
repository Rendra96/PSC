
import java.util.Random;

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
public class Gen {
    
    //pergerakan pada n-puzzle
    //0 : atas, 1 : kiri, 2 : kanan, 3: bawah
    private int pergerakan ;

    //generate gen baru 
    public Gen() {
        Random r = new Random();
        this.pergerakan = r.nextInt(4);
    }
    
    public int getPergerakan(){
        return this.pergerakan;
    }
    
    public void setPergerakan(int pergerakan){
        this.pergerakan = pergerakan;
    }
    
}
