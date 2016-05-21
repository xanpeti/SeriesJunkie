package com.example.paladin.seriesjunkie.Activities;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.paladin.seriesjunkie.BuildConfig;
import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.SJApplication;
import com.example.paladin.seriesjunkie.presenter.MainPresenter;
import com.example.paladin.seriesjunkie.view.MainView;
import com.orm.SugarContext;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView {

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
            Snackbar.make(this.findViewById(android.R.id.content)
                    , "navigation", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        if (id == R.id.action_refresh) {
            Snackbar.make(this.findViewById(android.R.id.content), "Refreshing from server", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
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
    public void showString(String s) {
        ((TextView)findViewById(R.id.tvPrint)).setText(s);
    }
}
