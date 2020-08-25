package com.hcy.jetpack.MyApp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hcy.jetpack.MyApp.adapter.Vp3Adapter;
import com.hcy.jetpack.MyApp.adapter.VpAdapter;
import com.hcy.jetpack.MyApp.fragment.vpfragment.ImageFragment;
import com.hcy.jetpack.MyApp.fragment.vpfragment.TextFragment;
import com.hcy.jetpack.MyApp.fragment.vpfragment.VideoFragment;
import com.hcy.jetpack.R;

import java.util.ArrayList;

public class SofaFragment extends Fragment {


    private ViewPager mViewPager;
    private TabLayout mTabLyout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.so_item, null);
        initView(inflate);
        initPager();
        return inflate;
    }

    private void initView(View inflate) {
        mTabLyout = inflate.findViewById(R.id.mTabLyout);
        mViewPager = inflate.findViewById(R.id.mViewPager);
    }

    private void initPager() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ImageFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), fragments);

        mTabLyout.setupWithViewPager(mViewPager);

        mViewPager.setAdapter(vpAdapter);
        mTabLyout.setupWithViewPager(mViewPager);
        mTabLyout.getTabAt(0).setCustomView(getCusView("图片"));
        mTabLyout.getTabAt(1).setCustomView(getCusView("视频"));
        mTabLyout.getTabAt(2).setCustomView(getCusView("文本"));


    }

    private View getCusView(String text) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.text, null);
        TextView text_tv = inflate.findViewById(R.id.text_tv);
        text_tv.setText(text);
        return inflate;
    }
}
