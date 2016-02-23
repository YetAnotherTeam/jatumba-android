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
    @POST("auth")
    Observable<User> authUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("signup")
    Observable<User> signupUser(@Field("email") String email, @Field("password") String password);
}
