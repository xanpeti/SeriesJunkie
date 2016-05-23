package com.example.paladin.seriesjunkie.Activities;

import android.content.Intent;
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

    private static int RESULT_LOAD_IMAGE = 1;

    @Inject
    NewSeriePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_series);


        SJApplication.injector.inject(this);
    }

    @Override
    public void saveSerie() {

    }

    @Override
    public void browseSerieImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, RESULT_LOAD_IMAGE);
    }
}
