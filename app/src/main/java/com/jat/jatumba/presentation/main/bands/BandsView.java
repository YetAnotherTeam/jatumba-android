package com.jat.jatumba.presentation.main.bands;

import com.jat.jatumba.data.entity.Band;
import com.jat.jatumba.presentation.main.common.BaseMainView;

import java.util.List;

/**
 * Created by bulat on 22.02.16.
 */
public interface BandsView extends BaseMainView {
    void setBands(List<Band> bands);
}
