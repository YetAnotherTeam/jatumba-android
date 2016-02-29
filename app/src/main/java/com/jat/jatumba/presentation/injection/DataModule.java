package com.jat.jatumba.presentation.injection;

import com.jat.jatumba.data.BandsDataProviderImpl;
import com.jat.jatumba.data.TracksDataProviderImpl;
import com.jat.jatumba.data.network.APIInterface;
import com.jat.jatumba.data.network.APIModule;
import com.jat.jatumba.domain.main.bands.BandsDataProvider;
import com.jat.jatumba.domain.main.tracks.TracksDataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataModule {

    @Singleton
    @Provides
    public TracksDataProvider provideTracksDataProvider() {
        return new TracksDataProviderImpl();
    }

//    @Singleton
//    @Provides
//    public UsersDataProvider provideMarksDataProvider() {
//        return new UsersDataProviderImpl();
//    }

    @Singleton
    @Provides
    public BandsDataProvider provideBandsDataProvider() {
        return new BandsDataProviderImpl();
    }

    @Singleton
    @Provides
    public APIInterface provideAPIInterface() {
        return APIModule.getAPIInterface();
    }
}
