package com.jat.jatumba.presentation.injection;

import com.jat.jatumba.presentation.auth.login.LoginFragment;
import com.jat.jatumba.presentation.auth.preloader.PreloaderFragment;
import com.jat.jatumba.presentation.auth.signUp.SignUpFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DomainModule.class, DataModule.class})
public interface AuthActivityComponent {
    void inject(LoginFragment loginFragment);

    void inject(SignUpFragment signUpFragment);

    void inject(PreloaderFragment preloaderFragment);
}
