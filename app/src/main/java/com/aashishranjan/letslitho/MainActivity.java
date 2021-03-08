package com.aashishranjan.letslitho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.Section;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.facebook.litho.widget.Text;
import com.facebook.soloader.SoLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SoLoader.init(this, false);

        final ComponentContext c = new ComponentContext(this);

        //create text component
//        final Component textComponent = Text.create(c)
//            .text("Hello Litho")
//            .textSizeDip(50)
//            .build();
//        setContentView(LithoView.create(c, textComponent));


        //create custom UI component (listItem)
//        final Component listItemComponent = ListItem.create(c).build();
//        setContentView(LithoView.create(c, listItemComponent));


        //create recycler view
//        final Section listSection = ListSection.create(
//            new SectionContext(c)
//        ).build();
//
//        final RecyclerCollectionComponent recyclerCollectionComponent =
//            RecyclerCollectionComponent.create(c)
//                .disablePTR(true)
//                .section(listSection)
//                .build();
//
//        setContentView(LithoView.create(c, recyclerCollectionComponent));

        //using mount spec to create colorDrawable
//        final ColorComponent colorComponent = ColorComponent.create(c)
//            .colorName("#3F51B5")
//            .build();
//
//        setContentView(LithoView.create(c, colorComponent));

//        //Create lottie layout programmatically
//        ConstraintLayout lottieLayout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_main, null);
//        setContentView(lottieLayout);
//
//        LottieAnimationView lav = new LottieAnimationView(this);
//        lav.setLayoutParams(new LinearLayout.LayoutParams(100, 100));
//        lav.setAnimation(R.raw.lottie_segmented_top_up);
//
//        lav.setRepeatCount(LottieDrawable.INFINITE);
//        lav.playAnimation();
//        lav.setBackgroundColor(Color.LTGRAY);
//
//        lottieLayout.addView(lav);

        final CustomLottieAnimationView clavComponent = CustomLottieAnimationView.create(c)
            .lottieResource(R.raw.lottie_segmented_top_up)
            .widthDip(100)
            .heightDip(100)
            .build();

        setContentView(LithoView.create(c, clavComponent));
    }
}
