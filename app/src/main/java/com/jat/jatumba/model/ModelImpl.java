package com.jat.jatumba.model;

import com.jat.jatumba.model.api.ApiInterface;
import com.jat.jatumba.model.api.ApiModule;
import com.jat.jatumba.model.dataTransferObject.UserDTO;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bulat on 12.02.16.
 */
public class ModelImpl implements Model {
    private final Observable.Transformer schedulersTransformer;
    private ApiInterface apiInterface = ApiModule.getApiInterface();

    public ModelImpl() {
        schedulersTransformer = o -> o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io());

    }
    @Override
    public Observable<List<UserDTO>> getGroupUserList(String name) {
        return null;
    }
}
