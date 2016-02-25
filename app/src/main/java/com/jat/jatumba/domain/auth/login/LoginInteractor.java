package com.jat.jatumba.domain.auth.login;

import com.jat.jatumba.data.retrofit.APIInterface;
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
public class LoginInteractor extends Interactor<User, User> {
    private final APIInterface apiInterface;

    @Inject
    public LoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                           @Named(DomainModule.UI) Scheduler uiScheduler,
                           APIInterface apiInterface) {
        super(jobScheduler, uiScheduler);
        this.apiInterface = apiInterface;
    }

    @Override
    protected Observable<User> buildObservable(User user) {
        return apiInterface.authUser(user.getUsername(), user.getPassword());
    }
}
