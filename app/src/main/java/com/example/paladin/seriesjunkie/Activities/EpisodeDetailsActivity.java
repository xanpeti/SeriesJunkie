package com.example.paladin.seriesjunkie.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.model.Episodes;
import com.example.paladin.seriesjunkie.model.Series;
import com.example.paladin.seriesjunkie.presenter.EpisodeDetailsPresenter;
import com.example.paladin.seriesjunkie.view.EpisodeDetailsView;

import javax.inject.Inject;

public class EpisodeDetailsActivity extends AppCompatActivity implements EpisodeDetailsView {



    private int episodeID = 0;
    @Inject
    EpisodeDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_details);

        SJApplication.injector.inject(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.action_refresh) {
            throw new RuntimeException(" 50 point to gryffindor");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
        episodeID = (int) (this.getIntent().getLongExtra("EPISODE_ID", 0));

        presenter.ShowEpisodeDetails(episodeID);
    }

    @Override
    public void ShowEpisodeDetails(Episodes episode) {
        TextView nametextview= (TextView) findViewById(R.id.Episode_serieName);
        TextView title= (TextView) findViewById(R.id.EpisodeDetailsTitle);
        TextView number= (TextView) findViewById(R.id.episodeDeteailsnumberView);
        TextView storytextview= (TextView) findViewById(R.id.Episode_storyTextView);
        episode.getNumber();
        episode.getTitle();
        episode.getStory();
        Series serie= presenter.interactor.getSerie(episode);

        nametextview.setText(serie.getName());
        number.setText(episode.getNumber()+".episode");
        title.setText(episode.getTitle());
        storytextview.setText(episode.getStory());


    }
}
