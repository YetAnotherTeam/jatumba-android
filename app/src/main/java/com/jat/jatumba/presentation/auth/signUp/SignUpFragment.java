package com.jat.jatumba.presentation.auth.signUp;

import android.support.annotation.NonNull;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.authCommon.BaseAuthFragment;
import com.jat.jatumba.presentation.common.BasePresenter;
import com.jat.jatumba.presentation.common.Layout;

import javax.inject.Inject;

@Layout(id = R.layout.fragment_sign_up)
public class SignUpFragment extends BaseAuthFragment implements SignUpView {
    private static final String LOG_TAG = "SignUpFragment";

    @Inject
    SignUpPresenter signUpPresenter;

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return signUpPresenter;
    }

    @Override
    protected void inject() {
        getAuthActivityComponent().inject(this);
    }
}
