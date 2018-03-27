package harkorrezun.multigames_clicker;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Harkor on 2018-03-26.
 */

public class F1_clicker extends Fragment {

    int amount=0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f1_clicker,container,false);
        return view;
    }


    public void pianoClick(View view,int button){
        Toast.makeText(getActivity(),"Butt: "+button,Toast.LENGTH_SHORT).show();
    }
}
