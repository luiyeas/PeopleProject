package com.lnavarro.peopleconcept.app.ui.home.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.lnavarro.peopleconcept.R;
import com.lnavarro.peopleconcept.app.base.PeopleApplication;
import com.lnavarro.peopleconcept.app.ui.GenericActivity;
import com.lnavarro.peopleconcept.domain.model.Person;
import com.lnavarro.peopleconcept.presentation.home.HomePresenterImpl;
import com.lnavarro.peopleconcept.app.ui.people.adapter.PeopleAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by luis on 17/10/17.
 */

public class HomeActivity extends GenericActivity implements HomePresenterImpl.View {

    Unbinder mUnbinder;

    @Inject
    HomePresenterImpl mPresenter;

    private PeopleAdapter mAdapter;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDagger();
        setContentView(R.layout.activity_home);
        initializePresenter();
        mUnbinder = ButterKnife.bind(this);
        mPresenter.create();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.destroy();
        mUnbinder.unbind();
    }


    private void initializeDagger() {
        PeopleApplication app = (PeopleApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        mPresenter.setView(this);
    }

    @Override
    public void configureView(ArrayList<Person> listPeople) {
        mToolbar.setTitle(getString(R.string.home_activity_title));
        setSupportActionBar(mToolbar);

        LinearLayoutManager llManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mAdapter = new PeopleAdapter(this, listPeople);
        mRecyclerView.setLayoutManager(llManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new PeopleAdapter.HeroesListener() {
            @Override
            public void onHeroeSelected(Person person, ImageView image) {
                mPresenter.onHeroeSelected(person, image);
            }
        });
    }
}
