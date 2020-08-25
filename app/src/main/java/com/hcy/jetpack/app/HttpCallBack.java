package com.hcy.jetpack.app;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.hcy.httplibrary.callback.BaseCallBack;


public abstract class HttpCallBack<T> extends BaseCallBack<T> {
     Response response;
    @Override
    protected T onConvert(String result) {
        T t=null;
        response = new Gson().fromJson(result, Response.class);
        JsonElement data = response.getData();
        int errorCode = response.getStatus();
        String errorMsg = response.getMessage();
        switch (errorCode) {
            case -1:
                onError(errorMsg,errorCode);
                Log.d(TAG, "onConvert: "+errorMsg);
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);
                }
                break;
        }
        Log.e("huangcy", "onConvert: "+t.toString() );
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
        if (response != null) {
            return response.getStatus() == 200;
        }
        return false;
    }

    private static final String TAG = "HttpCallBack";
}
