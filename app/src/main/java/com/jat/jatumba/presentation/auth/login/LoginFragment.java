package com.jat.jatumba.presentation.auth.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.authCommon.BaseAuthFragment;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

@Layout(id = R.layout.fragment_login)
public class LoginFragment extends BaseAuthFragment {
    private static final String LOG_TAG = "LoginFragment";
    @Inject
    LoginPresenter loginPresenter;
    @Bind(R.id.login)
    EditText loginEditText;
    @Bind(R.id.password)
    EditText passwordEditText;
    @Bind(R.id.login_button)
    Button loginButton;

    @OnClick(R.id.login_button)
    public void onClickLoginButton() {
        Log.d(LOG_TAG, "login");
        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if (login.length() > 0 && password.length() > 0) {
            loginPresenter.login(login, password);
        }
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
