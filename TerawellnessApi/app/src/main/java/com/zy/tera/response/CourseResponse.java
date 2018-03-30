package com.zy.tera.response;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/27.
 */

/*
{
	"data": {
		"total": 10,
		"rows": [{
			"address": "上海市黄浦区西藏南路1202号",
			"begindate": "2018-03-27",
			"begintime": "11:50:00",
			"clubid": 2492,
			"clubname": "上海黄浦丽园会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1496,
			"courselevel": "A",
			"coursename": "1012舞蹈",
			"distance": "12972.813",
			"duation": "60",
			"endtime": "12:50:00",
			"id": 313060,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-53079531",
			"site": "有氧教室",
			"sourceId": "1662814",
			"star_cnt": "2"
		}, {
			"address": "上海市静安区凤阳路599号3楼",
			"begindate": "2018-03-27",
			"begintime": "19:35:00",
			"clubid": 2511,
			"clubname": "上海凤阳路会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1496,
			"courselevel": "A",
			"coursename": "1012舞蹈",
			"distance": "12970.0427",
			"duation": "60",
			"endtime": "20:35:00",
			"id": 303125,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-60872300",
			"site": "有氧教室",
			"sourceId": "1664555",
			"star_cnt": "1"
		}, {
			"address": "上海市静安区凤阳路599号3楼",
			"begindate": "2018-03-27",
			"begintime": "18:30:00",
			"clubid": 2511,
			"clubname": "上海凤阳路会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1369,
			"courselevel": "A",
			"coursename": "普拉提",
			"distance": "12970.0427",
			"duation": "60",
			"endtime": "19:30:00",
			"id": 309095,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-60872300",
			"site": "有氧教室",
			"sourceId": "1664551",
			"star_cnt": "1"
		}, {
			"address": "上海市静安区凤阳路599号3楼",
			"begindate": "2018-03-27",
			"begintime": "20:40:00",
			"clubid": 2511,
			"clubname": "上海凤阳路会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1462,
			"courselevel": "A",
			"coursename": "太极禅",
			"distance": "12970.0427",
			"duation": "60",
			"endtime": "21:40:00",
			"id": 307484,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-60872300",
			"site": "有氧教室",
			"sourceId": "1664559",
			"star_cnt": "2"
		}, {
			"address": "上海市黄浦区淮海中路138号上海广场商场561-601",
			"begindate": "2018-03-28",
			"begintime": "12:00:00",
			"clubid": 2494,
			"clubname": "上海广场会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1369,
			"courselevel": "A",
			"coursename": "普拉提",
			"distance": "12971.4609",
			"duation": "60",
			"endtime": "13:00:00",
			"id": 312340,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-53097996",
			"site": "瑜伽教室",
			"sourceId": "1663442",
			"star_cnt": "2"
		}, {
			"address": "上海市长宁区镇宁路55号",
			"begindate": "2018-03-29",
			"begintime": "12:05:00",
			"clubid": 10026,
			"clubname": "上海东方剑桥会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1462,
			"courselevel": "A",
			"coursename": "太极禅",
			"distance": "12968.1264",
			"duation": "60",
			"endtime": "13:05:00",
			"id": 308051,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-32070659",
			"site": "有氧教室",
			"sourceId": "1666697",
			"star_cnt": "2"
		}, {
			"address": "上海市长宁区镇宁路55号",
			"begindate": "2018-03-29",
			"begintime": "11:00:00",
			"clubid": 10026,
			"clubname": "上海东方剑桥会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1496,
			"courselevel": "A",
			"coursename": "1012舞蹈",
			"distance": "12968.1264",
			"duation": "60",
			"endtime": "12:00:00",
			"id": 302398,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-32070659",
			"site": "有氧教室",
			"sourceId": "1666692",
			"star_cnt": "2"
		}, {
			"address": "上海市杨浦区凇沪路8号(百联又一城)8-9楼",
			"begindate": "2018-03-29",
			"begintime": "17:00:00",
			"clubid": 2521,
			"clubname": "上海五角场会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1424,
			"courselevel": "A",
			"coursename": "核心控制",
			"distance": "12972.2994",
			"duation": "60",
			"endtime": "18:00:00",
			"id": 305946,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-65330866",
			"site": "有氧教室",
			"sourceId": "1669787",
			"star_cnt": "0"
		}, {
			"address": "上海市杨浦区凇沪路8号(百联又一城)8-9楼",
			"begindate": "2018-03-29",
			"begintime": "18:05:00",
			"clubid": 2521,
			"clubname": "上海五角场会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1496,
			"courselevel": "A",
			"coursename": "1012舞蹈",
			"distance": "12972.2994",
			"duation": "60",
			"endtime": "19:05:00",
			"id": 303124,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-65330866",
			"site": "有氧教室",
			"sourceId": "1669792",
			"star_cnt": "0"
		}, {
			"address": "上海市徐汇区南丹东路300弄9号",
			"begindate": "2018-03-30",
			"begintime": "11:30:00",
			"clubid": 2495,
			"clubname": "上海徐汇会所",
			"coachid": 4388,
			"coachname": "宋伟伟",
			"course_payment_type": "0",
			"courseid": 1369,
			"courselevel": "A",
			"coursename": "普拉提",
			"distance": "12969.0862",
			"duation": "60",
			"endtime": "12:30:00",
			"id": 309484,
			"isDiscuss": false,
			"ispublic": "N",
			"phone": "021-54252222",
			"site": "瑜伽教室",
			"sourceId": "1665070",
			"star_cnt": "1"
		}]
	},
	"code": "1",
	"msg": "查询成功"
}
 */

public class CourseResponse extends BaseResponse {

    public CourseResponse.CourseInfo data;
    public String code;
    public String msg;

    public class CourseInfo{
        public int total;
        public List<CourseResponse.CourseInfo.Rows> rows;

        public class Rows{
            public String address;
            public String begindate;
            public String begintime;
            public int clubid;
            public String clubname;
            public int coachid;
            public String coachname;
            public String course_payment_type;
            public int courseid;
            public String courselevel;
            public String coursename;
            public String distance;
            public String duation;
            public String endtime;
            public int id;
            public boolean isDiscus;
            public String ispublic;
            public String phone;
            public String site;
            public String sourceId;
            public String star_cnt;
        }
    }
}
