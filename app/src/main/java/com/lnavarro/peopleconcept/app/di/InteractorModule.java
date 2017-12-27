package com.lnavarro.peopleconcept.app.di;

import android.content.Context;

import com.lnavarro.peopleconcept.data.repository.PeopleRepository;
import com.lnavarro.peopleconcept.domain.executor.MainThreadExecutor;
import com.lnavarro.peopleconcept.domain.interactor.home.implementation.HomeInteractorImpl;
import com.lnavarro.peopleconcept.domain.interactor.splash.implementation.SplashInteractorImpl;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by luis on 1/11/17.
 */

@Module
public class InteractorModule {

    @Provides
    SplashInteractorImpl provideSplashInteractorImpl(Context context, PeopleRepository heroesRepository, MainThreadExecutor mainThreadExecutor, CompositeDisposable compositeDisposable) {
        return new SplashInteractorImpl(context, heroesRepository, mainThreadExecutor, compositeDisposable);
    }

    @Provides
    HomeInteractorImpl provideHomeInteractor(Context context, PeopleRepository heroesRepository) {
        return new HomeInteractorImpl(context, heroesRepository);
    }

}
