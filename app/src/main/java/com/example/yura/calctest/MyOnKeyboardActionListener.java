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
            case 10:
                v.append("Pi");
                break;
            case 11:
                v.append("e");
                break;
            case 12:
                v.append("sin(");
                break;
            case 13:
                v.append("cos(");
                break;
            case 14:
                v.append("tan(");
                break;
            case 15:
                v.append("arcsin(");
                break;
            case 16:
                v.append("arccos(");
                break;
            case 17:
                v.append("arctan(");
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                v.append("%");
                break;
            case 21:
                v.append("X");
                break;
            case 22:
                v.append("^");
                break;
            case 23:
                v.append("√");
                break;
            case 24:
                v.append("ln");
                break;
            case 25:
                v.append("log");
                break;
            case 26:
                v.append("*");
                break;
            case 27:
                v.append("+");
                break;
            case 28:
                v.append("-");
                break;
            case 29:
                v.append("/");
                break;
            case 30:
                v.append("(");
                break;
            case 31:
                v.append(")");
                break;
            case 32:
                v.append("=");
                break;
            case 33:
                String text = v.getText().toString();
                v.setText(text.substring(0, text.length()-1));
                break;
            case 34:
                break;
            default:
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
