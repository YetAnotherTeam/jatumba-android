package com.jat.jatumba.domain.auth.preload;

import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import rx.Single;
import rx.Subscriber;

/**
 * Created by bulat on 16.02.16.
 */
public class PreloadInteractor extends Interactor<Long, Void> {
    private final static int PRELOAD_TIME = 2;
    @Inject
    public PreloadInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                             @Named(DomainModule.UI) Scheduler iuScheduler) {

        super(jobScheduler, iuScheduler);
    }

    @Override
    protected Observable<Long> buildObservable(Void parameter) {
        return Observable.interval(PRELOAD_TIME, TimeUnit.SECONDS);
    }
}
