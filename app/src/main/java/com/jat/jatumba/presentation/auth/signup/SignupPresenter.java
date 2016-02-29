package com.jat.jatumba.presentation.auth.signup;

import android.util.Log;

import com.jat.jatumba.R;
import com.jat.jatumba.data.network.response.AuthResponse;
import com.jat.jatumba.domain.auth.signup.SignupInteractor;
import com.jat.jatumba.data.entity.User;
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

    public void signup(String username, String password, String firstName, String lastName) {
        Log.d(LOG_TAG, "signup");
        if (username.length() > 0
                && password.length() > 0
                && firstName.length() > 0
                && lastName.length() > 0) {
            signupInteractor.execute(new User(username, password, firstName, lastName), new Subscriber<AuthResponse>() {
                @Override
                public void onCompleted() {
                    Log.d(LOG_TAG, "onCompleted");
                    signupInteractor.unsubscribe();
                    getRouter().openMainActivity();
                }

                @Override
                public void onError(Throwable e) {
                    String error = e.getMessage();
                    Log.e(LOG_TAG, "onError: " + error);
                    getView().showSnackMessage(error);
                    signupInteractor.unsubscribe();
                }

                @Override
                public void onNext(AuthResponse authResponse) {
                    Log.d(LOG_TAG, authResponse.toString());
                }
            });
        } else {
            getView().showSnackMessage(R.string.enter_all_fields);
        }
    }
}
