package com.example.sharepreferencestest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button save_data;
    private Button restore_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();
    }

    public void init() {
        save_data = findViewById(R.id.save_data);
        restore_data = findViewById(R.id.restore_data);
    }

    public void initListener() {
        save_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Tom");
                editor.putInt("age", 12);
                editor.putBoolean("married", false);
                editor.apply();
            }
        });

        restore_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = preferences.getString("name", "");
                int age = preferences.getInt("age", 0);
                Boolean married = preferences.getBoolean("married", false);
                Log.d("@@@@@", "name is: " + name);
                Log.d("@@@@@", "age is: " + age);
                Log.d("@@@@@", "married is: " + married);
            }
        });
    }
}
