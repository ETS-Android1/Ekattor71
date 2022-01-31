package com.mns.ekattor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mns.ekattor.model.Keys;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class GonokobrDetiels extends AppCompatActivity {

    Toolbar toolbar;
    ImageView  imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gonokobr_detiels);
        String[] arry=getResources().getStringArray(R.array.gonokobor);
        Intent intent=getIntent();
        int id=intent.getIntExtra(Keys.GONOKYE,0);
        toolbar=findViewById(R.id.gone_toolbar);
        toolbar.setTitle(arry[id]);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textView=findViewById(R.id.bodyTxt);
        imageView=findViewById(R.id.imgid);
        textView.setText(Keys.gonokoborHistory[id]);
        Glide.with(this).load(Keys.gonoUrl[id])
                .thumbnail(0.5f)
                .transition(withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
