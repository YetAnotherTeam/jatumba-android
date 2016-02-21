package com.jat.jatumba.presentation.auth.signup;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.authCommon.BaseAuthFragment;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

@Layout(id = R.layout.fragment_signup)
public class SignupFragment extends BaseAuthFragment implements SignupView {
    private static final String LOG_TAG = "SignupFragment";

    @Inject
    SignupPresenter signupPresenter;

    @Bind(R.id.login)
    TextView loginTextView;

    @Bind(R.id.password)
    EditText passwordEditText;

    @Bind(R.id.signup_button)
    FrameLayout signupButton;

    @OnClick(R.id.back_button)
    public void onClickBackButton() {
        Log.d(LOG_TAG, "onClickBackButton");
        signupPresenter.goBack();
    }

    @OnClick(R.id.signup_button)
    public void onClickSignupButton() {
        Log.d(LOG_TAG, "onClickLoginButton");
        String login = loginTextView.getText().toString();
        String password = passwordEditText.getText().toString();
        signupPresenter.signup(login, password);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return signupPresenter;
    }

    @Override
    protected void inject() {
        getAuthActivityComponent().inject(this);
    }
}
