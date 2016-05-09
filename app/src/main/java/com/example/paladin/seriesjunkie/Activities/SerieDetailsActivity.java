package com.example.paladin.seriesjunkie.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.presenter.EpisodeDetailsPresenter;
import com.example.paladin.seriesjunkie.presenter.SeriesDetailsPresenter;
import com.example.paladin.seriesjunkie.view.SeriesDetailsView;

import javax.inject.Inject;

public class SerieDetailsActivity extends AppCompatActivity implements SeriesDetailsView {

    @Inject
    SeriesDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_details);
        SJApplication.injector.inject(this);
    }
}
