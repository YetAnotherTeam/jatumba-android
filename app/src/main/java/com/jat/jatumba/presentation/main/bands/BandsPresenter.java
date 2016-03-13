package com.jat.jatumba.presentation.main.bands;

import android.util.Log;

import com.jat.jatumba.data.entity.Band;
import com.jat.jatumba.domain.main.bands.GetBandsInteractor;
import com.jat.jatumba.presentation.main.common.BaseMainPresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by bulat on 22.02.16.
 */
public class BandsPresenter extends BaseMainPresenter<BandsView> {
    private GetBandsInteractor getBandsInteractor;

    @Inject
    public BandsPresenter(GetBandsInteractor getBandsInteractor) {
        this.getBandsInteractor = getBandsInteractor;
    }

    @Override
    public void onStart() {
        getBandsInteractor.execute(new Subscriber<List<Band>>() {
            @Override
            public void onCompleted() {
                getBandsInteractor.unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(List<Band> bands) {
                getView().setBands(bands);
            }
        });
    }

    @Override
    public void onStop() {
        getBandsInteractor.unsubscribe();
    }

    public void bandSelected(Band band) {
        //getRouter().openCompositions(band);
    }
}
