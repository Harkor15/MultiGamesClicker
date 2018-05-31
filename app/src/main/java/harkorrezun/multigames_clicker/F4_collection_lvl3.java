package harkorrezun.multigames_clicker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

public class F4_collection_lvl3 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.f4_collection_lvl3,container,false);
        Bundle arguments = getArguments();
        //int collection = arguments.getInt("collection");//          TODO: ID OF COLECTION TO CREATE VIEW

        TextView textView=view.findViewById(R.id.colName);
        //textView.setText("Colection name"); //TODO: Set collection name

        // TEMPORARY DATA FOR TESTS
        String names[]={"asdf","sdfasdg","sdfa343dg","s3asdg","sdasfsdg","sdfasdg","sdfa343dg","s3asdg","sdasfsdg","sdfasdg","sdfa343dg","s3asdg","sdasfsdg"};
        int images[]={R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar};
        int amount[]={43,45,67,456,5675,756,56,5,67,0,44,236,34};

        GridView gridView=view.findViewById(R.id.gridViewLVL3);
        gridView.setNumColumns(5);
        GridAdapterLVL3 gridAdapterLVL3=new GridAdapterLVL3(getContext(),names,images,amount);
        gridView.setAdapter(gridAdapterLVL3);

        return view;
    }
}
