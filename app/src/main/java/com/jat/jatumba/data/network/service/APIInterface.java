package com.jat.jatumba.data.network.service;

import com.jat.jatumba.data.entity.Band;
import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.data.network.response.AuthResponse;
import com.jat.jatumba.data.network.response.MemberResponse;

import java.util.List;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by andreybondar on 12.03.16.
 */
public interface APIInterface {
    @GET("/api/user/{id}")
    Observable<User> getUser(@Path("id") int id);

    @GET("/api/user/")
    Observable<List<User>> getUserList();

    @GET("/api/band/")
    Observable<List<Band>> getBandList();

    @GET("/api/member/")
    Observable<List<MemberResponse>> getBandMemberList(@Query("band") int id);

    @GET("/api/member/{id}/")
    Observable<MemberResponse> getMember(@Path("id") int id);

    @FormUrlEncoded
    @POST("/api/token/refresh/")
    Observable<AuthResponse> refreshToken(@Field("refresh_token") String refresh_token);
}
