package com.zy.tera;


import com.zy.tera.response.ApmtedCourseResponse;
import com.zy.tera.response.AppointmentResponse;
import com.zy.tera.response.CoachResponse;
import com.zy.tera.response.CourseBookResponse;
import com.zy.tera.response.CourseDetailResponse;
import com.zy.tera.response.CourseResponse;
import com.zy.tera.response.CourseTypeResponse;
import com.zy.tera.response.LoginResponse;
import com.zy.tera.response.MembershipResponse;
import com.zy.tera.response.ShopDetailsResponse;
import com.zy.tera.response.ShopResponse;
import com.zy.tera.response.TypeCourseResponse;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface DataAPIService {

    @POST("YZWD/mobi/customer/customer!login.action")
    Call<LoginResponse> getLoginInfo(@QueryMap Map<String, String> parameters);

    @POST("YZWD/mobi/customer/customer!getMembershipByUser.action")
    Call<MembershipResponse> getMembership(@QueryMap Map<String, String> parameters);

    @POST("YZWD/mobi/customer/customer!getClubByMembership.action")
    Call<ShopResponse> getShopInfo(@QueryMap Map<String, String> parameters);

    @POST("YZWD/mobi/opreate/opreate!getCoachList.action")
    Call<CoachResponse> getCoachInfo(@QueryMap Map<String, String> parameters);

    @POST("YZWD/mobi/opreate/opreate!list.action")
    Call<CourseResponse> getCourseInfoByCoach(@QueryMap Map<String, String> parameters);

    @POST("YZWD/mobi/opreate/opreate!getCoursetypeList.action")
    Flowable<CourseTypeResponse> getCourseType(@QueryMap Map<String, String> parameters);

    @POST("YZWD/mobi/opreate/opreate!getCourseList.action")
    Call<TypeCourseResponse> getCourseByType(@QueryMap Map<String, String> parameters);

    @POST("YZWD/mobi/opreate/opreate!list.action")
    Call<CourseResponse> getCourseInfoByName(@QueryMap Map<String, String> parameters);

    @POST("YZWD/mobi/club/club!list.action")
    Call<ShopDetailsResponse> searchShop(@QueryMap Map<String, String> parameters);

    @POST("groupoperat/wap/getCoursesByName")
    Call<CourseDetailResponse> searchCoursebyShop(@QueryMap Map<String, String> parameters);

    @POST("app/groupoperat/isReadyAppointment")
    Call<AppointmentResponse> makeAppointment(@QueryMap Map<String, String> parameters);

    @POST("app/order/selectgroupoperateinfo")
    Call<ApmtedCourseResponse> getApmtedCourse(@QueryMap Map<String, String> parameters);

    @POST("app/groupoperat/selectcourseappointment")
    Call<CourseBookResponse> bookCourse(@QueryMap Map<String, String> parameters);

}
