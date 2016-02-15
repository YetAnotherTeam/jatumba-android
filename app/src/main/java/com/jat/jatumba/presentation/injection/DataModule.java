package com.jat.jatumba.presentation.injection;

import com.jat.jatumba.data.UsersDataProviderImpl;
import com.jat.jatumba.data.TracksDataProviderImpl;
import com.jat.jatumba.domain.users.UsersDataProvider;
import com.jat.jatumba.domain.tracks.MessagesDataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataModule {

    @Singleton
    @Provides
    public MessagesDataProvider provideNotesDataProvider() {
        return new TracksDataProviderImpl();
    }

    @Singleton
    @Provides
    public UsersDataProvider provideMarksDataProvider() {
        return new UsersDataProviderImpl();
    }
}
