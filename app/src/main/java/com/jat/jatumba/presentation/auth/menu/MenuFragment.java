package com.jat.jatumba.presentation.auth.menu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.common.BaseAuthFragment;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

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
        // TODO возможно ли переписать в VIPER стиль
        VKSdk.login(this, VKScope.EMAIL);
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                // Пользователь успешно авторизовался
                Log.d(LOG_TAG, "VKSdk.onActivityResult - onResult");
            }

            @Override
            public void onError(VKError error) {
                // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
                Log.d(LOG_TAG, "VKSdk.onActivityResult - onError");
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
