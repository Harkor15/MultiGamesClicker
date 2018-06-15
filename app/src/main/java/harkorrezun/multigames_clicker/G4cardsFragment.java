package harkorrezun.multigames_clicker;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Harkor on 2018-04-04.
 */

public class G4cardsFragment extends Fragment {
    int amount;
    SeekBar seekBar;
    TextView amountV,seekNumber;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_g4_cards,container,false);
        amountV=view.findViewById(R.id.amount);
        seekBar=view.findViewById(R.id.seekBar);
        seekNumber=view.findViewById(R.id.seekNumber);
        sharedPreferences=getContext().getSharedPreferences("harkor.multigamesclicker", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        amount=sharedPreferences.getInt("carrots",0);
        amountV.setText(amount+"");
        seekBar.setMax(amount);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            seekNumber.setText(seekBar.getProgress()+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        return view;
    }


}
