package com.jat.jatumba.domain.main.compositions;

import com.jat.jatumba.data.entity.Composition;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

public interface CompositionsDataProvider {
    Observable<List<Composition>> getAllCompositions(Scheduler scheduler);
}
