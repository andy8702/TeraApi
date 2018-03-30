package com.zy.tera.response;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/27.
 */
/*
{
	"data": {
		"total": 1,
		"rows": [{
			"address": "上海市黄浦区淮海中路138号上海广场商场561-601",
			"adimg": "",
			"aid": 107,
			"cno": "08142",
			"detailpath": "upload/club/201704/25/600-415_89ad3051-8a7d-4962-9cea-7f31cf72b739.jpg",
			"distance": "12971.4609",
			"id": 2494,
			"latitude": "31.23085",
			"longitude": "121.4844",
			"name": "上海广场会所",
			"phone": "021-53097996",
			"pid": 10,
			"state": "营业中",
			"title_path": "upload/club/201704/25/640-300_2ed8bbd2-6057-41cd-894e-3d57f8d584f3.jpg"
		}]
	},
	"code": "1",
	"msg": "查询成功"
}
 */


public class ShopDetailsResponse extends BaseResponse {

    public ShopDetailInfo data;
    public String code;
    public String msg;

    public class ShopDetailInfo {
        public int total;
        public List<Rows> rows;

        public class Rows {
            public String address;
            public String adimg;
            public String aid;
            public String cno;
            public String detailpath;
            public String distance;
            public String id;
            public String latitude;
            public String longitude;
            public String name;
            public String phone;
            public String pid;
            public String state;
            public String title_path;
        }
    }
}
