package com.jat.jatumba.model;

import com.jat.jatumba.model.dataTransferObject.UserDTO;

import java.util.List;

import rx.Observable;

/**
 * Created by bulat on 12.02.16.
 */
public interface Model {
    Observable<List<UserDTO>> getGroupUserList(String name);
}
