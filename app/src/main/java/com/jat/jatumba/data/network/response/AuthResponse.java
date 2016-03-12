package com.jat.jatumba.data.network.response;

import com.google.gson.annotations.SerializedName;
import com.jat.jatumba.data.entity.Session;
import com.jat.jatumba.data.entity.User;

/**
 * Created by bulat on 28.02.16.
 */
public class AuthResponse {
    @SerializedName("session")
    Session session;
    @SerializedName("user")
    User user;
}
