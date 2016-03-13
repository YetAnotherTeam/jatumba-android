package com.jat.jatumba.data.network.service;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by bulat on 19.02.16.
 */
public class AuthModule implements ConnectionParams{
    private static final String BASE_URL = SCHEMA + HOST;
    public static AuthInterface getAuthInterface() {
        OkHttpClient httpClient = new OkHttpClient();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(loggingInterceptor);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(httpClient);
        return builder.build().create(AuthInterface.class);
    }
}
