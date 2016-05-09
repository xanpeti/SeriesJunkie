package com.example.paladin.seriesjunkie.interactor;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.model.Episodes;
import com.example.paladin.seriesjunkie.model.Series;

import javax.inject.Inject;

/**
 * Created by PaLaDiN on 16/04/25.
 */
public class EpisodesInteractor {

    @Inject
    Episodes model;

    public EpisodesInteractor() {
        SJApplication.injector.inject(this);
    }
}
