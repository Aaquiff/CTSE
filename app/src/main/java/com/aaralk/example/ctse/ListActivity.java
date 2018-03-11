package com.aaralk.example.ctse;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        MyDBHelper helper = new MyDBHelper(this);

        List<Data> rawData = helper.readAll();
        List<String> data = new ArrayList<>();

        for(Data d : rawData){
            data.add(d.value);
        }

        ArrayAdapter<String> simpleAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        ListView lv = findViewById(R.id.listView);
        lv.setAdapter(simpleAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListActivity.this,DescriptionActivity.class);
                intent.putExtra("data", (i%6) + 1);
                ListActivity.this.startActivity(intent);
            }
        });




    }

}
