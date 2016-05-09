package com.example.paladin.seriesjunkie.presenter;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.interactor.EpisodesInteractor;
import com.example.paladin.seriesjunkie.interactor.SeriesInteractor;
import com.example.paladin.seriesjunkie.view.NewEpisodeView;
import com.example.paladin.seriesjunkie.view.NewSerieView;

import javax.inject.Inject;

/**
 * Created by PaLaDiN on 16/05/08.
 */
public class NewEpisodePresenter  extends Presenter<NewEpisodeView>  {

    @Inject
    public EpisodesInteractor interactor;

    public NewEpisodePresenter () {
        SJApplication.injector.inject(this);}
}
