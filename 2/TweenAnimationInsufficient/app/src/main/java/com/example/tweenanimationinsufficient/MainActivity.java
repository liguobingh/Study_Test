package com.example.tweenanimationinsufficient;

import android.animation.ValueAnimator;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initListener();
    }

    public void init() {
        start = findViewById(R.id.start);
        tv = findViewById(R.id.test_part);
    }

    public void initListener() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked me", Toast.LENGTH_SHORT).show();
            }
        });
    }

/*    public void startAnimation() {
        final TranslateAnimation animation = new TranslateAnimation(Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 400,
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE, 400);
        animation.setFillAfter(true);
        animation.setDuration(4000);
        tv.startAnimation(animation);
    }*/

    public void startAnimation() {
        final ValueAnimator animator = ValueAnimator.ofInt(0, 400);
        animator.setDuration(4000);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (Integer) animation.getAnimatedValue();
                Log.d("@@@@@", "curValue: " + curValue);
                tv.layout(curValue, curValue, curValue + tv.getWidth(), curValue + tv.getHeight());
            }
        });
        animator.start();
    }
}
