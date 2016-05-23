package com.example.paladin.seriesjunkie.interactor;


import javax.inject.Inject;

import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.model.SerieDB;
import com.example.paladin.seriesjunkie.model.Series;
import com.orm.SugarRecord;

import java.util.List;


/**
 * Created by PaLaDiN on 16/04/24.
 */
public class SeriesInteractor {
    @Inject
    SerieDB model;

    public SeriesInteractor() {
        SJApplication.injector.inject(this);
    }

    public void saveSerie(Series newseries) {
        model.addserie(newseries);
    }


    public Series getSerie(int serieID) {

        return model.getSerie(serieID);
    }
    public List<Series> getSeries(){
        return model.getAllseries();
    }


    public int deleteSerie(Series temp) {
        model.deleteSerie(temp);
                return 0;
    }
}
