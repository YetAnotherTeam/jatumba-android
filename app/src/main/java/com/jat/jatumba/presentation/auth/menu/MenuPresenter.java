package com.jat.jatumba.presentation.auth.menu;

import android.app.Fragment;
import android.util.Log;

import com.jat.jatumba.presentation.auth.common.BaseAuthPresenter;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;

import javax.inject.Inject;

/**
 * Created by bulat on 15.02.16.
 */
public class MenuPresenter extends BaseAuthPresenter<MenuView> {
    private static final String LOG_TAG = "MenuPresenter";

    @Inject
    public MenuPresenter(){
        Log.d(LOG_TAG, "Constructor");
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {}

    public void vkLogin(Fragment fragment) {
        VKSdk.login(fragment, VKScope.EMAIL);
    }

    public void openSignup() {
        getRouter().openSignUp();
    }

    public void openLogin() {
        getRouter().openLogin();
    }
}
