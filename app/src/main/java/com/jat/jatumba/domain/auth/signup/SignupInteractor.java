package com.jat.jatumba.domain.auth.signup;

import com.jat.jatumba.data.network.LoginInterface;
import com.jat.jatumba.data.network.response.AuthResponse;
import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.presentation.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 22.02.16.
 */
public class SignupInteractor extends Interactor<AuthResponse, User> {
    private final LoginInterface loginInterface;
    @Inject
    public SignupInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                            @Named(DomainModule.UI) Scheduler uiScheduler,
                            LoginInterface loginInterface) {
        super(jobScheduler, uiScheduler);
        this.loginInterface = loginInterface;
    }

    @Override
    protected Observable<AuthResponse> buildObservable(User user) {
        return loginInterface.signup(
                user.getUsername(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
