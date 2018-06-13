package harkorrezun.multigames_clicker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class F2_shop_opening extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.f2_shop_opening,container,false);
        TextView name=view.findViewById(R.id.newCardName);
        ImageView image=view.findViewById(R.id.newCardImage);
        Bundle arguments=getArguments();
        int collectionId=arguments.getInt("collection");
        Randomizer randomizer=new Randomizer(getContext());
        int result=randomizer.opening(collectionId);
        DatabaseHelper db=new DatabaseHelper(getContext());
        Card card=db.getCard(result,collectionId);
        db.addNewCard(collectionId,result);
        name.setText(card.name+"");
        image.setImageResource(card.image);

        return view;
    }
}
