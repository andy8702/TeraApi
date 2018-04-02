package com.zy.tera.fragments;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.zy.tera.MainActivity;
import com.zy.tera.R;
import com.zy.tera.adapter.ShopDetailAdapter;
import com.zy.tera.controller.LoginController;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.ShopDetailsResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopSearchFragment extends BaseFragment{

    private EditText editText;
    private Button btnSearch;
    private ListView listView;


    public ShopSearchFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editText = view.findViewById(R.id.et_shop_search);
        btnSearch = view.findViewById(R.id.btn_shop_search);
        listView = view.findViewById(R.id.ls_shop);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchShop();
            }
        });
    }

    public void searchShop(){
        loadingProgressDialog(R.string.loading);
        new LoginController().loadSearchShop(editText.getText().toString().trim(), new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                dismissLoading();
                ShopDetailsResponse response = (ShopDetailsResponse) obj;
                buildListView(response);
            }

            @Override
            public void onError(String msg) {
                dismissLoading();
                showToast(msg);
            }
        });
    }

    public void buildListView(ShopDetailsResponse response){
        ShopDetailAdapter detailAdapter = new ShopDetailAdapter(getContext(),response.data.rows);
        detailAdapter.setOnClickListener(new ShopDetailAdapter.OnClickListener() {
            @Override
            public void onCall(String number) {
                if(ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CALL_PHONE},1);
                }else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);//设置活动类型
                    intent.setData(Uri.parse("tel:"+number));//设置数据
                    startActivity(intent);//开启意图
                }
            }

            @Override
            public void onItemClick(ShopDetailsResponse.ShopDetailInfo.Rows item) {
                if (null!=listener){
                    listener.onReceive(MainActivity.COMMOND_SHOP_COURSES,item);
                }
            }
        });

        listView.setAdapter(detailAdapter);

    }

}
