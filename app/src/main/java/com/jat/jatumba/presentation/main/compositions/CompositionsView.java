package com.jat.jatumba.presentation.main.compositions;

import com.jat.jatumba.data.entity.Composition;
import com.jat.jatumba.presentation.main.common.BaseMainView;

import java.util.List;

/**
 * Created by bulat on 22.02.16.
 */
public interface CompositionsView extends BaseMainView {
    void setCompositions(List<Composition> compositions);
}
