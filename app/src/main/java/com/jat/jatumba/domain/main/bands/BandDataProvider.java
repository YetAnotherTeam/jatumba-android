package com.jat.jatumba.domain.main.bands;

import com.jat.jatumba.data.model.Band;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 24.02.16.
 */
public interface BandDataProvider {
    Observable<List<Band>> getAllBands(Scheduler scheduler);
}
