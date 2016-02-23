package com.jat.jatumba.domain.main.tracks;

import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class GetUsersInteractor extends Interactor<List<Message>, Void> {
    private final TracksDataProvider tracksDataProvider;

    @Inject
    public GetUsersInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                              @Named(DomainModule.UI) Scheduler uiScheduler,
                              TracksDataProvider tracksDataProvider) {
        super(jobScheduler, uiScheduler);
        this.tracksDataProvider = tracksDataProvider;
    }

    @Override
    protected Observable<List<Message>> buildObservable(Void parametr) {
        return null;
    }

    private int compareMessageTimestamp(Message message1, Message message2) {
        if (message1.getTimestamp() == message2.getTimestamp()) {
            return 0;
        }
        return message1.getTimestamp() > message2.getTimestamp() ? -1 : 1;
    }
}
