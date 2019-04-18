package com.example.tweenanimationinsufficient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private TextView test_part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();
    }

    public void init() {
        start = findViewById(R.id.start);
        test_part = findViewById(R.id.test_part);
    }

    public void initListener() {
        test_part.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
    }

    public void startAnimation() {

    }
}
