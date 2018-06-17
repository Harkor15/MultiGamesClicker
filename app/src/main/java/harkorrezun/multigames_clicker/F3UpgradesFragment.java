package harkorrezun.multigames_clicker;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Harkor on 2018-04-04.
 */

public class F3UpgradesFragment extends Fragment {
    private int pPiano;
    private int multiplayPiano;
    private SharedPreferences sharedPreferences;
    private int carrotAmount;
    private SharedPreferences.Editor editor;
    private TextView pianoPrice;
    private TextView tapPrice;
    private TextView amount;
    private Context context;
    private int pTap;
    private int multiplayTap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_f3_upgrades,container,false);
        context=getContext();
        ImageView piano=view.findViewById(R.id.upgradePiano);
        ImageView tap=view.findViewById(R.id.upgradeTap);
        pianoPrice=view.findViewById(R.id.upgradePianoPrice);
        tapPrice=view.findViewById(R.id.upgradeTapPrice);
        amount=view.findViewById(R.id.carrotAmount);
        sharedPreferences=getContext().getSharedPreferences("harkor.multigamesclicker", Context.MODE_PRIVATE);
        multiplayTap=sharedPreferences.getInt("multiplayCarrot",1);
        multiplayPiano=sharedPreferences.getInt("multiplay",1);
        carrotAmount=sharedPreferences.getInt("carrots",0);
        editor=sharedPreferences.edit();
        amount.setText(""+carrotAmount);
        double pricePiano=Math.pow(3,lvl(multiplayPiano));
        pPiano=(int)pricePiano*2500;
        double priceTap=Math.pow(3,lvl(multiplayTap));
        pTap=(int)priceTap*2000;
        tapPrice.setText(pTap+"");
        pianoPrice.setText(pPiano+"");
        piano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyPiano();
            }
        });
        tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyCarrot();
            }
        });

        return view;
    }
    private int lvl(int multiplay){
        if(multiplay==1){
            return 0;
        }else if (multiplay==2){
            return 1;
        }else {
            return (int) Math.sqrt(multiplay);
        }
    }
    private void buyPiano(){
        if(carrotAmount<pPiano){
            Toast.makeText(context,R.string.noMoney,Toast.LENGTH_SHORT).show();
        }else{
            carrotAmount-=pPiano;
            editor.putInt("carrots",carrotAmount);
            amount.setText(carrotAmount+"");
            multiplayPiano*=2;
            editor.putInt("multiplay",multiplayPiano);
            pPiano*=3;
            pianoPrice.setText(pPiano+"");
            editor.commit();
            Toast.makeText(context,R.string.upgraded,Toast.LENGTH_SHORT).show();

        }
    }
    private void buyCarrot(){
        if(carrotAmount<pTap){
            Toast.makeText(context,R.string.noMoney,Toast.LENGTH_SHORT).show();
        }else {
            carrotAmount -= pTap;
            editor.putInt("carrots", carrotAmount);
            amount.setText(carrotAmount + "");
            multiplayTap *= 2;
            editor.putInt("multiplayCarrot", multiplayTap);
            pTap *= 3;
            tapPrice.setText(pTap + "");
            editor.commit();
            Toast.makeText(context, R.string.upgraded, Toast.LENGTH_SHORT).show();
        }
    }


}
