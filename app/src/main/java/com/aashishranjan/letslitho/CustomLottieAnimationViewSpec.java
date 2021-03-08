package com.aashishranjan.letslitho;

import android.content.Context;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Size;
import com.facebook.litho.SizeSpec;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMeasure;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.Prop;

@MountSpec
public class CustomLottieAnimationViewSpec {

    @OnCreateMountContent
    static LottieAnimationView onCreateMountContent(Context c) {
        return new LottieAnimationView(c);
    }

    @OnMeasure
    static void onMeasure(
        ComponentContext c,
        ComponentLayout layout,
        int widthSpec,
        int heightSpec,
        Size size) {

        //set default width when no width is specified
        if (SizeSpec.getMode(widthSpec) == SizeSpec.UNSPECIFIED) {
            size.width = 100;
        } else {
            size.width = SizeSpec.getSize(widthSpec);
        }

        //set default height when no height is specified
        if (SizeSpec.getMode(heightSpec) == SizeSpec.UNSPECIFIED) {
            size.height = 100;
        } else {
            size.height = SizeSpec.getSize(heightSpec);
        }
    }

    @OnMount
    static void onMount(
        ComponentContext c,
        LottieAnimationView animationView,
        @Prop int lottieResource) {

        animationView.setAnimation(lottieResource);
        animationView.setRepeatCount(LottieDrawable.INFINITE);
        animationView.playAnimation();
    }

}
