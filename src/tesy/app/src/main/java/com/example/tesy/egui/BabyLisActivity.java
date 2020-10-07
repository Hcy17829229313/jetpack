package com.example.tesy.egui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.R;
import com.example.tesy.app.HttpCallBackTwo;
import com.example.tesy.babyAdapter.BabyLisAdapter;
import com.example.tesy.egBabyBean.BabyTabListBean;
import com.example.tesy.music.MusicActivity;
import com.google.gson.JsonElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class BabyLisActivity extends AppCompatActivity {

    private RecyclerView Ba_Li_rlv;
    private ArrayList<BabyTabListBean> beanArrayList;
    private BabyLisAdapter babyLisAdapter;
    private int apid;
    private ImageView Image_head;
    private ImageView mohu_image;
    private TextView mohu_titc;
    private TextView mohu_desc;
    private TextView title_mohu;
    private String img;
    private String titc;
    private String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_lis);
        apid = getIntent().getIntExtra("apid", -1);
        img = getIntent().getStringExtra("img");
        titc = getIntent().getStringExtra("titc");
        desc = getIntent().getStringExtra("desc");
        initView();
        initdata();

    }

    private void initdata() {

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("apid", apid);
        stringObjectHashMap.put("offset", 0);
        stringObjectHashMap.put("limit", 20);
        stringObjectHashMap.put("os", 3);
        stringObjectHashMap.put("code", 20618);
        stringObjectHashMap.put("uuid", "d7623e5c-0d6e-4ecb-b1da-2e226080b64a");
        stringObjectHashMap.put("channel", "qihu");
        HashMap<String, Object> stringObjectHashMap2 = new HashMap<>();
        stringObjectHashMap2.put("Content-Type", "application/json");
        new HttpClient.Builder().
                setApiUrl("getAudioByPlaylistId")
                .post()
                .setParamser(stringObjectHashMap)
                .build()
                .request(new HttpCallBackTwo<BabyTabListBean>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.e("11111111111", "onError: " + message + code);
                    }

                    @Override
                    public void cancle() {
                    }

                    @Override
                    public void onSuccess(BabyTabListBean recordBean) {

                        Log.d("onff", "onSuccess: " + recordBean.toString());
                        for (BabyTabListBean.AudiosBean recordBeans : recordBean.getAudios()) {
                            beanArrayList.add(recordBean);
                        }
                        babyLisAdapter.notifyDataSetChanged();

                        babyLisAdapter.setItemClick(new BabyLisAdapter.ItemClick() {
                            @Override
                            public void onClick(int posi) {
                                Intent intent = new Intent(BabyLisActivity.this, MusicActivity.class);
                                intent.putExtra("list",beanArrayList);
                                intent.putExtra("posi",posi);
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public BabyTabListBean convert(JsonElement result) {
                        return JsonUtils.jsonToClass(result, BabyTabListBean.class);
                    }
                });
    }

    private void initView() {
        Ba_Li_rlv = (RecyclerView) findViewById(R.id.Ba_Li_rlv);
        Image_head = (ImageView) findViewById(R.id.Image_head);
        mohu_image = (ImageView) findViewById(R.id.mohu_image);
        mohu_titc = (TextView) findViewById(R.id.mohu_titc);
        mohu_desc = (TextView) findViewById(R.id.mohu_desc);
        title_mohu = (TextView) findViewById(R.id.title_mohu);
        Ba_Li_rlv.setLayoutManager(new LinearLayoutManager(this));
        Ba_Li_rlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        beanArrayList = new ArrayList<>();
        babyLisAdapter = new BabyLisAdapter(this, beanArrayList);
        Ba_Li_rlv.setAdapter(babyLisAdapter);
        //  取到传过来的图
        Glide.with(BabyLisActivity.this).load(img).into(Image_head);

        Glide.with(this)
                .load(img)
                .apply(RequestOptions.bitmapTransform(new BlurTransformation(100,3)))
                .into(mohu_image);

        //  取到传过来的title
        mohu_titc.setText(titc);
        //  取到传过来的title
        title_mohu.setText(titc);
        //  取到传过来的内容
        mohu_desc.setText(desc);

    }
}
