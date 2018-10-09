package com.zy.tera.fragments;

/**
 * Created by Yang ZHOU on 2018/10/9.
 */
public interface IFragment {

    public void loadingProgressDialog(int res);
    public void dismissLoading();
    public void showToast(String msg);
    public void showAlertDialog(String msg);

}
