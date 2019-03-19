package com.zy.tera;

import com.zy.tera.response.CheckinoutResponse;
import com.zy.tera.response.WorkLoginResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface WorkAPIService {

    @POST("client.do")
    Call<WorkLoginResponse> login(@QueryMap Map<String, String> parameters);

    @POST("client.do?method=checkin&type=checkin")
    Call<CheckinoutResponse> checkin(@QueryMap Map<String, String> parameters);

    @GET("client.do?method=checkin&type=checkout&latlng=31.259115,121.482835&addr=%E4%B8%8A%E6%B5%B7%E5%B8%82%E8%99%B9%E5%8F%A3%E5%8C%BA%E5%9B%9B%E5%B7%9D%E5%8C%97%E8%B7%AF1751%E5%8F%B7%E9%9D%A0%E8%BF%91%E5%90%8C%E6%96%87%E5%90%9B%E4%BA%AD%E9%85%92%E5%BA%97%28%E5%9B%9B%E5%B7%9D%E5%8C%97%E8%B7%AF%29")
    Call<CheckinoutResponse> checkout(@Query("sessionkey") String sessionkey,@Query("wifiMac")String wifimac);
}
