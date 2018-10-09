package com.zy.tera.controller;

import android.text.TextUtils;

import com.zy.tera.DataAPIService;
import com.zy.tera.R;
import com.zy.tera.ServiceBuilder;
import com.zy.tera.fragments.IFragment;
import com.zy.tera.response.ApmtedCourseResponse;
import com.zy.tera.response.CoachResponse;
import com.zy.tera.response.ControllerInterface;
import com.zy.tera.response.CourseDetailResponse;
import com.zy.tera.response.CourseResponse;
import com.zy.tera.response.CourseTypeResponse;
import com.zy.tera.response.TypeCourseResponse;
import com.zy.tera.utils.TimeUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by yz250242 on 2018/3/29.
 */

public class CoursePresenter {

    DataAPIService service;
    IFragment view;

    public CoursePresenter(IFragment view) {
        if (null == service) {
            service = ServiceBuilder.getInstance();
        }
        this.view = view;
    }

    public void getAptedCourse(String userid, final ControllerInterface callback) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userid", userid);
        parameters.put("pageNum", "1");
        parameters.put("numPerPage", "10");


        Call makeCall = ServiceBuilder.getInstance().getApmtedCourse(parameters);

        makeCall.enqueue(new Callback<ApmtedCourseResponse>() {

            @Override
            public void onResponse(Call<ApmtedCourseResponse> call, Response<ApmtedCourseResponse> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<ApmtedCourseResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });
    }

    public void getCoursebyShop(String clubid, String date, final ControllerInterface callback) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "10");
        parameters.put("clubid", clubid);//上海广场2494
        if (TextUtils.isEmpty(date)) {
            parameters.put("date", TimeUtils.getTodayDate());
        } else {
            parameters.put("date", date);
        }
        parameters.put("coursename", "");


        Call courseCall = ServiceBuilder.getInstance().searchCoursebyShop(parameters);
        courseCall.enqueue(new Callback<CourseDetailResponse>() {

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

    public void getCoursebyCoachName(String name, final ControllerInterface callback) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("name", name);

        Call coachCall = ServiceBuilder.getInstance().getCoachInfo(parameters);
        coachCall.enqueue(new Callback<CoachResponse>() {
            @Override
            public void onResponse(Call<CoachResponse> call, Response<CoachResponse> response) {
                getCoursebyCoachId(response.body().data.rows.get(0).id.toString(), callback);
            }

            @Override
            public void onFailure(Call<CoachResponse> call, Throwable t) {
                callback.onError(t.toString());
            }
        });


    }

    private void getCoursebyCoachId(String coachid, final ControllerInterface callback) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "30");
        parameters.put("coachid", coachid);
        parameters.put("lon", "4.9E-324");
        parameters.put("lat", "4.9E-324");


        Call courseCall = ServiceBuilder.getInstance().getCourseInfoByCoach(parameters);

        courseCall.enqueue(new Callback<CourseResponse>() {

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
                                    final ControllerInterface callback) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "30");
        parameters.put("courseid", courseid);
        parameters.put("lon", "4.9E-324");
        parameters.put("lat", "4.9E-324");


        Call courseCall = ServiceBuilder.getInstance().getCourseInfoByName(parameters);
        courseCall.enqueue(new Callback<CourseResponse>() {

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
                                final ControllerInterface callback) {
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


    public void loadCourseType(final ControllerInterface callback) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");

        DataAPIService service = ServiceBuilder.getInstance();
        service.getCourseType(parameters)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        view.dismissLoading();
                    }
                })
                .subscribe(new Subscriber<CourseTypeResponse>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        view.loadingProgressDialog(R.string.loading);
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(CourseTypeResponse courseTypeResponse) {
                        callback.onResult(courseTypeResponse);
                    }

                    @Override
                    public void onError(Throwable t) {
                        callback.onError(t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
