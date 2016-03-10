package com.jat.jatumba.presentation.injection;

import com.jat.jatumba.presentation.main.bandMembers.BandMembersFragment;
import com.jat.jatumba.presentation.main.bands.BandsFragment;
import com.jat.jatumba.presentation.main.editor.EditorFragment;
import com.jat.jatumba.presentation.main.profile.ProfileFragment;
import com.jat.jatumba.presentation.main.compositions.CompositionsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DomainModule.class, DataModule.class})
public interface MainActivityComponent {
    void inject(BandMembersFragment bandMembersFragment);

    void inject(BandsFragment bandsFragment);

    void inject(ProfileFragment profileFragment);

    void inject(EditorFragment editorFragment);

    void inject(CompositionsFragment compositionsFragment);
}
