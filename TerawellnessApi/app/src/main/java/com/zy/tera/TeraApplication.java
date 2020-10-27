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

import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
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

    private FlutterEngine flutterEngine;
    public static String FLUTTER_ACTIVITY_ENGINE_ID = "my_engine_id";

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.init(true);

        refreshRateInfo();

        initFlutter();

    }

    private void initFlutter(){
        // Instantiate a FlutterEngine.
        flutterEngine = new FlutterEngine(this);

        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine.getDartExecutor().executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
        );

        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
                .getInstance()
                .put(FLUTTER_ACTIVITY_ENGINE_ID, flutterEngine);
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
