package com.jat.jatumba.presentation.main;

import com.jat.jatumba.data.entity.Composition;

/**
 * Created by bulat on 22.02.16.
 */
public interface MainRouter {
    void openCompositions();

    void openComposition(Composition composition);

    void openBands();

    void openBandMembers();
}
