package com.example.paladin.seriesjunkie;

import android.app.Application;

import com.example.paladin.seriesjunkie.view.ViewModule;

/**
 * Created by PaLaDiN on 16/04/24.
 */
public class SJApplication extends Application {

    public static  SJApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector= DaggerSJApplicationComponent.builder().viewModule(new ViewModule(this)).build();
    }
}
