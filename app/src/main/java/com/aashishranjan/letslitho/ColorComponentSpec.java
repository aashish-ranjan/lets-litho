package com.aashishranjan.letslitho;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.Output;
import com.facebook.litho.annotations.FromPrepare;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.OnPrepare;
import com.facebook.litho.annotations.Prop;

@MountSpec
public class ColorComponentSpec {

    @OnCreateMountContent
    static ColorDrawable onCreateMountContent(Context context) {
        return new ColorDrawable();
    }

    //a heavy operation, can be run on BG thread
    @OnPrepare
    static void onPrepare(
        ComponentContext c,
        @Prop String colorName,
        Output<Integer> color) {
        color.set(Color.parseColor(colorName));
    }

    @OnMount
    static void onMount(
        ComponentContext c,
        ColorDrawable colorDrawable,
        @FromPrepare int color) {

        colorDrawable.setColor(color);
    }
}
