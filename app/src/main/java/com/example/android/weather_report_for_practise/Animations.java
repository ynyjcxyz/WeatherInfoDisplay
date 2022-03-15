package com.example.android.weather_report_for_practise;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;

public class Animations {
    public static void setTextBold(TextView textView){
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
    }

    public static void setTextNormal(TextView textView){
        textView.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
    }

    public static void expand(View view) {
        Animation animation = expandAction(view);
        view.startAnimation(animation);
    }

    private static Animation expandAction(final View view) {
        view.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final int actualHeight = view.getMeasuredHeight();

        view.getLayoutParams().height = 0;
        view.setVisibility(View.VISIBLE);

        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {

                view.getLayoutParams().height = interpolatedTime == 1
                        ? ViewGroup.LayoutParams.WRAP_CONTENT
                        : (int) (actualHeight * interpolatedTime);
                view.requestLayout();
            }
        };
        animation.setDuration((long)
                (actualHeight /
                        view.getContext().getResources().getDisplayMetrics().density));
        view.startAnimation(animation);
        return animation;
    }

    public static void collapse(final View view) {
        final int actualHeight = view.getMeasuredHeight();
        Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    view.setVisibility(View.GONE);
                } else {
                    view.getLayoutParams().height =
                            actualHeight - (int) (actualHeight * interpolatedTime);
                    view.requestLayout();
                }
            }
        };
        animation.setDuration((long) (actualHeight /
                view.getContext().getResources().getDisplayMetrics().density));
        view.startAnimation(animation);
    }
}
