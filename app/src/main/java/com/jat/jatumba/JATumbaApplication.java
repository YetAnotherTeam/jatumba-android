package com.jat.jatumba;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.vk.sdk.VKSdk;

/**
 * Created by bulat on 22.02.16.
 */
public class JATumbaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(getApplicationContext());
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
