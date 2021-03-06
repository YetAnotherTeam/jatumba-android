package com.jat.jatumba.presentation.auth.menu;

import android.app.Fragment;
import android.util.Log;

import com.facebook.login.LoginManager;
import com.jat.jatumba.data.network.response.AuthResponse;
import com.jat.jatumba.domain.auth.menu.SocialLoginInteractor;
import com.jat.jatumba.presentation.auth.common.BaseAuthPresenter;
import com.jat.jatumba.presentation.auth.menu.mapper.SocialNetworkName;
import com.jat.jatumba.presentation.auth.menu.mapper.SocialParams;
import com.vk.sdk.VKSdk;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by bulat on 15.02.16.
 */
public class MenuPresenter extends BaseAuthPresenter<MenuView> {
    private static final String LOG_TAG = "MenuPresenter";
    private SocialLoginInteractor socialLoginInteractor;
    @Inject
    public MenuPresenter(SocialLoginInteractor socialLoginInteractor){
        Log.d(LOG_TAG, "Constructor");
        this.socialLoginInteractor = socialLoginInteractor;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {}

    public void getVkToken(Fragment fragment) {
        VKSdk.login(fragment);
    }

    public void getOkToken(Fragment fragment) {
        //VKSdk.login(fragment);
    }

    public void getFbToken(Fragment fragment) {
        LoginManager.getInstance().logInWithReadPermissions(fragment, null);
        //VKSdk.login(fragment);
    }

    public void openSignup() {
        getRouter().openSignUp();
    }

    public void openLogin() {
        getRouter().openLogin();
    }

    public void vkLogin(String accessToken) {
        socialLogin(accessToken, SocialNetworkName.VK);
    }

    public void okLogin(String accessToken) {
        socialLogin(accessToken, SocialNetworkName.OK);
    }

    public void fbLogin(String accessToken) {
        socialLogin(accessToken, SocialNetworkName.FB);
    }

    private void socialLogin(String accessToken, SocialNetworkName socialNetworkName) {
        socialLoginInteractor.execute(new SocialParams(accessToken, socialNetworkName), new Subscriber<AuthResponse>() {
            @Override
            public void onCompleted() {}

            @Override
            public void onError(Throwable e) {
                getView().showSnackMessage(e.getMessage());
            }

            @Override
            public void onNext(AuthResponse authResponse) {
            }
        });
    }
}
