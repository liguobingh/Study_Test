package com.example.animation.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.animation.R;

/**
 * Created by mayn on 2019/3/13.
 */

public class SetAnim1 extends Activity {
    private Context context;

    private Button btn;
    private Button btn1;
    private TextView tv;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_anim);

        initView();
        initListener();
    }

    public void initView() {
        context = getApplicationContext();
        btn = findViewById(R.id.btn);
        btn1 = findViewById(R.id.btn1);
        tv = findViewById(R.id.tv);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
    }

    public void initListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 利用动画工具类（AnimationUtils）的 loadAnimation(Context context, @AnimRes int id) 函数返回一个Animation的对象，实现加载动画的目的
                Animation animation = AnimationUtils.loadAnimation(context, R.anim.setanim);
                // 利用View的 startAnimation(Animation animation) 函数开始动画
                tv.startAnimation(animation);

//                Animation animation1 = AnimationUtils.loadAnimation(context, R.anim.rotateanim1);
//                tv1.startAnimation(animation1);

//                Animation animation2 = AnimationUtils.loadAnimation(context, R.anim.scaleanim9);
//                tv2.startAnimation(animation2);
//
//                Animation animation3 = AnimationUtils.loadAnimation(context, R.anim.scaleanim10);
//                tv3.startAnimation(animation3);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setClass(context, )
            }
        });
    }
}
