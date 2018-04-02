package com.zy.tera.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.zy.tera.R;
import com.zy.tera.response.ShopDetailsResponse;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class ShopDetailAdapter extends BaseAdapter {


    private List<ShopDetailsResponse.ShopDetailInfo.Rows> list;
    private Context context;
    private OnClickListener listener;

    public ShopDetailAdapter(Context context, List<ShopDetailsResponse.ShopDetailInfo.Rows> list) {
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
        final ShopDetailsResponse.ShopDetailInfo.Rows item = list.get(i);

        View v = LayoutInflater.from(context).inflate(R.layout.shop_detail_item, null);
        TextView tv = v.findViewById(R.id.item_tv);
        tv.setText(item.name.toString());

        TextView addr = v.findViewById(R.id.item_addr);
        addr.setText(item.address.toString());

        Button btn = v.findViewById(R.id.btn_item_call);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null!=listener){
                    listener.onCall(item.phone);
                }
            }
        });

        View itemLayout = v.findViewById(R.id.layout_item);
        itemLayout.setOnClickListener(new View.OnClickListener() {
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
        public void onCall(String number);

        public void onItemClick(ShopDetailsResponse.ShopDetailInfo.Rows item);
    }
}
