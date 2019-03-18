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

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkFragment extends Fragment {

    private TextView tvResult;
    private EditText etUsername, etPassword;
    private Button btnLogin, btnCheckin, btnCheckout;


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
    }

    private void login(){

    }

    private void checkin(){

    }

    private void checkout(){

    }
}
