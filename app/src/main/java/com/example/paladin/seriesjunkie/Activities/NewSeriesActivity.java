package com.example.paladin.seriesjunkie.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.presenter.NewEpisodePresenter;
import com.example.paladin.seriesjunkie.presenter.NewSeriePresenter;
import com.example.paladin.seriesjunkie.view.NewEpisodeView;
import com.example.paladin.seriesjunkie.view.NewSerieView;

import javax.inject.Inject;

public class NewSeriesActivity extends AppCompatActivity implements NewSerieView {

    @Inject
    NewSeriePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_series);
        SJApplication.injector.inject(this);
    }
}
