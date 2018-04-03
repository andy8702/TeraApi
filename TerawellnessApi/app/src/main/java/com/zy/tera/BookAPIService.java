package com.zy.tera;

import com.zy.tera.response.BookResultResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface BookAPIService {

    @GET("yzwderpserver/erp/coursereservation?")
    Call<BookResultResponse> book(@QueryMap Map<String, String> parameters);

    @GET("yzwderpserver/erp/coursereservationcancel?")
    Call<BookResultResponse> cancelBook(@QueryMap Map<String, String> parameters);
}
