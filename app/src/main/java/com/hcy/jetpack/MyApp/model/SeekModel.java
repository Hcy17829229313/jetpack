package com.hcy.jetpack.MyApp.model;

import android.util.Log;

import com.google.gson.JsonElement;
import com.hcy.httplibrary.client.HttpClient;
import com.hcy.httplibrary.utils.JsonUtils;
import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.jetpack.MyApp.contract.SeekContract;
import com.hcy.jetpack.app.HttpCallBack;

import java.util.HashMap;

public class SeekModel implements SeekContract.Model {
    @Override
    public void getDataSeek(SeekContract.CallBack callBack) {
            HashMap<String,Object> map=new HashMap<>();
            map.put("pageCount","10");
            map.put("tagId","0");
            map.put("userId","0");
            map.put("offset","0");
            map.put("tagType","excludeFollow");
            new HttpClient.Builder()
                    .setApiUrl("serverdemo/tag/queryTagList")
                    .get()
                    .setHeadres(map)
                    .build().request(new HttpCallBack<SeekBean>() {
                @Override
                public void onError(String message, int code) {

                }

                @Override
                public void cancle() {

                }

                @Override
                public void onSuccess(SeekBean dataBean) {
                    Log.d("seek", "onSuccess: "+dataBean);
                }

                @Override
                public SeekBean convert(JsonElement result) {
                    return JsonUtils.jsonToClass(result,SeekBean.class);
                }
            });
        }
    }

