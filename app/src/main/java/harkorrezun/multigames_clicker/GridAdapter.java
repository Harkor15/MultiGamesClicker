package harkorrezun.multigames_clicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private int images[];
    private String names[];
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context, int images[], String names[]){
    this.context=context;
    this.images=images;
    this.names=names;
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
            gridView=inflater.inflate(R.layout.one_collection,null);
        }
        ImageView imageView=gridView.findViewById(R.id.colImage);
        TextView textView=gridView.findViewById(R.id.colName);
        imageView.setImageResource(images[i]);
        textView.setText(names[i]);
        return gridView;
    }
}
