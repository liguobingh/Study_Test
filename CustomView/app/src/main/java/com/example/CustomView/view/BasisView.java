package com.example.CustomView.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by liguobin on 2019/3/4.
 */

public class BasisView extends View {

    public BasisView(Context context) {
        super(context);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(50);// 单位px。该函数生效的条件是：setStyle(Style style)函数传入的style值为 Paint.style.STROKE 或 Paint.style.FILL_AND_STROKE

        canvas.drawCircle(190, 190, 150, paint);// 本以为“（半径值 + 描边宽度）> 圆心坐标提供的最大值”会出现左边和上边部分被遮挡的情况，但是没有出现对应现象，问题应该在两者使用的单位不一样。
    }
}
