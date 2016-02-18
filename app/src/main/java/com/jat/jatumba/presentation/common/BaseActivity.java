package com.jat.jatumba.presentation.common;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.google.common.base.Preconditions;
import com.jat.jatumba.R;
import com.jat.jatumba.presentation.auth.authCommon.BaseAuthFragment;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class)) return;
        Annotation annotation = cls.getAnnotation(Layout.class);
        Layout layout = (Layout) annotation;
        setContentView(layout.id());
        ButterKnife.bind(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    protected void addBackStack(BaseAuthFragment fragment) {
        addBackStack(fragment, true);
    }

    protected void addBackStack(BaseAuthFragment fragment, boolean addBackStack) {
        Preconditions.checkNotNull(fragment);
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content, fragment);
        if (addBackStack) {
            tx.addToBackStack(fragment.getFragmentName());
        }
        tx.commit();
    }
}
