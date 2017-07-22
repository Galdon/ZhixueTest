package com.zkht.galdon.zhixuetest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.zkht.galdon.zhixuetest.R;
import com.zkht.galdon.zhixuetest.adapter.UserListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserActivity extends Activity {

    private ListView listView;
    private List<Map<String, Object>> listViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        listView = (ListView) findViewById(R.id.activity_user_list);
        listViewData = new ArrayList<Map<String, Object>>();
        bingAdapter();
    }

    public void bingAdapter() {

        Map<String, Object> item1 = new HashMap<String, Object>();
        Map<String, Object> item2 = new HashMap<String, Object>();
        Map<String, Object> item3 = new HashMap<String, Object>();
        Map<String, Object> item4 = new HashMap<String, Object>();

        item1.put("text", "成长任务卡");
        item1.put("img", R.drawable.user_cards);
        item2.put("text", "职业发展");
        item2.put("img", R.drawable.user_develope);
        item3.put("text", "智豆");
        item3.put("img", R.drawable.user_bean);
        item4.put("text", "我的审批");
        item4.put("img", R.drawable.user_audit);

        listViewData.add(item1);
        listViewData.add(item2);
        listViewData.add(item3);
        listViewData.add(item4);

        UserListViewAdapter listViewAdapter = new UserListViewAdapter(this, listViewData);
        listView.setAdapter(listViewAdapter);
    }
}
