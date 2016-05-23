package com.example.paladin.seriesjunkie.interactor;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.model.EpisodeDB;
import com.example.paladin.seriesjunkie.model.Episodes;
import com.example.paladin.seriesjunkie.model.SerieDB;
import com.example.paladin.seriesjunkie.model.Series;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by PaLaDiN on 16/04/25.
 */
public class EpisodesInteractor {

    @Inject
    EpisodeDB model;

    @Inject
    SerieDB smodel;

    public EpisodesInteractor() {
        SJApplication.injector.inject(this);
    }

    public List<Episodes> getEpisodes(int serieID) {
        return model.getEpisodes(serieID);
    }

    public Episodes getEpisode(long id) {
        return model.getEpisode(id);
    }

    public Series getSerie(Episodes episode) {

        return smodel.getSerie(episode);
    }
}
