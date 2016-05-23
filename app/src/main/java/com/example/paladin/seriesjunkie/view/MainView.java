package com.example.paladin.seriesjunkie.view;

import com.example.paladin.seriesjunkie.model.Series;

import java.util.List;

import javax.inject.Inject;
/**
 * Created by PaLaDiN on 16/04/24.
 */
public interface MainView {

    void showSeries(List<Series> series);
    void ShowSerieDetails(long driverId);

    void deleteSerie(int aVoid);
}
