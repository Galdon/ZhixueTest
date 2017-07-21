package com.zkht.galdon.zhixuetest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Gaozhi on 2017/7/21.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> fragmentNames;


    public FragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> fragmentNames) {
        super(fm);
        this.fragments = fragments;
        this.fragmentNames = fragmentNames;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

//    @Override
//    public CharSequence getPageTitle(int position) {
//        return fragmentNames.get(position);
//    }
}
