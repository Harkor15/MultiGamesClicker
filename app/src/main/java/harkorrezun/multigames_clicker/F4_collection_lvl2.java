package harkorrezun.multigames_clicker;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayDeque;

public class F4_collection_lvl2 extends Fragment {
    ArrayDeque<Collection>collectionArrayDeque;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.f4_collection_lvl2,container,false);
        Bundle arguments = getArguments();
        int category = arguments.getInt("category");
        String categoryName=arguments.getString("categoryName");
        TextView catName=view.findViewById(R.id.categoryName);
        catName.setText(categoryName);
        DatabaseHelper databaseHelper=new DatabaseHelper(getContext());
        final ArrayDeque<Collection> arrayDeque=databaseHelper.allCollectionsOfCategory(category);
        collectionArrayDeque=arrayDeque.clone();
        int size=arrayDeque.size();
        String names[]=new String[size];
        int images[]=new int[size];
        for(int i=0;i<size;i++){
            Collection col=arrayDeque.pollFirst();
            names[i]=col.getName();
            images[i]=col.getImage();
        }
        GridView gridView=view.findViewById(R.id.gridViewLVL2);
        GridAdapterLVL2 gridAdapter=new GridAdapterLVL2(getContext(),images,names);
        gridView.setNumColumns(3);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                enterCollection(idCollecionClicked(i));
            }
        });
        return view;
    }

    private void enterCollection(int colId){
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction;
        Fragment fragment=new F4_collection_lvl3();
        Bundle bundle=new Bundle();
        bundle.putInt("collection",colId);
        fragment.setArguments(bundle);
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rightContent,fragment);
        fragmentTransaction.commit();
    }
    private int idCollecionClicked(int clickID){
        for(int j=0;j<clickID;j++){
            collectionArrayDeque.removeFirst();

        }
        Collection coll=collectionArrayDeque.pollFirst();
        return coll.getId();
    }

}
