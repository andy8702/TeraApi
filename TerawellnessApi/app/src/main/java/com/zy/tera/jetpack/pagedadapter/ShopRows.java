package com.zy.tera.jetpack.pagedadapter;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

/**
 * Created by Yang ZHOU on 2019/9/9.
 */
public class ShopRows {

    public String club_id;
    public String club_no;
    public String clubname;

    public static DiffUtil.ItemCallback<ShopRows> DIFF_CALLBACK = new DiffUtil.ItemCallback<ShopRows>() {
        @Override
        public boolean areItemsTheSame(@NonNull ShopRows oldItem, @NonNull ShopRows newItem) {
            return oldItem.club_id == newItem.club_id;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull ShopRows oldItem, @NonNull ShopRows newItem) {
            return oldItem.equals(newItem);
        }
    };
}
