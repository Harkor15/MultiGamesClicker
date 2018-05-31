package harkorrezun.multigames_clicker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapterLVL3 extends BaseAdapter{

    private String names[];
    private int images[];
    private int amount[];
    private Context context;
    private LayoutInflater inflater;

    public GridAdapterLVL3(Context context,String names[], int images[],int amount[]){
        this.context=context;
        this.names=names;
        this.images=images;
        this.amount=amount;
    }


    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View gridView=view;
        if(view==null){
            inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView=inflater.inflate(R.layout.one_card,null);
        }



        ImageView imageView=gridView.findViewById(R.id.cardImage);
        TextView textView=gridView.findViewById(R.id.cardName);
        TextView amountView=gridView.findViewById(R.id.cardAmount);
        imageView.setImageResource(images[i]);
        textView.setText(names[i]);
        amountView.setText(amount[i]+"");

        return gridView;
    }
}
