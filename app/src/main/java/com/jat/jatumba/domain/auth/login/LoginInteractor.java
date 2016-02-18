package com.jat.jatumba.domain.auth.login;

import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.domain.main.users.User;
import com.jat.jatumba.presentation.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 18.02.16.
 */
public class LoginInteractor extends Interactor<User, Credentials> {
    @Inject
    public LoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                           @Named(DomainModule.UI) Scheduler uiScheduler) {
        super(jobScheduler, uiScheduler);
    }

    @Override
    protected Observable<User> buildObservable(Credentials parameter) {
        return null;
    }
}
