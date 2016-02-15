package com.jat.jatumba.domain.users;

import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class GetUsersInteractor extends Interactor<List<User>, Void> {

    private final UsersDataProvider contactsDataProvider;

    @Inject
    public GetUsersInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                              @Named(DomainModule.UI) Scheduler iuScheduler,
                              UsersDataProvider contactsDataProvider) {
        super(jobScheduler, iuScheduler);
        this.contactsDataProvider = contactsDataProvider;
    }

    @Override
    protected Observable<List<User>> buildObservable(Void parameter) {
        return contactsDataProvider.getAllUsers();
    }
}
