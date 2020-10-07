package com.example.tesy.egfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tesy.R;
import com.example.tesy.adapter.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class EgLucheFragment extends Fragment {
    private TabLayout luch_TabLayout;
    private ViewPager luch_viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.luche_item, null);
        initView(inflate);
        initPager();
        return inflate;
    }

    private void initPager() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new Video_Zhuan_Fragment());
        fragments.add(new VideoFragment());
        fragments.add(new Video_yin_Fragment());

        luch_viewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), fragments));
        luch_TabLayout.setupWithViewPager(luch_viewPager);

        luch_TabLayout.getTabAt(0).setText("视频专辑");
        luch_TabLayout.getTabAt(1).setText("视频");
        luch_TabLayout.getTabAt(2).setText("音频");
    }

    private void initView(View inflate) {
        luch_TabLayout = inflate.findViewById(R.id.luch_TabLayout);
        luch_viewPager = inflate.findViewById(R.id.luch_viewPager);
    }
}
