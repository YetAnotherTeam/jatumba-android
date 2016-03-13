package com.jat.jatumba.domain.main.bands;

import com.jat.jatumba.data.entity.Band;
import com.jat.jatumba.data.network.APIInterface;
import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class GetBandsInteractor extends Interactor<List<Band>, User> {
//    private final BandsDataProvider bandsDataProvider;
    private final APIInterface apiInterface;

    @Inject
    public GetBandsInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                              @Named(DomainModule.UI) Scheduler uiScheduler,
                              APIInterface apiInterface) {
        super(jobScheduler, uiScheduler);
        this.apiInterface = apiInterface;
    }

    @Override
    protected Observable<List<Band>> buildObservable(User parameter) {
        return apiInterface.getBandList();
    }
}
