package com.example.tesy.app;

import android.app.Application;

import com.example.httplibrary.HttpConstant;
import com.example.httplibrary.HttpGlobalConfig;

public class ShopApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpGlobalConfig.getInsance()
                //  .setBaseUrl("http://169.254.189.205:8080/kotlin/")
                //  .setBaseUrl("https://www.wanandroid.com/")
                //   .setBaseUrl("http://api.ergedd.com/api/v1/")
                 .setBaseUrl("http://api.ergedd.com/")
                .setTimeout(HttpConstant.TIME_OUT)
                .setShowLog(true)
                .setTimeUnit(HttpConstant.TIME_UNIT)
                .initReady(this);
    }
}
