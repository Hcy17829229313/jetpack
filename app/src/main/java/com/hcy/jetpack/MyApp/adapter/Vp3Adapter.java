package com.hcy.jetpack.MyApp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.hcy.mvplibrary.base.BaseFragment;

import java.util.ArrayList;

public class Vp3Adapter extends FragmentPagerAdapter {
    private ArrayList<BaseFragment> fragments;

    public Vp3Adapter(@NonNull FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
