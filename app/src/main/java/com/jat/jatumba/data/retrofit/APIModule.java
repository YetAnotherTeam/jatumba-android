package com.jat.jatumba.data.retrofit;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by bulat on 19.02.16.
 */
public class APIModule implements ConnectionParams{
    private static final String BASE_URL = SCHEMA + HOST;
    public static APIInterface getAPIInterface() {
        OkHttpClient httpClient = new OkHttpClient();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);

        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        builder.client(httpClient);
        return builder.build().create(APIInterface.class);
    }
}
