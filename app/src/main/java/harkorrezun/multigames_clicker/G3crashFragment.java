package harkorrezun.multigames_clicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Harkor on 2018-04-04.
 */

public class G3crashFragment extends Fragment {
    int amount,liveWinAmount;
    int myBet=0;
    Boolean crash=false;
    double result=1;
    TextView crashAmount,myBetDisplay,resultDisplay,liveWin,winLose;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SeekBar seekBar;
    Button startStop;
    Boolean started=false;
    CountDownTimer count;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_g3_crash,container,false);
        crashAmount=view.findViewById(R.id.crashAmount);
        liveWin=view.findViewById(R.id.crashLiveWin);
        winLose=view.findViewById(R.id.crashWinLose);
        winLose.setText("");
        sharedPreferences=getContext().getSharedPreferences("harkor.multigamesclicker", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        liveWin.setText(getResources().getString(R.string.liveWin)+" 0");
        amount=sharedPreferences.getInt("carrots",0);
        crashAmount.setText(amount+"");
        myBetDisplay=view.findViewById(R.id.crashMyBetDisplay);
        myBetDisplay.setText(getResources().getString(R.string.my_bet)+" 0");
        seekBar=view.findViewById(R.id.crashSeekBar);
        seekBar.setMax(amount);
        resultDisplay=view.findViewById(R.id.crashResultDisplay);
        count=new CountDownTimer(10000,500) {
            @Override
            public void onTick(long l) {
                if (!crash()||result==0.75) { //NO CRASH
                    if (result < 2) {
                        result += 0.25;
                    } else if (result < 4) {
                        result += 0.5;
                    } else {
                        result += 1;
                    }
                    resultDisplay.setText(result + "");
                    liveWinAmount= (int) (myBet*result);
                    liveWin.setText(getResources().getString(R.string.liveWin)+" "+liveWinAmount);

                }else{//CRASH
                    count.cancel();
                    resultDisplay.setTextColor(getResources().getColor(R.color.crashRed));
                    liveWin.setText(getResources().getString(R.string.liveWin)+" 0");
                    startStop.setText(R.string.restart);
                    winLose.setTextColor(getResources().getColor(R.color.crashRed));
                    winLose.setText(R.string.youLose);
                    crash=true;
                    amount-=myBet;
                    editor.putInt("carrots",amount);
                    editor.commit();
                }
            }
            @Override
            public void onFinish() {

            }
        };
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(started==false) {
                    myBet = i;
                    myBetDisplay.setText(getResources().getString(R.string.my_bet) + " " + i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        startStop=view.findViewById(R.id.crashStartStop);
        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started==false) {//START
                    if (myBet == 0) {
                        Toast.makeText(getContext(), R.string.setBetValue, Toast.LENGTH_SHORT).show();
                    } else {
                        started = true;
                        resultDisplay.setText("1.0");
                        result=0.75;
                        crash=false;
                        winLose.setText("");
                        count.start();
                        resultDisplay.setTextColor(getResources().getColor(R.color.crashGreen));
                        startStop.setText(R.string.stop);
                    }
                }else {//STOP
                    startStop.setText(R.string.start);
                    if(crash==false){
                        count.cancel();
                        amount+=liveWinAmount;
                        amount-=myBet;
                        winLose.setTextColor(getResources().getColor(R.color.crashGreen));
                        winLose.setText(R.string.youWin);
                        editor.putInt("carrots",amount);
                        editor.commit();
                    }else{

                        winLose.setText("");
                        resultDisplay.setText("1.0");
                        resultDisplay.setTextColor(getResources().getColor(R.color.darkGray));
                    }
                    crashAmount.setText(amount+"");

                    startStop.setText(R.string.start);
                    started=false;
                }

            }
        });

        return view;
    }
    private Boolean crash(){
        Random random=new Random();
        int octa=random.nextInt(6);
        if(octa==0){
            return true;
        }else{
            return false;
        }
    }
}
