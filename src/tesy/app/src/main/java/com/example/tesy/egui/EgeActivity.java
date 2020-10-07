package com.example.tesy.egui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.tesy.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class EgeActivity extends AppCompatActivity {

    private TabLayout eg_TabLayout;
    private ViewPager eg_ViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ege);
        initView();
        initPager();
    }

    private void initPager() {
        List<Fragment> fragments = new ArrayList<>();

    }

    private void initView() {
        eg_TabLayout = (TabLayout) findViewById(R.id.eg_TabLayout);
        eg_ViewPager = (ViewPager) findViewById(R.id.eg_ViewPager);
    }
}
