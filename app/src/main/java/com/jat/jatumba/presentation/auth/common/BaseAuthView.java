package com.jat.jatumba.presentation.auth.common;

import android.support.annotation.StringRes;

public interface BaseAuthView {
    void showError(String message);
    void showError(@StringRes int messageId);
}


