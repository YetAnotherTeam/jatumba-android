package com.jat.jatumba.domain.main.users;


import com.jat.jatumba.data.model.User;

import java.util.List;

import rx.Observable;

public interface UsersDataProvider {
    Observable<List<User>> getAllUsers();
    Observable<User> authUser();
}
