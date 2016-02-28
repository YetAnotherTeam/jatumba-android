package com.jat.jatumba.presentation.main.trackEditor;

import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

import javax.inject.Inject;

/**
 * Created by bulat on 26.02.16.
 */
@Layout(id = R.layout.fragment_track_editor)
public class TrackEditorFragment extends BaseMainFragment implements TrackEditorView {
    private static final String LOG_TAG = "TrackEditorFragment";
    @Inject
    TrackEditorPresenter trackEditorPresenter;

    @Override
    public String getTitle() {
        return "Edit track";
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return trackEditorPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }
}
