package com.lnavarro.peopleconcept.app.ui.splash.activity;

import android.os.Bundle;

import com.lnavarro.peopleconcept.R;
import com.lnavarro.peopleconcept.app.base.PeopleApplication;
import com.lnavarro.peopleconcept.app.ui.GenericActivity;
import com.lnavarro.peopleconcept.presentation.splash.SplashPresenterImpl;

import javax.inject.Inject;


public class SplashActivity extends GenericActivity implements SplashPresenterImpl.View{

    @Inject
    SplashPresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        setContentView(R.layout.activity_splash);
        initializePresenter();
        mPresenter.create();
    }


    private void initializeDagger() {
        PeopleApplication app = (PeopleApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        mPresenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }
}
