package com.example.tesy.egfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.R;
import com.example.tesy.adapter.GliAdapter;
import com.example.tesy.adapter.RecyAdapter;
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.egui.LookGrilActivity;
import com.example.tesy.egui.LookRecActivity;
import com.example.tesy.egui.OneActivity;
import com.example.tesy.ergbean.EgBannerBean;
import com.example.tesy.ergbean.EgBean;
import com.example.tesy.ergbean.EgGliBean;
import com.example.tesy.ergbean.OneBean;
import com.google.gson.JsonElement;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SelectFragment extends Fragment {
    private RecyclerView mGrilRecycler;
    private RecyclerView mRecycler;
    private ArrayList<EgGliBean> egGliBeanss;
    private GliAdapter gliAdapter;
    private ArrayList<EgBean.DataBean> videoBeanArrayList;
    private RecyAdapter recyAdapter;
    int id = 148;
    private ArrayList<EgBannerBean> egBannerBeans;
    private Banner mBanner;
    private ImageView one;
    private ImageView two;
    private ImageView three;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.sele_fragment_item, null);
        initView(inflate);
        initData();
        initmGrilRecycler();
        initDAta();
        initRecy();
        initReData();
        return inflate;
    }

    private void initData() {

        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("Authorization", "ergedd_android:Android");

        new HttpClient.Builder()
                .get()
                .setHeadres(stringObjectHashMap)
                .setApiUrl("api/v1/app_configs?types=promotion_banner")
                .build()
                .request(new HttpCallBack<List<EgBannerBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<EgBannerBean> egBannerBeans) {

                        String image_url = egBannerBeans.get(0).getImage_url();

                        if (getActivity() != null) {
                            Glide.with(getActivity()).load(image_url).into(one);

                            String image_url1 = egBannerBeans.get(1).getImage_url();
                            Glide.with(getActivity()).load(image_url1).into(two);

                            String image_url2 = egBannerBeans.get(2).getImage_url();
                            Glide.with(getActivity()).load(image_url2).into(three);
                        }

                        one.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                startActivity(new Intent(getActivity(), OneActivity.class));
                            }
                        });

                        two.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });

                        three.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                    }

                    @Override
                    public List<EgBannerBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, EgBannerBean.class);
                    }
                });
    }

    private void initReData() {


        new HttpClient.Builder()
                .setApiUrl("api/v1/home_items?type=1&channel=new&offset=0&limit=" + id + "&sensitive=8")
                .get()
                .build()
                .request(new HttpCallBack<List<EgBean.DataBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<EgBean.DataBean> videoBeans) {
                        videoBeanArrayList.addAll(videoBeans);
                        recyAdapter.notifyDataSetChanged();

                        recyAdapter.setItemClick(new RecyAdapter.ItemClick() {
                            @Override
                            public void Click(EgBean.DataBean dataBean) {
                                Intent intent = new Intent(getActivity(), LookRecActivity.class);
                                intent.putExtra("mp44", dataBean.getVideo().getResource());
                                intent.putExtra("titlee", dataBean.getVideo().getName());
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public List<EgBean.DataBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, EgBean.DataBean.class);
                    }
                });

    }


    private void initDAta() {
        new HttpClient.Builder()
                .setApiUrl("api/v1/albums/home_recommended?channel=new&offset=0&limit=8")
                .get()
                .build()
                .request(new HttpCallBack<List<EgGliBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<EgGliBean> egGliBeans) {
                        egGliBeanss.addAll(egGliBeans);
                        gliAdapter.notifyDataSetChanged();
                        gliAdapter.setItemClick(new GliAdapter.ItemClick() {
                            @Override
                            public void Click(EgGliBean egGliBean) {
                                Intent intent = new Intent(getActivity(), LookGrilActivity.class);
                                intent.putExtra("id", egGliBean.getId());
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public List<EgGliBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, EgGliBean.class);
                    }
                });
    }

    private void initmGrilRecycler() {
        mGrilRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        egGliBeanss = new ArrayList<>();
        gliAdapter = new GliAdapter(getActivity(), egGliBeanss);
        mGrilRecycler.setAdapter(gliAdapter);


    }

    private void initRecy() {
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        videoBeanArrayList = new ArrayList<>();
        recyAdapter = new RecyAdapter(getActivity(), videoBeanArrayList);
        mRecycler.setAdapter(recyAdapter);
    }

    private void initView(View inflate) {
        mGrilRecycler = inflate.findViewById(R.id.mGrilRecycler);
        mRecycler = inflate.findViewById(R.id.mRecycler);
        one = inflate.findViewById(R.id.one);
        two = inflate.findViewById(R.id.two);
        three = inflate.findViewById(R.id.three);

    }
}
