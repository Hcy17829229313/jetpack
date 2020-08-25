package com.hcy.jetpack;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hcy.jetpack.MyApp.fragment.HomeFragment;
import com.hcy.jetpack.MyApp.fragment.SeekFragment;
import com.hcy.jetpack.MyApp.fragment.SofaFragment;
import com.hcy.jetpack.MyApp.fragment.UserFragment;
import com.hcy.jetpack.jet.StatusBar;

public class MainActivity extends AppCompatActivity {


    private FrameLayout mFrameLayout;
    private BottomNavigationBar mbtn_bar;
    private FragmentManager supportFragmentManager;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private UserFragment userFragment;
    private SeekFragment seekFragment;
    private SofaFragment sofaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBar.fitSystemBar(this);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
        initNavigation();

    }


    private void initFragment() {
        supportFragmentManager = getSupportFragmentManager();
        transaction = supportFragmentManager.beginTransaction();
        homeFragment = new HomeFragment();
        //replace  每次切换到fragment 都是先销毁在创建，不建议用
        transaction.add(R.id.mFrameLayout, homeFragment);
        transaction.commit();
    }

    private void initNavigation() {
        mbtn_bar.setActiveColor(R.color.colorAccent);

        //生成BottomNavigationBar中的每一个item
        BottomNavigationItem item1 = new BottomNavigationItem(R.mipmap.icon_tab_home, "首页");
        BottomNavigationItem item2 = new BottomNavigationItem(R.mipmap.icon_tab_sofa, "沙发");
        BottomNavigationItem item3 = new BottomNavigationItem(R.mipmap.icon_tab_publish, "");
        BottomNavigationItem item4 = new BottomNavigationItem(R.mipmap.icon_tab_find, "发现");
        BottomNavigationItem item5 = new BottomNavigationItem(R.mipmap.icon_tab_mine, "我的");

        //将item添加到BottomNavigationBar中
        mbtn_bar.addItem(item1);
        mbtn_bar.addItem(item2);
        mbtn_bar.addItem(item3);
        mbtn_bar.addItem(item4);
        mbtn_bar.addItem(item5);

        mbtn_bar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        //设置BottomNavigationBar的模式
        mbtn_bar.setMode(BottomNavigationBar.MODE_FIXED);
        mbtn_bar.initialise();
        mbtn_bar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {


            //item变为选中回调
            @Override
            public void onTabSelected(int position) {
                transaction = supportFragmentManager.beginTransaction();
                hideFragment(transaction);
                switch (position) {
                    case 0:
                        homeFragment = new HomeFragment();
                        transaction.replace(R.id.mFrameLayout, homeFragment);

                        break;
                    case 1:

                        sofaFragment = new SofaFragment();
                        transaction.replace(R.id.mFrameLayout, sofaFragment);
                        break;
                    case 2:

                        break;
                    case 3:
                        seekFragment = new SeekFragment();
                        transaction.replace(R.id.mFrameLayout, seekFragment);
                        break;
                    case 4:
                        userFragment = new UserFragment();
                        transaction.replace(R.id.mFrameLayout, userFragment);
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
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (sofaFragment != null) {
            transaction.hide(sofaFragment);
        }

        if (seekFragment != null) {
            transaction.hide(seekFragment);
        }
        if (userFragment != null) {
            transaction.hide(userFragment);
        }
    }

    private static final String TAG = "MainActivity";

    private void initView() {
        mFrameLayout = (FrameLayout) findViewById(R.id.mFrameLayout);
        mbtn_bar = (BottomNavigationBar) findViewById(R.id.mbtn_bar);
    }
}