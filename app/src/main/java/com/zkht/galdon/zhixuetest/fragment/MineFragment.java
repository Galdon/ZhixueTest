package com.zkht.galdon.zhixuetest.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkht.galdon.zhixuetest.R;
import com.zkht.galdon.zhixuetest.activity.SearchActivity;
import com.zkht.galdon.zhixuetest.activity.UserActivity;
import com.zkht.galdon.zhixuetest.adapter.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private ImageView userImage;
    private ImageView searchImage;

    private List<Fragment> fragments;
    private List<String> fragmentNames;

    private MineDynamicFragment mMineDynamicFragment;
    private MineCreationFragment mMineCreationFragment;
    private MineCollectionFragment mMineCollectionFragment;
    private MineSubscribeFragment mMineSubscribeFragment;

    private FragmentAdapter mFragmentAdapter;


    public MineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        fragmentChange();

    }

    private void initView() {
        mTabLayout = (TabLayout) getActivity().findViewById(R.id.top_tab);
        mViewPager = (ViewPager) getActivity().findViewById(R.id.viewPager_mine);

        userImage = (ImageView) getActivity().findViewById(R.id.user_img);
        searchImage = (ImageView) getActivity().findViewById(R.id.search_img);

        userImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Intent intent = new Intent(getActivity(), UserActivity.class);
                    getActivity().startActivity(intent);
                }
                return true;
            }
        });

        searchImage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    Intent intent = new Intent(getActivity(), SearchActivity.class);
                    getActivity().startActivity(intent);
                }
                return true;
            }
        });
    }

    private void fragmentChange() {
        fragments = new ArrayList<>();
        fragmentNames = new ArrayList<>();

        mMineDynamicFragment = new MineDynamicFragment();
        mMineCreationFragment = new MineCreationFragment();
        mMineCollectionFragment = new MineCollectionFragment();
        mMineSubscribeFragment = new MineSubscribeFragment();

        fragments.add(mMineDynamicFragment);
        fragments.add(mMineCreationFragment);
        fragments.add(mMineCollectionFragment);
        fragments.add(mMineSubscribeFragment);

        fragmentNames.add("动态");
        fragmentNames.add("创作");
        fragmentNames.add("收藏");
        fragmentNames.add("订阅");

        mFragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragments, fragmentNames);  //getChildFragmentManager解决viewPager错误问题
        mViewPager.setAdapter(mFragmentAdapter);
//        mViewPager.setCurrentItem(0);
        mTabLayout.setupWithViewPager(mViewPager);

        //设置tab的文字
        for(int i = 0; i < mFragmentAdapter.getCount(); i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(R.layout.tab_item_top);

            if(i == 0) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_item_top_text)).setTextColor(0xFFF21010);
            }

            TextView textView = (TextView) tab.getCustomView().findViewById(R.id.tab_item_top_text);
            textView.setText(fragmentNames.get(i));
        }

        //切换 tab item 时修改文字
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_item_top_text)).setTextColor(0xFFF21010);
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_item_top_text)).setTextColor(0xFF000000);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                ((TextView) tab.getCustomView().findViewById(R.id.tab_item_top_text)).setTextColor(0xFFF21010);
                mViewPager.setCurrentItem(tab.getPosition());
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
