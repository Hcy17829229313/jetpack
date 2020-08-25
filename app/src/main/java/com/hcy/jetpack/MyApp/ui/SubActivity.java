package com.hcy.jetpack.MyApp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonElement;
import com.hcy.httplibrary.client.HttpClient;
import com.hcy.httplibrary.utils.JsonUtils;
import com.hcy.httplibrary.utils.LogUtils;
import com.hcy.jetpack.MyApp.adapter.SubAdapter;
import com.hcy.jetpack.MyApp.bean.SeekBean;
import com.hcy.jetpack.R;
import com.hcy.jetpack.app.HttpCallBack;

import java.util.ArrayList;
import java.util.HashMap;

public class SubActivity extends AppCompatActivity {

    private RecyclerView mrlv_sub;
    private ArrayList<SeekBean.DataBean> beanArrayList;
    private SubAdapter subAdapter;
    private int id;
    private RecyclerView mrlv_sub2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        initView();
        initData();
    }

    private void initData() {

        id = getIntent().getIntExtra("id", 0);

        HashMap<String, Object> map = new HashMap<>();
        map.put("pageCount", "10");
        map.put("tagId", "0");
        map.put("userId", "0");
        map.put("offset", "0");
        map.put("tagType", "excludeFollow");
        new HttpClient.Builder()
                .setApiUrl("serverdemo/tag/queryTagList")
                .get()
                .setParamser(map)
                .build().request(new HttpCallBack<SeekBean>() {
            @Override
            public void onError(String message, int code) {
                LogUtils.e(message + code);
            }

            @Override
            public void cancle() {

            }

            @Override
            public void onSuccess(SeekBean dataBean) {
                Log.d("seek", "onSuccess: " + dataBean.toString());
                beanArrayList.addAll(dataBean.getData());
                subAdapter.notifyDataSetChanged();
            }

            @Override
            public SeekBean convert(JsonElement result) {
                return JsonUtils.jsonToClass(result, SeekBean.class);
            }
        });
    }

    private void initView() {
        mrlv_sub = (RecyclerView) findViewById(R.id.mrlv_sub);
        mrlv_sub.setLayoutManager(new LinearLayoutManager(this));
        beanArrayList = new ArrayList<>();
        subAdapter = new SubAdapter(this, beanArrayList);
        mrlv_sub.setAdapter(subAdapter);
        mrlv_sub2 = (RecyclerView) findViewById(R.id.mrlv_sub2);
    }
}