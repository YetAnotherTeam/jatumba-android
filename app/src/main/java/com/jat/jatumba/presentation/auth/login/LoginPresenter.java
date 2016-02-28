package com.jat.jatumba.presentation.auth.login;

import android.util.Log;

import com.jat.jatumba.R;
import com.jat.jatumba.domain.auth.login.LoginInteractor;
import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.presentation.auth.common.BaseAuthPresenter;

import javax.inject.Inject;

import rx.Subscriber;


/**
 * Created by bulat on 18.02.16.
 */
public class LoginPresenter extends BaseAuthPresenter<LoginView> {
    private static final String LOG_TAG = "LoginPresenter";
    private final LoginInteractor loginInteractor;

    @Inject
    public LoginPresenter(LoginInteractor loginInteractor) {
        Log.d(LOG_TAG, "Constructor");
        this.loginInteractor = loginInteractor;
    }
    
    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public void login(String username, String password) {
        Log.d(LOG_TAG, "login");
        if (username.length() > 0 && password.length() > 0) {

            loginInteractor.execute(new User(username, password), new Subscriber<User>() {
                @Override
                public void onCompleted() {
                    Log.d(LOG_TAG, "onCompleted");
                    loginInteractor.unsubscribe();
                }

                @Override
                public void onError(Throwable e) {
                    String error = e.getMessage();
                    Log.e(LOG_TAG, "onError: " + error);
                    getView().showSnack(error);
                    loginInteractor.unsubscribe();
                }

                @Override
                public void onNext(User user) {

                }
            });
        } else {
            getView().showSnack(R.string.enter_all_fields);
        }
    }

    public void goBack() {
        getRouter().goBack();
    }
}
