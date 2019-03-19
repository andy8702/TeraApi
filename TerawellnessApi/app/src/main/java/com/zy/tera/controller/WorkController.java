package com.zy.tera.controller;

import android.content.Context;
import android.util.Log;

import com.zy.tera.TeraApplication;
import com.zy.tera.WorkAPIService;
import com.zy.tera.WorkServiceBuilder;
import com.zy.tera.response.CheckinoutResponse;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.WorkLoginResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkController {

    private Context context;
    public WorkController(Context context){
        this.context = context;
    }

    WorkAPIService service;

    String addr = "%E4%B8%8A%E6%B5%B7%E5%B8%82%E8%99%B9%E5%8F%A3%E5%8C%BA%E5%9B%9B%E5%B7%9D%E5%8C%97%E8%B7%AF1751%E5%8F%B7%E9%9D%A0%E8%BF%91%E5%90%8C%E6%96%87%E5%90%9B%E4%BA%AD%E9%85%92%E5%BA%97%28%E5%9B%9B%E5%B7%9D%E5%8C%97%E8%B7%AF%29";

    public void login(String username, String password, final ControllerInterface callback) {
        if (null == service) {
            service = WorkServiceBuilder.getInstance(context);
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
                Log.d("fail",t.toString());
                callback.onError(t.toString());
            }
        });
    }

    public void checkout(final ControllerInterface callback) {
        if (null == service) {
            service = WorkServiceBuilder.getInstance(context);
        }

        if (null == callback) {
            throw new IllegalArgumentException("no callback");
        }


        Call bookCall = service.checkout(TeraApplication.workLoginResponse.sessionkey,"null");

        bookCall.enqueue(new Callback<CheckinoutResponse>() {
            @Override
            public void onResponse(Call<CheckinoutResponse> call, Response<CheckinoutResponse> response) {
                Log.d("work",call.request().toString());
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<CheckinoutResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

    public void checkin(final ControllerInterface callback) {
        if (null == service) {
            service = WorkServiceBuilder.getInstance(context);
        }

        if (null == callback) {
            throw new IllegalArgumentException("no callback");
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put("method", "checkin");
        parameters.put("type", "checkin");
        parameters.put("latlng", "31.259115,121.482835");
        parameters.put("addr", addr);
        parameters.put("sessionkey", TeraApplication.workLoginResponse.sessionkey);
        parameters.put("wifiMac", "null");


        Call bookCall = service.checkin(parameters);

        bookCall.enqueue(new Callback<CheckinoutResponse>() {
            @Override
            public void onResponse(Call<CheckinoutResponse> call, Response<CheckinoutResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<CheckinoutResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }
}
