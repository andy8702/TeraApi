package com.zy.tera.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zy.tera.R;
import com.zy.tera.TeraApplication;
import com.zy.tera.controller.WorkController;
import com.zy.tera.response.CheckinoutResponse;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.WorkLoginResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkFragment extends Fragment {

    private TextView tvResult;
    private EditText etUsername, etPassword;
    private Button btnLogin, btnCheckin, btnCheckout;

    private WorkController controller;


    public WorkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_work, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvResult = view.findViewById(R.id.result);
        etUsername = view.findViewById(R.id.username);
        etPassword = view.findViewById(R.id.password);

        btnLogin = view.findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btnCheckin = view.findViewById(R.id.checkin);
        btnCheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkin();
            }
        });

        btnCheckout = view.findViewById(R.id.checkout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkout();
            }
        });

        controller = new WorkController();
    }

    private void login(){
        controller.login(etUsername.getText().toString().trim(),
                etPassword.getText().toString().trim(),
                new ControllerInterface() {
                    @Override
                    public void onResult(Object obj) {
                        WorkLoginResponse response = (WorkLoginResponse) obj;
                        TeraApplication.workLoginResponse = response;
                        tvResult.setText(response.sessionkey);
                    }

                    @Override
                    public void onError(String msg) {
                        tvResult.setText(msg);
                    }
                });
    }

    private void checkin(){

    }

    private void checkout(){
        controller.checkout(new ControllerInterface() {
            @Override
            public void onResult(Object obj) {
                CheckinoutResponse response = (CheckinoutResponse) obj;
                String msg = response.result + " " + response.msg + " "
                        +response.errorno + " "+response.error;
                tvResult.setText(msg);
            }

            @Override
            public void onError(String msg) {
                tvResult.setText(msg);
            }
        });
    }
}
