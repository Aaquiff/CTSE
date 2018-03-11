package com.aaralk.example.ctse;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"Lifecycle Event: onCreate");
        //SetServices();

        MyDBHelper helper = new MyDBHelper(this);
        helper.save("Sample value 1");
        helper.save("Sample value 2");
        helper.save("Sample value 3");
        helper.save("Sample value 4");
        helper.save("Sample value 5");
        helper.save("Sample value 6");

        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }



    /**
     * Start the background service and broadcast receiver
     */
    private void SetServices(){
        Intent explicitIntent = new Intent(this, MyBackgroundService.class);
        startService(explicitIntent);

        Intent implicitIntent = new Intent("com.aaralk.example.ctse.SIGNAL");
        sendBroadcast(implicitIntent);
    }

    private final static String TAG = "Lifecycle_watch";

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"Lifecycle Event: onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Lifecycle Event: onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"Lifecycle Event: onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"Lifecycle Event: onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"Lifecycle Event: onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"Lifecycle Event: onStart");
    }

    public void SendData(View view) {


        SharedPreferences preferences = getSharedPreferences("simple-store",MODE_PRIVATE);
        preferences.edit().putString("simpleKey","simple value").apply();

        Intent intent = new Intent(this,DescriptionActivity.class);
        intent.putExtra("data","Sample intent value");

        intent.putExtra("pref-name","simple-store");
        intent.putExtra("pref-key","simpleKey");

        MainActivity.this.startActivity(intent);


    }
}
