package harkorrezun.multigames_clicker;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayDeque;

/**
 * Created by Harkor on 2018-04-04.
 */

public class F3_oppening extends Fragment {
    DatabaseHelper myDb;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.f3_oppening,container,false);

        myDb=new DatabaseHelper(getContext());
        final Button add=view.findViewById(R.id.addOne);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myDb.addNewCard(1,2);
            }
        });
        Button how=view.findViewById(R.id.howMany);
        how.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount=myDb.howMany(1,2);
                Toast.makeText(getContext(),"Your carrots: "+amount,Toast.LENGTH_SHORT).show();
            }
        });

        Button collectionList=view.findViewById(R.id.collectionList);

        collectionList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayDeque<String> arrayDeque=myDb.allCollections();
                Toast.makeText(getContext(),"Collections: "+arrayDeque.size(),Toast.LENGTH_SHORT).show();
                String allCol="";
                for(int i=arrayDeque.size();i>0;i--){
                    allCol+=arrayDeque.poll()+" - ";
                }
                Log.d("Cols",allCol);

            }
        });

        Button firstCol=view.findViewById(R.id.firstCol);
        firstCol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayDeque<Card> arrayDeque=myDb.allFromColection(1);
                String allCard="";
                Toast.makeText(getContext(),"Cards: "+arrayDeque.size(),Toast.LENGTH_SHORT).show();
                for(int i=arrayDeque.size();i>0;i--) {
                    allCard+=arrayDeque.poll().name+", ";
                }
                Log.d("Cards",allCard);

            }
        });


        return view;
    }
}
