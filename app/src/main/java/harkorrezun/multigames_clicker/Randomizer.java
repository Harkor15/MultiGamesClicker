package harkorrezun.multigames_clicker;

import android.content.Context;
import android.util.Log;

import java.util.Random;

public class Randomizer {
    private static int[] lvls={1,3,6,10,15,21,28,36,45,55,66,78,91,105,120};

    public int opening(){
        Random random=new Random();
        int ran=random.nextInt();
        ran=Math.abs(ran);
        ran%=lvls[14];
        ran++;
        Log.d("ran",ran+"");
        int result;
        if(ran>lvls[13]){
            result=15;
        }else if(ran>lvls[12]){
            result=14;
        }else if(ran>lvls[11]){
            result=13;
        }else if(ran>lvls[10]){
            result=12;
        }else if(ran>lvls[9]){
            result=11;
        }else if(ran>lvls[8]){
            result=10;
        }else if(ran>lvls[7]){
            result=9;
        }else if(ran>lvls[6]){
            result=8;
        }else if(ran>lvls[5]){
            result=7;
        }else if(ran>lvls[4]){
            result=6;
        }else if(ran>lvls[3]){
            result=5;
        }else if(ran>lvls[2]){
            result=4;
        }else if(ran>lvls[1]){
            result=3;
        }else if(ran>lvls[0]){
            result=2;
        }else{
            result=1;
        }
        return result;
    }
}
