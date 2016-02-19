package com.jat.jatumba.data.retrofit;

import com.jat.jatumba.domain.main.users.User;


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
}