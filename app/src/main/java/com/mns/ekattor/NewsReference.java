package com.mns.ekattor;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mns.ekattor.model.GalleryAdapter;
import com.mns.ekattor.model.Image;

import java.util.ArrayList;

public class NewsReference extends AppCompatActivity {

    private ArrayList<Image> images;
    private GalleryAdapter mAdapter;
    private RecyclerView recyclerView;
    String [] url={
            "https://i.imgur.com/waV8jnr.jpg",
            "https://i.imgur.com/fPoUTH2.jpg",
            "https://i.imgur.com/f6oZMLH.jpg",
            "https://i.imgur.com/xcA4mqB.jpg",
            "https://i.imgur.com/74ezdyn.jpg",
            "https://i.imgur.com/wc4UeQq.jpg",
            "https://i.imgur.com/JWypRvv.jpg",
            "https://i.imgur.com/ghxlsyR.jpg",
            "https://i.imgur.com/0bSLYJ8.jpg",
            "https://i.imgur.com/cdkGAjk.jpg",
            "https://i.imgur.com/Rx8mPxG.jpg",
            "https://i.imgur.com/2yjy40i.jpg",
            "https://i.imgur.com/okalHfj.jpg",
            "https://i.imgur.com/IyWt7yY.jpg",
            "https://i.imgur.com/hGOvaA7.jpg",
            "https://i.imgur.com/ry6mxVj.jpg",
            "https://i.imgur.com/VBE69pL.jpg"
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
