package com.example.paladin.seriesjunkie.presenter;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.interactor.EpisodesInteractor;
import com.example.paladin.seriesjunkie.view.EpisodeDetailsView;


import javax.inject.Inject;

/**
 * Created by PaLaDiN on 16/05/08.
 */
public class EpisodeDetailsPresenter  extends Presenter<EpisodeDetailsView> {

    @Inject
   public EpisodesInteractor interactor;

    public EpisodeDetailsPresenter () {SJApplication.injector.inject(this);}
}
