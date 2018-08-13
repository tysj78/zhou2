package com.xm22xiu.zhou2;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * author:Created by YangYong on 2018/8/13 0013.
 */
public class MApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
