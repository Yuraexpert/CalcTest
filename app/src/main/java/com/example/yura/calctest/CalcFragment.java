package com.example.yura.calctest;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.inputmethodservice.Keyboard;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CalcFragment extends Fragment {
    private MyKeyboard mKeyboardView;
    private MyKeyboard mKeyboardView2;
    private Keyboard mKeyboard;
    private Button hideButton;
    private LinearLayout calcContainer;

    public CalcFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View calcView = inflater.inflate(R.layout.calc_layout, container, false);

        mKeyboard = new Keyboard(getActivity(), R.xml.keyboard);

        mKeyboardView = (MyKeyboard)calcView.findViewById(R.id.keyboard_view);
        mKeyboardView2 = (MyKeyboard)calcView.findViewById(R.id.keyboard_view2);

        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboardView.setOnKeyboardActionListener(new MyOnKeyboardActionListener(getActivity()));

        mKeyboardView2.setKeyboard(mKeyboard);
        mKeyboardView2.setOnKeyboardActionListener(new MyOnKeyboardActionListener(getActivity()));

        hideButton = (Button)calcView.findViewById(R.id.hide_calc_button);
        calcContainer = (LinearLayout)calcView.findViewById(R.id.keyboard_container);
        hideButton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                if (calcContainer.getVisibility() == View.GONE) {
                    calcContainer.setVisibility(View.VISIBLE);
                    calcContainer.animate().setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            super.onAnimationStart(animation);
                            calcContainer.setVisibility(View.VISIBLE);
                        }
                    })
                    .translationY(0);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)v.getLayoutParams();
                    params.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    v.setLayoutParams(params); //causes layout update
                } else {
                    calcContainer.animate().translationY(calcContainer.getHeight())
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            calcContainer.setVisibility(View.GONE);
                        }
                    });
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)v.getLayoutParams();
                    params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    v.setLayoutParams(params); //causes layout update
                }

            }
        });
        return calcView;
    }



}