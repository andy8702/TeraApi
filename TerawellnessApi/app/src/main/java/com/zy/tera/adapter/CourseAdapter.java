package com.zy.tera.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zy.tera.R;
import com.zy.tera.fragments.OnItemClickListener;
import com.zy.tera.response.CourseResponse;
import com.zy.tera.response.CourseTypeResponse;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private List<CourseResponse.CourseInfo.Rows> mData;

    private OnItemClickListener onItemClickListener;

    public CourseAdapter(List<CourseResponse.CourseInfo.Rows> data) {
        this.mData = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder v = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.course_info_item, parent, false),
                onItemClickListener);
        return v;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 绑定数据
        CourseResponse.CourseInfo.Rows row = mData.get(position);

        holder.courseName.setText(row.coursename);
        holder.courseTrainer.setText(row.coachname);
        holder.CourseTimeAddr.setText(row.clubname+" "+row.begintime+"-" + row.endtime);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView courseName,courseTrainer,CourseTimeAddr;
        OnItemClickListener onItemClickListener;

        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            courseName = (TextView) itemView.findViewById(R.id.tv_cname);
            courseTrainer = (TextView) itemView.findViewById(R.id.tv_tname);
            CourseTimeAddr = (TextView) itemView.findViewById(R.id.tv_timeaddr);

            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (null != onItemClickListener) {
                onItemClickListener.onClick(getPosition());
            }

        }
    }

}
