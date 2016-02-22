package com.jat.jatumba.presentation.main.bands;

import android.support.annotation.NonNull;

import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.main.DrawerActivity;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

/**
 * Created by bulat on 22.02.16.
 */
public class BandsFragment extends BaseMainFragment implements BandsView {
    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    protected void inject() {

    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public DrawerActivity.NavigationDrawerItem getCurrentNavDrawerItem() {
        return null;
    }
}
