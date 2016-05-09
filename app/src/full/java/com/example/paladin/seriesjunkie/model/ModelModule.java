package com.example.paladin.seriesjunkie.model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by PaLaDiN on 16/04/24.
 */
@Module
public class ModelModule {
    @Provides
    public Series getSeriesModel() {
        return new Series();
    }
    @Provides
    public Episodes getEpisodesModel (){return new Episodes();}
}
