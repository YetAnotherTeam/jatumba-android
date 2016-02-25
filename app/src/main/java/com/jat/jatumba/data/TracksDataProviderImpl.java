package com.jat.jatumba.data;

import com.jat.jatumba.data.entity.Track;
import com.jat.jatumba.domain.main.tracks.TracksDataProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Scheduler;

public class TracksDataProviderImpl implements TracksDataProvider {

    public static long PERIOD_UPDATE_IN_SECOND = 3;
    public static long NOW = new Date().getTime();

    @Override
    public Observable<List<Track>> getAllTracks(Scheduler scheduler) {
        return Observable.interval(0, PERIOD_UPDATE_IN_SECOND, TimeUnit.SECONDS, scheduler)
                .flatMap(this::getTracks);
    }

    private synchronized Observable<List<Track>> getTracks(long times) {
        List<Track> result = new ArrayList<>();
        for (int i = 0; i < times + 5; i++) {
            result.add(new Track(i, "Track " + i));
        }
        return Observable.just(result);
    }
}
