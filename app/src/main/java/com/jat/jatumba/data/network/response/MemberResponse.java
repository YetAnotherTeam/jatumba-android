package com.jat.jatumba.data.network.response;

import com.google.gson.annotations.SerializedName;
import com.jat.jatumba.data.entity.Band;
import com.jat.jatumba.data.entity.Instrument;
import com.jat.jatumba.data.entity.User;

/**
 * Created by andreybondar on 12.03.16.
 */
public class MemberResponse {
    @SerializedName("user")
    User user;
    @SerializedName("band")
    Band band;
    @SerializedName("instrument")
    Instrument instrument;
}
