package com.jat.jatumba.domain.main.bands;

import com.jat.jatumba.data.entity.Band;

import java.util.List;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 24.02.16.
 */
public interface BandsDataProvider {
    Observable<List<Band>> getAllBands(Scheduler scheduler);
}
