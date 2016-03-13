package com.jat.jatumba.presentation.main.compositionReader;

import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;

import com.jat.jatumba.R;
import com.jat.jatumba.data.entity.Composition;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

import javax.inject.Inject;

/**
 * Created by bulat on 26.02.16.
 */
@Layout(id = R.layout.fragment_composition_editor)
public class CompositionReaderFragment extends BaseMainFragment implements CompositionReaderView {
    private static final String LOG_TAG = "EditorFragment";
    @Inject
    CompositionReaderPresenter compositionReaderPresenter;

    public static CompositionReaderFragment newInstance(Composition composition) {
        return new CompositionReaderFragment();
    }

    @Override
    public String getTitle() {
        return "Read composition";
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return compositionReaderPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }
}
