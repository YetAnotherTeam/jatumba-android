package com.jat.jatumba.presentation.injection;

import com.jat.jatumba.presentation.auth.login.LoginFragment;
import com.jat.jatumba.presentation.auth.menu.MenuFragment;
import com.jat.jatumba.presentation.auth.signup.SignupFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DomainModule.class, DataModule.class})
public interface AuthActivityComponent {
    void inject(LoginFragment loginFragment);

    void inject(SignupFragment signUpFragment);

    void inject(MenuFragment menuFragment);
}
