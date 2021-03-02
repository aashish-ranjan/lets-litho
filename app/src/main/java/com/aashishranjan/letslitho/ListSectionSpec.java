package com.aashishranjan.letslitho;

import android.graphics.Color;

import com.facebook.litho.sections.Children;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.annotations.GroupSectionSpec;
import com.facebook.litho.sections.annotations.OnCreateChildren;
import com.facebook.litho.sections.common.SingleComponentSection;

@GroupSectionSpec
public class ListSectionSpec {

    @OnCreateChildren
    static Children onCreateChildren(final SectionContext c) {
        Children.Builder builder = Children.create();

        for (int i =0; i < 32; i++) {
            builder.child(
                SingleComponentSection.create(c)
                     .component(ListItem.create(c)
                         .title(i + ". Hello Litho")
                         .color(i%2==0 ? Color.LTGRAY : Color.WHITE)
                         .build())
            );
        }
        return builder.build();
    }
}
