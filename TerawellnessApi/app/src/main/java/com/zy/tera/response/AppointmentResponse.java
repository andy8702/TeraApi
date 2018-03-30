package com.zy.tera.response;

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
	"status": "0",
	"error": "",
	"msg": "您的账号有两次约课未取消，至2018-03-29前不能网约。",
	"data": ""
}
 */

public class AppointmentResponse extends BaseResponse {

    public String recordsTotal;
    public String pageSize;
    public String currentPage;
    public String pageData;
    public String pageCount;
    public String status;
    public String error;
    public String msg;
    public String data;
}
