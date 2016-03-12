package com.jat.jatumba.domain.auth.menu;

import com.jat.jatumba.data.network.LoginInterface;
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
    private final LoginInterface loginInterface;

    @Inject
    public SocialLoginInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                                 @Named(DomainModule.UI) Scheduler uiScheduler,
                                 LoginInterface loginInterface) {
        super(jobScheduler, uiScheduler);
        this.loginInterface = loginInterface;
    }

    @Override
    protected Observable<AuthResponse> buildObservable(SocialParams socialParams) {
        String accessToken = socialParams.getAccessToken();
        switch (socialParams.getNetworkName()) {
            case VK:
                return loginInterface.vkLogin(accessToken);
            case FB:
                return loginInterface.fbLogin(accessToken);
            default:
                throw new UnsupportedOperationException("Не реализовано для этой соцсети.");
        }

    }
}
