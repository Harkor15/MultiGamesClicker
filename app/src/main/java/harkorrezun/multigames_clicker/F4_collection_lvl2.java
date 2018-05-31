package harkorrezun.multigames_clicker;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class F4_collection_lvl2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.f4_collection_lvl2,container,false);
        Bundle arguments = getArguments();
        int category = arguments.getInt("category");
        //oast.makeText(getContext(),"Category: "+category,Toast.LENGTH_SHORT).show(); ///////////////////////////////ID OF CATEGORY!
        TextView catName=view.findViewById(R.id.categoryName);
        switch (category){
            case 1:  catName.setText("c1"); break;
            case 2:  catName.setText("c2"); break;
            case 3:  catName.setText("c3"); break;
            case 4:  catName.setText("c4"); break;
            case 5:  catName.setText("c5"); break;
            default:  catName.setText("Def error");
        }
        // TEMPORARY DATA FOR TESTS
        String cars[]={"asdf","sdfasdg","sdfa343dg","s3asdg","sdasfsdg","sdfasdg","sdfa343dg","s3asdg","sdasfsdg","sdfasdg","sdfa343dg","s3asdg","sdasfsdg"};
        int images[]={R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar,R.drawable.mar};


        GridView gridView=view.findViewById(R.id.gridViewLVL2);

        GridAdapterLVL2 gridAdapter=new GridAdapterLVL2(getContext(),images,cars);
        gridView.setNumColumns(3);
        gridView.setAdapter(gridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(),"Dawać kolekcje z numerem: "+i,Toast.LENGTH_SHORT).show();
                int collectionID=i; //TODO: GET COLLECTION ID FROM I!
                enterCollection(collectionID);


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


}
