package com.example.paladin.seriesjunkie.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.presenter.EpisodeDetailsPresenter;
import com.example.paladin.seriesjunkie.view.EpisodeDetailsView;

import javax.inject.Inject;

public class EpisodeDetailsActivity extends AppCompatActivity implements EpisodeDetailsView {

    @Inject
    EpisodeDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_details);

        SJApplication.injector.inject(this);
    }
}
