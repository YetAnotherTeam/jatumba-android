package com.jat.jatumba.data.network;

import com.jat.jatumba.data.entity.Band;
import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.data.network.response.AuthResponse;
import com.jat.jatumba.data.network.response.MemberResponse;

import java.util.List;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
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
    @POST("/api/user/sign_in/")
    Observable<AuthResponse> login(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/api/user/sign_up/")
    Observable<AuthResponse> signup(
            @Field("username") String username,
            @Field("password") String password,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName
    );

    @FormUrlEncoded
    @GET("/api/user/{id}")
    Observable<User> getUser(
            @Path("id") int id
    );

    @FormUrlEncoded
    @GET("/api/user/")
    Observable<List<User>> getUserList();

    @FormUrlEncoded
    @GET("/api/band/")
    Observable<List<Band>> getBandList();

    @FormUrlEncoded
    @GET("/api/member")
    Observable<List<MemberResponse>> getBandMemberList(@Query("band") int id);

}
