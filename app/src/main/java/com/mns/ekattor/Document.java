package com.mns.ekattor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Document extends AppCompatActivity implements View.OnClickListener {

    CardView video,audio,news,books;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        books=findViewById(R.id.book);
        news=findViewById(R.id.news);
        audio=findViewById(R.id.audio);
        video=findViewById(R.id.videos);
        toolbar=findViewById(R.id.doc_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        books.setOnClickListener(this);
        audio.setOnClickListener(this);
        video.setOnClickListener(this);
        news.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.news:
            Intent intent =new Intent(this,NewsReference.class);
            startActivity(intent);
            break;
    }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
