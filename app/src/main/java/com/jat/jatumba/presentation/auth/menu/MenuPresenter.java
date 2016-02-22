package com.jat.jatumba.presentation.auth.menu;

import android.util.Log;

import com.jat.jatumba.presentation.auth.common.BaseAuthPresenter;

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

    public void openSignUp() {
        getRouter().openSignUp();
    }

    public void openLogin() {
        getRouter().openLogin();
    }
}
