package com.zy.tera.response;

import java.util.List;

/**
 * Created by yz250242 on 2018/3/27.
 */
/*
{
	"data": {
		"total": 79,
		"rows": [{
			"club_id": "07086",
			"club_no": "07A6",
			"clubname": "上海阳光"
		}, {
			"club_id": "07087",
			"club_no": "07A7",
			"clubname": "上海联洋"
		}, {
			"club_id": "09984",
			"club_no": "A84",
			"clubname": "上海黄浦丽园"
		}]
	},
	"code": "1",
	"msg": "查询成功"
}
 */


public class ShopResponse  extends BaseResponse{

    public ShopInfo data;
    public String code;
    public String msg;

    public class ShopInfo{
        public int total;
        public List<Rows> rows;

        public class Rows{
            public String club_id;
            public String club_no;
            public String clubname;
        }
    }
}
