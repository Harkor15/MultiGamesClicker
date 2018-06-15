package harkorrezun.multigames_clicker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayDeque;

public class F4collectionL3Fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_f4_collection_l3,container,false);
        Bundle arguments = getArguments();
        int collection = arguments.getInt("collection");//          TODO: ID OF COLECTION TO CREATE VIEW
        DatabaseHelper db=new DatabaseHelper(getContext());
        db.getCollectionName(collection);
        TextView textView=view.findViewById(R.id.collectionName);
        textView.setText(db.getCollectionName(collection));
        ArrayDeque<Card> arrayDeque=db.allFromColection(collection);
        int length=arrayDeque.size();
        String names[]=new String[length];
        int images[]=new int[length];
        int amount[]=new int[length];
        for(int i=0;i<length;i++){
            Card card=arrayDeque.pollFirst();
            names[i]=card.name;
            images[i]=card.image;
            amount[i]=card.amount;
        }
        GridView gridView=view.findViewById(R.id.gridViewLVL3);
        gridView.setNumColumns(5);
        GridL3Adapter gridAdapterLVL3=new GridL3Adapter(getContext(),names,images,amount);
        gridView.setAdapter(gridAdapterLVL3);
        return view;
    }
}
