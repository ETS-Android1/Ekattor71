package com.mns.ekattor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAddapter  extends BaseAdapter{

    private Context mContext;

    private final String[] string;
    private final int[] Imageid;

    public GridAddapter(Context c, String[] string,int[] ImageId ) {
        mContext = c;

        this.Imageid = ImageId;
        this.string = string;
    }

    @Override
    public int getCount() {
        return string.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.custom_grid,null);
            TextView label= grid.findViewById(R.id.gridview_text);
            ImageView img=  grid.findViewById(R.id.gridview_image);
            label.setText(string[i]);
            img.setImageResource(Imageid[i]);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else{
            grid=convertView;
        }
        return grid;
    }
}
