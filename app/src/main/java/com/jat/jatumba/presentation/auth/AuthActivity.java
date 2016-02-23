package com.jat.jatumba.presentation.auth;

import android.content.Intent;
import android.os.Bundle;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.menu.MenuFragment;
import com.jat.jatumba.presentation.auth.signup.SignupFragment;
import com.jat.jatumba.presentation.common.BaseActivity;
import com.jat.jatumba.presentation.common.BaseFragment;
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
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            openMenu();
        }
    }

    public AuthActivityComponent getAuthActivityComponent() {
        return authActivityComponent;
    }

    @Override
    public void openLogin() {
        // TODO временно чтобы разработка шла полным ходом
        openMainActivity();
        // replaceToFragment(new LoginFragment());
    }

    @Override
    public void openSignUp() {
        replaceToFragment(new SignupFragment());
    }

    @Override
    public void openMenu() {
        BaseFragment fragment = new MenuFragment();
        replaceToFragment(fragment, false);
    }

    @Override
    public void goBack() {
        getFragmentManager().popBackStack();
    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
