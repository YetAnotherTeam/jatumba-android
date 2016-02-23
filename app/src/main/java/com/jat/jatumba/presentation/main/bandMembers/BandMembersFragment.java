package com.jat.jatumba.presentation.main.bandMembers;

import android.support.annotation.NonNull;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.main.DrawerActivity;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

import javax.inject.Inject;

/**
 * Created by bulat on 22.02.16.
 */
public class BandMembersFragment extends BaseMainFragment implements BandMembersView {
    @Inject
    BandMembersPresenter bandMembersPresenter;

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return bandMembersPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }

    @Override
    public String getTitle() {
        return getString(R.string.band_members);
    }
}
