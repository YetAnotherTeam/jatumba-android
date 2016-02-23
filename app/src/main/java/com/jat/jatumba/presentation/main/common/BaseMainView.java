package com.jat.jatumba.presentation.main.common;

import android.support.annotation.StringRes;

/**
 * Created by bulat on 22.02.16.
 */
public interface BaseMainView {
    void showError(String message);
    void showError(@StringRes int stringId);
}
