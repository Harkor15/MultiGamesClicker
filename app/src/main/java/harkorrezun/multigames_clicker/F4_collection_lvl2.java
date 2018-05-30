package harkorrezun.multigames_clicker;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class F4_collection_lvl2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.f4_collection_lvl2,container,false);
        Bundle arguments = getArguments();
        int category = arguments.getInt("category");
        Toast.makeText(getContext(),"Category: "+category,Toast.LENGTH_SHORT).show(); ///////////////////////////////ID OF CATEGORY!
        TextView catName=view.findViewById(R.id.categoryName);
        catName.setText("Category nr: "+category);
        return view;
    }
}
