package com.example.animation_3.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.example.animation_3.R;


/**
 * Created by mayn on 2019/3/12.
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    public void initView() {
    }

    public void initListener() {
    }
}
