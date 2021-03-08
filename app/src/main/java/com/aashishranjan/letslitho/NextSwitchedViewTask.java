package com.aashishranjan.letslitho;

import android.os.Handler;
import android.os.Looper;
import android.widget.ViewSwitcher;

import java.util.TimerTask;

class NextSwitchedViewTask extends TimerTask {
    private ViewSwitcher mViewSwitcher;
    private Handler handler = new Handler(Looper.getMainLooper());

    NextSwitchedViewTask(ViewSwitcher vs) {
        mViewSwitcher = vs;
    }

    @Override
    public void run() {
        handler.post(
            new Runnable() {
                @Override
                public void run() {
                    slideShow();
                }
            }
        );
    }

    private void slideShow() {
        if (mViewSwitcher.getDisplayedChild() == 0) {
            mViewSwitcher.showNext();
        } else {
            mViewSwitcher.showPrevious();
        }
    }
}