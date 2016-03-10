package com.jat.jatumba.presentation.main.compositions;

import com.jat.jatumba.data.entity.Composition;
import com.jat.jatumba.domain.main.compositions.GetCompositionsInteractor;
import com.jat.jatumba.presentation.main.common.BaseMainPresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by bulat on 22.02.16.
 */
public class CompositionsPresenter extends BaseMainPresenter<CompositionsView> {
    private GetCompositionsInteractor getCompositionsInteractor;

    @Inject
    public CompositionsPresenter(GetCompositionsInteractor getCompositionsInteractor) {
        this.getCompositionsInteractor = getCompositionsInteractor;
    }

    @Override
    public void onStart() {
        getCompositionsInteractor.execute(new Subscriber<List<Composition>>() {
            @Override
            public void onCompleted() {
                getCompositionsInteractor.unsubscribe();
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(List<Composition> compositions) {
                getView().setCompositions(compositions);
            }
        });
    }

    @Override
    public void onStop() {
        getCompositionsInteractor.unsubscribe();
    }

    public void compositionSelected(Composition composition) {
        getRouter().openComposition(composition);
    }
}
