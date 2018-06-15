package harkorrezun.multigames_clicker;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Harkor on 2018-03-22.
 */

public class MenuFragment extends Fragment{
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    MenuFragmentListener activityComander;
    public interface MenuFragmentListener{
         void changeContent(int fragNr);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityComander=(MenuFragmentListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu,container,false);
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
        btn5=view.findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComander.changeContent(5);
            }
        });
        btn6=view.findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComander.changeContent(6);
            }
        });
        return view;
    }




}
