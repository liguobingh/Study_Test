package com.example.pathmeasure.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PathMea extends View {
    Paint paint;
    Path path;
    //    PathMeasure measure1;
    PathMeasure measure2;

    public PathMea(Context context) {
        this(context, null);
    }

    public PathMea(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathMea(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
//        measure1 = new PathMeasure(path, true);
        measure2 = new PathMeasure(path, false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(150, 150);

//        path.moveTo(0, 0);
//        path.lineTo(0, 100);
//        path.lineTo(100, 100);
//        path.lineTo(100, 0);

        path.addRect(-50, -50, 50, 50, Path.Direction.CW);
        path.addRect(-100, -100, 100, 100, Path.Direction.CW);
        path.addRect(-120, -120, 120, 120, Path.Direction.CW);
        path.addCircle(0, 0, 50, Path.Direction.CW);

//        Log.d("@@@@@", "forceClosed = true---->" + measure1.getLength());
        do {
            Log.d("@@@@@", "forceClosed = false---->" + measure2.getLength());
        } while (measure2.nextContour());
//        Log.d("@@@@@", "forceClosed = false---->" + measure2.getLength());

        canvas.drawPath(path, paint);
    }
}
