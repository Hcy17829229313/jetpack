package com.example.tesy.egui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.R;
import com.example.tesy.adapter.LookCountAdapter;
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.ergbean.EgCountBean;
import com.example.tesy.ergbean.EgGliBean;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class LookGrilActivity extends AppCompatActivity {

    private RecyclerView Rlv_look_gil;
    private ArrayList<EgCountBean> beanArrayList;
    private LookCountAdapter lookCountAdapter;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_gril);
        initView();
        id = getIntent().getIntExtra("id", 0);
        initData();
    }

    private void initData() {
        new HttpClient.Builder()
                .setApiUrl("api/v1/albums/" + id + "/videos?channel=new&offset=0&limit=20&sensitive=8")
                .get()
                .build()
                .request(new HttpCallBack<List<EgCountBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<EgCountBean> egCountBeans) {
                        beanArrayList.addAll(egCountBeans);
                        lookCountAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<EgCountBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, EgCountBean.class);
                    }
                });
    }

    private void initView() {
        Rlv_look_gil = (RecyclerView) findViewById(R.id.Rlv_look_gil);
        Rlv_look_gil.setLayoutManager(new LinearLayoutManager(this));
        beanArrayList = new ArrayList<>();
        lookCountAdapter = new LookCountAdapter(this, beanArrayList);
        Rlv_look_gil.setAdapter(lookCountAdapter);
    }
}
