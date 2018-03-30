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
			"cid": 0,
			"id": 19197,
			"name": "宋伟伟"
		}]
	},
	"code": "1",
	"msg": "查询成功"
}
 */

public class CoachResponse  extends BaseResponse{

    public CoachResponse.CoachInfo data;
    public String code;
    public String msg;

    public class CoachInfo{
        public int total;
        public List<CoachResponse.CoachInfo.Rows> rows;

        public class Rows{
            public String cid;
            public String id;
            public String name;
        }
    }
}
