package com.hcy.jetpack.MyApp.fragment.vpfragment;

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

import com.google.gson.JsonElement;
import com.hcy.httplibrary.client.HttpClient;
import com.hcy.httplibrary.utils.JsonUtils;
import com.hcy.jetpack.MyApp.adapter.SoFaTxtAdapter;
import com.hcy.jetpack.MyApp.bean.SoFaBean;
import com.hcy.jetpack.R;
import com.hcy.jetpack.app.HttpCallBack;

import java.util.ArrayList;
import java.util.List;

public class TextFragment extends Fragment {
    private RecyclerView txt_rlv;
    private ArrayList<SoFaBean.DataBean> beanArrayList;
    private SoFaTxtAdapter soFaTxtAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.text_item, null);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {

        new HttpClient.Builder()
                .setApiUrl("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedId=0&userId=0&feedType=text")
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
                        beanArrayList.addAll(dataBeans);
                        soFaTxtAdapter.notifyDataSetChanged();
                        Log.d("3", "onSuccess: "+dataBeans);
                    }

                    @Override
                    public List<SoFaBean.DataBean> convert(JsonElement result) {
                        SoFaBean soFaBean = JsonUtils.jsonToClass(result, SoFaBean.class);
                        return JsonUtils.jsonToClassList(soFaBean.getData(),SoFaBean.DataBean.class);
                    }
                });
    }

    private void initView(View inflate) {
        RecyclerView txt_rlv = inflate.findViewById(R.id.txt_rlv);
        txt_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        txt_rlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        beanArrayList = new ArrayList<>();
        soFaTxtAdapter = new SoFaTxtAdapter(getActivity(), beanArrayList);
        txt_rlv.setAdapter(soFaTxtAdapter);
    }
}
