package harkorrezun.multigames_clicker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class F2_shop_opening extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f2_shop_opening,container,false);
        TextView name=view.findViewById(R.id.newCardName);
        ImageView image=view.findViewById(R.id.newCardImage);


        Randomizer randomizer=new Randomizer(getContext());
        int result=randomizer.opening(2); //TODO: zmiana id kolekcji

        //TMP:
        name.setText("You won card: "+result);

        return view;
    }
}
