package com.mns.ekattor.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mns.ekattor.R;

public class DiaryAddepter extends PagerAdapter {
    Context thisContex;
    String[] event;
    LayoutInflater inflater;
    public DiaryAddepter(Context context,String[] str){
        this.thisContex=context;
        this.event=str;
    }

    @Override
    public int getCount() {
        return event.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(ScrollView)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater= (LayoutInflater) thisContex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.pager_item,container,false);
        TextView body=v.findViewById(R.id.diary_body);
        body.setText(event[position]);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ScrollView)object);
    }
}
