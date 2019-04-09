package com.example.broadcastbestpractice.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.broadcastbestpractice.R;
import com.example.broadcastbestpractice.base.BaseActivity;
import com.example.broadcastbestpractice.config.BroadcastAction;

public class MainActivity extends BaseActivity {
    private Button forceOffline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();
    }

    public void init() {
        forceOffline = findViewById(R.id.force_offline);
    }

    public void initListener() {
        forceOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadcastAction.FORCE_OFFLINE);
                sendBroadcast(intent);
            }
        });
    }
}
