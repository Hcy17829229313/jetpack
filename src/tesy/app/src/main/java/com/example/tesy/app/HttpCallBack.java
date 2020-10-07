package com.example.tesy.app;

import android.util.Log;

import com.example.httplibrary.callback.BaseCallBack;
import com.example.tesy.ergbean.EgResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class HttpCallBack<T> extends BaseCallBack<T> {
    EgResponse egResponse;
    int errorCode;

    @Override
    protected T onConvert(String result) {
        T t = null;
        egResponse = new Gson().fromJson(result, EgResponse.class);
        JsonElement data = egResponse.getData();
        boolean success = egResponse.isSuccess();
        String message = egResponse.getMessage();

        if (success == true) {
            errorCode = 0;
        } else {
            errorCode = -1;
        }

        switch (errorCode) {
            case -1:
                onError(message, errorCode);
                break;
            default:
                if (isCodeSuccess()) {
                    t = convert(data);
                }
                break;
        }
        Log.e("liangxq", "onConvert: " + t.toString());
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
        if (egResponse != null) {
            return errorCode == 0;
        }
        return false;
    }

}
