package com.jat.jatumba.presentation.common;

import android.support.annotation.StringRes;

/**
 * Created by bulat on 27.02.16.
 */
public interface BaseView {
    void showError(@StringRes int stringId);
    void showError(String message);
}
