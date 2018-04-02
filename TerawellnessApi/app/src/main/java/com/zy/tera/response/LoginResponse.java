package com.zy.tera.response;

/*
{
	"data": {
		"total": 1,
		"buttonPic": {
			"filename": "",
			"filepath": "",
			"filesize": "",
			"id": 0,
			"modifyTime": null,
			"modifyUser": "",
			"sortNum": 0,
			"title": ""
		},
		"skipflag": "",
		"rows": {
			"avatar": "",
			"birth": "",
			"city": "",
			"cling_Clock": "",
			"cling_Config": "",
			"cling_Remind": "",
			"clingemail": "13524284562",
			"clingpwd": "AB_1518326858986",
			"createdate": "",
			"erp_address": "",
			"erp_birthday": "",
			"erp_cardid": "10227783",
			"erp_cardstate": "已开卡",
			"erp_company": "",
			"erp_contact": "",
			"erp_height": "",
			"erp_idcard": "310109198702194156",
			"erp_sex": "男",
			"erp_telephone": "13524284562",
			"erp_userid": "M00188170",
			"erp_username": "周扬",
			"gender": 1,
			"headimg": "",
			"height": "",
			"id": 1319,
			"initscore": 0,
			"isdelete": "",
			"isnew": "N",
			"lastlogintime": "",
			"lastmodpwdtime": "",
			"nickname": "",
			"org_no": "",
			"passwd": "5EDF3A560E2F7A3A2ECF979A598805C6",
			"publish_Health": 0,
			"publish_Location": 1,
			"publish_Sleep": 1,
			"publish_Step": 1,
			"publish_Temp": 1,
			"remark": "",
			"run_Step_Length": "",
			"source": "APP",
			"stacey": "Andy",
			"step_Length": "",
			"telephone": "13524284562",
			"u_status": "",
			"username": "Andy",
			"weight": "",
			"wxheadimg": "",
			"wxopenid": ""
		}
	},
	"code": "1",
	"msg": "登录成功"
}
 */


public class LoginResponse extends BaseResponse {

    private LoginData data;
    
    private String code;
    
    private String msg;

    public LoginData getData() {
        return data;
    }

