package com.jat.jatumba.presentation.main.tracks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.jat.jatumba.R;
import com.jat.jatumba.data.entity.Track;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by bulat on 22.02.16.
 */
@Layout(id = R.layout.fragment_tracks)
public class TracksFragment extends BaseMainFragment implements TracksView {
    private static final String LOG_TAG = "TracksFragment";
    @Inject
    TracksPresenter tracksPresenter;

    @Bind(R.id.tracks_recycler_view)
    RecyclerView recyclerView;

    public TracksFragment() {
        Log.d(LOG_TAG, "Constructor");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return tracksPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public String getTitle() {
        return getString(R.string.tracks);
    }

    public void setTracks(List<Track> tracks) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        TracksAdapter tracksAdapter = new TracksAdapter(tracks);
        tracksAdapter.setOnItemClickListener(view -> tracksPresenter.trackSelected((Track) view.getTag()));
        recyclerView.setAdapter(tracksAdapter);
    }
}
