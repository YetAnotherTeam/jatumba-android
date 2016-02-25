package com.jat.jatumba.domain.main.bands;

import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.domain.main.tracks.Message;
import com.jat.jatumba.domain.main.tracks.TracksDataProvider;
import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class GetBandsInteractor extends Interactor<List<Message>, User> {
    private final TracksDataProvider tracksDataProvider;

    @Inject
    public GetBandsInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                              @Named(DomainModule.UI) Scheduler uiScheduler,
                              TracksDataProvider tracksDataProvider) {
        super(jobScheduler, uiScheduler);
        this.tracksDataProvider = tracksDataProvider;
    }

    @Override
    protected Observable<List<Message>> buildObservable(User parameter) {
        return null;
    }
}
