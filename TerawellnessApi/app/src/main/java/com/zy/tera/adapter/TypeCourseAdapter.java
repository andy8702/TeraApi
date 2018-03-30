package com.zy.tera.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zy.tera.R;
import com.zy.tera.response.TypeCourseResponse;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class TypeCourseAdapter extends BaseAdapter {


    private List<TypeCourseResponse.TypeCourseInfo.Rows> list;
    private Context context;

    public TypeCourseAdapter(Context context,List<TypeCourseResponse.TypeCourseInfo.Rows> list){
        this.list = list;
        this.context = context;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = LayoutInflater.from(context).inflate(R.layout.text_item,null);
        TextView tv = v.findViewById(R.id.item_tv);
        tv.setText(list.get(i).name.toString());

        return v;
    }
}
