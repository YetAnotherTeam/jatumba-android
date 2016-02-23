package com.jat.jatumba.domain.main.tracks;

import com.jat.jatumba.data.model.Track;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

public interface TracksDataProvider {
    Observable<List<Track>> getAllTracks(Scheduler scheduler);
}
