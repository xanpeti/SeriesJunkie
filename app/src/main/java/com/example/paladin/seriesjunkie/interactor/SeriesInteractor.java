package com.example.paladin.seriesjunkie.interactor;


import javax.inject.Inject;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.model.SeriesModel;


/**
 * Created by PaLaDiN on 16/04/24.
 */
public class SeriesInteractor {
    @Inject
    SeriesModel model;

    public SeriesInteractor() {
        SJApplication.injector.inject(this);
    }

    public String getString() {
        return model.getNextSeries();
    }
}
