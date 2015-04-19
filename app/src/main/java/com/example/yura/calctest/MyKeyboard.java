package com.example.yura.calctest;

import android.content.Context;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;

/**
 * Created by Yura on 18.04.2015.
 */
public class MyKeyboard extends KeyboardView {
    public MyKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void showWithAnimation(Animation animation) {
        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.VISIBLE);
            }
        });

        setAnimation(animation);
    }
}
