package com.example.paladin.seriesjunkie.presenter;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.interactor.SeriesInteractor;
import com.example.paladin.seriesjunkie.model.Series;
import com.example.paladin.seriesjunkie.view.NewSerieView;
import com.example.paladin.seriesjunkie.view.SeriesDetailsView;

import javax.inject.Inject;

/**
 * Created by PaLaDiN on 16/05/08.
 */
public class NewSeriePresenter  extends Presenter<NewSerieView>  {

    @Inject
    public SeriesInteractor interactor;

    public NewSeriePresenter () {
        SJApplication.injector.inject(this);}

    public void saveSerie(String teamName, String teamLeader, String serieImage) {

        Series newseries = new Series();


        interactor.saveSerie(newseries);
        view.saveSerie();
    }



    public void browseTeamImage() {
        view.browseSerieImage();
    }
}
