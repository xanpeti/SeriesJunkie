package com.example.paladin.seriesjunkie.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.adapters.EpisodeAdapter;
import com.example.paladin.seriesjunkie.adapters.SeriesAdapter;
import com.example.paladin.seriesjunkie.model.Episodes;
import com.example.paladin.seriesjunkie.model.Series;
import com.example.paladin.seriesjunkie.presenter.EpisodeDetailsPresenter;
import com.example.paladin.seriesjunkie.presenter.SeriesDetailsPresenter;
import com.example.paladin.seriesjunkie.view.SeriesDetailsView;

import java.util.List;

import javax.inject.Inject;

public class SerieDetailsActivity extends AppCompatActivity implements SeriesDetailsView {

    private int serieID = 0;
    private long selectedep=0;

    @Inject
    SeriesDetailsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serie_details);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_add) {
            Intent intent = new Intent(SerieDetailsActivity.this, NewEpisodeActivity.class);
//        intent.putExtra(KEY_ARTIST,artistSearchTerm);
            startActivity(intent);
        }
        if (id == R.id.action_refresh) {
            Snackbar.make(this.findViewById(android.R.id.content), "Refreshing from server", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            presenter.ShowEpisodesOfSerie(serieID);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.attachView(this);
        serieID = (int) (this.getIntent().getLongExtra("SERIES_ID", 0))-1;

            presenter.ShowSerie(serieID);
            presenter.ShowEpisodesOfSerie(serieID);

    }





    @Override
    public void ShowSerie(Series serie) {
        TextView nametextview= (TextView) findViewById(R.id.serieName_textView);
        TextView typetextview= (TextView) findViewById(R.id.serie_type_textView);
        TextView storytextview= (TextView) findViewById(R.id.serie_story_textview);

        nametextview.setText(serie.getName());
        typetextview.setText(serie.getType());
        storytextview.setText(serie.getStory());
    }

    @Override
    public void ShowEpisodes(List<Episodes> episodes) {
        ListView episodelistview = (ListView)this.findViewById(R.id.Episode_listView);

        final EpisodeAdapter adapter= new EpisodeAdapter(this,R.layout.episode_row,episodes);

        episodelistview.setAdapter(adapter);


        episodelistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                presenter.ShowEpisodeDetails(adapter.getItem(position).getId());
            }

        });

    }

    @Override
    public void ShowEpisode(Episodes episode) {
        selectedep=episode.getId();
        Intent intent = new Intent(this, EpisodeDetailsActivity.class);
        intent.putExtra("EPISODE_ID", selectedep);
        startActivity(intent);
    }
}
