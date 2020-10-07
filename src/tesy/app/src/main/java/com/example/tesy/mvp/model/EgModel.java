package com.example.tesy.mvp.model;

import android.util.Log;

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.ergbean.EgHomeTabBean;
import com.example.tesy.mvp.presenter.EgPresenter;
import com.google.gson.JsonElement;
import com.hcy.mvplibrary.model.BaseModel;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.List;

public class EgModel implements BaseModel {
    public interface TabCallBack {
        void CallSuccess(List<EgHomeTabBean> tabBeans);
    }

    public void getData(TabCallBack tabCallBack) {
        new HttpClient.Builder()
                .setApiUrl("api/v1/album_categories?offset=0&limit=100&addition_album_count=20&channel=new")
                .get()

                .build().request(new HttpCallBack<List<EgHomeTabBean>>() {
            @Override
            public void onError(String message, int code) {

            }

            @Override
            public void cancle() {

            }

            @Override
            public void onSuccess(List<EgHomeTabBean> egHomeTabBeans) {
                Log.d("123", "onSuccess: "+egHomeTabBeans.toString());
                tabCallBack.CallSuccess(egHomeTabBeans);
            }

            @Override
            public List<EgHomeTabBean> convert(JsonElement result) {
                return JsonUtils.jsonToClassList(result,EgHomeTabBean.class);
            }
        });
    }


}
