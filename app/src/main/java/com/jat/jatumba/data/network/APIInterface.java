package com.jat.jatumba.data.network;

import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.data.network.response.AuthResponse;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by bulat on 18.02.16.
 */
public interface APIInterface {
    @FormUrlEncoded
    @POST("/api/sign_up/vk/")
    Observable<AuthResponse> vkLogin(
            @Field("token") String accessToken
    );

    @FormUrlEncoded
    @POST("/api/sign_up/fb/")
    Observable<AuthResponse> fbLogin(
            @Field("token") String accessToken
    );

    @FormUrlEncoded
    @POST("/api/sign_in/")
    Observable<AuthResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/api/sign_up/")
    Observable<AuthResponse> signup(
            @Field("username") String username,
            @Field("password") String password,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName
    );
}
