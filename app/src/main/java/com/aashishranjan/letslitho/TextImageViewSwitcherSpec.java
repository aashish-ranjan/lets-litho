package com.aashishranjan.letslitho;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.Output;
import com.facebook.litho.annotations.FromPrepare;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.OnPrepare;
import com.facebook.litho.annotations.OnUnmount;
import com.facebook.litho.annotations.Prop;

import java.util.Timer;

@MountSpec
public class TextImageViewSwitcherSpec {

    @OnCreateMountContent
    static ViewSwitcher onCreateMountContent(Context c) {
        return new ViewSwitcher(c);
    }

    @OnMount
    static void onMount(ComponentContext c,
        ViewSwitcher viewSwitcher, @Prop String textValue,
        @Prop int imageResId, @Prop Timer timer) {

        Context ac = c.getAndroidContext();

        TextView textView = new TextView(ac);
        textView.setText(textValue);
        textView.setTextSize(12f);

        ImageView imageView = new ImageView(ac);
        imageView.setImageResource(imageResId);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        float dpToPxFactor = ac.getResources().getDisplayMetrics().density;
        int widthInPx = (int) (100f * dpToPxFactor);
        int heightInPx = (int) (20f * dpToPxFactor);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(widthInPx, heightInPx));

        viewSwitcher.addView(textView);
        viewSwitcher.addView(imageView);

        viewSwitcher.setInAnimation(AnimationUtils.loadAnimation(ac, android.R.anim.slide_in_left));
        viewSwitcher.setOutAnimation(AnimationUtils.loadAnimation(ac, android.R.anim.slide_out_right));

        timer.scheduleAtFixedRate(new NextSwitchedViewTask(viewSwitcher), 0 , 1000);
    }

    @OnUnmount
    static void onUnMount(ComponentContext c, ViewSwitcher viewSwitcher, Timer timer) {
        if(timer != null) {
            timer.cancel();
        }
    }
}
