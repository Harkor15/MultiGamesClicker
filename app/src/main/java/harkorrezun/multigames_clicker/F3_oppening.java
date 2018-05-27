package harkorrezun.multigames_clicker;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
        Button add=view.findViewById(R.id.addOne);
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


        return view;
    }
}
