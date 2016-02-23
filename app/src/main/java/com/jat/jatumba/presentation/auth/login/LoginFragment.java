package com.jat.jatumba.presentation.auth.login;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.common.BaseAuthFragment;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

@Layout(id = R.layout.fragment_login)
public class LoginFragment extends BaseAuthFragment implements LoginView {
    private static final String LOG_TAG = "LoginFragment";

    @Inject
    LoginPresenter loginPresenter;

    @Bind(R.id.login)
    TextView loginTextView;

    @Bind(R.id.password)
    EditText passwordEditText;

    @Bind(R.id.login_button)
    FrameLayout loginButton;

    public LoginFragment() {
        Log.d(LOG_TAG, "Constructor");
    }

    @OnClick(R.id.back_button)
    public void onClickBackButton() {
        Log.d(LOG_TAG, "onClickBackButton");
        loginPresenter.goBack();
    }

    @OnClick(R.id.login_button)
    public void onClickLoginButton() {
        Log.d(LOG_TAG, "onClickLoginButton");
        String login = loginTextView.getText().toString();
        String password = passwordEditText.getText().toString();
        loginPresenter.login(login, password);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return loginPresenter;
    }

    @Override
    protected void inject() {
        getAuthActivityComponent().inject(this);
    }
}
