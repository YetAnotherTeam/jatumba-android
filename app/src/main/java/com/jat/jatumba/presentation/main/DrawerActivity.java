package com.jat.jatumba.presentation.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.StringRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.common.BaseActivity;
import com.jat.jatumba.presentation.common.BaseFragment;
import com.jat.jatumba.presentation.main.bands.BandsFragment;
import com.jat.jatumba.presentation.main.profile.ProfileFragment;
import com.jat.jatumba.presentation.main.tracks.TracksFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

import butterknife.Bind;

public abstract class DrawerActivity extends BaseActivity {
    private static final int NAVDRAWER_LAUNCH_DELAY = 258;

    private Drawer mDrawer;

    private Handler mHandler;

    private NavigationDrawerItem currentNavDrawerItem;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    public enum NavigationDrawerItem {
        TRACKS(R.drawable.ic_music_note_black_18dp, R.string.tracks),
        BANDS(R.drawable.ic_group_black_18dp, R.string.bands),
        PROFILE(R.drawable.ic_person_black_18dp, R.string.profile),
        SETTINGS(R.drawable.ic_settings_black_18dp, R.string.settings),
        DIVIDER(true),
        LOG_OUT(R.drawable.ic_exit_to_app_black_18dp, R.string.log_out);

        private int name;
        private int icon;
        private boolean isDivider = false;

        NavigationDrawerItem(int icon, @StringRes int name) {
            this.icon = icon;
            this.name = name;
        }

        NavigationDrawerItem(boolean isDivider) {
            this.isDivider = isDivider;
        }

        public int getName() {
            return name;
        }

        public int getIcon() {
            return icon;
        }

        public boolean isDivider() {
            return isDivider;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHandler = new Handler();
    }

    protected int getHomeAsUpIndicator() {
        return 0;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createDrawer();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        if (currentNavDrawerItem != null) {
            mDrawer.setSelection(
                    currentNavDrawerItem.ordinal(),
                    false
            );
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                if (getHomeAsUpIndicator() != 0) {
                    getSupportActionBar().setHomeAsUpIndicator(getHomeAsUpIndicator());
                }
            }
        }
    }

    /**
     * Build and set navigation drawer
     */
    private void createDrawer() {
        final AccountHeader header = new AccountHeaderBuilder()
                .withActivity(this)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("Username")
                                .withIcon(R.drawable.avatar)
                )
                .withHeaderBackground(R.drawable.header)
                .withAlternativeProfileHeaderSwitching(false)
                .withSelectionListEnabled(false)
                .build();

        ArrayList<IDrawerItem> items = new ArrayList<>();
        for (NavigationDrawerItem item : NavigationDrawerItem.values()) {
            if (item.isDivider()) {
                items.add(new DividerDrawerItem());
            } else {
                items.add(
                        new PrimaryDrawerItem()
                                .withName(getString(item.getName()))
                                .withIcon(item.getIcon())
                                .withIdentifier(item.ordinal())
                                .withIconTintingEnabled(true)
                );
            }
        }

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(header)
                .withDrawerItems(items)
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    onNavDrawerItemClicked(NavigationDrawerItem.values()[drawerItem.getIdentifier()]);
                    return true;
                })
                .withCloseOnClick(false)
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        closeKeyboard();
                    }

                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                    }
                })
                .withHeaderDivider(false)
                .build();
    }

    private void onNavDrawerItemClicked(final NavigationDrawerItem item) {
        mDrawer.closeDrawer();
        if (item == currentNavDrawerItem) {
            return;
        }
        // Launch the target Fragment after a short delay, to allow the close animation to play
        mHandler.postDelayed(() -> navigateTo(item), NAVDRAWER_LAUNCH_DELAY);
    }

    private void navigateTo(NavigationDrawerItem item) {
        currentNavDrawerItem = item;
        BaseFragment fragment;
        switch (item) {
            case TRACKS:
                fragment = new TracksFragment();
                break;
            case BANDS:
                fragment = new BandsFragment();
                break;
            case PROFILE:
                fragment = new ProfileFragment();
                break;
            case SETTINGS:
                //TODO поправить название фрагментов
                fragment = new BandsFragment();
                break;
            case LOG_OUT:
                fragment = new BandsFragment();
                break;
            default:
                return;
        }
        replaceToFragment(fragment, false);
    }

    /**
     * Closes keyboard.
     * Used to close keyboard, when drawer opens
     */
    private void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }
}
