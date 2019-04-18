package com.example.animation_3.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.example.animation_3.R;

/**
 * Created by mayn on 2019/3/18.
 */

public class LoadingImageView extends ImageView {
    private int mTop;
    private int mCurImgIndex = 0;
    private static int mImgCount = 12;

    public LoadingImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        mTop = top;
    }

    public void init() {
        //
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 100, 0);
        // 设置动画重新启动模式为“重头开始”
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        // 设置动画重新启动次数为“无穷次”
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        // 设置动画运行一次的时间为2秒
        valueAnimator.setDuration(2000);
        // 设置动画插值器为：先加速在减速插值器
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());

        // 给动画设置一个“更新时监听器”
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int dx = (Integer) animation.getAnimatedValue();
                setTop(mTop - dx);
            }
        });

        // 给动画设置一个变化是的监听器
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                setImageDrawable(getResources().getDrawable(R.drawable.pic_01));
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                mCurImgIndex++;
                switch (mCurImgIndex % mImgCount) {
                    case 0:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_01));
                        break;
                    case 1:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_02));
                        break;
                    case 2:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_03));
                        break;
                    case 3:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_04));
                        break;
                    case 4:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_05));
                        break;
                    case 5:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_06));
                        break;
                    case 6:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_07));
                        break;
                    case 7:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_08));
                        break;
                    case 8:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_09));
                        break;
                    case 9:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_10));
                        break;
                    case 10:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_11));
                        break;
                    case 11:
                        setImageDrawable(getResources().getDrawable(R.drawable.pic_12));
                        break;
                    default:
                        break;
                }
            }

            public void onAnimationEnd(Animator animation) {
            }

            public void onAnimationCancel(Animator animation) {
            }
        });

        valueAnimator.start();
    }
}
