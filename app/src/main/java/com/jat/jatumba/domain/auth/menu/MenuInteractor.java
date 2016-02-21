package com.jat.jatumba.domain.auth.menu;

import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 16.02.16.
 */
public class MenuInteractor extends Interactor<Boolean, Void> {
    private final static int PRELOAD_TIME = 200;
    @Inject
    public MenuInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                          @Named(DomainModule.UI) Scheduler iuScheduler) {
        super(jobScheduler, iuScheduler);
    }

    @Override
    protected Observable<Boolean> buildObservable(Void parameter) {
        return Observable.just(true).delay(PRELOAD_TIME, TimeUnit.SECONDS);
    }
}
