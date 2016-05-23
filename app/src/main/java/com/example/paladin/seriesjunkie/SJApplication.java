package com.example.paladin.seriesjunkie;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.example.paladin.seriesjunkie.view.ViewModule;
import com.orm.SugarApp;
import io.fabric.sdk.android.Fabric;

/**
 * Created by PaLaDiN on 16/04/24.
 */
public class SJApplication extends Application {

    public static  SJApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        injector= DaggerSJApplicationComponent.builder().viewModule(new ViewModule(this)).build();

    }
}
