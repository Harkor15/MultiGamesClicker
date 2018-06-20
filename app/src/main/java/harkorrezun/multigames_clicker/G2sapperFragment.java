package harkorrezun.multigames_clicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Harkor on 2018-04-04.
 */

public class G2sapperFragment extends Fragment {
    ImageView sapper1, sapper2, sapper3,sapper4, sapper5, sapper6, sapper7, sapper8, sapper9, sapper10;
    TextView amountView,myBetDisplay,multiplayAct,winAct;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int amount,myBet=0,bomb;
    Boolean started=false;
    Button buttonStartStop;
    int winLVL=0;
    SeekBar seekBar;
    String multiplayActString,winActString;
    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_g2_sapper,container,false);
        multiplayAct=view.findViewById(R.id.textViewSapperMultiplayer);
        winAct=view.findViewById(R.id.textViewSapperPosibleWin);
        multiplayActString=getResources().getString(R.string.multiplay);
        winActString=getResources().getString(R.string.reward);
        sapper1=view.findViewById(R.id.imageViewSapper1);
        sapper2=view.findViewById(R.id.imageViewSapper2);
        sapper3=view.findViewById(R.id.imageViewSapper3);
        sapper4=view.findViewById(R.id.imageViewSapper4);
        sapper5=view.findViewById(R.id.imageViewSapper5);
        sapper6=view.findViewById(R.id.imageViewSapper6);
        sapper7=view.findViewById(R.id.imageViewSapper7);
        sapper8=view.findViewById(R.id.imageViewSapper8);
        sapper9=view.findViewById(R.id.imageViewSapper9);
        sapper10=view.findViewById(R.id.imageViewSapper10);
        amountView=view.findViewById(R.id.sapperAmountTextView);
        sharedPreferences=getContext().getSharedPreferences("harkor.multigamesclicker", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        amount=sharedPreferences.getInt("carrots",0);
        amountView.setText(amount+"");
        myBetDisplay=view.findViewById(R.id.sapperMyBetDisplasyTextView);
        myBetDisplay.setText(getResources().getString(R.string.my_bet)+" 0");
        seekBar=view.findViewById(R.id.sapperSeekBar);
        seekBar.setMax(amount);
        final String myBetString=getResources().getString(R.string.my_bet);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                myBet=i;
                myBetDisplay.setText(myBetString+" "+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonStartStop=view.findViewById(R.id.buttonSapperStartStop);
        buttonStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started==false){
                    if(myBet==0){
                        Toast.makeText(getContext(),R.string.setBetValue,Toast.LENGTH_SHORT).show();
                    }else{//START
                        winLVL=0;
                        started=true;
                        buttonStartStop.setText(R.string.stop);
                        clearTable();
                        setBomb();
                        multiplayAct.setText(multiplayActString+" 1");
                        winAct.setText(winActString+" 0");
                    }
                }else{//STOP
                    started=false;
                    amount+=winDecryptor();
                    amountView.setText(amount+"");
                    editor.putInt("carrots",amount);
                    editor.commit();
                    buttonStartStop.setText(R.string.start);
                    clearTable();
                    seekBar.setMax(amount);
                    multiplayAct.setText(multiplayActString+" 1");
                    winAct.setText(winActString+" 0");
                    //WIN!

                }
            }
        });
        sapper1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(1);
            }
        });
        sapper2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(2);
            }
        });
        sapper3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(3);
            }
        });
        sapper4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(4);
            }
        });
        sapper5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(5);
            }
        });
        sapper6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(6);
            }
        });
        sapper7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(7);
            }
        });
        sapper8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(8);
            }
        });
        sapper9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(9);
            }
        });
        sapper10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sapperCheck(10);
            }
        });


        return view;
    }
    private void clearTable(){
        sapper1.setImageResource(R.drawable.sapper_empty);
        sapper2.setImageResource(R.drawable.sapper_empty);
        sapper3.setImageResource(R.drawable.sapper_empty);
        sapper4.setImageResource(R.drawable.sapper_empty);
        sapper5.setImageResource(R.drawable.sapper_empty);
        sapper6.setImageResource(R.drawable.sapper_empty);
        sapper7.setImageResource(R.drawable.sapper_empty);
        sapper8.setImageResource(R.drawable.sapper_empty);
        sapper9.setImageResource(R.drawable.sapper_empty);
        sapper10.setImageResource(R.drawable.sapper_empty);
    }
    private void setBomb(){
        Random random=new Random();
        bomb=random.nextInt(10)+1;
    }
    private void sapperCheck(int i){
        if(started==true) {
            if (i == bomb) {
                setImage(i, R.drawable.sapper_bomb);
                sapperLose();
            } else {
                setImage(i, R.drawable.sapper_flag);
                winLVL++;
                setInfo();
                if(winLVL==9){
                    amount+=winDecryptor();
                    amountView.setText(amount+"");
                    editor.putInt("carrots",amount);
                    editor.commit();
                    seekBar.setMax(amount);
                                    }
            }
        }
    }
    private void setImage(int id, int drawable){
        switch (id){
            case 1: sapper1.setImageResource(drawable);break;
            case 2: sapper2.setImageResource(drawable);break;
            case 3: sapper3.setImageResource(drawable);break;
            case 4: sapper4.setImageResource(drawable);break;
            case 5: sapper5.setImageResource(drawable);break;
            case 6: sapper6.setImageResource(drawable);break;
            case 7: sapper7.setImageResource(drawable);break;
            case 8: sapper8.setImageResource(drawable);break;
            case 9: sapper9.setImageResource(drawable);break;
            case 10: sapper10.setImageResource(drawable);break;
        }
    }
    private void sapperLose(){
        amount-=myBet;
        started=false;
        amountView.setText(amount+"");
        editor.putInt("carrots",amount);
        editor.commit();
        seekBar.setMax(amount);
        buttonStartStop.setText(R.string.start);

    }
    private int winDecryptor(){

        switch (winLVL){
            case 0: return 0;
            case 1: return(int)(0.1*myBet);
            case 2: return(int)(0.2*myBet);
            case 3: return(int)(0.3*myBet);
            case 4: return(int)(0.6*myBet);
            case 5: return(1*myBet);
            case 6: return(int)(1.5*myBet);
            case 7: return(2*myBet);
            case 8: return(4*myBet);
            case 9: return(9*myBet);
        }
        return 0;
    }
    private void setInfo(){
        winAct.setText(winActString+" "+(winDecryptor()));
        double multi;
        switch (winLVL){
            case 0: multi=1;break;
            case 1: multi=1.1;break;
            case 2: multi=1.2;break;
            case 3: multi=1.3;break;
            case 4: multi=1.6;break;
            case 5: multi=2;break;
            case 6: multi=2.5;break;
            case 7: multi=3;break;
            case 8: multi=5;break;
            case 9: multi=10;break;
            default: multi=1;break;
            }
        multiplayAct.setText(multiplayActString+multi);
    }

}
