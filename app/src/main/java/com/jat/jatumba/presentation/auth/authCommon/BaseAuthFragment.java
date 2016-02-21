package com.jat.jatumba.presentation.auth.authCommon;


import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;

import com.jat.jatumba.presentation.common.BaseFragment;
import com.jat.jatumba.presentation.auth.AuthActivity;
import com.jat.jatumba.presentation.injection.AuthActivityComponent;

import javax.annotation.Resource;

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
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(int stringId) {
        Snackbar.make(getView(), getResources().getString(stringId), Snackbar.LENGTH_LONG).show();
    }

    protected AuthActivityComponent getAuthActivityComponent() {
        return ((AuthActivity)getActivity()).getAuthActivityComponent();
    }
}
