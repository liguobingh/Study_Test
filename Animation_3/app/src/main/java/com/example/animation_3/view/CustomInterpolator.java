package com.example.animation_3.view;

import android.view.animation.BaseInterpolator;

public class CustomInterpolator extends BaseInterpolator {

    public CustomInterpolator() {
    }

    @Override
    public float getInterpolation(float input) {
        return 100 - input;
    }
}
