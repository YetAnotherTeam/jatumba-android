package com.jat.jatumba.presentation.common;

import android.support.annotation.StringRes;

/**
 * Created by bulat on 27.02.16.
 */
public interface BaseView {
    void showSnack(@StringRes int stringId);
    void showSnack(String message);
}
