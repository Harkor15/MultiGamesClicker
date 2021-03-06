package harkorrezun.multigames_clicker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Harkor on 2018-04-04.
 */

public class F4collectionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_f4_collection,container,false);
        ConstraintLayout c1=view.findViewById(R.id.cat1);
        ConstraintLayout c2=view.findViewById(R.id.cat2);
        ConstraintLayout c3=view.findViewById(R.id.cat3);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(1,getResources().getString(R.string.football));
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(2,getResources().getString(R.string.rl));
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                open(3,getResources().getString(R.string.csgo));
            }
        });

        return view;
    }
    public void open(int id,String name){
        FragmentManager fm=getFragmentManager();
        FragmentTransaction fragmentTransaction;
        Fragment fragment = new F4collectionL2Fragment();
        Bundle bundle=new Bundle();
        bundle.putInt("category",id);
        bundle.putString("categoryName",name);
        fragment.setArguments(bundle);
        fragmentTransaction=fm.beginTransaction();
        fragmentTransaction.replace(R.id.rightContent,fragment);
        fragmentTransaction.commit();
    }
}
