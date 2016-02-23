package com.jat.jatumba.presentation.main.tracks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

import javax.inject.Inject;

/**
 * Created by bulat on 22.02.16.
 */
@Layout(id = R.layout.fragment_tracks)
public class TracksFragment extends BaseMainFragment implements TracksView {
    private static final String LOG_TAG = "TracksFragment";
    @Inject
    TracksPresenter tracksPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
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
}
