package com.example.tesy.egfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.R;
import com.example.tesy.adapter.FriendAdapter;
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.ergbean.EgFriandBean;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HuoFragment extends Fragment {
    private RecyclerView mFriend_rlv;
    private ArrayList<EgFriandBean> egFriandBeanArrayList;
    private FriendAdapter friendAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.huo_fragment_item, null);
        initView(inflate);
        initdata();
        return inflate;
    }

    private void initdata() {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("Authorization", "ergedd_android:Android");
        new HttpClient.Builder()
                .setApiUrl("api/v1/app_configs?types=brand_area")
                .get()
                .setHeadres(stringObjectHashMap)
                .build()
                .request(new HttpCallBack<List<EgFriandBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<EgFriandBean> egFriandBeans) {
                        egFriandBeanArrayList.addAll(egFriandBeans);
                        friendAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<EgFriandBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, EgFriandBean.class);
                    }
                });
    }

    private void initView(View inflate) {
        mFriend_rlv = inflate.findViewById(R.id.mFriend_rlv);
        mFriend_rlv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        egFriandBeanArrayList = new ArrayList<>();
        friendAdapter = new FriendAdapter(getActivity(), egFriandBeanArrayList);
        mFriend_rlv.setAdapter(friendAdapter);
    }
}
