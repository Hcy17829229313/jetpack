package com.hcy.jetpack.MyApp.fragment.seekFvg;

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

import com.example.greendaodemo.db.CollectionBeanDao;
import com.hcy.jetpack.MyApp.adapter.Seek2SubAdapter;
import com.hcy.jetpack.MyApp.adapter.SeekSubAdapter;
import com.hcy.jetpack.MyApp.bean.CollectionBean;
import com.hcy.jetpack.MyApp.db.Utils;
import com.hcy.jetpack.R;
import com.hcy.jetpack.app.MyApp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

public class AttionFragment extends Fragment {
    private RecyclerView Seek_rlv;
    private ArrayList<CollectionBean> beans;
    private CollectionBeanDao dao;
    private SeekSubAdapter seekSubAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.sub_item, null);
        EventBus.getDefault().register(this);
        initView(inflate);

        return inflate;
    }

    @Subscribe
    public void initData(String s) {
        List<CollectionBean> all = dao.loadAll();
        beans.clear();
        beans.addAll(all);
        Log.d("233", "initData: " + all);
        seekSubAdapter.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        Seek_rlv = inflate.findViewById(R.id.Seek_rlv);
        Seek_rlv.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        Seek_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        dao = MyApp.getInstance().getDaoSession().getCollectionBeanDao();

        List<CollectionBean> all = dao.loadAll();

        beans = new ArrayList<>();
        beans.addAll(all);
        seekSubAdapter = new SeekSubAdapter(getActivity(), beans);
        Seek_rlv.setAdapter(seekSubAdapter);
    }
}
