package com.mns.ekattor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class Birshrastho extends AppCompatActivity implements View.OnClickListener {
    CardView moti,jang,ruhul,hamid,rouf,nur,kaml;
    public  static final String KEY="name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birshrastho);
        moti=findViewById(R.id.bir1);
        hamid=findViewById(R.id.bir2);
        kaml=findViewById(R.id.bir3);
        ruhul=findViewById(R.id.bir4);
        nur=findViewById(R.id.bir5);
        rouf=findViewById(R.id.bir6);
        jang=findViewById(R.id.bir7);

        moti.setOnClickListener(this);
        hamid.setOnClickListener(this);
        kaml.setOnClickListener(this);
        ruhul.setOnClickListener(this);
        nur.setOnClickListener(this);
        rouf.setOnClickListener(this);
        jang.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        intent=new Intent(this,BirDetails.class);
        switch (v.getId()){
            case R.id.bir1:
                intent.putExtra(KEY,1);
                break;
            case R.id.bir2:
                intent.putExtra(KEY,2);
                break;
            case R.id.bir3:
                intent.putExtra(KEY,3);
                break;
            case R.id.bir4:
                intent.putExtra(KEY,4);
                break;
            case R.id.bir5:
                intent.putExtra(KEY,5);
                break;
            case R.id.bir6:
                intent.putExtra(KEY,6);
                break;
            case R.id.bir7:
                intent.putExtra(KEY,7);
                break;
             default:
                    intent.putExtra(KEY,1);
                    break;

        }
        startActivity(intent);
    }
}
