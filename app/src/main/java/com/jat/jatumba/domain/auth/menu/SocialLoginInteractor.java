package com.jat.jatumba.domain.auth.menu;

import com.jat.jatumba.data.network.APIInterface;
import com.jat.jatumba.data.network.response.AuthResponse;
import com.jat.jatumba.domain.common.Interactor;
import com.jat.jatumba.presentation.auth.menu.mapper.SocialParams;
import com.jat.jatumba.presentation.injection.DomainModule;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by bulat on 18.02.16.
 */
public class SocialLoginInteractor extends Interactor<AuthResponse, SocialParams> {
    private final APIInterface apiInterface;

    @Inject
    public SocialLoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                                 @Named(DomainModule.UI) Scheduler uiScheduler,
                                 APIInterface apiInterface) {
        super(jobScheduler, uiScheduler);
        this.apiInterface = apiInterface;
    }

    @Override
    protected Observable<AuthResponse> buildObservable(SocialParams socialParams) {
        String accessToken = socialParams.getAccessToken();
        switch (socialParams.getNetworkName()) {
            case VK:
                return apiInterface.vkLogin(accessToken);
            case FB:
                return apiInterface.fbLogin(accessToken);
            default:
                throw new UnsupportedOperationException("Не реализовано для этой соцсети.");
        }

    }
}
