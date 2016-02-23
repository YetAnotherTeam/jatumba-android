package com.jat.jatumba.domain.main.teams;

import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.domain.main.tracks.Message;
import com.jat.jatumba.domain.main.tracks.MessagesDataProvider;
import com.jat.jatumba.data.model.User;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class GetTeamsInteractor extends Interactor<List<Message>, User> {
    private final MessagesDataProvider messagesDataProvider;

    @Inject
    public GetTeamsInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                              @Named(DomainModule.UI) Scheduler uiScheduler,
                              MessagesDataProvider messagesDataProvider) {
        super(jobScheduler, uiScheduler);
        this.messagesDataProvider = messagesDataProvider;
    }

    @Override
    protected Observable<List<Message>> buildObservable(User parameter) {
        return messagesDataProvider.getAllMessages(jobScheduler)
                .flatMap(listNotification -> Observable.from(listNotification)
                        .filter(r -> r.getContact().equals(parameter))
                        .toSortedList((message1, message2) -> {
                            if (message1.getTimestamp() == message2.getTimestamp()) {
                                return 0;
                            }
                            return message1.getTimestamp() > message2.getTimestamp() ? 1 : -1;
                        }));
    }
}
