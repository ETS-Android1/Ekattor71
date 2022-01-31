package com.mns.ekattor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Sector1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        int pos=intent.getIntExtra("POS",0);
        switch (pos){
            case 0:
                setContentView(R.layout.sector1);
                break;
            case 1:
                setContentView(R.layout.sec_2);
                break;
            case 2:
                setContentView(R.layout.sec_3);
                break;
            case 3:
                setContentView(R.layout.sec_4);
                break;
            case 4:
                setContentView(R.layout.sec_5);
                break;
            case 5:
                setContentView(R.layout.sec_6);
                break;
            case 6:
                setContentView(R.layout.sec_7);
                break;
            case 7:
                setContentView(R.layout.sec_8);
                break;
            case 8:
                setContentView(R.layout.sec_9);
                break;
            case 9:
                setContentView(R.layout.sec_10);
                break;
            case 10:
                setContentView(R.layout.sec_11);
                break;
            default:
                 setContentView(R.layout.sector1);
                 break;

        }
    }
}
