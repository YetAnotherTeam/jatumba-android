package com.jat.jatumba.presentation.auth.preloader;

import android.util.Log;

import com.jat.jatumba.domain.auth.preload.PreloadInteractor;
import com.jat.jatumba.presentation.auth.authCommon.BaseAuthPresenter;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by bulat on 15.02.16.
 */
public class PreloaderPresenter extends BaseAuthPresenter<PreloaderView> {
    private static final String LOG_TAG = "PreloaderPresenter";
    private final PreloadInteractor preloadInteractor;

    @Inject
    public PreloaderPresenter(PreloadInteractor preloadInteractor){
        Log.d(LOG_TAG, "Constructor");
        this.preloadInteractor = preloadInteractor;
    }

    @Override
    public void onStart() {
        preloadInteractor.execute(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {
                Log.d(LOG_TAG, "onCompleted");
                getRouter().openLogin();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(LOG_TAG, "onError: " + e);
                getView().showError(e.getMessage());
            }

            @Override
            public void onNext(Boolean aLong) {
            }
        });
    }

    @Override
    public void onStop() {
        preloadInteractor.unsubscribe();
    }
}
