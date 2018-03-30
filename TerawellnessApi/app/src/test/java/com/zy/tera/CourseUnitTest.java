package com.zy.tera;

import com.zy.tera.response.ApmtedCourseResponse;
import com.zy.tera.response.AppointmentResponse;
import com.zy.tera.response.CourseDetailResponse;
import com.zy.tera.response.CourseResponse;
import com.zy.tera.response.CourseTypeResponse;
import com.zy.tera.response.TypeCourseResponse;
import com.zy.tera.utils.TimeUtils;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by yz250242 on 2018/3/27.
 */

public class CourseUnitTest {

    @Test
    public void getApmtedCourse(){
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userid", "1319");
        parameters.put("pageNum", "1");
        parameters.put("numPerPage", "10");


        Call makeCall = ServiceBuilder.getInstance().getApmtedCourse(parameters);
        try {
            Response<ApmtedCourseResponse> bookResponse = makeCall.execute();

            List<ApmtedCourseResponse.GroupClassInfo.ApmtedInfo> list = bookResponse.body().data.groupoplist;

            for (int i=0;i<list.size();i++){
                ApmtedCourseResponse.GroupClassInfo.ApmtedInfo item = list.get(i);

                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(item.courseName);
                stringBuffer.append(" "+item.coachName);
                stringBuffer.append("@"+item.clubName);
                stringBuffer.append(" "+item.begintime);
                System.out.println(stringBuffer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void makeAppointment() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("coursetype", "1");
        parameters.put("opid", "311758");
        parameters.put("userid", "1319");


        Call makeCall = ServiceBuilder.getInstance().makeAppointment(parameters);
        try {
            Response<AppointmentResponse> bookResponse = makeCall.execute();

            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(bookResponse.body().status);
            stringBuffer.append("-"+bookResponse.body().msg);
            System.out.println(stringBuffer.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCourseInfobyShop() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "10");
        parameters.put("clubid", "2494");//上海广场
        parameters.put("date", TimeUtils.getTodayDate());
        parameters.put("coursename", "");


        Call courseCall = ServiceBuilder.getInstance().searchCoursebyShop(parameters);
        try {
            Response<CourseDetailResponse> courseResponse = courseCall.execute();

            List<CourseDetailResponse.CourseDetailInfo> rows = courseResponse.body().data;

            if (!rows.isEmpty()) {
                for (CourseDetailResponse.CourseDetailInfo row : rows) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(row.coursename);
                    stringBuffer.append(" " + row.coachname);
                    stringBuffer.append("@" + row.clubname);
                    stringBuffer.append(" " + row.coursetime);
                    System.out.println(stringBuffer.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCourseInfobyName() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "30");
        parameters.put("courseid", "1496");
        parameters.put("lon", "4.9E-324");
        parameters.put("lat", "4.9E-324");


        Call courseCall = ServiceBuilder.getInstance().getCourseInfoByName(parameters);
        try {
            Response<CourseResponse> courseResponse = courseCall.execute();

            List<CourseResponse.CourseInfo.Rows> rows = courseResponse.body().data.rows;

            if (!rows.isEmpty()) {
                for (CourseResponse.CourseInfo.Rows row : rows) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(row.coursename);
                    stringBuffer.append(" " + row.coachname);
                    stringBuffer.append("@" + row.clubname);
                    stringBuffer.append(" " + row.begindate);
                    stringBuffer.append(" " + row.begintime);
                    stringBuffer.append("-" + row.endtime);
                    System.out.println(stringBuffer.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCourseByType() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("tid", "225");
        parameters.put("stype", "N");


        Call courseTypeCall = ServiceBuilder.getInstance().getCourseByType(parameters);
        try {
            Response<TypeCourseResponse> courseResponse = courseTypeCall.execute();

            List<TypeCourseResponse.TypeCourseInfo.Rows> rows = courseResponse.body().data.rows;

            if (!rows.isEmpty()) {
                for (TypeCourseResponse.TypeCourseInfo.Rows row : rows) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(row.name);
                    stringBuffer.append(" " + row.id);
                    stringBuffer.append(" " + row.tid);
                    System.out.println(stringBuffer.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCourseType() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");


        Call courseTypeCall = ServiceBuilder.getInstance().getCourseType(parameters);
        try {
            Response<CourseTypeResponse> courseResponse = courseTypeCall.execute();

            List<CourseTypeResponse.CourseTypeInfo.Rows> rows = courseResponse.body().data.rows;

            if (!rows.isEmpty()) {
                for (CourseTypeResponse.CourseTypeInfo.Rows row : rows) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(row.name);
                    stringBuffer.append(" " + row.id);
                    System.out.println(stringBuffer.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getCourseInfobyCoach() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "30");
        parameters.put("coachid", "19704");
        parameters.put("lon", "4.9E-324");
        parameters.put("lat", "4.9E-324");


        Call courseCall = ServiceBuilder.getInstance().getCourseInfoByCoach(parameters);
        try {
            Response<CourseResponse> courseResponse = courseCall.execute();

            List<CourseResponse.CourseInfo.Rows> rows = courseResponse.body().data.rows;

            if (!rows.isEmpty()) {
                for (CourseResponse.CourseInfo.Rows row : rows) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(row.coursename);
                    stringBuffer.append(" " + row.coachname);
                    stringBuffer.append("@" + row.clubname);
                    stringBuffer.append(" " + row.begindate);
                    stringBuffer.append(" " + row.begintime);
                    System.out.println(stringBuffer.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
