package com.example.paladin.seriesjunkie.presenter;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.interactor.SeriesInteractor;
import com.example.paladin.seriesjunkie.model.Series;
import com.example.paladin.seriesjunkie.view.MainView;

import javax.inject.Inject;

/**
 * Created by PaLaDiN on 16/04/24.
 */
public class MainPresenter extends Presenter<MainView> {

    @Inject
    public SeriesInteractor interactor;

    public MainPresenter () {SJApplication.injector.inject(this);}



    public void ShowSerieDetails(long serieid) {
        view.ShowSerieDetails(serieid);
    }


    public void  showSeries()
    {
        view.showSeries(interactor.getSeries());

    }

    public void deleteSerie(Series temp) {
        view.deleteSerie(interactor.deleteSerie(temp));

    }
}