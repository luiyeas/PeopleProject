package com.lnavarro.peopleconcept.presentation.home;

import android.content.Context;
import android.widget.ImageView;

import com.lnavarro.peopleconcept.app.navigator.Navigator;
import com.lnavarro.peopleconcept.domain.model.Person;
import com.lnavarro.peopleconcept.presentation.Presenter;
import com.lnavarro.peopleconcept.domain.interactor.home.implementation.HomeInteractorImpl;

import java.util.ArrayList;

import javax.inject.Inject;


/**
 * Created by luis on 17/10/17.
 */

public class HomePresenterImpl extends Presenter<HomePresenterImpl.View> {

    private HomeInteractorImpl mInteractor;
    private Navigator mNavigator;

    @Inject
    public HomePresenterImpl(Context context, Navigator navigator, HomeInteractorImpl interactor) {
        super(context);
        this.mNavigator = navigator;
        this.mInteractor = interactor;
    }

    public void create() {
        mView.configureView(mInteractor.getPeople());
    }

    public void destroy() {
        mInteractor.destroy();
    }

    public void onHeroeSelected(Person person, ImageView image) {
        if (person != null) {
            mNavigator.navigateToHeroeDetailActivity(person, image);
        }
    }


    public interface View extends Presenter.View {
        void configureView(ArrayList<Person> list);
    }
}
