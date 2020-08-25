package com.hcy.jetpack.MyApp.fragment.vpfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonElement;
import com.hcy.httplibrary.client.HttpClient;
import com.hcy.httplibrary.utils.JsonUtils;
import com.hcy.jetpack.MyApp.adapter.SoFoImageAdapter;
import com.hcy.jetpack.MyApp.bean.SoFaBean;
import com.hcy.jetpack.R;
import com.hcy.jetpack.app.HttpCallBack;

import java.util.ArrayList;
import java.util.List;

public class ImageFragment extends Fragment {


    private ArrayList<SoFaBean.DataBean> dataBeansss;
    private SoFoImageAdapter soFoImageAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.image_item, null);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        new HttpClient.Builder()
                .setApiUrl("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedId=0&userId=0&feedType=pics")
                .get()
                .build()
                .request(new HttpCallBack<List<SoFaBean.DataBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<SoFaBean.DataBean> dataBeans) {
                        dataBeansss.addAll(dataBeans);
                        soFoImageAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<SoFaBean.DataBean> convert(JsonElement result) {
                        SoFaBean soFaBean = JsonUtils.jsonToClass(result, SoFaBean.class);
                        return JsonUtils.jsonToClassList(soFaBean.getData(),SoFaBean.DataBean.class);
                    }
                });
    }

    private void initView(View inflate) {
        RecyclerView sofa_img_rlv = inflate.findViewById(R.id.sofa_img_rlv);
        sofa_img_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        sofa_img_rlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        dataBeansss = new ArrayList<>();
        soFoImageAdapter = new SoFoImageAdapter(getActivity(), dataBeansss);
        sofa_img_rlv.setAdapter(soFoImageAdapter);
    }
}
