package com.jat.jatumba.presentation.main.bands;

import android.support.annotation.NonNull;
import android.util.Log;

import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

import javax.inject.Inject;

/**
 * Created by bulat on 22.02.16.
 */
public class BandsFragment extends BaseMainFragment implements BandsView {
    private static final String LOG_TAG = "BandsFragment";
    @Inject
    BandsPresenter bandsPresenter;

    public BandsFragment() {
        Log.d(LOG_TAG, "Constructor");
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return bandsPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public String getTitle() {
        return null;
    }
}
