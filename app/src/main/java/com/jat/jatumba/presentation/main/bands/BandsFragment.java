package com.jat.jatumba.presentation.main.bands;

import android.support.annotation.NonNull;

import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.main.DrawerActivity;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

import javax.inject.Inject;

/**
 * Created by bulat on 22.02.16.
 */
public class BandsFragment extends BaseMainFragment implements BandsView {
    @Inject
    BandsPresenter bandsPresenter;

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
