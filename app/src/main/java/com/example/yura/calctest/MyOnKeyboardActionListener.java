package com.example.yura.calctest;

import android.app.Activity;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.widget.TextView;

/**
 * Created by Yura on 18.04.2015.
 */
public class MyOnKeyboardActionListener  implements KeyboardView.OnKeyboardActionListener {
    private Activity mTargetActivity;

    public MyOnKeyboardActionListener(Activity targetActivity) {
        this.mTargetActivity = targetActivity;
    }
    @Override
    public void onPress(int primaryCode) {

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        TextView v  = (TextView)mTargetActivity.findViewById(R.id.calc_text);
        //v.append(String.valueOf(primaryCode));
        switch (primaryCode) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0: v.append(String.valueOf(primaryCode));
                break;
        }
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
