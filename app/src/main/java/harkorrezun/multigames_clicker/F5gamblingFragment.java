package harkorrezun.multigames_clicker;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * Created by Harkor on 2018-04-04.
 */

public class F5gamblingFragment extends Fragment {
    ImageView rulette;
    ImageView sapper;
    ImageView crash;
    ImageView cards;
    GamblingFragmentListener activityComanderr;
    public interface GamblingFragmentListener{
        void toGambling(int gID);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            activityComanderr=(GamblingFragmentListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_f5_gambling,container,false);
        rulette=view.findViewById(R.id.rulette);
        rulette.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComanderr.toGambling(1);
            }
        });
        sapper=view.findViewById(R.id.saper);
        sapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComanderr.toGambling(2);
            }
        });
        crash=view.findViewById(R.id.crash);
        crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComanderr.toGambling(3);
            }
        });
        cards=view.findViewById(R.id.cards);
        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityComanderr.toGambling(4);
            }
        });
        return view;
    }
}
