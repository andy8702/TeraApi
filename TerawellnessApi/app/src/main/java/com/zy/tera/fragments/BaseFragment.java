package com.zy.tera.fragments;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;
import android.widget.TextView;
import android.widget.Toast;

import com.zy.tera.R;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class BaseFragment extends Fragment {

    ProgressDialog dialog = null;

    public void replaceSpaceHolder(TextView tv, String value){
        String testStr = tv.getText().toString();
        tv.setText(String.format(testStr,value));
    }

    public void loadingProgressDialog(int res){
        if (null == dialog){
            dialog = new ProgressDialog(getContext());
        }
        dialog.setMessage(getString(res));
        dialog.show();
    }

    public void dismissLoading(){
        if (dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }

    public void showToast(String msg){
        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG);
    }
}
