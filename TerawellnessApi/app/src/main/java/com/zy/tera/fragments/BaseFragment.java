package com.zy.tera.fragments;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.zy.tera.R;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class BaseFragment extends Fragment implements IFragment{

    ProgressDialog dialog = null;

    AlertDialog simpleDialog;

    FragmentListener listener;

    public void setFragmentListener(FragmentListener listener){
        this.listener = listener;
    }

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
        Toast.makeText(getContext(),msg,Toast.LENGTH_LONG).show();
    }

    public void showAlertDialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        // 设置参数
        builder.setMessage(msg).setPositiveButton(R.string.confrim, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                simpleDialog.dismiss();
            }
        });

        simpleDialog = builder.create();
        simpleDialog.show();
    }
}
