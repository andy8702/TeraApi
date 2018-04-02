package com.zy.tera;

import android.app.Application;
import android.util.Log;

import com.zy.tera.response.LoginResponse;
import com.zy.tera.response.MembershipResponse;
import com.zy.tera.response.ShopResponse;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class TeraApplication extends Application{

    public LoginResponse loginResponse;
    public MembershipResponse membershipResponse;
    public ShopResponse shopInfo;

    public static boolean isUseSpecialBook = true;

    public void setLoginInfo(LoginResponse loginResponse){
        this.loginResponse = loginResponse;
        Log.d("app",loginResponse.toString());
    }

    public void setMembershipInfo(MembershipResponse membershipResponse){
        this.membershipResponse = membershipResponse;
        Log.d("app",membershipResponse.toString());
    }

    public void setAvailableShopInfo(ShopResponse shopInfo){
        this.shopInfo = shopInfo;
        Log.d("app",shopInfo.toString());
    }

}
