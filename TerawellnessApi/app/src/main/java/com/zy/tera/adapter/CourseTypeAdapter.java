package com.zy.tera.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zy.tera.R;
import com.zy.tera.fragments.OnItemClickListener;
import com.zy.tera.response.CourseTypeResponse;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class CourseTypeAdapter extends RecyclerView.Adapter<CourseTypeAdapter.ViewHolder>  {

    private List<CourseTypeResponse.CourseTypeInfo.Rows> mData;

    private OnItemClickListener onItemClickListener;

    public CourseTypeAdapter(List<CourseTypeResponse.CourseTypeInfo.Rows> data) {
        this.mData = data;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder v = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item, parent, false),
                onItemClickListener);
        return v;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 绑定数据
        holder.mTv.setText(mData.get(position).name.toString());
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mTv;
        ImageView imageView;
        OnItemClickListener onItemClickListener;

        public ViewHolder(View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.item_tv);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onClick(getPosition());
        }
    }

}
