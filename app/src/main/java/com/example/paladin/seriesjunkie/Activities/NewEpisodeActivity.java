package com.example.paladin.seriesjunkie.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.presenter.EpisodeDetailsPresenter;
import com.example.paladin.seriesjunkie.presenter.NewEpisodePresenter;
import com.example.paladin.seriesjunkie.view.NewEpisodeView;

import javax.inject.Inject;

public class NewEpisodeActivity extends AppCompatActivity implements NewEpisodeView {

    @Inject
    NewEpisodePresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_episode);
        SJApplication.injector.inject(this);
    }
}
