package com.jat.jatumba.presentation.main.tracks;

import android.support.annotation.NonNull;

import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.main.DrawerActivity;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

/**
 * Created by bulat on 22.02.16.
 */
public class TracksFragment extends BaseMainFragment implements TracksView {
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
