package com.example.tesy.egfragment;

import android.content.Intent;
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

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.R;
import com.example.tesy.adapter.BaBySubAdapter;
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.egBabyBean.BabySubBean;
import com.example.tesy.egui.BabyLisActivity;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class BabyFragment extends Fragment {
    private RecyclerView ba_sub_recycler;
    private ArrayList<BabySubBean> babySubBeanArrayList;
    private BaBySubAdapter baBySubAdapter;
    private int id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.baby_fragment, null);
        initView(inflate);
        id = getArguments().getInt("id");
        initData();
        return inflate;
    }

    private void initData() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_categories/" + id + "/playlists?channel=new&offset=0&limit=20")
                .build()
                .request(new HttpCallBack<List<BabySubBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<BabySubBean> babySubBeans) {
                        babySubBeanArrayList.addAll(babySubBeans);
                        baBySubAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<BabySubBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, BabySubBean.class);
                    }
                });
    }

    private void initView(View inflate) {
        ba_sub_recycler = inflate.findViewById(R.id.ba_sub_recycler);
        ba_sub_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        ba_sub_recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        babySubBeanArrayList = new ArrayList<>();
        baBySubAdapter = new BaBySubAdapter(getActivity(), babySubBeanArrayList);
        ba_sub_recycler.setAdapter(baBySubAdapter);

        baBySubAdapter.setItemClicki(new BaBySubAdapter.ItemClick() {
            @Override
            public void Click(BabySubBean subBean) {
                Intent intent = new Intent(getActivity(), BabyLisActivity.class);
                intent.putExtra("apid", subBean.getId());
                intent.putExtra("img", subBean.getImage());
                intent.putExtra("titc", subBean.getName());
                intent.putExtra("desc", subBean.getDescription());
                startActivity(intent);
            }
        });
    }
}
