package com.example.day20190709zhoukao1.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day20190709zhoukao1.R;
import com.example.day20190709zhoukao1.model.bean.Bean;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Bean> list;

    public MyAdapter(Context context, List<Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
          viewHolder holder;
        if (convertview==null){
           convertview =  View.inflate(context, R.layout.item,null);
           holder = new viewHolder();
           holder.iv = convertview.findViewById(R.id.iv);
           holder.tv_desc = convertview.findViewById(R.id.tv_desc);
            convertview.setTag(holder);
        }
        return convertview;
    }

    class viewHolder{
        private TextView tv_desc;
        private ImageView iv;
    }
}
