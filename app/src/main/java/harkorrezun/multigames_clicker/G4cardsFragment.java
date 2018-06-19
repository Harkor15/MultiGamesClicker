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

public class G4cardsFragment extends Fragment {
    int amount;
    boolean started=false;
    int winner;
    int myBet=0;
    SeekBar seekBar;
    TextView amountV, myBetDisplay,winLoseDisplay;
    ImageView  cardOne, cardTwo, cardThree;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_g4_cards,container,false);
        context=getContext();
        winLoseDisplay=view.findViewById(R.id.cardsWinLoseDisplay);
        cardOne=view.findViewById(R.id.cardOne);
        cardTwo=view.findViewById(R.id.cardTwo);
        cardThree=view.findViewById(R.id.cardThree);
        amountV=view.findViewById(R.id.cardsAmount);
        seekBar=view.findViewById(R.id.cardsSeekBar);
        myBetDisplay=view.findViewById(R.id.cardsMyBetDisplay);
        sharedPreferences=getContext().getSharedPreferences("harkor.multigamesclicker", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        amount=sharedPreferences.getInt("carrots",0);
        amountV.setText(amount+"");
        seekBar.setMax(amount);
        myBetDisplay.setText(getResources().getString(R.string.my_bet)+" 0");
        winLoseDisplay.setText("");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                myBet=i;
                myBetDisplay.setText(getResources().getString(R.string.my_bet)+" "+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        Button startButton=view.findViewById(R.id.cardsStartButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myBet==0){
                    Toast.makeText(context,R.string.setBetValue,Toast.LENGTH_SHORT).show();
                }else{
                    startGame();
                }
            }
        });
        cardOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started==true) {
                    cardPick(1);
                }
            }
        });
        cardTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started==true) {
                    cardPick(2);
                }
            }
        });
        cardThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(started==true) {
                    cardPick(3);
                }
            }
        });
        return view;
    }
    private void startGame(){
        started=true;
        Random random=new Random();
        winner=random.nextInt(3)+1;
        cardOne.setImageResource(R.drawable.cards_empty);
        cardTwo.setImageResource(R.drawable.cards_empty);
        cardThree.setImageResource(R.drawable.cards_empty);
    }
    private void cardPick(int cardId){
        if(winner==1){
            cardOne.setImageResource(R.drawable.cards_win);
            cardTwo.setImageResource(R.drawable.cards_lose);
            cardThree.setImageResource(R.drawable.cards_lose);
        }else if(winner==2){
            cardOne.setImageResource(R.drawable.cards_lose);
            cardTwo.setImageResource(R.drawable.cards_win);
            cardThree.setImageResource(R.drawable.cards_lose);
        }else{
            cardOne.setImageResource(R.drawable.cards_lose);
            cardTwo.setImageResource(R.drawable.cards_lose);
            cardThree.setImageResource(R.drawable.cards_win);
        }
        if(winner==cardId){//WIN!!!
            winLoseDisplay.setText(R.string.youWin);
            amount+=myBet+myBet;
        }else{//LOSE!!!
            winLoseDisplay.setText(R.string.youLose);
            amount-=myBet;
        }
        editor.putInt("carrots",amount);
        amountV.setText(amount+"");
        seekBar.setMax(amount);
        started=false;
    }

}
