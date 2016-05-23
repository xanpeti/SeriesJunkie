package com.example.paladin.seriesjunkie.view;

import com.example.paladin.seriesjunkie.model.Episodes;
import com.example.paladin.seriesjunkie.model.Series;

import java.util.List;

/**
 * Created by PaLaDiN on 16/04/25.
 */
public interface SeriesDetailsView {

    void ShowSerie(Series serie);

    void ShowEpisodes(List<Episodes> episodes);

    void ShowEpisode(Episodes episode);
}
