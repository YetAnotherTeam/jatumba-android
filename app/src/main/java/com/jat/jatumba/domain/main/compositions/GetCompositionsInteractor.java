package com.jat.jatumba.domain.main.compositions;

import com.jat.jatumba.data.entity.Composition;
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
public class GetCompositionsInteractor extends Interactor<List<Composition>, Integer> {
    private final CompositionsDataProvider compositionsDataProvider;

    @Inject
    public GetCompositionsInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                                     @Named(DomainModule.UI) Scheduler uiScheduler,
                                     CompositionsDataProvider compositionsDataProvider) {
        super(jobScheduler, uiScheduler);
        this.compositionsDataProvider = compositionsDataProvider;
    }

    @Override
    protected Observable<List<Composition>> buildObservable(Integer parameter) {
        return compositionsDataProvider.getAllCompositions(jobScheduler);
    }
}
