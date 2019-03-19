package com.zy.tera;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookServiceBuilder {

    private static BookAPIService service;

    public static BookAPIService getInstance(){
        if (null == service){
            try {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BOOK_BASEURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(LogInterceptor.getLogInterceptor())
                        .build();

                service = retrofit.create(BookAPIService.class);
            }catch (IllegalArgumentException e){
                System.out.println("The API host URL is not correct!");
                throw new IllegalArgumentException("The API host URL is not correct!");
            }
        }

        return service;
    }

}
