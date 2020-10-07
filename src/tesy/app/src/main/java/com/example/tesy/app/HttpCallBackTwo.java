package com.example.tesy.app;

import android.util.Log;

import com.example.httplibrary.callback.BaseCallBack;
import com.example.tesy.egBabyBean.BabyRespone;
import com.example.tesy.ergbean.EgResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class HttpCallBackTwo<T> extends BaseCallBack<T> {
    BabyRespone babyRespone;

    @Override
    protected T onConvert(String result) {
        T t = null;
        babyRespone = new Gson().fromJson(result, BabyRespone.class);
        JsonElement data = babyRespone.getRecord();
        int errorCode = babyRespone.getStatus();
        String message = babyRespone.getMessages().toString();

        switch (errorCode) {
            case 201:
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
        if (babyRespone != null) {
            return babyRespone.getStatus() == 200;
        }
        return false;
    }

}
