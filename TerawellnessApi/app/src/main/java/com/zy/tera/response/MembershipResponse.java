package com.zy.tera.response;

import com.zy.tera.utils.TimeUtils;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yz250242 on 2018/3/27.
 */

/*
{
	"data": {
		"total": 10,
		"rows": [{
			"begindate": "2017-10-18",
			"card_id": "10227783                 ",
			"enddate": "2020-10-17",
			"membership_co": "08036",
			"membership_no": "14001668",
			"state": "关闭（转出店）",
			"user_id": "M00188170                     "
		}, {
			"begindate": "2015-10-19",
			"card_id": "10227783                 ",
			"enddate": "2020-10-18",
			"membership_co": "08036",
			"membership_no": "14001631",
			"state": "关闭（升级）",
			"user_id": "M00188170                     "
		}]
	},
	"code": "1",
	"msg": "查询成功"
}
 */

public class MembershipResponse extends BaseResponse {
    private Membership data;

    private String code;

    private String msg;

    public List<Membership.CardInfo> getValidCardInfo(){
        List<Membership.CardInfo> list = new ArrayList<>();
        for (Membership.CardInfo card:data.getRows()) {
            if (TimeUtils.isValidCard(card.enddate)){
                list.add(card);
            }
        }

        return list;
    }

    public Membership getData() {
        return data;
    }

    public void setData(Membership data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public class Membership {
        private int total;

        private List<CardInfo> rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<CardInfo> getRows() {
            return rows;
        }

        public void setRows(List<CardInfo> rows) {
            this.rows = rows;
        }

        public class CardInfo {
            private String begindate;
            private String card_id;
            private String enddate;
            private String membership_co;
            private String membership_no;
            private String state;
            private String user_id;

            public String getBegindate() {
                return begindate;
            }

            public void setBegindate(String begindate) {
                this.begindate = begindate;
            }

            public String getCard_id() {
                return card_id;
            }

            public void setCard_id(String card_id) {
                this.card_id = card_id;
            }

            public String getEnddate() {
                return enddate;
            }

            public void setEnddate(String enddate) {
                this.enddate = enddate;
            }

            public String getMembership_co() {
                return membership_co;
            }

            public void setMembership_co(String membership_co) {
                this.membership_co = membership_co;
            }

            public String getMembership_no() {
                return membership_no;
            }

            public void setMembership_no(String membership_no) {
                this.membership_no = membership_no;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }
        }
    }
}
