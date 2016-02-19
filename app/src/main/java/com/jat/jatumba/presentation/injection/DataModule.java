package com.jat.jatumba.presentation.injection;

import com.jat.jatumba.data.UsersDataProviderImpl;
import com.jat.jatumba.data.TracksDataProviderImpl;
import com.jat.jatumba.data.retrofit.APIInterface;
import com.jat.jatumba.data.retrofit.APIModule;
import com.jat.jatumba.domain.main.tracks.MessagesDataProvider;
import com.jat.jatumba.domain.main.users.UsersDataProvider;

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

//    @Singleton
//    @Provides
//    public UsersDataProvider provideMarksDataProvider() {
//        return new UsersDataProviderImpl();
//    }

    @Singleton
    @Provides
    public APIInterface provideAPIInterface() {
        return APIModule.getAPIInterface();
    }
}
