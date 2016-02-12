package com.jat.jatumba.model.api;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

public class ApiModule implements ConnectionSettings{
    private static final boolean ENABLE_LOG = true;

    private static final boolean ENABLE_AUTH = true;


    public static ApiInterface getApiInterface() {

        OkHttpClient httpClient = new OkHttpClient();

        if (ENABLE_AUTH) {
            httpClient.interceptors().add(chain -> {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", "Basic " + AUTH_64)
                        .method(original.method(), original.body())
                        .build();

                return chain.proceed(request);
            });
        }

        Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());

        builder.client(httpClient);

        ApiInterface apiInterface = builder.build().create(ApiInterface.class);
        return apiInterface;
    }

}
