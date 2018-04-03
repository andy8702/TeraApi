package com.zy.tera.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.zy.tera.R;
import com.zy.tera.response.ApmtedCourseResponse;
import com.zy.tera.response.CourseDetailResponse;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class MyAppointmentAdapter extends BaseAdapter {


    private List<ApmtedCourseResponse.GroupClassInfo.ApmtedInfo> list;
    private Context context;
    private OnClickListener listener;

    public MyAppointmentAdapter(Context context, List<ApmtedCourseResponse.GroupClassInfo.ApmtedInfo> list) {
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
        final ApmtedCourseResponse.GroupClassInfo.ApmtedInfo item = list.get(i);

        View v = LayoutInflater.from(context).inflate(R.layout.course_info_item_book, null);
        TextView courseName = v.findViewById(R.id.tv_cname);
        courseName.setText(item.courseName.toString());

        TextView tName = v.findViewById(R.id.tv_tname);
        tName.setText(item.coachName.toString());

        TextView addr = v.findViewById(R.id.tv_timeaddr);
        addr.setText(item.clubName + " " + item.begindate+" "+item.begintime);

        Button btn = v.findViewById(R.id.btn_book);

        if ("NEW".equals(item.reservation_status)){
            btn.setText(R.string.cancel_app);
        }else{
            btn.setText(item.displaystr);
            btn.setEnabled(false);
            btn.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != listener) {
                    listener.onItemClick(item);
                }
            }
        });

        return v;
    }

    public interface OnClickListener {
        public void onItemClick(ApmtedCourseResponse.GroupClassInfo.ApmtedInfo item);
    }
}
