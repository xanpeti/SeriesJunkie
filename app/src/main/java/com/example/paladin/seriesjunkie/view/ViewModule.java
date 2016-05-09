package com.example.paladin.seriesjunkie.view;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.example.paladin.seriesjunkie.Activities.EpisodeDetailsActivity;
import com.example.paladin.seriesjunkie.presenter.EpisodeDetailsPresenter;
import com.example.paladin.seriesjunkie.presenter.MainPresenter;
import com.example.paladin.seriesjunkie.presenter.NewEpisodePresenter;
import com.example.paladin.seriesjunkie.presenter.NewSeriePresenter;
import com.example.paladin.seriesjunkie.presenter.SeriesDetailsPresenter;

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

    @Provides
    @Singleton
    public EpisodeDetailsPresenter episodeDetailsPresenter() {
        return new EpisodeDetailsPresenter();
    }

    @Provides
    @Singleton
    public SeriesDetailsPresenter getSeriesDetailsPresenter() {
        return new SeriesDetailsPresenter();
    }


    @Provides
    @Singleton
    public NewSeriePresenter getNewSeriePresenter() {
        return new NewSeriePresenter();
    }

    @Provides
    @Singleton
    public NewEpisodePresenter getNewEpisodePresenter() {
        return new NewEpisodePresenter();
    }



}
