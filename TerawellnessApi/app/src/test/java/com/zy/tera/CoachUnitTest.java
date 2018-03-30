package com.zy.tera;

import com.zy.tera.response.CoachResponse;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by yz250242 on 2018/3/27.
 */

public class CoachUnitTest {

    @Test
    public void getCoachInfo(){
        System.out.println("Begin to test coach");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("app", "a");
        parameters.put("name", "任一帆");

        Call coachCall = ServiceBuilder.getInstance().getCoachInfo(parameters);

        System.out.println(coachCall.request().url().toString());

        try {
            Response<CoachResponse> coachResponse = coachCall.execute();

            List<CoachResponse.CoachInfo.Rows> rows = coachResponse.body().data.rows;

            if (!rows.isEmpty()){
                for (CoachResponse.CoachInfo.Rows row:rows) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("name:"+row.name);
                    stringBuffer.append(" cid:"+row.cid);
                    stringBuffer.append(" id:"+row.id);
                    System.out.println(stringBuffer.toString());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
