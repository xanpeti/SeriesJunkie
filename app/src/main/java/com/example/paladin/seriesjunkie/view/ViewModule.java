package com.example.paladin.seriesjunkie.view;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.example.paladin.seriesjunkie.presenter.MainPresenter;

/**
 * Created by PaLaDiN on 16/04/24.
 */
@Module
public class ViewModule {

    private Context context;

    public ViewModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter getMainPresenter() {
        return new MainPresenter();
    }
}
