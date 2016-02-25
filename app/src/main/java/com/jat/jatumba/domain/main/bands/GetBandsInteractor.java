package com.jat.jatumba.domain.main.bands;

import com.jat.jatumba.data.entity.Band;
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

public class GetBandsInteractor extends Interactor<List<Band>, User> {
    private final BandsDataProvider bandsDataProvider;

    @Inject
    public GetBandsInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                              @Named(DomainModule.UI) Scheduler uiScheduler,
                              BandsDataProvider bandsDataProvider) {
        super(jobScheduler, uiScheduler);
        this.bandsDataProvider = bandsDataProvider;
    }

    @Override
    protected Observable<List<Band>> buildObservable(User parameter) {
        return bandsDataProvider.getAllBands(jobScheduler);
    }
}
