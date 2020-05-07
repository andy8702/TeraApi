package com.zy.tera.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.zy.tera.R;
import com.zy.tera.TeraApplication;
import com.zy.tera.response.CourseDetailResponse;

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

        View blacklist = v.findViewById(R.id.blacklist);
        View recommond = v.findViewById(R.id.tv_recommond);
        View pending = v.findViewById(R.id.tv_pending);

        if (null!= TeraApplication.blacklist && TeraApplication.blacklist.contains(item.coachname.toString())){
            blacklist.setVisibility(View.VISIBLE);

            courseName.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
            tName.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
            addr.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
        }else{
            blacklist.setVisibility(View.GONE);
            courseName.getPaint().setFlags(0);
            tName.getPaint().setFlags(0);
            addr.getPaint().setFlags(0);
        }

        if (null!=TeraApplication.pendingList && TeraApplication.pendingList.contains(item.coachname.toString())){
            pending.setVisibility(View.VISIBLE);
        }else{
            pending.setVisibility(View.GONE);
        }

        if (null!=TeraApplication.recommondlist && TeraApplication.recommondlist.contains(item.coachname.toString())){
            recommond.setVisibility(View.VISIBLE);
        }else{
            recommond.setVisibility(View.GONE);
        }

        return v;
    }

    public interface OnClickListener {
        public void onItemClick(CourseDetailResponse.CourseDetailInfo item);
    }
}
