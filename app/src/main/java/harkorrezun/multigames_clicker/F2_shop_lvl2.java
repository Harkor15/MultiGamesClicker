package harkorrezun.multigames_clicker;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String mess=getResources().getString(R.string.wannaBuy);
            new AlertDialog.Builder(getContext())
                    .setTitle(R.string.buy)
                    .setMessage(mess+" "+prices[i]+"?")
                    .setNegativeButton(R.string.no,null)
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            FragmentManager fragmentManager=getFragmentManager();
                            Fragment fragment=new F2_shop_opening();
                            //Bundle bundle=new Bundle();
                            //bundle.putInt("",);
                            //fragment.setArguments(bundle);
                            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.rightContent,fragment);
                            fragmentTransaction.commit();


                            //TODO: take money and give card;

                        }
                    }).create().show();

            }
        });
        return view;
    }


}
