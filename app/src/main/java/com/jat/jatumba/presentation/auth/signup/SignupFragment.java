package com.jat.jatumba.presentation.auth.signup;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.common.BaseAuthFragment;
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

    @Bind(R.id.username)
    EditText usernameTextView;

    @Bind(R.id.password)
    EditText passwordEditText;

    @Bind(R.id.first_name)
    EditText firstNameEditText;

    @Bind(R.id.last_name)
    EditText lastNameEditText;

    @Bind(R.id.signup_button)
    FrameLayout signupButton;

    public SignupFragment() {
        Log.d(LOG_TAG, "Constructor");
    }

    @OnClick(R.id.back_button)
    public void onClickBackButton() {
        Log.d(LOG_TAG, "onClickBackButton");
        signupPresenter.goBack();
    }

    @OnClick(R.id.signup_button)
    public void onClickSignupButton() {
        Log.d(LOG_TAG, "onClickLoginButton");
        String username = usernameTextView.getText().toString();
        String password = passwordEditText.getText().toString();
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        signupPresenter.signup(username, password, firstName, lastName);
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
