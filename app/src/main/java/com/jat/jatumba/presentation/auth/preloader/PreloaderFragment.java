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

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreloaderFragment extends BaseAuthFragment implements PreloaderView {
    @Inject
    PreloaderPresenter preloaderPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preloader, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inject();
        //noinspection unchecked
        getPresenter().setView(this);
    }

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
