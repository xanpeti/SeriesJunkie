package com.example.paladin.seriesjunkie.model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PaLaDiN on 16/04/24.
 */
@Module
public class ModelModule {
    @Provides
    public SeriesModel getSeriesModel() {
        return new SeriesModel();
    }
}
