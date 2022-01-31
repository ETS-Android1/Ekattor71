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

public class SectorList extends AppCompatActivity {

    String[] description={"চট্টগ্রাম ও পার্বত্য চট্টগ্রাম থেকে ফেনী নদী পর্যন্ত",
            "নোয়াখালী জেলা, কুমিল্লা জেলার আখাউড়া - ভৈরব রেললাইন পর্যন্ত এবং ফরিদপুর ও ঢাকার অংশবিশেষ",
            "সিলেট জেলার হবিগঞ্জ মহকুমা, কিশোরগঞ্জ মহকুমা, আখাউড়া-ভৈরব রেললাইন থেকে উত্তর-পূর্ব দিকে কুমিল্লা ও ঢাকা জেলার অংশবিশেষ ",
            "সিলেট জেলার পূর্বাঞ্চল এবং খোয়াই-শায়েস্তাগঞ্জ রেললাইন বাদে পূর্ব ও উত্তর দিকে সিলেট-ডাউকি সড়ক পর্যন্ত ",
            "সিলেট-ডাউকি সড়ক থেকে সিলেট জেলার সমগ্র উত্তর ও পশ্চিমাঞ্চল ",
            "সমগ্র রংপুর জেলা এবং দিনাজপুর জেলার ঠাকুরগাঁও মহকুমা ",
            "দিনাজপুর জেলার দক্ষিণাঞ্চল, বগুড়া, রাজশাহী এবং পাবনা জেলা ",
            "সমগ্র কুষ্টিয়া ও যশোর জেলা, ফরিদপুরের অধিকাংশ এলাকা এবং দৌলতপুর-সাতক্ষীরা সড়কের উত্তরাংশ ",
            "দৌলতপুর-সাতক্ষীরা সড়ক থেকে খুলনার দক্ষিণাঞ্চল এবং সমগ্র বরিশাল ও পটুয়াখালী জেলা ",
            "কোনো আঞ্চলিক সীমানা নেই। ৫১৫ জন নৌবাহিনীর কমান্ডো অধীনস্হ।",
            "কিশোরগঞ্জ মহকুমা বাদে সমগ্র ময়মনসিংহ ও টাঙ্গাইল জেলা এবং নগরবাড়ি-আরিচা থকে ফুলছড়ি-বাহাদুরাবাদ পর্যন্ত যমুনা নদী ও তীর অঞ্চল"};
    int[] img={R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven,
            R.drawable.eight,
            R.drawable.nine,
            R.drawable.ten,
            R.drawable.one_copy};
    ListView listView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_list);
        listView=findViewById(R.id.mainList);
        toolbar=findViewById(R.id.sector_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        listView.setAdapter(new CustomAddepter(this,img,description));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                intent=new Intent(getApplicationContext(),Sector1.class);
                intent.putExtra("POS",position);
                startActivity(intent);

                /**if(position==0){
                        intent=new Intent(getApplicationContext(),Sector1.class);
                        startActivity(intent);
                }

                else{
                    Toast tst=Toast.makeText(getApplicationContext(),"Sector"+position+"is Clicked",Toast.LENGTH_SHORT);
                    tst.show();
                }**/

            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

class CustomAddepter extends BaseAdapter{
    private int[] secImg;
    private  String[] des;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomAddepter(Context aContext, int[] secImg, String[] des) {
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
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.noView =  convertView.findViewById(R.id.imageView_no);
            holder.dec =  convertView.findViewById(R.id.textView_dec);
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