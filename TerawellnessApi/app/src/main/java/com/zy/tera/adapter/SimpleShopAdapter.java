package com.zy.tera.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zy.tera.R;
import com.zy.tera.response.ShopResponse;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class SimpleShopAdapter extends RecyclerView.Adapter<SimpleShopAdapter.ViewHolder>  {

    private List<ShopResponse.ShopInfo.Rows> mData;

    public SimpleShopAdapter(List<ShopResponse.ShopInfo.Rows> data) {
        this.mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_shop_item, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 绑定数据
        holder.mTv.setText(mData.get(position).clubname);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView mTv;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv = (TextView) itemView.findViewById(R.id.item_tv);
            imageView = itemView.findViewById(R.id.item_logo);
        }
    }

}
