package com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.implementation;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.data.repository.PeopleRepository;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.AbstractInteractor;
import com.lnavarro.heroescleanarchitectureconcept.domain.model.Heroe;
import com.lnavarro.heroescleanarchitectureconcept.domain.interactor.home.HomeInteractor;

import java.util.ArrayList;

import javax.inject.Inject;


/**
 * Created by luis on 17/10/17.
 */

public class HomeInteractorImpl extends AbstractInteractor implements HomeInteractor {

    private PeopleRepository mHeroeRepository;

    @Inject
    public HomeInteractorImpl(Context context, PeopleRepository heroesRepository) {
        super(context);
        this.mHeroeRepository = heroesRepository;
    }

    @Override
    public void run() {

    }

    @Override
    public void removeCallbacks() {

    }

    @Override
    public void destroy() {

    }

    public ArrayList<Heroe> getHeroes(){
        return mHeroeRepository.getHeroes();
    }
}
