package com.mns.ekattor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.mns.ekattor.model.Keys;

public class CalMonth extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] month={
            "January",
            "February",
            "March",
            "April",
            "May",
            "Jun",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };
    private int[] imgTd={
            R.drawable.cal1_jan,
            R.drawable.cal1_feb,
            R.drawable.cal1_mar,
            R.drawable.cal1_apr,
            R.drawable.cal1_may,
            R.drawable.cal1_jun,
            R.drawable.cal1_jul,
            R.drawable.cal_aug,
            R.drawable.cal1_sep,
            R.drawable.cal1_oct,
            R.drawable.cal1_nov,
            R.drawable.cal1_dec
    };
    GridView gridView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_month);
        gridView=findViewById(R.id.monthGrid);
        gridView.setAdapter(new GridAddapter(this,month,imgTd));
        gridView.setOnItemClickListener(this);
        toolbar=findViewById(R.id.cal_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,Date.class);
        intent.putExtra(Keys.MONTH,position);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
