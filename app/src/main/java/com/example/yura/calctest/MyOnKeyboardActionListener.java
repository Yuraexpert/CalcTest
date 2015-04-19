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
        long eventTime = System.currentTimeMillis();
        KeyEvent event = new KeyEvent(eventTime, eventTime,
                KeyEvent.ACTION_DOWN, primaryCode, 0, 0, 0, 0,
                KeyEvent.FLAG_SOFT_KEYBOARD | KeyEvent.FLAG_KEEP_TOUCH_MODE);

        TextView v  = (TextView)mTargetActivity.findViewById(R.id.calc_text);
        v.append(String.valueOf(primaryCode));
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
