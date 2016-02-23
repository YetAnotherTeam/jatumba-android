package com.jat.jatumba.presentation.common;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.facebook.appevents.AppEventsLogger;
import com.google.common.base.Preconditions;
import com.jat.jatumba.R;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class)) {
            return;
        }
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
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onBackPressed() {
        if (!getFragmentManager().popBackStackImmediate()) {
            supportFinishAfterTransition();
        }
    }

    protected void replaceToFragment(BaseFragment fragment) {
        replaceToFragment(fragment, true);
    }

    protected void replaceToFragment(BaseFragment fragment, boolean addToBackStack) {
        Preconditions.checkNotNull(fragment);
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.content, fragment);
        if (addToBackStack) {
            tx.addToBackStack(fragment.getFragmentName());
        }
        tx.commit();
    }
}
