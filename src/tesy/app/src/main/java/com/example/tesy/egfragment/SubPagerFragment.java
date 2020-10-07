package com.example.tesy.egfragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.R;
import com.example.tesy.adapter.SubAdapter;
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.egui.EgCountActivity;
import com.example.tesy.ergbean.EgBannerBean;
import com.example.tesy.ergbean.EgSubBean;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class SubPagerFragment extends Fragment {
    private int id;
    private SubAdapter subAdapter;
    private ArrayList<EgSubBean> egSubBeanArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.sub_item, null);
        initView(inflate);
        id = getArguments().getInt("id");
        initData();
        initListener();
        return inflate;
    }


    private void initData() {
        new HttpClient.Builder()
                .setApiUrl("api/v1/album_categories/" + id + "/albums?channel=new&offset=0&limit=20&sensitive=8")
                .get()
                .build()
                .request(new HttpCallBack<List<EgSubBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.d("Eerr", "onError: " + message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<EgSubBean> egSubBeans) {
                        egSubBeanArrayList.addAll(egSubBeans);
                        subAdapter.notifyDataSetChanged();
                        Log.d("fghj", "onSuccess: " + egSubBeans.toString());
                    }

                    @Override
                    public List<EgSubBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, EgSubBean.class);
                    }
                });
    }

    private void initView(View inflate) {
        RecyclerView sub_rlv = inflate.findViewById(R.id.sub_rlv);
        sub_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        sub_rlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        egSubBeanArrayList = new ArrayList<>();
        Log.d("jihe ", "initView: " + egSubBeanArrayList);
        subAdapter = new SubAdapter(getActivity(), egSubBeanArrayList);
        sub_rlv.setAdapter(subAdapter);
    }

    private void initListener() {
        subAdapter.setItemClick(new SubAdapter.ItemClick() {
            @Override
            public void Click(EgSubBean egSubBean) {
                Intent intent = new Intent(getActivity(), EgCountActivity.class);
                intent.putExtra("data",egSubBean);
                startActivity(intent);
            }
        });
    }

}
