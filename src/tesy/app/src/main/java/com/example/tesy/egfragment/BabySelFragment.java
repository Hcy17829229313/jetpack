package com.example.tesy.egfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.babyAdapter.BabyItem2Adapter;
import com.example.tesy.babyAdapter.BabyItemAdapter;
import com.example.tesy.egBabyBean.BabyItem2Bean;
import com.example.tesy.egBabyBean.BabyItemBean;
import com.example.tesy.ergbean.EgBannerBean;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BabySelFragment extends Fragment {
    private RecyclerView ba_Rlv1;
    private RecyclerView ba_Rlv2;
    private ArrayList<BabyItemBean> babyItemBeanArrayList;
    private BabyItemAdapter babyItemAdapter;
    private ArrayList<BabyItem2Bean> babyItem2BeanArrayList;
    private BabyItem2Adapter babyItem2Adapter;
    private ImageView ba_one;
    private ImageView ba_two;
    private ImageView ba_three;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.baby_sele_item, null);
        initView(inflate);
        initBannerDa();
        initRlv1();
        initData1();
        initRlv2();
        initData2();
        return inflate;
    }

    private void initBannerDa() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("Authorization", "ergedd_android:Android");
        new HttpClient.Builder().setApiUrl("api/v1/app_configs?types=promotion_audio_banner")
                .get()
                .setHeadres(stringObjectHashMap)
                .build().request(new HttpCallBack<List<EgBannerBean>>() {
            @Override
            public void onError(String message, int code) {

            }

            @Override
            public void cancle() {

            }

            @Override
            public void onSuccess(List<EgBannerBean> egBannerBeans) {
                String image_url = egBannerBeans.get(0).getImage_url();

                if (getActivity()!=null){
                    Glide.with(getActivity()).load(image_url).into(ba_one);

                    String image_url1 = egBannerBeans.get(1).getImage_url();
                    Glide.with(getActivity()).load(image_url1).into(ba_two);

                    String image_url2 = egBannerBeans.get(2).getImage_url();
                    Glide.with(getActivity()).load(image_url2).into(ba_three);
                }

            }

            @Override
            public List<EgBannerBean> convert(JsonElement result) {
                return JsonUtils.jsonToClassList(result, EgBannerBean.class);
            }
        });
    }

    private void initData2() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_categories?channel=original")
                .build()
                .request(new HttpCallBack<List<BabyItem2Bean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<BabyItem2Bean> babyItem2Beans) {
                        babyItem2BeanArrayList.addAll(babyItem2Beans);
                        babyItem2Adapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<BabyItem2Bean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, BabyItem2Bean.class);
                    }
                });
    }

    private void initRlv2() {
        ba_Rlv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        ba_Rlv2.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        babyItem2BeanArrayList = new ArrayList<>();
        babyItem2Adapter = new BabyItem2Adapter(getActivity(), babyItem2BeanArrayList);
        ba_Rlv2.setAdapter(babyItem2Adapter);
    }

    private void initData1() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_playlists/excellent?channel=original")
                .build()
                .request(new HttpCallBack<List<BabyItemBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<BabyItemBean> babyItemBeans) {
                        babyItemBeanArrayList.addAll(babyItemBeans);
                        babyItemAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<BabyItemBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, BabyItemBean.class);
                    }
                });
    }

    private void initRlv1() {
        ba_Rlv1.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        babyItemBeanArrayList = new ArrayList<>();
        babyItemAdapter = new BabyItemAdapter(getActivity(), babyItemBeanArrayList);
        ba_Rlv1.setAdapter(babyItemAdapter);
    }

    private void initView(View inflate) {
        ba_Rlv1 = inflate.findViewById(R.id.ba_Rlv1);
        ba_Rlv2 = inflate.findViewById(R.id.ba_Rlv2);
        ba_one = inflate.findViewById(R.id.ba_one);
        ba_two = inflate.findViewById(R.id.ba_two);
        ba_three = inflate.findViewById(R.id.ba_three);
    }
}
