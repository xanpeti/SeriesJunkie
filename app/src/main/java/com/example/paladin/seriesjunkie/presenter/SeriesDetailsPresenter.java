package com.example.paladin.seriesjunkie.presenter;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.interactor.SeriesInteractor;
import com.example.paladin.seriesjunkie.view.MainView;
import com.example.paladin.seriesjunkie.view.SeriesDetailsView;

import javax.inject.Inject;

/**
 * Created by PaLaDiN on 16/04/25.
 */
public class SeriesDetailsPresenter extends Presenter<SeriesDetailsView> {

    @Inject
    public SeriesInteractor interactor;

    public SeriesDetailsPresenter () {
        SJApplication.injector.inject(this);}

}
