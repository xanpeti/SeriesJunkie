package com.example.paladin.seriesjunkie;

import javax.inject.Singleton;

import dagger.Component;
import com.example.paladin.seriesjunkie.interactor.InteractorModule;
import com.example.paladin.seriesjunkie.interactor.SeriesInteractor;
import com.example.paladin.seriesjunkie.model.ModelModule;
import com.example.paladin.seriesjunkie.presenter.MainPresenter;
import com.example.paladin.seriesjunkie.view.MainActivity;
import com.example.paladin.seriesjunkie.view.ViewModule;


/**
 * Created by PaLaDiN on 16/04/24.
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class})
public interface SJApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(SeriesInteractor seriesInteractor);

}
