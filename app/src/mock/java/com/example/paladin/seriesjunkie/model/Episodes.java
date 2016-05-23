package com.example.paladin.seriesjunkie.model;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by PaLaDiN on 16/04/25.
 */


public class Episodes {

    private Long id;

    public Long serieId;

    public int episodeNumber;

    public String episodedetails;

    public String EpisodeTitle;

    public Episodes(Long id, Long serieId, int episodeNumber,  String episodeTitle,String episodedetails) {
        this.id = id;
        this.serieId = serieId;
        this.episodeNumber = episodeNumber;
        this.episodedetails = episodedetails;
        EpisodeTitle = episodeTitle;
    }

    public Long getSerieId() {
        return serieId;
    }

    public Long getId() {
        return id;
    }
    public int getNumber() {
        return episodeNumber;
    }

    public String getTitle() {
        return EpisodeTitle;
    }


    public String getStory() {
        return episodedetails;
    }
}
