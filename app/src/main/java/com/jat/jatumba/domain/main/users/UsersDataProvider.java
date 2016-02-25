package com.jat.jatumba.domain.main.users;


import com.jat.jatumba.data.entity.User;

import java.util.List;

import rx.Observable;

public interface UsersDataProvider {
    Observable<List<User>> getAllUsers();
    Observable<User> authUser();
}
