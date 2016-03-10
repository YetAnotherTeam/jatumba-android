package com.jat.jatumba.presentation.main.editor;

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
@Layout(id = R.layout.fragment_composition_editor)
public class EditorFragment extends BaseMainFragment implements EditorView {
    private static final String LOG_TAG = "EditorFragment";
    @Inject
    EditorPresenter editorPresenter;

    @Override
    public String getTitle() {
        return "Edit composition";
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return editorPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }
}
