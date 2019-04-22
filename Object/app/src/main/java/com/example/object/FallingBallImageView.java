package com.example.object;

import android.content.Context;
import android.graphics.Point;
import android.media.Image;
import android.util.AttributeSet;

public class FallingBallImageView extends Image {
    public FallingBallImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setFallingPos(Point pos) {
        layout(pos.x, pos.y, pos.x + getWidth(), pos.y + getHeight());
    }

    public void layout(float right, float top, float left, float button) {

    }

}
