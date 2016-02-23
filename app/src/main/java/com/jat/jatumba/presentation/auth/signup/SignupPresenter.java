package com.jat.jatumba.presentation.auth.signup;

import android.util.Log;

import com.jat.jatumba.R;
import com.jat.jatumba.domain.auth.common.Credentials;
import com.jat.jatumba.domain.auth.signup.SignupInteractor;
import com.jat.jatumba.data.model.User;
import com.jat.jatumba.presentation.auth.common.BaseAuthPresenter;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by bulat on 15.02.16.
 */
public class SignupPresenter extends BaseAuthPresenter<SignupView> {
    private static final String LOG_TAG = "SignupPresenter";
    private final SignupInteractor signupInteractor;

    @Inject
    public SignupPresenter(SignupInteractor signupInteractor) {
        Log.d(LOG_TAG, "Constructor");
        this.signupInteractor = signupInteractor;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    public void goBack() {
        getRouter().goBack();
    }

    public void signup(String login, String password) {
        Log.d(LOG_TAG, "signup");
        if (login.length() > 0 && password.length() > 0) {

            signupInteractor.execute(new Credentials(login, password), new Subscriber<User>() {
                @Override
                public void onCompleted() {
                    Log.d(LOG_TAG, "onCompleted");
                    signupInteractor.unsubscribe();
                }

                @Override
                public void onError(Throwable e) {
                    String error = e.getMessage();
                    Log.e(LOG_TAG, "onError: " + error);
                    getView().showError(error);
                    signupInteractor.unsubscribe();
                }

                @Override
                public void onNext(User user) {

                }
            });
        } else {
            getView().showError(R.string.enter_login_and_password);
        }
    }
}
