package com.jat.jatumba.domain.main.compositions;

import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class GetUsersInteractor extends Interactor<List<Message>, Void> {
    private final CompositionsDataProvider compositionsDataProvider;

    @Inject
    public GetUsersInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                              @Named(DomainModule.UI) Scheduler uiScheduler,
                              CompositionsDataProvider compositionsDataProvider) {
        super(jobScheduler, uiScheduler);
        this.compositionsDataProvider = compositionsDataProvider;
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
