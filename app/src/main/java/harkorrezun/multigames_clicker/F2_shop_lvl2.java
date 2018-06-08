package harkorrezun.multigames_clicker;





import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Locale;


public class F2_shop_lvl2 extends Fragment {
    GridView gridView;

    //Tmp
    //String names[]={"abc","cba"};
    //int images[]={R.drawable.mar,R.drawable.mar};
    //int prices[]={100,150};







    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.f2_shop_lvl2, container, false);
        gridView=view.findViewById(R.id.shop2GridView);



        Bundle arguments = getArguments();
        int category = arguments.getInt("idCategory");
        DatabaseHelper databaseHelper=new DatabaseHelper(getContext());
        ArrayDeque<Collection> arrayDeque=databaseHelper.allCollectionsOfCategory(category);
        int size=arrayDeque.size();
        String names[]=new String[size];
        int images[]=new int[size];
        int prices[]=new int[size];
        for(int i=0;i<size;i++){
            Collection col=arrayDeque.pollFirst();
            names[i]=col.getName();
            images[i]=col.getImage();
            prices[i]=col.getPrice();
        }

        //TMP:
        Log.d("lmage",""+images[0]);
        final int prices2[]=prices;

        GridAdapterShop2 adapter=new GridAdapterShop2(getContext(),names,images,prices);
        gridView.setAdapter(adapter);

        gridView.setNumColumns(4);
        TextView textView=view.findViewById(R.id.categoryName);
        textView.setText("Category: "+category);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String mess=getResources().getString(R.string.wannaBuy);
            new AlertDialog.Builder(getContext())
                    .setTitle(R.string.buy)
                    .setMessage(mess+" "+prices2[i]+"?")
                    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            hideBar();
                        }
                    })
                    .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            hideBar();
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
                    })
                    .setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialogInterface) {
                            hideBar();
                        }
                    }).create().show();

            hideBar();

            }
        });
        return view;
    }

    private void hideBar(){
        Activity activity=getActivity();
        View decorView = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                            | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
