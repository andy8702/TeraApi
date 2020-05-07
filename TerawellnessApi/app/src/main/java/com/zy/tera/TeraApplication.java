package com.zy.tera;

import android.app.Application;
import android.util.Log;

import com.zy.tera.response.LoginResponse;
import com.zy.tera.response.MembershipResponse;
import com.zy.tera.response.ShopResponse;
import com.zy.tera.response.WorkLoginResponse;
import com.zy.tera.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class TeraApplication extends Application{

    public LoginResponse loginResponse;
    public MembershipResponse membershipResponse;
    public ShopResponse shopInfo;

    public static boolean isUseSpecialBook = true;
    public static String LOGINID ="13524284562";
    public static List blacklist;
    public static List recommondlist;
    public static List pendingList;

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(true);

        String[] p = getResources().getStringArray(R.array.array_pending);
        if (null != p && p.length>0){
            pendingList = new ArrayList();
            for (int i=0;i<p.length;i++){
                pendingList.add(p[i]);
            }
        }

        String[] b = getResources().getStringArray(R.array.array_blacklist);
        if (null != b && b.length>0){
            blacklist = new ArrayList();
            for (int i=0;i<b.length;i++){
                blacklist.add(b[i]);
            }
        }

        String[] r = getResources().getStringArray(R.array.array_recommondlist);
        if (null != r && r.length>0){
            recommondlist = new ArrayList();
            for (int i=0;i<r.length;i++){
                recommondlist.add(r[i]);
            }
        }
    }

    //for work
    public static WorkLoginResponse workLoginResponse = null;

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
