package com.zkht.galdon.zhixuetest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zkht.galdon.zhixuetest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineCreationFragment extends Fragment {


    public MineCreationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine_creation, container, false);
    }

}
