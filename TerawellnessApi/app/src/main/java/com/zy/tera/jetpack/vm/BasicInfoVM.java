package com.zy.tera.jetpack.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.zy.tera.jetpack.datasource.ShopDataFactory;
import com.zy.tera.jetpack.pagedadapter.ShopRows;

import java.util.List;

/**
 * Created by Yang ZHOU on 2019/9/9.
 */
public class BasicInfoVM extends ViewModel {

    private LiveData<PagedList<ShopRows>> shoprows;
    private List<ShopRows> data;

    public void setData(List<ShopRows> data){
        this.data = data;
    }

    public LiveData<PagedList<ShopRows>> getShoprows() {
        if (null == shoprows){
            PagedList.Config pagedListConfig =
                    (new PagedList.Config.Builder())
                            .setEnablePlaceholders(false)
                            .setInitialLoadSizeHint(10)
                            .setPageSize(20)
                            .build();

            ShopDataFactory factory = new ShopDataFactory(data);
            shoprows = (new LivePagedListBuilder(factory , pagedListConfig)).build();
        }
        return shoprows;
    }

}
