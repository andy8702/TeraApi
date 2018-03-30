package com.zy.tera.response;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/27.
 */

public class TypeCourseResponse extends BaseResponse{

    public TypeCourseResponse.TypeCourseInfo data;
    public String code;
    public String msg;

    public class TypeCourseInfo{
        public int total;
        public List<TypeCourseResponse.TypeCourseInfo.Rows> rows;

        public class Rows{
            public String id;
            public String name;
            public String tid;

        }
    }
}
