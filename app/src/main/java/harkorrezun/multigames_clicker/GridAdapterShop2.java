package harkorrezun.multigames_clicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapterShop2 extends BaseAdapter {
    private Context context;
    private String names[];
    private int images[];
    private int prices[];
    private LayoutInflater inflater;

    public GridAdapterShop2(Context context, String names1[],int images1[],int prices1[]){
        this.context=context;
        this.names=names1;
        this.images=images1;
        this.prices=prices1;

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
            gridView=inflater.inflate(R.layout.one_collection_shop,null);
        }
        TextView name=gridView.findViewById(R.id.shop2_name);
        ImageView image=gridView.findViewById(R.id.shop2_image);
        TextView price=gridView.findViewById(R.id.shop2_price);
        name.setText(names[i]);
        image.setImageResource(images[i]);
        price.setText(prices[i]+"");

        return gridView;
    }
}
