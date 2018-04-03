package com.zy.tera.controller;

import com.zy.tera.Constants;
import com.zy.tera.DataAPIService;
import com.zy.tera.ServiceBuilder;
import com.zy.tera.TeraApplication;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.LoginResponse;
import com.zy.tera.response.MembershipResponse;
import com.zy.tera.response.ShopDetailsResponse;
import com.zy.tera.response.ShopResponse;
import com.zy.tera.utils.TimeUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginController {

    DataAPIService service;

    public void loginResponse(final ControllerInterface callback) throws IOException {
        if (null == service) {
            service = ServiceBuilder.getInstance();
        }

        if (null == callback){
            throw new IllegalArgumentException("no callback");
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("phone", TeraApplication.LOGINID);
        parameters.put("cardid", TeraApplication.LOGINID);
        parameters.put("pwd", "5EDF3A560E2F7A3A2ECF979A598805C6");
        parameters.put("oldUser", "");

        Call loginCall = service.getLoginInfo(parameters);

        loginCall.enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                callback.onError(throwable.toString());
            }
        });

    }

    public void loadMembership(String userid,final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("userid", userid);

        Call membershipCall = ServiceBuilder.getInstance().getMembership(parameters);

        membershipCall.enqueue(new Callback<MembershipResponse>(){
            @Override
            public void onResponse(Call<MembershipResponse> call, Response<MembershipResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<MembershipResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

    public void loadAvailableShop(MembershipResponse response,final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("no", response.getValidCardInfo().get(0).getMembership_no());
        parameters.put("co", response.getValidCardInfo().get(0).getMembership_co());

        Call shopCall = ServiceBuilder.getInstance().getShopInfo(parameters);

        shopCall.enqueue(new Callback<ShopResponse>() {
            @Override
            public void onResponse(Call<ShopResponse> call, Response<ShopResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<ShopResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

    public void loadSearchShop(String name,final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "10");
        parameters.put("lat", "4.9E-324");
        parameters.put("lon", "4.9E-324");
        parameters.put("clubname", name);

        Call shopCall = ServiceBuilder.getInstance().searchShop(parameters);

        shopCall.enqueue(new Callback<ShopDetailsResponse>(){

            @Override
            public void onResponse(Call<ShopDetailsResponse> call, Response<ShopDetailsResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<ShopDetailsResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

}
