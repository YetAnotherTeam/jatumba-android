package com.jat.jatumba.presentation.common.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.jat.jatumba.R;

public class MainActivity extends DrawerActivity {

    @Override
    public NavigationDrawerItem getCurrentNavDrawerItem() {
        return NavigationDrawerItem.COMPOSITIONS;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

}
