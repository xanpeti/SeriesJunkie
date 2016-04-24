package com.example.paladin.seriesjunkie.presenter;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.interactor.SeriesInteractor;
import com.example.paladin.seriesjunkie.view.MainView;

import javax.inject.Inject;

/**
 * Created by PaLaDiN on 16/04/24.
 */
public class MainPresenter extends Presenter<MainView> {

    @Inject
    public SeriesInteractor interactor;

    public MainPresenter () {SJApplication.injector.inject(this);}

    public void doStuff(){view.showString(interactor.getString());}
}