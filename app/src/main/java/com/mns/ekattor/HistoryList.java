package com.mns.ekattor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mns.ekattor.model.Keys;

public class HistoryList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] description={"পটভূমি","স্বাধীনতা যুদ্ধ","ভারত-পাকিস্তান যুদ্ধ","পাকিস্তানি বাহিনীর আত্মসমর্পণ ও বিজয়"," আন্তর্জাতিক স্বীকৃতি","নৃশংসতা","বৈদেশিক প্রতিক্রিয়া"};
    int[] img={R.drawable.proto,
            R.drawable.sadhenota,
            R.drawable.varot_pakitan,
            R.drawable.salender,
            R.drawable.international,
            R.drawable.nisontota,
            R.drawable.boydesik};
    ListView listView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_list);
        toolbar=findViewById(R.id.history_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listView=findViewById(R.id.historyList);
        listView.setAdapter(new HistoryAddepter(this,img,description));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent= new Intent(this,HistoryDetails.class);
        intent.putExtra(Keys.HOSTORY_ID,position);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}


class HistoryAddepter extends BaseAdapter {
    private int[] secImg;
    private  String[] des;
    private LayoutInflater layoutInflater;
    private Context context;

    public HistoryAddepter(Context aContext, int[] secImg, String[] des) {
        this.context = aContext;
        this.secImg = secImg;
        this.des=des;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return des.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.history_item, null);
            holder = new ViewHolder();
            holder.noView =  convertView.findViewById(R.id.imgIc);
            holder.dec =  convertView.findViewById(R.id.labl);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.dec.setText(des[position]);
        holder.noView.setImageResource(secImg[position]);
        return convertView;
    }

    static class ViewHolder {
        ImageView noView;
        TextView dec;
    }
}