package com.mns.ekattor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class BirDetails extends AppCompatActivity {
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayoutAndroid;
    CoordinatorLayout rootLayoutAndroid;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        int id=intent.getIntExtra(Birshrastho.KEY,1);
        switch (id){
            case 1:
                name="বীরশ্রেষ্ঠ মতিউর রহমান";
                setContentView(R.layout.bir_motiur);
                break;
            case 2:
                name="বীরশ্রেষ্ঠ হামিদুর রহমান";
                setContentView(R.layout.bir_hamidur);
                break;
            case 3:
                name="বীরশ্রেষ্ঠ মোস্তফা কামাল";
                setContentView(R.layout.bir_kamal);
                break;
            case 4:
                name="বীরশ্রেষ্ঠ রুহুল আমীন";
                setContentView(R.layout.bir_ruhul);
                break;
            case 5:
                name="বীরশ্রেষ্ঠ নূর মোহাম্মদ";
                setContentView(R.layout.bir_nur);
                break;
            case 6:
                name="বীরশ্রেষ্ঠ মুন্সি আব্দুর রঊফ";
                setContentView(R.layout.bir_abdulrauf);
                break;
            case 7:
                name="বীরশ্রেষ্ঠ মহিউদ্দিন জাহাঙ্গীর";
                setContentView(R.layout.bir_jahangir);
                break;
            default:
                name="বীরশ্রেষ্ঠ মতিউর রহমান";
                setContentView(R.layout.bir_motiur);
                break;

        }

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initInstances();
    }
    private void initInstances() {
        rootLayoutAndroid =  findViewById(R.id.android_coordinator_layout);
        collapsingToolbarLayoutAndroid =  findViewById(R.id.collapsing_toolbar_android_layout);
        collapsingToolbarLayoutAndroid.setTitle(name);
    }

}
