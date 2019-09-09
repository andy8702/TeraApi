package com.zy.tera.jetpack.datasource;

import androidx.paging.DataSource;

import com.zy.tera.jetpack.pagedadapter.ShopRows;

import java.util.List;

/**
 * Created by Yang ZHOU on 2019/9/9.
 */
public class ShopDataFactory extends DataSource.Factory {

    private List<ShopRows> data;
    public ShopDataFactory(List<ShopRows> data){
        this.data = data;
    }

    @Override
    public DataSource create() {
        ShopDataSource source = new ShopDataSource(data);
        return source;
    }
}
