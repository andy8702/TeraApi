package com.zy.tera.response;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/27.
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
	"msg": "查询成功",
	"data": [{
		"id": 311161,
		"courseid": "",
		"sourceId": "1663406",
		"coachid": "",
		"clubid": "",
		"begintime": "",
		"endtime": "",
		"begindate": "",
		"duation": "",
		"courselevel": "",
		"site": "有氧教室",
		"coursePaymentType": "0",
		"courseUnitPrice": "",
		"siteMaxQty": "",
		"disTimeout": "",
		"isdiscuss": "",
		"ispublic": "N",
		"site_max_qty": "",
		"begintimeStr": "",
		"membercode": "",
		"erp_userid": "",
		"isappointment": "",
		"creation_date": "",
		"dis_timeout": "",
		"createtime": "",
		"erpisdiscuss": "",
		"cdate": "",
		"area_level1": "",
		"area_level2": "",
		"strdate": "",
		"clubname": "上海广场会所",
		"coursename": "弹力蹦床",
		"coachname": "陈毅卿",
		"coursedesc": "",
		"distance": "",
		"fileName": "",
		"filePath": "",
		"isDay": "",
		"princtId": "",
		"pname": "",
		"areaId": "",
		"cityname": "",
		"newappointNo": "",
		"first_file_name": "",
		"first_file_path": "",
		"logo_path": "upload/active/201707/18/241-62_ef0c8bb4-15e4-4718-95e6-9bbda19bd69c.png",
		"ids": "",
		"cno": "",
		"state": "",
		"begindateflag": "",
		"date1": "",
		"date2": "",
		"date3": "",
		"date4": "",
		"date5": "",
		"date6": "",
		"date7": "",
		"coursetime": "11:45-12:45",
		"begintimeLast": "",
		"beginStr": "",
		"can_new_cnt": "11",
		"star_cnt": "2"
	}]
}
 */

public class CourseDetailResponse extends BaseResponse{

    public List<CourseDetailInfo> data;
    public String recordsTotal;
    public String pageSize;
    public String currentPage;
    public String pageData;
    public String pageCount;
    public String status;
    public String error;
    public String msg;

    public class CourseDetailInfo {

        public String id;
        public String courseid;
        public String sourceId;
        public String coachid;
        public String clubid;
        public String begintime;
        public String endtime;
        public String begindate;
        public String duation;
        public String courselevel;
        public String site;
        public String coursePaymentType;
        public String courseUnitPrice;
        public String siteMaxQty;
        public String disTimeout;
        public String isdiscuss;
        public String ispublic;
        public String site_max_qty;
        public String begintimeStr;
        public String membercode;
        public String erp_userid;
        public String isappointment;
        public String creation_date;
        public String dis_timeout;
        public String createtime;
        public String erpisdiscuss;
        public String cdate;
        public String area_level1;
        public String area_level2;
        public String strdate;
        public String clubname;
        public String coursename;
        public String coachname;
        public String coursedesc;
        public String distance;
        public String fileName;
        public String filePath;
        public String isDay;
        public String princtId;
        public String pname;
        public String areaId;
        public String cityname;
        public String newappointNo;
        public String first_file_name;
        public String first_file_path;
        public String logo_path;
        public String ids;
        public String cno;
        public String state;
        public String begindateflag;
        public String date1;
        public String date2;
        public String date3;
        public String date4;
        public String date5;
        public String date6;
        public String date7;
        public String coursetime;
        public String begintimeLast;
        public String beginStr;
        public String can_new_cnt;
        public String star_cnt;
    }
}
