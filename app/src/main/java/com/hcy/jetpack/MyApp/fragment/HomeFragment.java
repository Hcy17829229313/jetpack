package com.hcy.jetpack.MyApp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonElement;
import com.hcy.httplibrary.HttpManager;
import com.hcy.httplibrary.client.HttpClient;
import com.hcy.httplibrary.servicer.ApiServer;
import com.hcy.httplibrary.utils.JsonUtils;
import com.hcy.httplibrary.utils.LogUtils;
import com.hcy.jetpack.MyApp.adapter.HomeAdapter;
import com.hcy.jetpack.MyApp.bean.HomeBean;
import com.hcy.jetpack.R;
import com.hcy.jetpack.app.Demo;
import com.hcy.jetpack.app.HttpCallBack;
import com.hcy.jetpack.app.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment {


    private HashMap<String, Object> map;
    private RecyclerView mRecycler;
    private ArrayList<HomeBean.DataBean> homeBeans;
    private HomeAdapter homeAdapter;
    int position;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.hone_item, null);
        initView(inflate);
        initDta();
        initListener();
        return inflate;
    }



    private void initDta() {
        map = new HashMap<>();
        map.put("pageCount", 12);
        map.put("feedId", 0);
        map.put("feedType", "all");
        new HttpClient.Builder()
                .setApiUrl("serverdemo/feeds/queryHotFeedsList")
                .get()
//                .setHeadres(map)
                .build()
                .request(new HttpCallBack<List<HomeBean.DataBean>>() {

                    @Override
                    public void onError(String message, int code) {
                        Log.d("hunagcy", "onReeo" + message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<HomeBean.DataBean> demo) {
                        Log.d(TAG, "onSuccess: " + demo.toString());
                        homeBeans.addAll(demo);
                        homeAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public List<HomeBean.DataBean> convert(JsonElement result) {
                        HomeBean homeBean = JsonUtils.jsonToClass(result, HomeBean.class);
                        return JsonUtils.jsonToClassList(homeBean.getData(), HomeBean.DataBean.class);
                    }
                });
    }

    private void initView(View inflate) {
        mRecycler = inflate.findViewById(R.id.mRecycler);
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        homeBeans = new ArrayList<>();
        homeAdapter = new HomeAdapter(getActivity(), homeBeans);
        mRecycler.setAdapter(homeAdapter);
    }
    private void initListener() {
        homeAdapter.setItemClick(new HomeAdapter.ItemClick() {
            @Override
            public void Click(int posi) {
                position = posi;
            }
        });

    }


    private static final String TAG = "HomeFragment";
}
