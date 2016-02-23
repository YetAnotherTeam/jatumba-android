package com.jat.jatumba.presentation.main.tracks;

import com.jat.jatumba.domain.main.tracks.GetTracksInteractor;
import com.jat.jatumba.presentation.main.common.BaseMainPresenter;

import javax.inject.Inject;

/**
 * Created by bulat on 22.02.16.
 */
public class TracksPresenter extends BaseMainPresenter<TracksView> {
    private GetTracksInteractor getTracksInteractor;

    @Inject
    public TracksPresenter(GetTracksInteractor getTracksInteractor) {
        this.getTracksInteractor = getTracksInteractor;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }
}
