package harkorrezun.multigames_clicker;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Harkor on 2018-03-22.
 */


public class MenuFragment extends Fragment{

    MenuFragmentListener activityComander;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;



    public interface MenuFragmentListener{
         void changeContent(int fragNr);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            activityComander=(MenuFragmentListener)activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.menu_fragment,container,false);

        btn1= view.findViewById(R.id.clicker);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComander.changeContent(1);
            }
        });

        btn2=view.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComander.changeContent(2);
            }
        });
        btn3=view.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComander.changeContent(3);
            }
        });
        btn4=view.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComander.changeContent(4);
            }
        });


        return view;
    }




}
