package com.hcy.jetpack.MyApp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.hcy.jetpack.MyApp.adapter.Vp3Adapter;
import com.hcy.jetpack.MyApp.fragment.seekFvg.SubFragment;
import com.hcy.jetpack.MyApp.fragment.seekFvg.AttionFragment;
import com.hcy.jetpack.R;
import com.hcy.mvplibrary.base.BaseFragment;

import java.util.ArrayList;

public class SeekFragment extends Fragment {
    private TabLayout Seek_TabLayout;
    private ViewPager Seek_ViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.seek_item, null);
        initView(inflate);
        initPager();
        return inflate;
    }

    private void initPager() {
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new AttionFragment());
        fragments.add(new SubFragment());

        final ArrayList<String> titles = new ArrayList<>();
        titles.add("关注");
        titles.add("推荐");

        Seek_ViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles.get(position);
            }
        });

        Seek_TabLayout.setupWithViewPager(Seek_ViewPager);



    }
    private View getCusView(String text) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.text, null);
        TextView text_tv = inflate.findViewById(R.id.text_tv);
        text_tv.setText(text);
        return inflate;
    }

    private void initView(View inflate) {
         Seek_TabLayout = inflate.findViewById(R.id.Seek_TabLayout);
         Seek_ViewPager = inflate.findViewById(R.id.Seek_ViewPager);
    }
}

