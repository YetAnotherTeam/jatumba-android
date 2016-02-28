package com.jat.jatumba.data;


import com.jat.jatumba.data.retrofit.APIInterface;
import com.jat.jatumba.data.entity.User;
import com.jat.jatumba.domain.main.users.UsersDataProvider;
import com.jat.jatumba.presentation.injection.DomainModule;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;

public class UsersDataProviderImpl implements UsersDataProvider {
    private Observable.Transformer schedulersTransformer;

    public UsersDataProviderImpl(@Named(DomainModule.JOB) Scheduler jobScheduler,
                                 @Named(DomainModule.UI) Scheduler uiScheduler) {
        //.inject(this);
        schedulersTransformer = o -> ((Observable) o).subscribeOn(jobScheduler)
                .observeOn(uiScheduler)
                .unsubscribeOn(jobScheduler);
    }

    @Inject
    protected APIInterface apiInterface;

    @Override
    public Observable<List<User>> getAllUsers() {
        List<User> result = new ArrayList<>();
        // TODO Заглушка для спика юзеров
        for (int i = 0; i < 1000; i++) {
            result.add(new User(i, "Имя" + i, "Фамилия" + i, "Профессия" + i));
        }
        return Observable.just(result);
    }

    @Override
    public Observable<User> authUser() {
        return apiInterface
                .login("", "")
                .compose(applySchedulers());
    }

    private <T> Observable.Transformer<T, T> applySchedulers() {
        return (Observable.Transformer<T, T>) schedulersTransformer;
    }

}
