package com.jat.jatumba.data.network;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by andreybondar on 12.03.16.
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain)
            throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("token", "android")
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}

