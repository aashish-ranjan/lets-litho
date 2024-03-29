package com.aashishranjan.letslitho;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.Output;
import com.facebook.litho.Size;
import com.facebook.litho.SizeSpec;
import com.facebook.litho.annotations.FromPrepare;
import com.facebook.litho.annotations.MountSpec;
import com.facebook.litho.annotations.OnCreateMountContent;
import com.facebook.litho.annotations.OnMeasure;
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

    @OnMeasure
    static void onMeasure(
        ComponentContext c,
        ComponentLayout layout,
        int widthSpec,
        int heightSpec,
        Size size) {

        //set default width(in px) when no width is specified
        if (SizeSpec.getMode(widthSpec) == SizeSpec.UNSPECIFIED) {
            size.width = 40;
        } else {
            size.width = SizeSpec.getSize(widthSpec);
        }

        //set default height(in px) when no height is specified
        if (SizeSpec.getMode(heightSpec) == SizeSpec.UNSPECIFIED) {
            size.height = (int) (size.width * 1.5);
        } else {
            size.height = SizeSpec.getSize(heightSpec);
        }
    }
}
