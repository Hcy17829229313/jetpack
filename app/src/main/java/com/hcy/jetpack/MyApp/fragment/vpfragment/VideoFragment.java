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
import com.hcy.jetpack.MyApp.adapter.SoFaVideoAdapter;
import com.hcy.jetpack.MyApp.bean.SoFaBean;
import com.hcy.jetpack.R;
import com.hcy.jetpack.app.HttpCallBack;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment {
    private RecyclerView video_rlv;
    private ArrayList<SoFaBean.DataBean> arrayList;
    private SoFaVideoAdapter soFaVideoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.video_item, null);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        new HttpClient.Builder()
                .setApiUrl("serverdemo/feeds/queryHotFeedsList?pageCount=12&feedId=0&userId=0&feedType=video")
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
                        arrayList.addAll(dataBeans);
                        soFaVideoAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<SoFaBean.DataBean> convert(JsonElement result) {
                        SoFaBean soFaBean = JsonUtils.jsonToClass(result, SoFaBean.class);
                        return JsonUtils.jsonToClassList(soFaBean.getData(),SoFaBean.DataBean.class);
                    }
                });
    }

    private void initView(View inflate) {
        RecyclerView video_rlv = inflate.findViewById(R.id.video_rlv);
        video_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        video_rlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        arrayList = new ArrayList<>();
        soFaVideoAdapter = new SoFaVideoAdapter(getActivity(), arrayList);
        video_rlv.setAdapter(soFaVideoAdapter);
    }
}
