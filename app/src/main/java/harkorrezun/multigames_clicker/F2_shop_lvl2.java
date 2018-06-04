package harkorrezun.multigames_clicker;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;


public class F2_shop_lvl2 extends Fragment {
    GridView gridView;

    //Tmp
    String names[]={"abc","cba"};
    int images[]={R.drawable.mar,R.drawable.mar};
    int prices[]={100,150};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.f2_shop_lvl2, container, false);
        gridView=view.findViewById(R.id.shop2GridView);
        GridAdapterShop2 adapter=new GridAdapterShop2(getContext(),names,images,prices);
        gridView.setAdapter(adapter);
        Bundle arguments = getArguments();
        int category = arguments.getInt("idCategory");
        gridView.setNumColumns(4);
        TextView textView=view.findViewById(R.id.categoryName);
        textView.setText("Category: "+category);
        return view;
    }


}
