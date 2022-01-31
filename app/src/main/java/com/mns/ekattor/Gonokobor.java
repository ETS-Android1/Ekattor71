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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mns.ekattor.model.Keys;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class Gonokobor extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    Toolbar toolbar;
    private String[] url={
            "https://i.imgur.com/HSZpTAgt.jpg",
            "https://i.imgur.com/3qE3fXR.jpg",
            "https://i.imgur.com/KuBCLkFt.jpg",
            "https://i.imgur.com/wdGWHyot.jpg",
            "https://i.imgur.com/vb7SG8it.jpg",
            "https://i.imgur.com/3xvuVAv.jpg",
            "https://i.imgur.com/wFy3tSbt.jpg",
            "https://i.imgur.com/Pl0rvENt.jpg",
            "https://i.imgur.com/pAqh4qxt.jpg",
            "https://i.imgur.com/g7ohvXZt.jpg",
            "https://i.imgur.com/9kkWCmSt.jpg",
            "https://i.imgur.com/PL3JNSdt.jpg",
            "https://i.imgur.com/wQKGEq0t.jpg",
            "https://i.imgur.com/H3bQu5xt.jpg",
            "https://i.imgur.com/Aup23rbt.jpg",
            "https://i.imgur.com/9r3ksAQt.jpg",
            "https://i.imgur.com/PeMeEnet.jpg",
            "https://i.imgur.com/64hFVYRt.jpg",
            "https://i.imgur.com/FafU6xVt.jpg",
            "https://i.imgur.com/O8FVIM0t.jpg"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gonokobor);
        listView=findViewById(R.id.gono_list);
        toolbar=findViewById(R.id.gonoList_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listView.setAdapter(new GonoAddepter(this,url,getResources().getStringArray(R.array.gonokobor)));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent= new Intent(this,GonokobrDetiels.class);
        intent.putExtra(Keys.GONOKYE,position);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
class GonoAddepter extends BaseAdapter {
    private String[] secImg;
    private  String[] des;
    private LayoutInflater layoutInflater;
    private Context context;

    public GonoAddepter(Context aContext, String[] secImg, String[] des) {
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
        Glide.with(context).load(secImg[position])
                .thumbnail(0.5f)
                .transition(withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.noView);
        return convertView;
    }

    static class ViewHolder {
        ImageView noView;
        TextView dec;
    }
}
