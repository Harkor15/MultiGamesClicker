package harkorrezun.multigames_clicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Harkor on 2018-03-26.
 */

public class F1_clicker extends Fragment {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    ImageView piano1,piano2,piano3,piano4;
    ImageView mid1,mid2,mid3,mid4;
    ImageView small1,small2,small3,small4;
    TextView amountView;
    ImageView carrot;
    int amount;
    int multiplay;

    int [] sm=new int [5];
    int [] md=new int [5];
    int [] pi=new int [5];



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f1_clicker,container,false);
        sharedPreferences=getContext().getSharedPreferences("harkor.multigamesclicker", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        amount=sharedPreferences.getInt("carrots",0);
        multiplay=sharedPreferences.getInt("multiplay",1);
        carrot=view.findViewById(R.id.carrot);
        piano1= view.findViewById(R.id.piano1);
        piano2= view.findViewById(R.id.piano2);
        piano3= view.findViewById(R.id.piano3);
        piano4= view.findViewById(R.id.piano4);
        mid1= view.findViewById(R.id.midle1);
        mid2= view.findViewById(R.id.midle2);
        mid3= view.findViewById(R.id.midle3);
        mid4= view.findViewById(R.id.midle4);
        small1= view.findViewById(R.id.small1);
        small2= view.findViewById(R.id.small2);
        small3= view.findViewById(R.id.small3);
        small4= view.findViewById(R.id.small4);
        amountView=view.findViewById(R.id.carrotAmount);
        amountView.setText(amount+"");
        piano1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCash(1);
            }
        });
        piano2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCash(2);
            }
        });
        piano3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCash(3);
            }
        });
        piano4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCash(4);
            }
        });

        startAct();

        ImageView carrot =view.findViewById(R.id.carrot);
        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: New multiplayer for carrot
                //TODO: Adding carrots for clicking carrots
            }
        });



        return view;
    }
    @Override
    public void onPause() {
        editor.putInt("carrots",amount);
        editor.commit();
        //Toast.makeText(getContext(),"OnPause!  "+amount,Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    public void addCash(int idButton){
        int tmp=multiplay;
        //int tmp=1;
        //tmp*=multiplay;
        if(pi[idButton]==1){
            tmp*=(-5);
        }else if(pi[idButton]==2){
            tmp*=(-5);
        }else if(pi[idButton]==3){
        tmp*=(-5);
        }else{
            tmp*=10;
        }

        amount+=tmp;
        if(amount<0){
            amount=0;
        }
        amountView.setText(""+amount);

        fishPush();
        try {
            fireworks();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void startAct(){
        for(int i=1;i<5;i++){
            Random random=new Random();
            sm[i]=random.nextInt(4)+1;
            md[i]=random.nextInt(4)+1;
            pi[i]=random.nextInt(4)+1;
        }
        /////////////////// SM
        if(sm[2]==sm[1]){
            sm[2]++;
            if(sm[2]>4){
                sm[2]=1;
            }
        }
        while(sm[3]==sm[2]||sm[3]==sm[1]){
            sm[3]++;
            if(sm[3]>4){
                sm[3]=1;
            }
        }
        while(sm[4]==sm[3]||sm[4]==sm[2]||sm[4]==sm[1]){
            sm[4]++;
            if(sm[4]>4){
                sm[4]=1;
            }
        }
        /////////////////// MD
        if(md[2]==md[1]){
            md[2]++;
            if(md[2]>4){
                md[2]=1;
            }
        }
        while(md[3]==md[2]||md[3]==md[1]){
            md[3]++;
            if(md[3]>4){
                md[3]=1;
            }
        }
        while(md[4]==md[3]||md[4]==md[2]||md[4]==md[1]){
            md[4]++;
            if(md[4]>4){
                md[4]=1;
            }
        }
        /////////////// PI
        if(pi[2]==pi[1]){
            pi[2]++;
            if(pi[2]>4){
                pi[2]=1;
            }
        }
        while(pi[3]==pi[2]||pi[3]==pi[1]){
            pi[3]++;
            if(pi[3]>4){
                pi[3]=1;
            }
        }
        while(pi[4]==pi[3]||pi[4]==pi[2]||pi[4]==pi[1]){
            pi[4]++;
            if(pi[4]>4){
                pi[4]=1;
            }
        }


        setAllButtons();
    }
    public int whichColor(int id){
        if(id==1){
            return R.color.jet;
        }else if(id==2){
            return R.color.jet;
        }else if(id==3){
            return R.color.jet;
        }else{
            return R.color.pia4;
        }
    }
    public void fishPush(){
        for(int i=1;i<5;i++){
            pi[i]=md[i];
            md[i]=sm[i];
        }
        Random rand=new Random();
        sm[1]=rand.nextInt(4)+1;
        sm[2]=rand.nextInt(4)+1;
        sm[3]=rand.nextInt(4)+1;
        sm[4]=rand.nextInt(4)+1;
        /////////////////// SM
        if(sm[2]==sm[1]){
            sm[2]++;
            if(sm[2]>4){
                sm[2]=1;
            }
        }
        while(sm[3]==sm[2]||sm[3]==sm[1]){
            sm[3]++;
            if(sm[3]>4){
                sm[3]=1;
            }
        }
        while(sm[4]==sm[3]||sm[4]==sm[2]||sm[4]==sm[1]){
            sm[4]++;
            if(sm[4]>4){
                sm[4]=1;
            }
        }
        setAllButtons();



    }
    public void setAllButtons(){
        small1.setImageResource(whichColor(sm[1]));
        small2.setImageResource(whichColor(sm[2]));
        small3.setImageResource(whichColor(sm[3]));
        small4.setImageResource(whichColor(sm[4]));
        mid1.setImageResource(whichColor(md[1]));
        mid2.setImageResource(whichColor(md[2]));
        mid3.setImageResource(whichColor(md[3]));
        mid4.setImageResource(whichColor(md[4]));
        piano1.setImageResource(whichColor(pi[1]));
        piano2.setImageResource(whichColor(pi[2]));
        piano3.setImageResource(whichColor(pi[3]));
        piano4.setImageResource(whichColor(pi[4]));
    }
    public void fireworks() throws InterruptedException {
    //carrot.setMinimumHeight(320);
    //carrot.setMinimumHeight(320);
    //TimeUnit.MILLISECONDS.sleep(500);
    //carrot.setMinimumHeight(300);
    //carrot.setMinimumHeight(300);

    }
    }
