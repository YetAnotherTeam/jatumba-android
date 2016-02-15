package com.jat.jatumba.presentation.auth.authCommon;


import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;

import com.jat.jatumba.presentation.common.BaseFragment;
import com.jat.jatumba.presentation.auth.AuthActivity;
import com.jat.jatumba.presentation.injection.AuthActivityComponent;

public abstract class BaseAuthFragment extends BaseFragment implements BaseAuthView {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        AuthActivity authActivity = (AuthActivity) getActivity();
        //noinspection unchecked
        getPresenter().setRouter(authActivity);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //noinspection unchecked
        getPresenter().setRouter(null);
    }

    @Override
    public void showError(@StringRes int message) {
        Snackbar.make(getView(), getString(message), Snackbar.LENGTH_LONG).show();
    }

    protected AuthActivityComponent getMainActivityComponent() {
        return ((AuthActivity)getActivity()).getAuthActivityComponent();
    }
}
