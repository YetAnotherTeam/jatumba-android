package com.jat.jatumba.presentation.common;

import android.support.annotation.StringRes;

/**
 * Created by bulat on 27.02.16.
 */
public interface BaseView {
    void showSnackMessage(@StringRes int stringId);
    void showSnackMessage(String message);
}
