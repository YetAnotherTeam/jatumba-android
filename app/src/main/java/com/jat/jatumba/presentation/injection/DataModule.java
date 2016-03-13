package com.jat.jatumba.presentation.injection;

import com.jat.jatumba.data.BandsDataProviderImpl;
import com.jat.jatumba.data.CompositionsDataProviderImpl;
import com.jat.jatumba.data.network.service.APIInterface;
import com.jat.jatumba.data.network.service.APIModule;
import com.jat.jatumba.data.network.service.AuthInterface;
import com.jat.jatumba.data.network.service.AuthModule;
import com.jat.jatumba.domain.main.bands.BandsDataProvider;
import com.jat.jatumba.domain.main.compositions.CompositionsDataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataModule {

    @Singleton
    @Provides
    public CompositionsDataProvider provideCompositionsDataProvider() {
        return new CompositionsDataProviderImpl();
    }

    @Singleton
    @Provides
    public BandsDataProvider provideBandsDataProvider() {
        return new BandsDataProviderImpl();
    }

    @Singleton
    @Provides
    public AuthInterface provideAuthInterface() {
        return AuthModule.getAuthInterface();
    }

    @Singleton
    @Provides
    public APIInterface provideAPIInterface() {
        return APIModule.getAPIInterface();
    }
}
