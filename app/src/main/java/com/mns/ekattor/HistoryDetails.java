package com.mns.ekattor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;

import com.mns.ekattor.model.Keys;

public class HistoryDetails extends AppCompatActivity {
    WebView textView;
    Toolbar toolbar;
    String[] description={"পটভূমি","স্বাধীনতা যুদ্ধ","ভারত-পাকিস্তান যুদ্ধ","পাকিস্তানি বাহিনীর আত্মসমর্পণ ও বিজয়"," আন্তর্জাতিক স্বীকৃতি","নৃশংসতা","বৈদেশিক প্রতিক্রিয়া"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detils);
        textView=findViewById(R.id.history_body);
        toolbar=findViewById(R.id.historyDetails_toolbar);
        Intent intent=getIntent();
        int id=intent.getIntExtra(Keys.HOSTORY_ID,0);
        toolbar.setTitle(description[id]);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        switch (id){
            case 0:
                textView.loadData(Keys.poto , "text/html; charset=UTF-8", null);
                break;
            case 1:
                textView.loadData(Keys.sadhinita , "text/html; charset=UTF-8", null);
                break;
            case 2:
                textView.loadData(Keys.india_pak , "text/html; charset=UTF-8", null);
                break;
            case 3:
                textView.loadData(Keys.selender , "text/html; charset=UTF-8", null);
                break;
            case 4:
                textView.loadData(Keys.sikriti , "text/html; charset=UTF-8", null);
                break;
            case 5:
                textView.loadData(Keys.gonohotta , "text/html; charset=UTF-8", null);
                break;
            case 6:
                textView.loadData(Keys.international , "text/html; charset=UTF-8", null);
                break;
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
