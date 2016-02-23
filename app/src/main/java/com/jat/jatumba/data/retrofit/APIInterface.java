package com.jat.jatumba.data.retrofit;

import com.jat.jatumba.data.model.User;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by bulat on 18.02.16.
 */
public interface APIInterface {
    @FormUrlEncoded
    @POST("/api/auth/")
    Observable<User> authUser(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/api/sign_up/")
    Observable<User> signupUser(
            @Field("username") String username,
            @Field("password") String password,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName
    );
}
