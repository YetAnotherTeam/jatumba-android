package com.jat.jatumba.presentation.main.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;

import javax.inject.Inject;

/**
 * Created by bulat on 24.02.16.
 */
@Layout(id = R.layout.fragment_profile)
public class ProfileFragment extends BaseMainFragment implements ProfileView {
    private static final String LOG_TAG = "ProfileFragment";
    @Inject
    ProfilePresenter profilePresenter;

    @Override
    public String getTitle() {
        return "Profile";
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return profilePresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }
}
