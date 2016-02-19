package com.jat.jatumba.presentation.auth.preloader;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.authCommon.BaseAuthFragment;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
@Layout(id = R.layout.fragment_preloader)
public class PreloaderFragment extends BaseAuthFragment implements PreloaderView {
    @Inject
    PreloaderPresenter preloaderPresenter;

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return preloaderPresenter;
    }

    @Override
    protected void inject() {
        getAuthActivityComponent().inject(this);
    }
}
