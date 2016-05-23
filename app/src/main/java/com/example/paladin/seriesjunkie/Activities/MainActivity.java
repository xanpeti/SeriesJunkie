package com.example.paladin.seriesjunkie.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.paladin.seriesjunkie.BuildConfig;
import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.adapters.SeriesAdapter;
import com.example.paladin.seriesjunkie.model.Series;
import com.example.paladin.seriesjunkie.presenter.MainPresenter;
import com.example.paladin.seriesjunkie.view.MainView;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

    private SeriesAdapter listAdapter;

    private long selectedseries=0;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if(BuildConfig.FLAVOR.equals("full")){
            SugarContext.init(this);
            System.out.println("sugar orm in");
        }else{
            System.out.println("mock version");

        }
        SJApplication.injector.inject(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Series temp=mainPresenter.interactor.getSerie((int)selectedseries);

               if(temp!=null)
                mainPresenter.deleteSerie(temp);

                Snackbar.make(view, "Delete Item", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

/*        findViewById(R.id.btnBtn).setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                mainPresenter.doStuff();
            }
        });*/



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
             Intent intent = new Intent(MainActivity.this, NewSeriesActivity.class);
//        intent.putExtra(KEY_ARTIST,artistSearchTerm);
            startActivity(intent);
        }
        if (id == R.id.action_refresh) {
            Snackbar.make(this.findViewById(android.R.id.content), "Refreshing from server", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            mainPresenter.showSeries();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
        mainPresenter.showSeries();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(BuildConfig.FLAVOR.equals("full")){
            SugarContext.terminate();
            System.out.println("sugar orm out");
        }else{
            System.out.println("mock version");

        }
        mainPresenter.detachView();
    }


    @Override
    public void showSeries(List<Series> series) {

        final ArrayList<Series> list = new ArrayList<>();
        for (int i = 0; i < series.size(); ++i) {
            list.add(series.get(i));
        }

        ListView seriesListView = (ListView)this.findViewById(R.id.series_listview);

        SeriesAdapter adapter= new SeriesAdapter(this,R.layout.serie_row,list);


        seriesListView.setAdapter(adapter);
        seriesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainPresenter.ShowSerieDetails(id);
            }

        });
    }

    @Override
    public void ShowSerieDetails(long serieid) {
        selectedseries=serieid;
        Intent intent = new Intent(this, SerieDetailsActivity.class);
        intent.putExtra("SERIES_ID", serieid);
        startActivity(intent);
    }

    @Override
    public void deleteSerie(int zero) {

        if(zero==0)
            mainPresenter.showSeries();
    }
}
