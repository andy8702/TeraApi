package com.zy.tera.controller;

import android.util.Log;

import com.zy.tera.BookAPIService;
import com.zy.tera.BookServiceBuilder;
import com.zy.tera.DataAPIService;
import com.zy.tera.ServiceBuilder;
import com.zy.tera.response.BookResultResponse;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.CourseBookResponse;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookController {

    DataAPIService service;

    BookAPIService bookService;

    public void makeAppointment(final String courseid, final String userid,final String mobile,final String membercode,
                           final ControllerInterface callback){
        if (null == service) {
            service = ServiceBuilder.getInstance();
        }

        if (null == callback){
            throw new IllegalArgumentException("no callback");
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put("opid", courseid);
        parameters.put("coursetype", "1");
        parameters.put("userid", userid);

        Call bookCall = service.makeAppointment(parameters);

        bookCall.enqueue(new Callback<CourseBookResponse>() {

            @Override
            public void onResponse(Call<CourseBookResponse> call, Response<CourseBookResponse> response) {
                bookCourese(courseid,userid,mobile,membercode,callback);
            }

            @Override
            public void onFailure(Call<CourseBookResponse> call, Throwable throwable) {
                callback.onError(throwable.toString());
            }
        });

    }

    private void bookCourese(final String courseid, final String userid,final String mobile,final String membercode,
                             final ControllerInterface callback){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("opid", courseid);
        parameters.put("coursetype", "1");
        parameters.put("userid", userid);

        Call bookCall = service.bookCourse(parameters);

        bookCall.enqueue(new Callback<CourseBookResponse>() {

            @Override
            public void onResponse(Call<CourseBookResponse> call, Response<CourseBookResponse> response) {
                String sourceid = response.body().data.sourceId;
                book(sourceid,membercode,mobile,callback);
            }

            @Override
            public void onFailure(Call<CourseBookResponse> call, Throwable throwable) {
                callback.onError(throwable.toString());
            }
        });
    }

    private void book(String sourceid,String membercode,String mobile,final ControllerInterface callback){
        if (null == bookService) {
            bookService = BookServiceBuilder.getInstance();
        }

        if (null == callback){
            throw new IllegalArgumentException("no callback");
        }

        Map<String, String> parameters = new HashMap<>();
        parameters.put("course_id", sourceid);
        parameters.put("member_code", membercode);
        parameters.put("mobile", mobile);

        Call call = bookService.book(parameters);

        Log.d("test",call.request().url().toString());
        call.enqueue(new Callback<BookResultResponse>(){

            @Override
            public void onResponse(Call<BookResultResponse> call, Response<BookResultResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<BookResultResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }
}
