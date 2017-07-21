package com.zkht.galdon.zhixuetest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkht.galdon.zhixuetest.R;
import com.zkht.galdon.zhixuetest.adapter.FragmentAdapter;
import com.zkht.galdon.zhixuetest.fragment.CompanyFragment;
import com.zkht.galdon.zhixuetest.fragment.MineFragment;
import com.zkht.galdon.zhixuetest.fragment.ZKFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> fragments;
    private List<String> fragmentNames;
    private List<Integer> fragmentImgs;

    private MineFragment mMineFragment;
    private CompanyFragment mCompanyFragment;
    private ZKFragment mZKFragment;

    private FragmentAdapter mFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        fragmentChange();
    }

    //初始化组件
    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    //绑定fragment和viewPager
    private void fragmentChange() {

        fragments = new ArrayList<>();
        fragmentNames = new ArrayList<>();
        fragmentImgs = new ArrayList<>();

        mMineFragment = new MineFragment();
        mCompanyFragment = new CompanyFragment();
        mZKFragment = new ZKFragment();

        fragments.add(mMineFragment);
        fragments.add(mCompanyFragment);
        fragments.add(mZKFragment);

        fragmentNames.add("我的");
        fragmentNames.add("学院");
        fragmentNames.add("智库");

        fragmentImgs.add(R.drawable.tab_mine);
        fragmentImgs.add(R.drawable.tab_company);
        fragmentImgs.add(R.drawable.tab_zk);

        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, fragmentNames);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        //设置tab的文字和图片
        for(int i = 0; i < mFragmentAdapter.getCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(R.layout.tab_item);

            if(i == 0) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_item_text)).setTextColor(0xFFF21010);
            }

            TextView textView = (TextView) tab.getCustomView().findViewById(R.id.tab_item_text);
            textView.setText(fragmentNames.get(i));

            ImageView imageView = (ImageView) tab.getCustomView().findViewById(R.id.tab_item_img);
            imageView.setImageResource(fragmentImgs.get(i));
        }

        //切换 tab item 时修改文字和图片
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_item_text)).setTextColor(0xFFF21010);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_item_text)).setTextColor(0xFF000000);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //禁用viewPager左右滑动切换
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }
}
