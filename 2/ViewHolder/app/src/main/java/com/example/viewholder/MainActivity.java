package com.example.viewholder;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private Button scale_anim_btn;
    private MyTextView mytv;
    private PropertyValuesHolder rotationHolder;
    private PropertyValuesHolder alphaHolder;
    private PropertyValuesHolder charHolder;
    private ObjectAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initLietener();
    }

    public void init() {
        tv = findViewById(R.id.tv);
        scale_anim_btn = findViewById(R.id.scale_anim_btn);
        mytv = findViewById(R.id.mytv);

        rotationHolder = PropertyValuesHolder.ofFloat("rotation", 0, 270, 0);
        alphaHolder = PropertyValuesHolder.ofFloat("alpha", 1, 0, 1);
        charHolder = PropertyValuesHolder.ofObject("CharText", new CharEvaluater(), new Character('a'), new Character('z'));

        animator = ObjectAnimator.ofPropertyValuesHolder(tv, rotationHolder, alphaHolder);
        animator = ObjectAnimator.ofPropertyValuesHolder(mytv, charHolder);
        animator.setDuration(12000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
//        animator.start();
    }

    public void initLietener() {
        scale_anim_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animator.start();
            }
        });
    }

    class CharEvaluater implements TypeEvaluator<Character> {

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startInt = (int) startValue;
            int endInt = (int) endValue;
            int curInt = (int) (startInt + fraction * (endInt - startInt));
//            Log.d("@@@@@", "curInt: " + curInt);
            char result = (char) curInt;
            return result;
        }
    }
}
