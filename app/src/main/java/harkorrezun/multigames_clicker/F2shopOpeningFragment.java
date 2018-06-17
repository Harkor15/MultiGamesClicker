package harkorrezun.multigames_clicker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class F2shopOpeningFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_f2_shop_opening,container,false);
        TextView name=view.findViewById(R.id.newCardName);
        ImageView image=view.findViewById(R.id.newCardImage);
        Bundle arguments=getArguments();
        final int collectionId=arguments.getInt("collection");
        Randomizer randomizer=new Randomizer(getContext());
        int result=randomizer.opening(collectionId);
        final DatabaseHelper db=new DatabaseHelper(getContext());
        Card card=db.getCard(result,collectionId);
        db.addNewCard(collectionId,result);
        name.setText(card.name+"");
        Drawable drawable=new Drawable();
        image.setImageResource(drawable.getCardImage(collectionId,result));
        Button skip_ok=view.findViewById(R.id.skip_ok);
        skip_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                Fragment fragment=new F2shopFragment();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rightContent,fragment,"");
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}
