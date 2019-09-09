package com.zy.tera.jetpack.pagedadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.zy.tera.R;

/**
 * Created by Yang ZHOU on 2019/9/9.
 */
public class PagedShopAdapter extends PagedListAdapter<ShopRows, PagedShopAdapter.ViewHolder> {


    public PagedShopAdapter(@NonNull DiffUtil.ItemCallback<ShopRows> diffCallback) {
        super(diffCallback);
    }

    public PagedShopAdapter(@NonNull AsyncDifferConfig<ShopRows> config) {
        super(config);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_shop_item, parent, false);
        // 实例化viewholder
        PagedShopAdapter.ViewHolder viewHolder = new PagedShopAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // 绑定数据
        holder.mTv.setText(getItem(position).clubname);
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
