package com.jat.jatumba.presentation.main;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.jat.jatumba.R;
import com.jat.jatumba.presentation.common.BaseActivity;
import com.jat.jatumba.presentation.common.BaseFragment;
import com.jat.jatumba.presentation.main.bands.BandsFragment;
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
        TRACKS(R.drawable.ic_music_note_black_18dp, R.string.tracks, new TracksFragment()),
        BANDS(R.drawable.ic_group_black_18dp, R.string.bands, new BandsFragment());

        private int name;
        private int icon;
        private BaseFragment fragment;
        private boolean isDivider = false;

        NavigationDrawerItem(int icon, int name, BaseFragment fragment) {
            this.icon = icon;
            this.name = name;
            this.fragment = fragment;
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

        public BaseFragment getFragment() {
            return fragment;
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

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        // If current navigation drawer presents,
        // init navigation drawer
        if (currentNavDrawerItem != null) {
            createDrawer();
            mDrawer.setSelection(
                    currentNavDrawerItem.ordinal(),
                    false
            );
        } else {
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

        this.mDrawer = new DrawerBuilder()
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

    /**
     * Set badge to navigation drawer item
     *
     * @param item navigation drawer item
     * @param text badge text
     */
    protected void setBadge(NavigationDrawerItem item, String text) {
        try {
            PrimaryDrawerItem drawerItem = (PrimaryDrawerItem) mDrawer.getDrawerItem(item.ordinal());
            drawerItem.withBadge(text);
            mDrawer.updateItem(drawerItem);
        } catch (ClassCastException e) {
            e.printStackTrace();
            Log.e("DrawerBaseActivity", "Navigation drawer item must be primary drawer item");
        }
    }

    /**
     * Called when user taps on navigation drawer item
     *
     * @param item current navigation drawer item
     */
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
        replaceToFragment(item.getFragment(), false);
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
