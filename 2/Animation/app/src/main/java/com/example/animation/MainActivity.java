package com.example.animation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.example.animation.ui.AlphaAnim1;
import com.example.animation.ui.AnimationAttr;
import com.example.animation.ui.RotateAnim1;
import com.example.animation.ui.ScaleAnim1;
import com.example.animation.ui.SetAnim1;
import com.example.animation.ui.TranslateAnim1;

/**
 * Created by mayn on 2019/3/12.
 */

public class MainActivity extends Activity {
    private Context context;

    private Button scale_anim_btn;
    private Button Animation_attr_btn;
    private Button alpha_anim_btn;
    private Button rotate_anim_btn;
    private Button translate_anim_btn;
    private Button set_anim_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initListener();
    }

    public void initView() {
        context = getApplicationContext();

        scale_anim_btn = findViewById(R.id.scale_anim_btn);
        Animation_attr_btn = findViewById(R.id.Animation_attr_btn);
        alpha_anim_btn = findViewById(R.id.alpha_anim_btn);
        rotate_anim_btn = findViewById(R.id.rotate_anim_btn);
        translate_anim_btn = findViewById(R.id.translate_anim_btn);
        set_anim_btn = findViewById(R.id.set_anim_btn);
    }

    public void initListener() {
        scale_anim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, ScaleAnim1.class);
                startActivity(intent);
            }
        });

        Animation_attr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, AnimationAttr.class);
                startActivity(intent);
            }
        });

        alpha_anim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, AlphaAnim1.class);
                startActivity(intent);
            }
        });

        rotate_anim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, RotateAnim1.class);
                startActivity(intent);
            }
        });

        translate_anim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, TranslateAnim1.class);
                startActivity(intent);
            }
        });

        set_anim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(context, SetAnim1.class);
                startActivity(intent);
            }
        });
    }
}
