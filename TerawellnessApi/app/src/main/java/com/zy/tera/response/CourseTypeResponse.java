package com.zy.tera.response;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/27.
 */

public class CourseTypeResponse extends BaseResponse {

    public CourseTypeResponse.CourseTypeInfo data;
    public String code;
    public String msg;

    public class CourseTypeInfo{
        public int total;
        public List<CourseTypeResponse.CourseTypeInfo.Rows> rows;

        public class Rows{
            public String id;
            public String name;
        }
    }
}
