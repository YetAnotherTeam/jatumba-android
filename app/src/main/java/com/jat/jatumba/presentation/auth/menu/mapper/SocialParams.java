package com.jat.jatumba.presentation.auth.menu.mapper;

/**
 * Created by bulat on 27.02.16.
 */
public class SocialParams {
    private SocialNetworkName socialNetworkName;
    private String accessToken;

    public SocialParams(String accessToken, SocialNetworkName socialNetworkName) {
        this.accessToken = accessToken;
        this.socialNetworkName = socialNetworkName;
    }

    public SocialNetworkName getNetworkName() {
        return socialNetworkName;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
