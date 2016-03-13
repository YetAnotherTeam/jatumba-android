package com.jat.jatumba.domain.auth.login;

import com.jat.jatumba.data.network.service.AuthInterface;
import com.jat.jatumba.data.network.response.AuthResponse;
import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.presentation.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 18.02.16.
 */
public class LoginInteractor extends Interactor<AuthResponse, User> {
    private final AuthInterface loginInterface;

    @Inject
    public LoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                           @Named(DomainModule.UI) Scheduler uiScheduler,
                           AuthInterface loginInterface) {
        super(jobScheduler, uiScheduler);
        this.loginInterface = loginInterface;
    }

    @Override
    protected Observable<AuthResponse> buildObservable(User user) {
        return loginInterface.login(user.getUsername(), user.getPassword());
    }
}
