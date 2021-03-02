package com.aashishranjan.letslitho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;
import com.facebook.soloader.SoLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SoLoader.init(this, false);

        final ComponentContext c = new ComponentContext(this);

//        final Component textComponent = Text.create(c)
//            .text("Hello Litho")
//            .textSizeDip(50)
//            .build();

        final Component listItemComponent = ListItem.create(c).build();

        setContentView(LithoView.create(c, listItemComponent));
    }
}
