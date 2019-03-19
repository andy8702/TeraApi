package com.zy.tera;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static DataAPIService service;

    public static DataAPIService getInstance(){
        if (null == service){
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASEURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(LogInterceptor.getLogInterceptor())
                        .build();

                service = retrofit.create(DataAPIService.class);
            }catch (IllegalArgumentException e){
                System.out.println("The API host URL is not correct!");
                throw new IllegalArgumentException("The API host URL is not correct!");
            }
        }

        return service;
    }

}
