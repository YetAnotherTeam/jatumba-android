package com.jat.jatumba.presentation.main.tracks;

import com.jat.jatumba.data.model.Track;
import com.jat.jatumba.domain.main.tracks.GetTracksInteractor;
import com.jat.jatumba.presentation.main.common.BaseMainPresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

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
        getTracksInteractor.execute(new Subscriber<List<Track>>() {
            @Override
            public void onCompleted() {
                getTracksInteractor.unsubscribe();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Track> tracks) {
                getView().setTracks(tracks);
            }
        });

    }

    @Override
    public void onStop() {
    }

    public void trackSelected(Track track) {
        getRouter().openTrack(track);
    }
}
