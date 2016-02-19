package com.jat.jatumba.presentation.auth.login;

import android.util.Log;

import com.jat.jatumba.domain.auth.login.Credentials;
import com.jat.jatumba.domain.auth.login.LoginInteractor;
import com.jat.jatumba.domain.main.users.User;
import com.jat.jatumba.presentation.auth.authCommon.BaseAuthPresenter;

import javax.inject.Inject;

import rx.Subscriber;


/**
 * Created by bulat on 18.02.16.
 */
public class LoginPresenter extends BaseAuthPresenter<LoginView> {
    private static final String LOG_TAG = "LoginPresenter";
    private final LoginInteractor loginInteractor;

    @Inject
    public LoginPresenter(LoginInteractor loginInteractor){
        Log.d(LOG_TAG, "Constructor");
        this.loginInteractor = loginInteractor;
    }
    
    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        loginInteractor.unsubscribe();
    }

    public void login(String login, String password) {
        Log.d(LOG_TAG, "login");
        loginInteractor.execute(new Credentials(login, password), new Subscriber<User>() {
            @Override
            public void onCompleted() {
                Log.d(LOG_TAG, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(LOG_TAG, "onError: " + e);
                getView().showError(e.getMessage());
            }

            @Override
            public void onNext(User user) {

            }
        });
    }
}
