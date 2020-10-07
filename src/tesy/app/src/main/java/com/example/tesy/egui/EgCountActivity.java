package com.example.tesy.egui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.R;
import com.example.tesy.adapter.CountAdapter;
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.ergbean.EgCountBean;
import com.example.tesy.ergbean.EgSubBean;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class EgCountActivity extends AppCompatActivity {

    private TextView Count_title;
    private ImageView Count_msg;
    private ImageView Count_back;
    private ImageView Count_share;
    private EgSubBean data;
    private RecyclerView Count_rlv;
    private ArrayList<EgCountBean> egCountBeanArrayList;
    private CountAdapter countAdapter;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg_count);
        initView();
        data = (EgSubBean) getIntent().getSerializableExtra("data");
        id = data.getId();
        initData();
        initRlv();
        initDa();
    }

    private void initDa() {
        new HttpClient.Builder()
                .setApiUrl("api/v1/albums/"+id+"/videos?channel=new&offset=0&limit=20&sensitive=8")
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
                        egCountBeanArrayList.addAll(egCountBeans);
                        countAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<EgCountBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, EgCountBean.class);
                    }
                });
    }

    private void initRlv() {
        Count_rlv.setLayoutManager(new LinearLayoutManager(this));
        Count_rlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        egCountBeanArrayList = new ArrayList<>();
        countAdapter = new CountAdapter(this, egCountBeanArrayList);
        Count_rlv.setAdapter(countAdapter);

        countAdapter.setItemClick(new CountAdapter.ItemClick() {
            @Override
            public void Click(EgCountBean egCountBean) {
                Intent intent = new Intent(EgCountActivity.this,LookActivity.class);
                intent.putExtra("mp4",egCountBean.getResource());
                intent.putExtra("title",egCountBean.getName());
                startActivity(intent);
            }
        });
    }

    private void initData() {
        Count_title.setText(data.getName());
    }

    private void initView() {
        Count_title = (TextView) findViewById(R.id.Count_title);
        Count_msg = (ImageView) findViewById(R.id.Count_msg);
        Count_back = (ImageView) findViewById(R.id.Count_back);
        Count_share = (ImageView) findViewById(R.id.Count_share);
        Count_rlv = (RecyclerView) findViewById(R.id.Count_rlv);
        Count_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
