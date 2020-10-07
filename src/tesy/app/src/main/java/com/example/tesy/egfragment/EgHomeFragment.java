package com.example.tesy.egfragment;

import android.os.Bundle;
import android.util.Log;
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
import com.example.tesy.ergbean.EgHomeTabBean;
import com.example.tesy.mvp.presenter.EgPresenter;
import com.example.tesy.mvp.view.RgView;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonElement;
import com.hcy.mvplibrary.base.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

public class    EgHomeFragment extends BaseMvpFragment<RgView, EgPresenter> implements RgView {
    private TabLayout eg_TabLayout;
    private ViewPager eg_ViewPager;
    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.er_home_item, null);
        return inflate;
    }

    @Override
    protected int initLayoutId() {
        return R.layout.er_home_item;
    }

    @Override
    public void SuccessView(List<EgHomeTabBean> egHomeTabBeans) {

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new SelectFragment());
        for (int i = 0; i < egHomeTabBeans.size(); i++) {
            SubPagerFragment subPagerFragment = new SubPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("id", egHomeTabBeans.get(i).getId());
            subPagerFragment.setArguments(bundle);
            fragments.add(subPagerFragment);
        }
        fragments.add(new HuoFragment());
        eg_ViewPager.setAdapter(new PagerAdapter(getChildFragmentManager(), fragments));
        eg_TabLayout.setupWithViewPager(eg_ViewPager);
        eg_TabLayout.getTabAt(0).setText("精选");
        for (int i = 0; i < egHomeTabBeans.size(); i++) {
            String name = egHomeTabBeans.get(i).getName();
            eg_TabLayout.getTabAt(i + 1).setText(name);
        }
        eg_TabLayout.getTabAt(7).setText("伙伴");
    }

    @Override
    protected void initdata() {
        mPresenter.getData();
    }

    @Override
    protected void initView() {
        eg_TabLayout = inflate.findViewById(R.id.eg_TabLayout);
        eg_ViewPager = inflate.findViewById(R.id.eg_ViewPager);
        eg_TabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    protected EgPresenter initPresenter() {
        return new EgPresenter();
    }

    @Override
    public void Error(String s, int Code) {

    }

    @Override
    public void Cancel() {

    }
}