    public void setData(LoginData data) {
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

    public class LoginData {
        
        private int total;
        
        private String skipFlag;
        
        private ButtonPic buttonPic;
        
        private Rows rows;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getSkipFlag() {
            return skipFlag;
        }

        public void setSkipFlag(String skipFlag) {
            this.skipFlag = skipFlag;
        }

        public ButtonPic getButtonPic() {
            return buttonPic;
        }

        public void setButtonPic(ButtonPic buttonPic) {
            this.buttonPic = buttonPic;
        }

        public Rows getRows() {
            return rows;
        }

        public void setRows(Rows rows) {
            this.rows = rows;
        }

        public class ButtonPic {
            
            private String filename;
            
            private String filepath;
            
            private String filesize;
            
            private String id;
            
            private String modifyTime;
            
            private String modifyUser;
            
            private int sortNum;
            
            private String title;

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public String getFilepath() {
                return filepath;
            }

            public void setFilepath(String filepath) {
                this.filepath = filepath;
            }

            public String getFilesize() {
                return filesize;
            }

            public void setFilesize(String filesize) {
                this.filesize = filesize;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(String modifyTime) {
                this.modifyTime = modifyTime;
            }

            public String getModifyUser() {
                return modifyUser;
            }

            public void setModifyUser(String modifyUser) {
                this.modifyUser = modifyUser;
            }

            public int getSortNum() {
                return sortNum;
            }

            public void setSortNum(int sortNum) {
                this.sortNum = sortNum;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public class Rows {
            private String avatar;
            private String birth;
            private String city;
            private String cling_Clock;
            private String cling_Config;
            private String cling_Remind;
            private String clingemail;
            private String clingpwd;
            private String createdate;
            private String erp_address;
            private String erp_birthday;
            private String erp_cardid;
            private String erp_cardstate;
            private String erp_company;
            private String erp_contact;
            private String erp_height;
            private String erp_idcard;
            private String erp_sex;
            private String erp_telephone;
            private String erp_userid;
            private String erp_username;
            private int genderprivate;
            private String headimg;
            private String height;
            private String id;
            private int idprivate;
            private int initscoreprivate;
            private String isdelete;
            private String isnew;
            private String lastlogintime;
            private String lastmodpwdtime;
            private String nickname;
            private String org_no;
            private String passwd;
            private int publish_Healthprivate;
            private int publish_Locationprivate;
            private int publish_Sleepprivate;
            private int publish_Stepprivate;
            private int publish_Tempprivate;
            private String remark;
            private String run_Step_Length;
            private String source;
            private String stacey;
            private String step_Length;
            private String telephone;
            private String u_status;
            private String username;
            private String weight;
            private String wxheadimg;
            private String wxopenid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getBirth() {
                return birth;
            }

            public void setBirth(String birth) {
                this.birth = birth;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCling_Clock() {
                return cling_Clock;
            }

            public void setCling_Clock(String cling_Clock) {
                this.cling_Clock = cling_Clock;
            }

            public String getCling_Config() {
                return cling_Config;
            }

            public void setCling_Config(String cling_Config) {
                this.cling_Config = cling_Config;
            }

            public String getCling_Remind() {
                return cling_Remind;
            }

            public void setCling_Remind(String cling_Remind) {
                this.cling_Remind = cling_Remind;
            }

            public String getClingemail() {
                return clingemail;
            }

            public void setClingemail(String clingemail) {
                this.clingemail = clingemail;
            }

            public String getClingpwd() {
                return clingpwd;
            }

            public void setClingpwd(String clingpwd) {
                this.clingpwd = clingpwd;
            }

            public String getCreatedate() {
                return createdate;
            }

            public void setCreatedate(String createdate) {
                this.createdate = createdate;
            }

            public String getErp_address() {
                return erp_address;
            }

            public void setErp_address(String erp_address) {
                this.erp_address = erp_address;
            }

            public String getErp_birthday() {
                return erp_birthday;
            }

            public void setErp_birthday(String erp_birthday) {
                this.erp_birthday = erp_birthday;
            }

            public String getErp_cardid() {
                return erp_cardid;
            }

            public void setErp_cardid(String erp_cardid) {
                this.erp_cardid = erp_cardid;
            }

            public String getErp_cardstate() {
                return erp_cardstate;
            }

            public void setErp_cardstate(String erp_cardstate) {
                this.erp_cardstate = erp_cardstate;
            }

            public String getErp_company() {
                return erp_company;
            }

            public void setErp_company(String erp_company) {
                this.erp_company = erp_company;
            }

            public String getErp_contact() {
                return erp_contact;
            }

            public void setErp_contact(String erp_contact) {
                this.erp_contact = erp_contact;
            }

            public String getErp_height() {
                return erp_height;
            }

            public void setErp_height(String erp_height) {
                this.erp_height = erp_height;
            }

            public String getErp_idcard() {
                return erp_idcard;
            }

            public void setErp_idcard(String erp_idcard) {
                this.erp_idcard = erp_idcard;
            }

            public String getErp_sex() {
                return erp_sex;
            }

            public void setErp_sex(String erp_sex) {
                this.erp_sex = erp_sex;
            }

            public String getErp_telephone() {
                return erp_telephone;
            }

            public void setErp_telephone(String erp_telephone) {
                this.erp_telephone = erp_telephone;
            }

            public String getErp_userid() {
                return erp_userid;
            }

            public void setErp_userid(String erp_userid) {
                this.erp_userid = erp_userid;
            }

            public String getErp_username() {
                return erp_username;
            }

            public void setErp_username(String erp_username) {
                this.erp_username = erp_username;
            }

            public int getGenderprivate() {
                return genderprivate;
            }

            public void setGenderprivate(int genderprivate) {
                this.genderprivate = genderprivate;
            }

            public String getHeadimg() {
                return headimg;
            }

            public void setHeadimg(String headimg) {
                this.headimg = headimg;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public int getIdprivate() {
                return idprivate;
            }

            public void setIdprivate(int idprivate) {
                this.idprivate = idprivate;
            }

            public int getInitscoreprivate() {
                return initscoreprivate;
            }

            public void setInitscoreprivate(int initscoreprivate) {
                this.initscoreprivate = initscoreprivate;
            }

            public String getIsdelete() {
                return isdelete;
            }

            public void setIsdelete(String isdelete) {
                this.isdelete = isdelete;
            }

            public String getIsnew() {
                return isnew;
            }

            public void setIsnew(String isnew) {
                this.isnew = isnew;
            }

            public String getLastlogintime() {
                return lastlogintime;
            }

            public void setLastlogintime(String lastlogintime) {
                this.lastlogintime = lastlogintime;
            }

            public String getLastmodpwdtime() {
                return lastmodpwdtime;
            }

            public void setLastmodpwdtime(String lastmodpwdtime) {
                this.lastmodpwdtime = lastmodpwdtime;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getOrg_no() {
                return org_no;
            }

            public void setOrg_no(String org_no) {
                this.org_no = org_no;
            }

            public String getPasswd() {
                return passwd;
            }

            public void setPasswd(String passwd) {
                this.passwd = passwd;
            }

            public int getPublish_Healthprivate() {
                return publish_Healthprivate;
            }

            public void setPublish_Healthprivate(int publish_Healthprivate) {
                this.publish_Healthprivate = publish_Healthprivate;
            }

            public int getPublish_Locationprivate() {
                return publish_Locationprivate;
            }

            public void setPublish_Locationprivate(int publish_Locationprivate) {
                this.publish_Locationprivate = publish_Locationprivate;
            }

            public int getPublish_Sleepprivate() {
                return publish_Sleepprivate;
            }

            public void setPublish_Sleepprivate(int publish_Sleepprivate) {
                this.publish_Sleepprivate = publish_Sleepprivate;
            }

            public int getPublish_Stepprivate() {
                return publish_Stepprivate;
            }

            public void setPublish_Stepprivate(int publish_Stepprivate) {
                this.publish_Stepprivate = publish_Stepprivate;
            }

            public int getPublish_Tempprivate() {
                return publish_Tempprivate;
            }

            public void setPublish_Tempprivate(int publish_Tempprivate) {
                this.publish_Tempprivate = publish_Tempprivate;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getRun_Step_Length() {
                return run_Step_Length;
            }

            public void setRun_Step_Length(String run_Step_Length) {
                this.run_Step_Length = run_Step_Length;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getStacey() {
                return stacey;
            }

            public void setStacey(String stacey) {
                this.stacey = stacey;
            }

            public String getStep_Length() {
                return step_Length;
            }

            public void setStep_Length(String step_Length) {
                this.step_Length = step_Length;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getU_status() {
                return u_status;
            }

            public void setU_status(String u_status) {
                this.u_status = u_status;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getWxheadimg() {
                return wxheadimg;
            }

            public void setWxheadimg(String wxheadimg) {
                this.wxheadimg = wxheadimg;
            }

            public String getWxopenid() {
                return wxopenid;
            }

            public void setWxopenid(String wxopenid) {
                this.wxopenid = wxopenid;
            }
        }
    }

}
