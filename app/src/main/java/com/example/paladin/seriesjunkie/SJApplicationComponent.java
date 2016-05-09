package com.example.paladin.seriesjunkie;

import javax.inject.Singleton;

import dagger.Component;

import com.example.paladin.seriesjunkie.Activities.EpisodeDetailsActivity;
import com.example.paladin.seriesjunkie.Activities.NewEpisodeActivity;
import com.example.paladin.seriesjunkie.Activities.NewSeriesActivity;
import com.example.paladin.seriesjunkie.Activities.SerieDetailsActivity;
import com.example.paladin.seriesjunkie.interactor.EpisodesInteractor;
import com.example.paladin.seriesjunkie.interactor.InteractorModule;
import com.example.paladin.seriesjunkie.interactor.SeriesInteractor;
import com.example.paladin.seriesjunkie.model.ModelModule;
import com.example.paladin.seriesjunkie.presenter.EpisodeDetailsPresenter;
import com.example.paladin.seriesjunkie.presenter.MainPresenter;
import com.example.paladin.seriesjunkie.Activities.MainActivity;
import com.example.paladin.seriesjunkie.presenter.NewEpisodePresenter;
import com.example.paladin.seriesjunkie.presenter.NewSeriePresenter;
import com.example.paladin.seriesjunkie.presenter.SeriesDetailsPresenter;
import com.example.paladin.seriesjunkie.view.NewEpisodeView;
import com.example.paladin.seriesjunkie.view.ViewModule;


/**
 * Created by PaLaDiN on 16/04/24.
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class})
public interface SJApplicationComponent {

    //activities
    void inject(EpisodeDetailsActivity episodeDetailsActivity);
    void inject(MainActivity mainActivity);
    void inject(SerieDetailsActivity seriesDetailsActivity);
    void inject(NewEpisodeActivity newEpisodeActivity );
    void inject(NewSeriesActivity newSeriesActivity);


    // presenters
    void inject(MainPresenter mainPresenter);
    void inject(SeriesDetailsPresenter seriesDetailsPresenter);
    void inject(EpisodeDetailsPresenter episodeDetailsPresenter);
    void inject(NewSeriePresenter newSeriePresenter);
    void inject(NewEpisodePresenter NewEpisodePresenter);

    //interactors
    void inject(SeriesInteractor seriesInteractor);
    void inject(EpisodesInteractor episodesInteractor);
}
