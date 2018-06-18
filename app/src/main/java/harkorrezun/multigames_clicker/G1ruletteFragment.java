package harkorrezun.multigames_clicker;

import android.content.Context;
import android.content.SharedPreferences;
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

public class G1ruletteFragment extends Fragment {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    SeekBar seekBar;
    TextView amountView;
    TextView myBetView;
    TextView textViewResult;
    TextView textViewWinLose;
    ImageView buttonRed;
    ImageView buttonGreen;
    ImageView buttonBlack;
    ImageView resultColor;
    Button goBet;
    int amount;
    int myBet=0;
    int pickedColor=0;
    String myBetString;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_g1_rulette,container,false);
        context=getContext();
        textViewWinLose=view.findViewById(R.id.textViewWinLose);
        textViewWinLose.setText("");
        textViewResult=view.findViewById(R.id.textViewResult);
        resultColor=view.findViewById(R.id.imageViewResultColor);
        sharedPreferences=getContext().getSharedPreferences("harkor.multigamesclicker", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        buttonGreen=view.findViewById(R.id.imageViewGreen);
        buttonRed=view.findViewById(R.id.imageViewRed);
        buttonBlack=view.findViewById(R.id.imageViewBlack);
        amountView=view.findViewById(R.id.carrotsAmount);
        goBet=view.findViewById(R.id.buttonBet);
        amount=sharedPreferences.getInt("carrots",0);
        amountView.setText(amount+"");
        myBetString=getContext().getResources().getString(R.string.my_bet);
        myBetView=view.findViewById(R.id.myBetView);
        myBetView.setText(myBetString+" "+myBet);
        seekBar=view.findViewById(R.id.seekBarBet);
        seekBar.setMax(amount);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                myBet=i;
                myBetView.setText(myBetString+" "+myBet);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickedColor=1;
                buttonRed.setImageResource(R.color.rouletteRed2);
                buttonBlack.setImageResource(R.color.rouletteBlack);
                buttonGreen.setImageResource(R.color.rouletteGreen);
            }
        });
        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickedColor=2;
                buttonGreen.setImageResource(R.color.rouletteGreen2);
                buttonRed.setImageResource(R.color.rouletteRed);
                buttonBlack.setImageResource(R.color.rouletteBlack);
            }
        });
        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickedColor=3;
                buttonBlack.setImageResource(R.color.rouletteBlack2);
                buttonRed.setImageResource(R.color.rouletteRed);
                buttonGreen.setImageResource(R.color.rouletteGreen);
            }
        });
        goBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pickedColor==0){
                    Toast.makeText(context,R.string.pickColor,Toast.LENGTH_SHORT).show();
                }else if(myBet==0){
                    Toast.makeText(context,R.string.setBetValue,Toast.LENGTH_SHORT).show();
                }else{
                    rule();
                }
            }
        });

        return view;
    }
    private void rule(){
        Random random=new Random();
        int result=random.nextInt();
        result=result%15;
        result=Math.abs(result);
        textViewResult.setText(result+"");
        if(result==0){
            resultColor.setImageResource(R.color.rouletteGreen);
            result=2;
        }else if(result%2==0){
            resultColor.setImageResource(R.color.rouletteRed);
            result=1;
        }else{
            resultColor.setImageResource(R.color.rouletteBlack);
            result=3;
        }
        if(result==pickedColor){//WIN
            textViewWinLose.setText(R.string.youWin);
            textViewWinLose.setTextColor(getResources().getColor(R.color.rouletteGreen));
            if(pickedColor==2){
                amount+=(myBet*14);
            }else{
                amount+=myBet;
            }
        }else{//LOSE
            textViewWinLose.setText(R.string.youLose);
            textViewWinLose.setTextColor(getResources().getColor(R.color.rouletteRed));
            amount-=myBet;
        }
        amountView.setText(""+amount);
        seekBar.setMax(amount);
        editor.putInt("carrots",amount);
        editor.commit();
        //seekBar.setProgress(0);
    }


}
