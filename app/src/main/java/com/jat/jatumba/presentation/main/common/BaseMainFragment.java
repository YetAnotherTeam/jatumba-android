package com.jat.jatumba.presentation.main.common;

import com.jat.jatumba.presentation.common.BaseFragment;
import com.jat.jatumba.presentation.main.DrawerActivity;

/**
 * Created by bulat on 22.02.16.
 */
public abstract class BaseMainFragment extends BaseFragment implements BaseMainView {
    /**
     * @return current navigation drawer item,
     * which would be displayed as selected
     */
    public abstract String getTitle();
    public abstract DrawerActivity.NavigationDrawerItem getCurrentNavDrawerItem();
}
