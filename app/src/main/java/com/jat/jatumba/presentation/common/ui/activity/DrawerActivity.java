package com.jat.jatumba.presentation.common.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.jat.jatumba.R;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import java.util.ArrayList;

public abstract class DrawerActivity extends BaseActivity {
    private static final int NAVDRAWER_LAUNCH_DELAY = 258;

    private Drawer mDrawer;
    private Handler mHandler;

    public enum NavigationDrawerItem {
        COMPOSITIONS(R.drawable.ic_music_note_black_18dp, R.string.compositions, MainActivity.class),
        GROUP(R.drawable.ic_group_black_18dp, R.string.group, MainActivity.class);

        private int name;
        private int icon;
        private Class<? extends Activity> activity;
        private boolean isDivider = false;

        NavigationDrawerItem(int icon, int name, Class<? extends Activity> activity) {
            this.icon = icon;
            this.name = name;
            this.activity = activity;
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

        public Class<? extends Activity> getActivity() {
            return activity;
        }

        public boolean isDivider() {
            return isDivider;
        }
    }

    protected Toolbar toolbar;

    /**
     * @return current navigation drawer item,
     * which would be displayed as selected
     */
    public abstract NavigationDrawerItem getCurrentNavDrawerItem();

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

        this.toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(this.toolbar);
        }

        // If current navigation drawer presents,
        // init navigation drawer
        if (getCurrentNavDrawerItem() != null) {
            createDrawer();
            mDrawer.setSelection(
                    getCurrentNavDrawerItem().ordinal(),
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
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        Intent intent = new Intent(DrawerActivity.this, MainActivity.class);
                        startActivity(intent);
                        return true;
                    }
                })
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
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        onNavDrawerItemClicked(NavigationDrawerItem.values()[drawerItem.getIdentifier()]);
                        return true;
                    }
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

        if (item == getCurrentNavDrawerItem()) {
            return;
        }

        // Launch the target Activity after a short delay, to allow the close animation to play
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigateTo(item);
            }
        }, NAVDRAWER_LAUNCH_DELAY);
    }

    /**
     * Opens appropriate activity
     *
     * @param item navigation drawer item
     */
    private void navigateTo(NavigationDrawerItem item) {
        Intent intent = new Intent();
        intent.setClass(this, item.getActivity());

        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Disable activity animation
        overridePendingTransition(0, 0);
        finish();
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
