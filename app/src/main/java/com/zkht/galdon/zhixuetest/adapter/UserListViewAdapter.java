package com.zkht.galdon.zhixuetest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zkht.galdon.zhixuetest.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Gaozhi on 2017/7/22.
 */

public class UserListViewAdapter extends BaseAdapter {

    private List<Map<String, Object>> data;
    private Context context;
    private LayoutInflater layoutInflater;

    public UserListViewAdapter(Context context, List<Map<String, Object>> data) {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.listview_user, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.listView_user_text);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.listView_user_img);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.textView.setText((String) data.get(position).get("text"));
        viewHolder.imageView.setImageResource((Integer) data.get(position).get("img"));

        return convertView;
    }

    public class ViewHolder{
        public ImageView imageView;
        public TextView textView;
    }
}
