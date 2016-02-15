package com.jat.jatumba.presentation.common.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jat.jatumba.presentation.common.BasePresenter;

/**
 * Created by bulat on 12.02.16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected BasePresenter presenter;

    private BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }
}
