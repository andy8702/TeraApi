package com.zy.tera.response;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/28.
 */

/*
{
	"recordsTotal": "",
	"pageSize": "",
	"currentPage": "",
	"pageData": "",
	"pageCount": "",
	"status": "1",
	"error": "",
	"msg": "已预约信息获取成功！",
	"data": {
		"groupoplist": [{
			"id": 311843,
			"courseId": 1663484,
			"courseName": "整合训练",
			"coachId": 11981,
			"coachName": "周效磊",
			"begintime": "18:10",
			"begindate": "20180322",
			"duation": "60",
			"level": "A",
			"site": "有氧教室",
			"clubName": "上海广场会所",
			"score": "N",
			"isdiscuss": "N",
			"erpuserid": "M00188170",
			"issigned": "",
			"displaystr": "已过期",
			"coursePaymentType": "0",
			"courseUnitPrice": 0.00,
			"reservationid": "7302",
			"reservation_status": "EXP",
			"iscancel": "N",
			"cancelstatus": "已过期",
			"ispublic": "N",
			"star_cnt": "1"
		}]
	}
}
 */

public class ApmtedCourseResponse extends BaseResponse {

    public String recordsTotal;
    public String pageSize;
    public String currentPage;
    public String pageData;
    public String pageCount;
    public String status;
    public String error;
    public String msg;
    public GroupClassInfo data;

    public class GroupClassInfo {

        public List<ApmtedInfo> groupoplist;

        public class ApmtedInfo {
            public String id;
            public String courseId;
            public String courseName;
            public String coachId;
            public String coachName;
            public String begintime;
            public String begindate;
            public String duation;
            public String level;
            public String site;
            public String clubName;
            public String score;
            public String isdiscuss;
            public String erpuserid;
            public String issigned;
            public String displaystr;
            public String coursePaymentType;
            public String courseUnitPrice;
            public String reservationid;
            public String reservation_status;
            public String iscancel;
            public String cancelstatus;
            public String ispublic;
            public String star_cnt;
        }
    }
}
