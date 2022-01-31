package com.mns.ekattor;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mns.ekattor.model.GalleryAdapter;
import com.mns.ekattor.model.Image;

import java.util.ArrayList;

public class PhotoGallaryGlide extends AppCompatActivity {

    private ArrayList<Image> images;
    private GalleryAdapter mAdapter;
    private RecyclerView recyclerView;
    String [] url={

            "https://i.imgur.com/UFD1kr2.jpg",
            "https://i.imgur.com/5x33JZQ.jpg",
            "https://i.imgur.com/IPrJtPk.jpg",
            "https://i.imgur.com/cxQ0KRF.jpg",
            "https://i.imgur.com/dbXIAUv.jpg",
            "https://i.imgur.com/6bjRbeZ.jpg",
            "https://i.imgur.com/zDtbToP.jpg",
            "https://i.imgur.com/wVbTGVK.jpg",
            "https://i.imgur.com/UdykU25.jpg",
            "https://i.imgur.com/8XKe88s.jpg",
            "https://i.imgur.com/q6GeTR4.jpg",
            "https://i.imgur.com/XuQLqkE.jpg",
            "https://i.imgur.com/4SfKqtn.jpg",
            "https://i.imgur.com/HTho4cg.jpg",
            "https://i.imgur.com/8EGQMX8.jpg",
            "https://i.imgur.com/HKpyGd0.jpg",
            "https://i.imgur.com/6Kxcq6G.jpg",
            "https://i.imgur.com/NQkFvzt.jpg",
            "https://i.imgur.com/vYnIYFy.jpg",
            "https://i.imgur.com/vXxLaiM.jpg",
            "https://i.imgur.com/7Z9COYN.jpg",
            "https://i.imgur.com/4RFFLqL.jpg"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallary_glide);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView =  findViewById(R.id.recycler_view);
        images = new ArrayList<>();
        for(int i=0;i<url.length;i++){
            images.add(new Image("Libaretuon war",url[i],url[i],url[i],"march 1971"));
        }
        mAdapter = new GalleryAdapter(getApplicationContext(), images);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new GalleryAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new GalleryAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("images", images);
                bundle.putInt("position", position);

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                SlideshowDialogFragment newFragment = SlideshowDialogFragment.newInstance();
                newFragment.setArguments(bundle);
                newFragment.show(ft, "slideshow");
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }
}
