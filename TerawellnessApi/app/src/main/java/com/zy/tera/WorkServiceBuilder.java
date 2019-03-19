package com.zy.tera;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zy.tera.utils.HTTPSUtils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorkServiceBuilder {

    private static WorkAPIService service;

    public static WorkAPIService getInstance(Context context){
        if (null == service){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.WORK_BASEURL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .client(HTTPSUtils.getHttpsClient(context))
                        .build();

                service = retrofit.create(WorkAPIService.class);
            }catch (IllegalArgumentException e){
                System.out.println("The API host URL is not correct!");
                throw new IllegalArgumentException("The API host URL is not correct!");
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return service;
    }

}
