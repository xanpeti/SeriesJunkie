package com.example.paladin.seriesjunkie.model;

/**
 * Created by PaLaDiN on 16/04/24.
 */
public class SeriesModel {

    private int seriesid= 0;

    private String[] series= {"Arrow","legends of tomorrow",
            "Adventures of Superman","Alphas"};


    public String getNextSeries(){

            if(seriesid==series.length)
            {
                seriesid=0;

            }

            return series[seriesid++];
    }


}
