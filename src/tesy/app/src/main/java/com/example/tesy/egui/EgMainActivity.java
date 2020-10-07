package com.example.tesy.egui;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.tesy.R;
import com.example.tesy.egfragment.EgBabyFragment;
import com.example.tesy.egfragment.EgHomeFragment;
import com.example.tesy.egfragment.EgLucheFragment;

public class EgMainActivity extends AppCompatActivity {

    private FrameLayout frame;
    private BottomNavigationBar nav_btnBar;

    private FragmentManager supportFragmentManager;
    private FragmentTransaction transaction;
    private EgHomeFragment egHomeFragment;
    private EgLucheFragment egLucheFragment;
    private EgBabyFragment egBabyFragment;
    RelativeLayout toobat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eg_main);
        initView();
        initFragment();
        initNavigation();
    }

    private void initView() {
        frame = (FrameLayout) findViewById(R.id.frame);
        toobat = (RelativeLayout) findViewById(R.id.toobat);
        nav_btnBar = (BottomNavigationBar) findViewById(R.id.nav_btnBar);
    }

    private void initFragment() {
        supportFragmentManager = getSupportFragmentManager();
        transaction = supportFragmentManager.beginTransaction();
        egHomeFragment = new EgHomeFragment();
        //replace  每次切换到fragment 都是先销毁在创建，不建议用
        transaction.add(R.id.frame, egHomeFragment);
        transaction.commit();
    }

    private void initNavigation() {
        nav_btnBar.setActiveColor(R.color.colorPrimary);
        nav_btnBar.setBarBackgroundColor(R.color.text_dark);

        //生成BottomNavigationBar中的每一个item
        BottomNavigationItem item1 = new BottomNavigationItem(R.mipmap.video_unchecked, "宝宝看");
        BottomNavigationItem item2 = new BottomNavigationItem(R.mipmap.audio_unchecked, "宝宝听");
        BottomNavigationItem item3 = new BottomNavigationItem(R.mipmap.mine_unchecked, "缓存");

        //将item添加到BottomNavigationBar中
        nav_btnBar.addItem(item1);
        nav_btnBar.addItem(item2);
        nav_btnBar.addItem(item3);


        nav_btnBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //设置BottomNavigationBar的模式
        nav_btnBar.setMode(BottomNavigationBar.MODE_FIXED);
        nav_btnBar.initialise();
        nav_btnBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {


            //item变为选中回调
            @Override
            public void onTabSelected(int position) {
                transaction = supportFragmentManager.beginTransaction();
                hideFragment(transaction);
                switch (position) {
                    case 0:
                        egHomeFragment = new EgHomeFragment();
                        transaction.add(R.id.frame, egHomeFragment);

                        break;
                    case 1:

                        egBabyFragment = new EgBabyFragment();
                        transaction.add(R.id.frame, egBabyFragment);
                        break;
                    case 2:
                        egLucheFragment = new EgLucheFragment();
                        toobat.setVisibility(View.GONE);
                        transaction.add(R.id.frame, egLucheFragment);
                        break;

                }
                transaction.commit();
            }

            //item变为未选中回调
            @Override
            public void onTabUnselected(int position) {

            }

            //item再次变为选中回调
            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (egHomeFragment != null) {
            toobat.setVisibility(View.VISIBLE);
            transaction.hide(egHomeFragment);
        }
        if (egBabyFragment != null) {
            toobat.setVisibility(View.VISIBLE);
            transaction.hide(egBabyFragment);
        }

        if (egLucheFragment != null) {
            transaction.hide(egLucheFragment);
        }

    }
}
