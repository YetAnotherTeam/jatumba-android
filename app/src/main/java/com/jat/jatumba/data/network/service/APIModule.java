package com.jat.jatumba.data.network.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;


public class APIModule implements ConnectionParams {
    private static final String BASE_URL = SCHEMA + HOST;
    public static APIInterface getAPIInterface() {
        OkHttpClient httpClient = new OkHttpClient();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(loggingInterceptor);
        httpClient.interceptors().add(headerInterceptor);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(httpClient);
        return builder.build().create(APIInterface.class);
    }
}
