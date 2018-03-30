package com.zy.tera;

import com.zy.tera.response.LoginResponse;
import com.zy.tera.response.MembershipResponse;
import com.zy.tera.response.ShopDetailsResponse;
import com.zy.tera.response.ShopResponse;
import com.zy.tera.utils.TimeUtils;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by yz250242 on 2018/3/26.
 */

public class LoginUnitTest {

    @Test
    public void testLogin(){
        System.out.println("Begin to test login");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("phone", "13524284562");
        parameters.put("cardid", "13524284562");
        parameters.put("pwd", "5EDF3A560E2F7A3A2ECF979A598805C6");
        parameters.put("oldUser", "");

        Call loginCall = ServiceBuilder.getInstance().getLoginInfo(parameters);
        try {
            Response<LoginResponse> response = loginCall.execute();
            System.out.println("login done, response="+response.body().getMsg());
        } catch (IOException e) {
            System.out.println("login fail");
            e.printStackTrace();
        }
    }

    @Test
    public void testMembership(){
        System.out.println("Begin to test membership");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("userid", "M00188170");

        Call membershipCall = ServiceBuilder.getInstance().getMembership(parameters);
        try {
            Response<MembershipResponse> response = membershipCall.execute();
            System.out.println("test membership done");

            if (!response.body().getValidCardInfo().isEmpty()){
                for (MembershipResponse.Membership.CardInfo card:response.body().getData().getRows()) {
                    if (TimeUtils.isValidCard(card.getEnddate())){
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Card No:"+card.getCard_id()+" ");
                        stringBuffer.append("从"+card.getBegindate());
                        stringBuffer.append("至"+card.getEnddate());
                        System.out.println(stringBuffer.toString());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("test membership fail");
            e.printStackTrace();
        }
    }

    @Test
    public void testAvailableShop(){
        System.out.println("Begin to test shop");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("no", "14001631");
        parameters.put("co", "08036");

        Call shopCall = ServiceBuilder.getInstance().getShopInfo(parameters);
        try {
            Response<ShopResponse> shopResponse = shopCall.execute();

            List<ShopResponse.ShopInfo.Rows> rows = shopResponse.body().data.rows;

            if (!rows.isEmpty()){
                for (ShopResponse.ShopInfo.Rows row:rows) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("name:"+row.clubname);
                    stringBuffer.append(" no:"+row.club_no);
                    stringBuffer.append(" id:"+row.club_id);
                    System.out.println(stringBuffer.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchShop(){
        System.out.println("Begin to test search shop");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("page", "1");
        parameters.put("rows", "10");
        parameters.put("lat", "4.9E-324");
        parameters.put("lon", "4.9E-324");
        parameters.put("clubname", "上海广场");

        Call shopCall = ServiceBuilder.getInstance().searchShop(parameters);
        try {
            Response<ShopDetailsResponse> shopResponse = shopCall.execute();

            List<ShopDetailsResponse.ShopDetailInfo.Rows> rows = shopResponse.body().data.rows;

            if (!rows.isEmpty()){
                for (ShopDetailsResponse.ShopDetailInfo.Rows row:rows) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(row.name);
                    stringBuffer.append(" "+row.address);
                    stringBuffer.append(" "+row.phone);
                    System.out.println(stringBuffer.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
