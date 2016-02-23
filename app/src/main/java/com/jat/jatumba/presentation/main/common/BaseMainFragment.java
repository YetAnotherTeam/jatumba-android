package com.jat.jatumba.presentation.main.common;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.util.Log;

import com.jat.jatumba.presentation.common.BaseFragment;
import com.jat.jatumba.presentation.injection.MainActivityComponent;
import com.jat.jatumba.presentation.main.MainActivity;

/**
 * Created by bulat on 22.02.16.
 */
public abstract class BaseMainFragment extends BaseFragment implements BaseMainView {
    private static final String LOG_TAG = "BaseMainFragment";

    public abstract String getTitle();

    @Override
    public void showError(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(@StringRes int stringId) {
        Snackbar.make(getView(), getResources().getString(stringId), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        MainActivity mainActivity = (MainActivity) getActivity();
        //noinspection unchecked
        getPresenter().setRouter(mainActivity);
        mainActivity.resolveToolbar(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //noinspection unchecked
        getPresenter().setRouter(null);
    }

    protected MainActivityComponent getMainActivityComponent() {
        return ((MainActivity) getActivity()).getMainActivityComponent();
    }
}
