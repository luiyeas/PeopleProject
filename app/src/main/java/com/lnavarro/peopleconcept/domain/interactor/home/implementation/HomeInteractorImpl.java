package com.lnavarro.peopleconcept.domain.interactor.home.implementation;

import android.content.Context;

import com.lnavarro.peopleconcept.data.repository.PeopleRepository;
import com.lnavarro.peopleconcept.domain.interactor.AbstractInteractor;
import com.lnavarro.peopleconcept.domain.interactor.home.HomeInteractor;
import com.lnavarro.peopleconcept.domain.model.Person;

import java.util.ArrayList;

import javax.inject.Inject;


/**
 * Created by luis on 17/10/17.
 */

public class HomeInteractorImpl extends AbstractInteractor implements HomeInteractor {

    private PeopleRepository mPeopleRepository;

    @Inject
    public HomeInteractorImpl(Context context, PeopleRepository peopleRepository) {
        super(context);
        this.mPeopleRepository = peopleRepository;
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

    public ArrayList<Person> getPeople(){
        return mPeopleRepository.getPeople();
    }
}
