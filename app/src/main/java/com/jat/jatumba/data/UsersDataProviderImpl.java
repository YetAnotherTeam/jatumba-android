package com.jat.jatumba.data;


import com.jat.jatumba.domain.main.users.User;
import com.jat.jatumba.domain.main.users.UsersDataProvider;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class UsersDataProviderImpl implements UsersDataProvider {
    @Override
    public Observable<List<User>> getAllUsers() {
        List<User> result = new ArrayList<>();
        // TODO Заглушка для спика юзеров
        for (int i = 0; i < 1000; i++) {
            result.add(new User(i, "Имя" + i, "Фамилия" + i, "Профессия" + i));
        }
        return Observable.just(result);
    }
}
