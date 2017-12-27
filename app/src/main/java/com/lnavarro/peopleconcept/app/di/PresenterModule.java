package com.lnavarro.peopleconcept.app.di;

import android.content.Context;

import com.lnavarro.peopleconcept.app.navigator.Navigator;
import com.lnavarro.peopleconcept.domain.interactor.home.implementation.HomeInteractorImpl;
import com.lnavarro.peopleconcept.domain.interactor.splash.implementation.SplashInteractorImpl;
import com.lnavarro.peopleconcept.presentation.heroes.PeopleDetailPresenterImpl;
import com.lnavarro.peopleconcept.presentation.home.HomePresenterImpl;
import com.lnavarro.peopleconcept.presentation.splash.SplashPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luis on 1/11/17.
 */
@Module
public class PresenterModule {

    @Provides
    SplashPresenterImpl provideLoginPresenter(Context context, SplashInteractorImpl interactor, Navigator navigator) {
        return new SplashPresenterImpl(context, interactor, navigator);
    }

    @Provides
    HomePresenterImpl provideHomePresenter(Context context, HomeInteractorImpl interactor, Navigator navigator) {
        return new HomePresenterImpl(context, navigator, interactor);
    }

    @Provides
    PeopleDetailPresenterImpl provideHeroeDetailPresenter(Context context, Navigator navigator) {
        return new PeopleDetailPresenterImpl(context, navigator);
    }
}
