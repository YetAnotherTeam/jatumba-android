package com.jat.jatumba.domain.main.tracks;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

public interface MessagesDataProvider {
    Observable<List<Message>> getAllMessages(Scheduler scheduler);
}
