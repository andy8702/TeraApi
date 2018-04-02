package com.zy.tera.controller;

import android.text.TextUtils;

import com.zy.tera.DataAPIService;
import com.zy.tera.ServiceBuilder;
import com.zy.tera.response.CoachResponse;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.CourseDetailResponse;
import com.zy.tera.response.CourseResponse;
import com.zy.tera.response.CourseTypeResponse;
import com.zy.tera.response.TypeCourseResponse;
import com.zy.tera.utils.TimeUtils;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class CourseController {

    DataAPIService service;

    public CourseController(){
        if (null == service) {
            service = ServiceBuilder.getInstance();
        }
    }

    public void getCoursebyShop(String clubid,String date,final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "10");
        parameters.put("clubid", clubid);//上海广场2494
        if (TextUtils.isEmpty(date)){
            parameters.put("date", TimeUtils.getTodayDate());
        }else{
            parameters.put("date", date);
        }
        parameters.put("coursename", "");


        Call courseCall = ServiceBuilder.getInstance().searchCoursebyShop(parameters);
        courseCall.enqueue(new Callback<CourseDetailResponse>(){

            @Override
            public void onResponse(Call<CourseDetailResponse> call, Response<CourseDetailResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<CourseDetailResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

    public void getCoursebyCoachName(String name,final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("name", name);

        Call coachCall = ServiceBuilder.getInstance().getCoachInfo(parameters);
        coachCall.enqueue(new Callback<CoachResponse>() {
            @Override
            public void onResponse(Call<CoachResponse> call, Response<CoachResponse> response) {
                getCoursebyCoachId(response.body().data.rows.get(0).id.toString(),callback);
            }

            @Override
            public void onFailure(Call<CoachResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });


    }

    private void getCoursebyCoachId(String coachid,final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "30");
        parameters.put("coachid", coachid);
        parameters.put("lon", "4.9E-324");
        parameters.put("lat", "4.9E-324");


        Call courseCall = ServiceBuilder.getInstance().getCourseInfoByCoach(parameters);

        courseCall.enqueue(new Callback<CourseResponse>(){

            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

    public void getCourseInfobyName(String courseid,
                                    final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "30");
        parameters.put("courseid", courseid);
        parameters.put("lon", "4.9E-324");
        parameters.put("lat", "4.9E-324");


        Call courseCall = ServiceBuilder.getInstance().getCourseInfoByName(parameters);
        courseCall.enqueue(new Callback<CourseResponse>(){

            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

    public void getCourseByType(CourseTypeResponse.CourseTypeInfo.Rows item,
                                final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("tid", item.id);
        parameters.put("stype", "N");

        Call call = ServiceBuilder.getInstance().getCourseByType(parameters);

        call.enqueue(new Callback<TypeCourseResponse>() {
            @Override
            public void onResponse(Call<TypeCourseResponse> call, Response<TypeCourseResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<TypeCourseResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }



    public void loadCourseType(final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");

        Call call = ServiceBuilder.getInstance().getCourseType(parameters);

        call.enqueue(new Callback<CourseTypeResponse>() {
            @Override
            public void onResponse(Call<CourseTypeResponse> call, Response<CourseTypeResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<CourseTypeResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }
}
