package com.example.liangxq.shopping;

import android.os.Bundle;
import android.util.Log;

import com.example.httplibrary.HttpManager;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.server.ApiServer;
import com.example.httplibrary.utils.JsonUtils;
import com.example.httplibrary.utils.LogUtils;
import com.example.liangxq.shopping.httpdemo.shopping.ShopDemo;
import com.example.liangxq.shopping.httpdemo.wanandroid.Demo;
import com.example.liangxq.shopping.httpdemo.wanandroid.HttpCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class MainActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new HttpClient.Builder()
                .setApiUrl("wxarticle/list/408/1/json")
                .get()
                .build().request(new HttpCallBack<Demo>() {
            @Override
            public void onError(String message, int code) {
                LogUtils.e(message);
            }
            @Override
            public void cancle() {

            }

            @Override
            public void onSuccess(Demo demo) {
              LogUtils.e(demo.toString());
            }

            @Override
            public Demo convert(JsonElement result) {
//                return new Gson().fromJson(result,Demo.class);
                return JsonUtils.jsonToClass(result,Demo.class);
            }
        });
        new HttpClient.Builder()
                .setApiUrl("category/getCategory")
                .post()
                .setActivityEvent(ActivityEvent.DESTROY)
                .setLifecycleProvider(this)
                //怎么转换成json
                .setJsonBody("{\"parentId\":\"0\"}",true)
                //数据的回调要注意要理解
                .build().request(new HttpCallBack<List<ShopDemo>>() {
            @Override
            public void onError(String message, int code) {

            }

            @Override
            public void cancle() {

            }

            @Override
            public void onSuccess(List<ShopDemo> shopDemos) {
                LogUtils.e(shopDemos.toString());
            }

            @Override
            public List<ShopDemo> convert(JsonElement result) {
                return JsonUtils.jsonToClassList(result,ShopDemo.class);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    public void get(){
        ApiServer apiServer = HttpManager.getInstance().getRetrofit("", 5, TimeUnit.DAYS).create(ApiServer.class);
        Observable<JsonElement> post = apiServer.post("", new HashMap<String, Object>(), new HashMap<String, Object>());


        post.map(new Function<JsonElement, Object>() {
            @Override
            public Object apply(JsonElement jsonElement) throws Exception {
                return new Gson().toJson(jsonElement);
            }
        }).compose(this.bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
