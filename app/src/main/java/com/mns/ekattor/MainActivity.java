package com.mns.ekattor;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity{
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
    CoordinatorLayout rootLayoutAndroid;
    GridView gridView;

    public static String[] gridViewStrings = {
            " ইতিহাস ",
            "৭ বীরশ্রেষ্ঠ",
            "১১ সেক্টর",
            "গণকবর",
            "জেলাভিত্তিক মুক্তিযোদ্ধা",
            "যুদ্ধদলিল",
            "৭১ কালপুঞ্জিকা",
            "ফটোগ্যালারি",
            "আমাদের কথা",

    };

    public static int[] gridViewImages = {

            R.drawable.gono,
            R.drawable.bir7,
            R.drawable.sector11,
            R.drawable.bodhi,
            R.drawable.frigter_list,
            R.drawable.ref,
            R.drawable.cal,
            R.drawable.pic_g,
            R.drawable.app_luncher
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gridView=findViewById(R.id.grid);
        gridView.setAdapter(new GridAddapter(this,gridViewStrings,gridViewImages));

       /** gridView.setOnItemClickListener(this);*/
       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               if(position==0){
                   Intent intent =new Intent(getApplicationContext(),HistoryList.class);
                   startActivity(intent);
               }
               else if(position==1){
                   Intent intent =new Intent(getApplicationContext(),Birshrastho.class);
                   startActivity(intent);
               }
               else if(position==2){
                   Intent intent =new Intent(getApplicationContext(),SectorList.class);
                   startActivity(intent);
               }
               else if(position==3){
                   Intent intent =new Intent(getApplicationContext(),Gonokobor.class);
                   startActivity(intent);
               }
               else if(position==4){
                   Intent intent =new Intent(getApplicationContext(),DistrictList.class);
                   startActivity(intent);
               }
               else if(position==5){
                   Intent intent =new Intent(getApplicationContext(),Document.class);
                   startActivity(intent);
               }
               else if(position==6){
                   Intent intent =new Intent(getApplicationContext(),CalMonth.class);
                   startActivity(intent);
               }
               else if(position==7){
                   Intent intent =new Intent(getApplicationContext(),PhotoGallaryGlide.class);
                   startActivity(intent);
               }
               else if(position==8){
                   Intent intent =new Intent(getApplicationContext(),AboutApp.class);
                   startActivity(intent);
               }
               else{
                   Toast tost= Toast.makeText(getApplicationContext(),"This is "+gridViewStrings[position],Toast.LENGTH_SHORT);
                   tost.show();
               }
           }
       });
        initInstances();
    }
    private void initInstances() {
       rootLayoutAndroid =  findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayoutAndroid =  findViewById(R.id.collapsing_toolbar_android_layout);
        collapsingToolbarLayoutAndroid.setTitle("একাত্তোর ৭১");
    }
}
