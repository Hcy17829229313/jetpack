package com.hcy.jetpack.app;

import android.app.Application;

import com.hcy.httplibrary.HttpConstant;
import com.hcy.httplibrary.HttpGlobalConfig;
import com.umeng.commonsdk.UMConfigure;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        HttpGlobalConfig.getInsance()
                .setBaseUrl("http://123.56.232.18:8080/")
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);
        initQQ();
    }

    private void initQQ() {
        UMConfigure.init(this,"5f447b61113468235fdc455c"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0

    }
}
