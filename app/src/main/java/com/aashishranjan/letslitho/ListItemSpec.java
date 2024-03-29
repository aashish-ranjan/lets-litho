package com.aashishranjan.letslitho;

import android.graphics.Color;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class ListItemSpec {

    @OnCreateLayout
    static Component onCreateLayout(ComponentContext c,
                                    @Prop String title,
                                    @Prop int color) {
        return Column.create(c)
            .paddingDip(YogaEdge.ALL, 16)
            .backgroundColor(color)
            .child(
                Text.create(c)
                .text(title)
                .textSizeSp(40)
            )
            .child(
                Text.create(c)
                .text("Second line")
                .textSizeSp(20)
            ).build();
    }
}
