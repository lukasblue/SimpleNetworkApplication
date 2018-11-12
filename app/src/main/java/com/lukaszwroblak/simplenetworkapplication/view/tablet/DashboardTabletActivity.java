package com.lukaszwroblak.simplenetworkapplication.view.tablet;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lukaszwroblak.simplenetworkapplication.R;
import com.lukaszwroblak.simplenetworkapplication.view.DashboardInterface;
import com.lukaszwroblak.simplenetworkapplication.view.DetailsFragment;
import com.lukaszwroblak.simplenetworkapplication.view.ListFragment;

import org.jetbrains.annotations.NotNull;

/**
 * Created by lukaszwroblak on 11.11.2018.
 */

public class DashboardTabletActivity extends AppCompatActivity implements DashboardInterface {

    private ListFragment fragmentList = new ListFragment();
    private DetailsFragment fragmentDetails = new DetailsFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_tablet);
        getSupportFragmentManager().beginTransaction().add(R.id.flList, fragmentList).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.flDetails, fragmentDetails).commit();
    }

    @Override
    public void showDetails(@NotNull String elementName) {
       fragmentDetails.setElement(elementName);
    }

    //QUICK FIX I've missed the point about orientation change on tablet, I probably should solve this in more suffisticated way
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        finish();
    }
}
