package com.jat.jatumba.presentation.auth;

import android.os.Bundle;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.login.LoginFragment;
import com.jat.jatumba.presentation.auth.preloader.PreloaderFragment;
import com.jat.jatumba.presentation.auth.signUp.SignUpFragment;
import com.jat.jatumba.presentation.common.BaseActivity;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.injection.AuthActivityComponent;
import com.jat.jatumba.presentation.injection.DaggerAuthActivityComponent;
import com.jat.jatumba.presentation.injection.DataModule;
import com.jat.jatumba.presentation.injection.DomainModule;


@Layout(id = R.layout.activity_auth)
public class AuthActivity extends BaseActivity implements AuthRouter {
    private AuthActivityComponent authActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authActivityComponent =
                DaggerAuthActivityComponent
                        .builder()
                        .dataModule(new DataModule())
                        .domainModule(new DomainModule())
                        .build();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            openPreloader();
        }
    }

    public AuthActivityComponent getAuthActivityComponent() {
        return authActivityComponent;
    }

    @Override
    public void openLogin() {
        addBackStack(new LoginFragment(), false);
    }

    @Override
    public void openSignUp() {
        addBackStack(new SignUpFragment(), false);
    }

    @Override
    public void openPreloader() {
        addBackStack(new PreloaderFragment(), false);
    }
}
