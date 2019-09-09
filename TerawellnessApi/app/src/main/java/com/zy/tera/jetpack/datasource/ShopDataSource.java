package com.zy.tera.jetpack.datasource;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.zy.tera.jetpack.pagedadapter.ShopRows;

import java.util.List;

/**
 * Created by Yang ZHOU on 2019/9/9.
 */
public class ShopDataSource extends PageKeyedDataSource<Long, ShopRows> {

    private List<ShopRows> data;
    public ShopDataSource(List<ShopRows> data){
        this.data = data;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Long> params, @NonNull LoadInitialCallback<Long, ShopRows> callback) {
        callback.onResult(data,null,null);
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, ShopRows> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Long> params, @NonNull LoadCallback<Long, ShopRows> callback) {
        callback.onResult(data,null);
    }
}
