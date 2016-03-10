package com.jat.jatumba.data;

import com.jat.jatumba.data.entity.Composition;
import com.jat.jatumba.domain.main.compositions.CompositionsDataProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;

public class CompositionsDataProviderImpl implements CompositionsDataProvider {

    public static long PERIOD_UPDATE_IN_SECOND = 3;
    public static long NOW = new Date().getTime();

    @Override
    public Observable<List<Composition>> getAllCompositions(Scheduler scheduler) {
        return Observable.interval(0, PERIOD_UPDATE_IN_SECOND, TimeUnit.SECONDS, scheduler)
                .flatMap(this::getCompositions);
    }

    private synchronized Observable<List<Composition>> getCompositions(long times) {
        List<Composition> result = new ArrayList<>();
        for (int i = 0; i < times + 5; i++) {
            result.add(new Composition(i, "Composition " + i));
        }
        return Observable.just(result);
    }
}
