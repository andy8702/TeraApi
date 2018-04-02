package com.zy.tera.response;

/*
{
	"p_msg": "您的课程预约已成功提交。",
	"p_member_code": "M00188170",
	"p_course_id": "1680115",
	"p_reservation_id": "8318",
	"p_reservation_amount": "",
	"p_success_flag": "Y",
	"p_mobile": "13524284562"
}
 */
public class BookResultResponse extends BaseResponse {

    public String p_msg;
    public String p_member_code;
    public String p_course_id;
    public String p_reservation_id;
    public String p_reservation_amount;
    public String p_success_flag;
    public String p_mobile;
}
