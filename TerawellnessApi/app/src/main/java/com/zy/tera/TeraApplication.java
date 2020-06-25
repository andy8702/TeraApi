package com.zy.tera;

import android.app.Application;
import android.util.Log;

import com.zy.tera.db.CoachRateInfo;
import com.zy.tera.db.TeraDatabase;
import com.zy.tera.response.LoginResponse;
import com.zy.tera.response.MembershipResponse;
import com.zy.tera.response.ShopResponse;
import com.zy.tera.response.WorkLoginResponse;
import com.zy.tera.utils.LogUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class TeraApplication extends Application {

    public LoginResponse loginResponse;
    public MembershipResponse membershipResponse;
    public ShopResponse shopInfo;

    public static boolean isUseSpecialBook = true;
    public static String LOGINID = "13524284562";

    private CompositeDisposable disposable = new CompositeDisposable();

    public static Map ratemap = new HashMap<String, Float>();

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(true);

        refreshRateInfo();

    }

    public void refreshRateInfo(){
        disposable.add(TeraDatabase.Companion.getInstance(this).coachRateInfoDao().getAllRatingCoach()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<CoachRateInfo>>() {
                               @Override
                               public void accept(List<CoachRateInfo> coachRateInfos) throws Exception {
                                   for (int i = 0; i < coachRateInfos.size(); i++) {
                                       ratemap.put(coachRateInfos.get(i).getName(), coachRateInfos.get(i).getRate());
                                   }

                               }
                           }
                ));
    }

    //for work
    public static WorkLoginResponse workLoginResponse = null;

    public void setLoginInfo(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
        Log.d("app", loginResponse.toString());
    }

    public void setMembershipInfo(MembershipResponse membershipResponse) {
        this.membershipResponse = membershipResponse;
        Log.d("app", membershipResponse.toString());
    }

    public void setAvailableShopInfo(ShopResponse shopInfo) {
        this.shopInfo = shopInfo;
        Log.d("app", shopInfo.toString());
    }

}
