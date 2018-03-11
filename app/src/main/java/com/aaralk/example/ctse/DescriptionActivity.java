package com.aaralk.example.ctse;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);



        //String data = getIntent().getExtras().getString("data");

//        String prefName = getIntent().getStringExtra("pref-name");
//        String prefKey = getIntent().getStringExtra("pref-key");
//
//        SharedPreferences preferences = getSharedPreferences(prefName,MODE_PRIVATE);
//        String text = preferences.getString(prefKey,"default");
//
//        ((TextView)findViewById(R.id.textView)).setText(data);

        int id = getIntent().getExtras().getInt("data");
        MyDBHelper dbHelper = new MyDBHelper(this);
        String text = dbHelper.read(id);
        TextView tv = findViewById(R.id.textView);
        tv.setText(text);

    }
}
