package com.jat.jatumba.presentation.injection;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Module
public class DomainModule {
    public static final String JOB = "JOB";
    public static final String UI = "UI";

    @Provides
    @Singleton
    @Named(JOB)
    public Scheduler provideJobScheduler() {
        return Schedulers.computation();
    }

    @Provides
    @Singleton
    @Named(UI)
    public Scheduler provideUIScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
