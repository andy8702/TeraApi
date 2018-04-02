package com.zy.tera.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.zy.tera.R;
import com.zy.tera.response.CourseDetailResponse;
import com.zy.tera.response.ShopDetailsResponse;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class ShopCourseAdapter extends BaseAdapter {


    private List<CourseDetailResponse.CourseDetailInfo> list;
    private Context context;
    private OnClickListener listener;

    public ShopCourseAdapter(Context context, List<CourseDetailResponse.CourseDetailInfo> list) {
        this.list = list;
        this.context = context;
    }

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
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
        final CourseDetailResponse.CourseDetailInfo item = list.get(i);

        View v = LayoutInflater.from(context).inflate(R.layout.course_info_item_book, null);
        TextView courseName = v.findViewById(R.id.tv_cname);
        courseName.setText(item.coursename.toString());

        TextView tName = v.findViewById(R.id.tv_tname);
        tName.setText(item.coachname.toString());

        TextView addr = v.findViewById(R.id.tv_timeaddr);
        addr.setText(item.clubname+" "+item.coursetime.toString());

        Button btn = v.findViewById(R.id.btn_book);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null!=listener){
                    listener.onItemClick(item);
                }
            }
        });

        return v;
    }

    public interface OnClickListener {
        public void onItemClick(CourseDetailResponse.CourseDetailInfo item);
    }
}
