package com.example.paladin.seriesjunkie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PaLaDiN on 2016. 05. 23..
 */
public class SerieDB {

    private static List<Series> series=new ArrayList<Series>();


    public SerieDB() {

        if(series.size()==0) {
            series.add(new Series(1l, "Scifi", 8.8000000f, null, "1 series story", "1.serie"));
            series.add(new Series(2l, "Scifi", 8.8000000f, null, "2 series story", "2.serie"));
            series.add(new Series(3l, "Scifi", 8.80000000f, null, "3 series story", "3.serie"));
            series.add(new Series(4l, "Scifi", 8.800000000f, null, "4 series story", "4.serie"));
            series.add(new Series(5l, "Scifi", 8.8000000f, null, "5 series story", "5.serie"));
            series.add(new Series(6l, "Scifi", 8.80000f, null, "6 series story", "6.serie"));
            series.add(new Series(7l, "Scifi", 8.8f, null, "7 series story", "7.serie"));
        }
    }

    public List<Series> getAllseries() {

        return series ;
    }

    public void addserie(Series newseries) {
        series.add(newseries);
    }


    public void removeSerie(Series deleteserie) {
        series.remove(deleteserie);
    }

    public Series getSerie(int serieID) {

        if( serieID> series.size())
            return null;

        return series.get(serieID);
    }
    public void deleteSerie(Series temp) {
        series.remove(temp);
    }


    public Series getSerie(Episodes episode) {

        for (Series se:series) {
            if(se.getId()==episode.getId())
                return se;
        }
        return null;
    }
}