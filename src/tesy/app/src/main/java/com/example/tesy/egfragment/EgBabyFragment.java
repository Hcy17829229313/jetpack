package com.example.tesy.egfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.httplibrary.client.HttpClient;
import com.example.httplibrary.utils.JsonUtils;
import com.example.tesy.R;
import com.example.tesy.adapter.PagerAdapter;
import com.example.tesy.app.HttpCallBack;
import com.example.tesy.egBabyBean.BabyTabBean;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class EgBabyFragment extends Fragment {
    private TabLayout ba_mTabLayout;
    private ViewPager ba_mViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.baby_item, null);
        initView(inflate);
        initpager();
        return inflate;
    }

    private void initpager() {
        new HttpClient.Builder()
                .get()
                .setApiUrl("api/v1/audio_categories?channel=original")
                .build()
                .request(new HttpCallBack<List<BabyTabBean>>() {
                    @Override
                    public void onError(String message, int code) {

                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    public void onSuccess(List<BabyTabBean> babyTabBeans) {

                        ArrayList<Fragment> fragments = new ArrayList<>();
                        fragments.add(new BabySelFragment());
                        for (int i = 0; i < babyTabBeans.size(); i++) {
                            BabyFragment babyFragment = new BabyFragment();
                            Bundle bundle = new Bundle();
                            bundle.putInt("id", babyTabBeans.get(i).getId());
                            babyFragment.setArguments(bundle);
                            fragments.add(babyFragment);
                        }
                        ba_mViewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), fragments));
                        ba_mTabLayout.setupWithViewPager(ba_mViewPager);
                        ba_mTabLayout.getTabAt(0).setText("精选");
                        for (int i = 0; i < babyTabBeans.size(); i++) {
                            BabyTabBean babyTabBean = babyTabBeans.get(i);
                            String name = babyTabBean.getName();
                            ba_mTabLayout.getTabAt(i+1).setText(name);
                        }

                    }

                    @Override
                    public List<BabyTabBean> convert(JsonElement result) {
                        return JsonUtils.jsonToClassList(result, BabyTabBean.class);
                    }
                });
    }

    private void initView(View inflate) {
        ba_mTabLayout = inflate.findViewById(R.id.ba_mTabLayout);
        ba_mViewPager = inflate.findViewById(R.id.ba_mViewPager);
        ba_mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

}
