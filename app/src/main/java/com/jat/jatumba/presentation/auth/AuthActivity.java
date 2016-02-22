package com.jat.jatumba.presentation.auth;

import android.content.Intent;
import android.os.Bundle;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.menu.MenuFragment;
import com.jat.jatumba.presentation.auth.signup.SignupFragment;
import com.jat.jatumba.presentation.common.BaseActivity;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.injection.AuthActivityComponent;
import com.jat.jatumba.presentation.injection.DaggerAuthActivityComponent;
import com.jat.jatumba.presentation.injection.DataModule;
import com.jat.jatumba.presentation.injection.DomainModule;
import com.jat.jatumba.presentation.main.MainActivity;


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
            openMenu();
        }
    }

    public AuthActivityComponent getAuthActivityComponent() {
        return authActivityComponent;
    }

    @Override
    public void openLogin() {
        // TODO временно чтобы разработка шла полным ходом
        openMain();
        // addBackStack(new LoginFragment());
    }

    @Override
    public void openSignUp() {
        addBackStack(new SignupFragment());
    }

    @Override
    public void openMenu() {
        addBackStack(new MenuFragment(), false);
    }

    @Override
    public void goBack() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void openMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
