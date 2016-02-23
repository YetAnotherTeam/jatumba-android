package com.jat.jatumba.presentation.main;

import android.os.Bundle;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.common.BaseActivity;
import com.jat.jatumba.presentation.common.Layout;
import com.jat.jatumba.presentation.injection.DaggerMainActivityComponent;
import com.jat.jatumba.presentation.injection.DataModule;
import com.jat.jatumba.presentation.injection.DomainModule;
import com.jat.jatumba.presentation.injection.MainActivityComponent;
import com.jat.jatumba.presentation.main.common.BaseMainFragment;
import com.jat.jatumba.presentation.main.tracks.TracksFragment;

/**
 * Created by bulat on 22.02.16.
 */
@Layout(id = R.layout.activity_main)
public class MainActivity extends BaseActivity implements MainRouter {
    private MainActivityComponent mainActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityComponent =
                DaggerMainActivityComponent
                        .builder()
                        .dataModule(new DataModule())
                        .domainModule(new DomainModule())
                        .build();
        if (getFragmentManager().getBackStackEntryCount() == 0) {
           openTracks();
        }
    }

    public void resolveToolbar(BaseMainFragment fragment) {
//        toolbar.setTitle(fragment.getTitle());
//        if (getFragmentManager().getBackStackEntryCount() > 0) {
//            toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
//            toolbar.setNavigationOnClickListener(v -> onBackPressed());
//        } else {
//            toolbar.setNavigationIcon(null);
//            toolbar.setNavigationOnClickListener(null);
//        }
    }

    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }

    @Override
    public void openTracks() {
        replaceToFragment(new TracksFragment(), false);
    }
}
