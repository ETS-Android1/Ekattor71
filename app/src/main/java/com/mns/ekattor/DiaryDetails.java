package com.mns.ekattor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mns.ekattor.model.DiaryAddepter;
import com.mns.ekattor.model.Keys;

public class DiaryDetails extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private String[][] dialy;
   // TextView txtDiary;
    Toolbar toolbar;
    ViewPager viewPager;
    int month;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_details);
        toolbar=findViewById(R.id.diary_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Intent intent=getIntent();
         month=intent.getIntExtra(Keys.MONTH,0);
        int date=intent.getIntExtra(Keys.DATE,0);
        viewPager=findViewById(R.id.pager);
        dialy= new String[][]{getResources().getStringArray(R.array.jan),
                getResources().getStringArray(R.array.feb),
                getResources().getStringArray(R.array.mar),
                getResources().getStringArray(R.array.apr),
                getResources().getStringArray(R.array.may),
                getResources().getStringArray(R.array.jul),
                getResources().getStringArray(R.array.jul),
                getResources().getStringArray(R.array.aug),
                getResources().getStringArray(R.array.sep),
                getResources().getStringArray(R.array.oct),
                getResources().getStringArray(R.array.nov),
                getResources().getStringArray(R.array.dec)};
        viewPager.setAdapter(new DiaryAddepter(this,dialy[month]));
        viewPager.setCurrentItem(date,false);
        setToolbar(date);
        viewPager.addOnPageChangeListener(this);
     //   txtDiary=findViewById(R.id.diary_body);
    //    txtDiary.setText(dialy[month][date]);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
        setToolbar(i);
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    void setToolbar(int date){
        String st=(date+1)+" "+Keys.getBanlabonth(month)+" ১৯৭১ ";
        toolbar.setTitle(st);
    }
}
