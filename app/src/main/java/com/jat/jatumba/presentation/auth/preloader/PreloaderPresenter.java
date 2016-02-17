package com.jat.jatumba.presentation.auth.preloader;

import com.jat.jatumba.domain.main.tracks.GetUsersInteractor;
import com.jat.jatumba.presentation.auth.authCommon.BaseAuthPresenter;

import javax.inject.Inject;

/**
 * Created by bulat on 15.02.16.
 */
public class PreloaderPresenter extends BaseAuthPresenter<PreloaderView> {

    private final GetUsersInteractor getUsersInteractor;

    @Inject
    public PreloaderPresenter(GetUsersInteractor getUsersInteractor){
        this.getUsersInteractor = getUsersInteractor;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
