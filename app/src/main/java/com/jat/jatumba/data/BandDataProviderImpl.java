package com.jat.jatumba.data;


import com.jat.jatumba.data.model.Band;
import com.jat.jatumba.domain.main.bands.BandDataProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;

public class BandDataProviderImpl implements BandDataProvider {

    public static long PERIOD_UPDATE_IN_SECOND = 3;
    public static long NOW = new Date().getTime();

    @Override
    public Observable<List<Band>> getAllBands(Scheduler scheduler) {
        return Observable.interval(0, PERIOD_UPDATE_IN_SECOND, TimeUnit.SECONDS, scheduler)
                .flatMap(this::getBands);
    }

    private synchronized Observable<List<Band>> getBands(long times) {
        List<Band> result = new ArrayList<>();
        int contactId = 0;
        for (int i = 0; i < times + 5; i++) {
            result.add(new Band());
            if (contactId < 1000 - 1) {
                ++contactId;
            }else {
                contactId = 0;
            }
        }
        return Observable.just(result);
    }
}
