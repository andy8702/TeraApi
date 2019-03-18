package com.zy.tera.controller;

import com.zy.tera.WorkAPIService;
import com.zy.tera.WorkServiceBuilder;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.WorkLoginResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkController {

    WorkAPIService service;

    public void login(String username, String password, final ControllerInterface callback) {
        if (null == service) {
            service = WorkServiceBuilder.getInstance();
        }

        if (null == callback) {
            throw new IllegalArgumentException("no callback");
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put("method", "login");
        parameters.put("loginid", username);
        parameters.put("password", password);
        parameters.put("isneedmoulds", "1");
        parameters.put("client", "1");
        parameters.put("clientver", "6.5 .47");
        parameters.put("udid", "357586090467124");
        parameters.put("clientos", "PPR1.180610.011");
        parameters.put("clientosver", "9");
        parameters.put("clienttype", "android");
        parameters.put("language", "zh");
        parameters.put("country", "CN");
        parameters.put("relogin", "0");


        Call bookCall = service.login(parameters);

        bookCall.enqueue(new Callback<WorkLoginResponse>() {
            @Override
            public void onResponse(Call<WorkLoginResponse> call, Response<WorkLoginResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<WorkLoginResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

}
