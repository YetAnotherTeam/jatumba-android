package com.jat.jatumba.presentation.main.tracks;

import com.jat.jatumba.data.entity.Track;
import com.jat.jatumba.presentation.main.common.BaseMainView;

import java.util.List;

/**
 * Created by bulat on 22.02.16.
 */
public interface TracksView extends BaseMainView {
    void setTracks(List<Track> tracks);
}
