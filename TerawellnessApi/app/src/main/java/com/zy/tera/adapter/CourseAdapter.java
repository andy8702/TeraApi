package com.zy.tera.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zy.tera.R;
import com.zy.tera.TeraApplication;
import com.zy.tera.fragments.OnItemClickListener;
import com.zy.tera.response.CourseResponse;
import com.zy.tera.utils.TimeUtils;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {

    private List<CourseResponse.CourseInfo.Rows> mData;

    private OnItemClickListener onItemClickListener;

    private Context context;

    public CourseAdapter(List<CourseResponse.CourseInfo.Rows> data) {
        this.mData = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setContext(Context context){
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder v = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.course_info_item, parent, false),
                onItemClickListener);
        return v;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 绑定数据
        CourseResponse.CourseInfo.Rows row = mData.get(position);

        if (row.clubname.startsWith("上海")){
            holder.layoutItem.setBackgroundResource(R.color.item_highlight);
        }else{
            holder.layoutItem.setBackgroundResource(android.R.color.white);
        }
        holder.courseName.setText(row.coursename);
        holder.courseTrainer.setText(row.coachname);
        holder.CourseTimeAddr.setText(row.clubname+"("+row.begindate+" "+TimeUtils.dateToWeek(row.begindate) +" "+row.begintime+")");

        if (TeraApplication.ratemap.size()>0 && TeraApplication.ratemap.containsKey(row.coachname)){
            holder.ratingBar.setVisibility(View.VISIBLE);
            float f = (float) TeraApplication.ratemap.get(row.coachname);
            holder.ratingBar.setRating(f);
        }else{
            holder.ratingBar.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView courseName,courseTrainer,CourseTimeAddr;
        OnItemClickListener onItemClickListener;
        View layoutItem;
        RatingBar ratingBar;

        public ViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            courseName = (TextView) itemView.findViewById(R.id.tv_cname);
            courseTrainer = (TextView) itemView.findViewById(R.id.tv_tname);
            CourseTimeAddr = (TextView) itemView.findViewById(R.id.tv_timeaddr);
            layoutItem = itemView.findViewById(R.id.layout_item);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar1);

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
