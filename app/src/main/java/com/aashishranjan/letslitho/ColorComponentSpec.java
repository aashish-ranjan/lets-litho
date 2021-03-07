package com.aashishranjan.letslitho;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMount;
import com.facebook.litho.annotations.Prop;

@MountSpec
public class ColorComponentSpec {

    @OnCreateMountContent
    static ColorDrawable onCreateMountContent(Context context) {
        return new ColorDrawable();
    }

    @OnMount
    static void onMount(
        ComponentContext c,
        ColorDrawable colorDrawable,
        @Prop String colorName) {

        colorDrawable.setColor(Color.parseColor(colorName));
    }
}
