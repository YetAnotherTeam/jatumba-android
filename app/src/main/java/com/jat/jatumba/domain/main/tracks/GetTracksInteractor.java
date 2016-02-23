package com.jat.jatumba.domain.main.tracks;

import com.jat.jatumba.data.model.Track;
import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 23.02.16.
 */
public class GetTracksInteractor extends Interactor<List<Track>, Integer> {
    @Inject
    public GetTracksInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                               @Named(DomainModule.UI) Scheduler uiScheduler) {
        super(jobScheduler, uiScheduler);
    }

    @Override
    protected Observable<List<Track>> buildObservable(Integer parameter) {
        return null;
    }
}