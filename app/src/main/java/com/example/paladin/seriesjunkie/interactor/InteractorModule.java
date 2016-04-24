package com.example.paladin.seriesjunkie.interactor;


import dagger.Module;
import dagger.Provides;
/**
 * Created by PaLaDiN on 16/04/24.
 */
@Module
public class InteractorModule {
    @Provides
    public SeriesInteractor getSeriesInteractor() {
        return new SeriesInteractor();
    }
}
