package com.example.paladin.seriesjunkie.interactor;


import javax.inject.Inject;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.model.Series;
import com.orm.SugarRecord;


/**
 * Created by PaLaDiN on 16/04/24.
 */
public class SeriesInteractor {
    @Inject
    Series model;

    public SeriesInteractor() {
        SJApplication.injector.inject(this);
    }

    public String getString() {

        Series newser= new Series();
        newser.Name="sajtos guba";

        newser.save();

        return model.getName();
    }
}
