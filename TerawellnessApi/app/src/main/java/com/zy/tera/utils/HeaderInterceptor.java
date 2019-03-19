package com.zy.tera.utils;

import android.util.Log;

import com.zy.tera.TeraApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        if (original.url().toString().contains("client.do?method=checkin&type=checkout")||
                original.url().toString().contains("client.do?method=checkin&type=checkin")
        ) {
            Log.d("header", "checkout add header");

            Request request = original.newBuilder()
                    .header("Accept-Language", "zh-CN,zh;q=0.5")
                    .header("Accept-Charset", "utf-8;q=0.7,*;q=0.7")
                    .header("Accept-Encoding", "gzip")
                    .header("Timezone", "GMT+08:00")
                    .header("Host", "oa.sheca.com:8443")
                    .header("Connection", "Keep-Alive")
                    .header("User-Agent", "E-Mobile/6.5.47 (Linux;U;Android 2.2.1;zh-CN;Nexus One Build.FRG83) AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1")
                    .header("Cookie", "userid=286; userKey=fbf5c233-f909-437f-a419-847f5f87e5ae; ClientUDID=357586090467124; ClientToken=; ClientVer=6.5.47; ClientType=android; ClientLanguage=zh; ClientCountry=CN; ClientMobile=; setClientOS=PPR1.180610.011; setClientOSVer=9; Pad=false; JSESSIONID=" + TeraApplication.workLoginResponse.sessionkey)
                    .header("Cookie2", "$Version=1")
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        } else {
            return chain.proceed(original);
        }
    }
}
