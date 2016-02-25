package com.jat.jatumba.presentation.main;

import com.jat.jatumba.data.entity.Track;

/**
 * Created by bulat on 22.02.16.
 */
public interface MainRouter {
    void openTracks();

    void openTrack(Track track);

    void openBands();

    void openBandMembers();
}
