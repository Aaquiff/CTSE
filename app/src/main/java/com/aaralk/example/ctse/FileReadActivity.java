package com.aaralk.example.ctse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;

public class FileReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_read);

        String fileText = "Did not read";
        try {
            byte[] bytes = new byte[1000];
            InputStream open = null;
            try {
                open = getAssets().open("simple.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            open.read(bytes);
            fileText = new String(bytes);

        } catch (IOException e) {
            e.printStackTrace();
            fileText = e.getMessage();
        }
    }
}
