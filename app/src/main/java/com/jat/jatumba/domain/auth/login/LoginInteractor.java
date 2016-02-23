package com.jat.jatumba.domain.auth.login;

import com.jat.jatumba.data.retrofit.APIInterface;
import com.jat.jatumba.domain.auth.common.Credentials;
import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.data.model.User;
import com.jat.jatumba.presentation.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 18.02.16.
 */
public class LoginInteractor extends Interactor<User, Credentials> {
    private final APIInterface apiInterface;

    @Inject
    public LoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                           @Named(DomainModule.UI) Scheduler uiScheduler, APIInterface apiInterface) {
        super(jobScheduler, uiScheduler);
        this.apiInterface = apiInterface;
    }

    @Override
    protected Observable<User> buildObservable(Credentials credentials) {
        return apiInterface.authUser(credentials.getLogin(), credentials.getPassword());
    }
}
