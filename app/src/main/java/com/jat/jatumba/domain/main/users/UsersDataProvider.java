package com.jat.jatumba.domain.main.users;


import java.util.List;

import rx.Observable;

public interface UsersDataProvider {
    Observable<List<User>> getAllUsers();
}
