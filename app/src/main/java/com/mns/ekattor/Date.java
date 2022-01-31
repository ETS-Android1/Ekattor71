package com.mns.ekattor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.mns.ekattor.model.Keys;

import java.util.ArrayList;
import java.util.List;


public class Date extends AppCompatActivity implements AdapterView.OnItemClickListener {
    int month;
    GridView gridView;
    Toolbar toolbar;
    private final String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        toolbar=findViewById(R.id.date_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        gridView=findViewById(R.id.dateGrid);
        Intent intent=getIntent();
        month=intent.getIntExtra(Keys.MONTH,0);
        toolbar.setTitle(months[month]);
        gridView.setAdapter(new DateAddapter(this,month));
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent= new Intent(this,DiaryDetails.class);
        intent.putExtra(Keys.DATE,position);
        intent.putExtra(Keys.MONTH,month);
        startActivity(intent);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

class DateAddapter  extends BaseAdapter {

    private Context mContext;
    private final int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private List<String> string;


    public DateAddapter(Context c, int month ) {
        mContext = c;
        string= new ArrayList<>();
        for(int k=1;k<=daysOfMonth[month];k++)
        this.string.add (String.valueOf(k));
    }

    @Override
    public int getCount() {
        return string.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View grid;
        LayoutInflater inflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.date_element,null);
            TextView label= grid.findViewById(R.id.txtDate);
            label.setText(string.get(i));
        }
        else{
            grid=convertView;
        }
        return grid;
    }
}