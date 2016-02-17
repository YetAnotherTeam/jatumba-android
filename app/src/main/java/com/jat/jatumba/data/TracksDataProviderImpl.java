package com.jat.jatumba.data;

import com.jat.jatumba.domain.main.tracks.Message;
import com.jat.jatumba.domain.main.tracks.MessagesDataProvider;
import com.jat.jatumba.domain.main.users.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;

public class TracksDataProviderImpl implements MessagesDataProvider {

    public static long PERIOD_UPDATE_IN_SECOND = 3;
    public static long NOW = new Date().getTime();

    @Override
    public Observable<List<Message>> getAllMessages(Scheduler scheduler) {
        return Observable.interval(0, PERIOD_UPDATE_IN_SECOND, TimeUnit.SECONDS, scheduler)
                .flatMap(this::getMessages);
    }

    private synchronized Observable<List<Message>> getMessages(long times) {
        List<Message> result = new ArrayList<>();
        int contactId = 0;
        for (int i = 0; i < times + 5; i++) {
            result.add(new Message(i, new User(contactId, "Имя " + contactId, "Фамилия" + contactId, "Музыкант" + contactId), "Message " + i, NOW + i*10000));
            if (contactId < 1000 - 1) {
                ++contactId;
            }else {
                contactId = 0;
            }
        }
        return Observable.just(result);
    }
}
