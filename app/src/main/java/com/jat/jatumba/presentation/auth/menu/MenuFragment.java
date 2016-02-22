package com.jat.jatumba.presentation.auth.menu;

import android.support.annotation.NonNull;
import android.util.Log;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.common.BaseAuthFragment;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;

import javax.inject.Inject;

import butterknife.OnClick;

@Layout(id = R.layout.fragment_menu)
public class MenuFragment extends BaseAuthFragment implements MenuView {
    private static final String LOG_TAG = "MenuFragment";

    @Inject
    MenuPresenter menuPresenter;

    @OnClick(R.id.vk_button)
    public void onClickVkButton() {
        Log.d(LOG_TAG, "onClickVkButton");
    }

    @OnClick(R.id.ok_button)
    public void onClickOkButton() {
        Log.d(LOG_TAG, "onClickOkButton");
    }

    @OnClick(R.id.fb_button)
    public void onClickFbButton() {
        Log.d(LOG_TAG, "onClickFbButton");
    }

    @OnClick(R.id.email_button)
    public void onClickEmailButton() {
        Log.d(LOG_TAG, "onClickEmailButton");
        menuPresenter.openSignUp();
    }

    @OnClick(R.id.login_button)
    public void onClickLoginButton() {
        Log.d(LOG_TAG, "onClickLoginButton");
        menuPresenter.openLogin();
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return menuPresenter;
    }

    @Override
    protected void inject() {
        getAuthActivityComponent().inject(this);
    }
}
