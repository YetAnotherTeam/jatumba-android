package com.jat.jatumba.presentation.auth.login;

import android.util.Log;

import com.jat.jatumba.R;
import com.jat.jatumba.domain.auth.common.Credentials;
import com.jat.jatumba.domain.auth.login.LoginInteractor;
import com.jat.jatumba.data.model.User;
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

    public void login(String login, String password) {
        Log.d(LOG_TAG, "login");
        if (login.length() > 0 && password.length() > 0) {

            loginInteractor.execute(new Credentials(login, password), new Subscriber<User>() {
                @Override
                public void onCompleted() {
                    Log.d(LOG_TAG, "onCompleted");
                    loginInteractor.unsubscribe();
                }

                @Override
                public void onError(Throwable e) {
                    String error = e.getMessage();
                    Log.e(LOG_TAG, "onError: " + error);
                    getView().showError(error);
                    loginInteractor.unsubscribe();
                }

                @Override
                public void onNext(User user) {

                }
            });
        } else {
            getView().showError(R.string.enter_login_and_password);
        }
    }

    public void goBack() {
        getRouter().goBack();
    }
}
