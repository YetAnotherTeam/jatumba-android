package com.jat.jatumba.domain.main.users;

import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class GetUsersInteractor extends Interactor<List<User>, Void> {

    private final UsersDataProvider usersDataProvider;

    @Inject
    public GetUsersInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                              @Named(DomainModule.UI) Scheduler uiScheduler,
                              UsersDataProvider usersDataProvider) {
        super(jobScheduler, uiScheduler);
        this.usersDataProvider = usersDataProvider;
    }

    @Override
    protected Observable<List<User>> buildObservable(Void parameter) {
        return usersDataProvider.getAllUsers();
    }
}
