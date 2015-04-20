package com.example.yura.calctest;

import android.animation.Animator;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

/**
 * Created by Yura on 20.04.2015.
 */
public class MyAnimationListener implements Animator.AnimatorListener {
    View container;
    View hideButton;
    public MyAnimationListener(View container, View hideButton) {
        this.container = container;
        this.hideButton = hideButton;
    }

    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        container.setVisibility(View.GONE);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)hideButton.getLayoutParams();
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        hideButton.setLayoutParams(params); //causes layout update
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
