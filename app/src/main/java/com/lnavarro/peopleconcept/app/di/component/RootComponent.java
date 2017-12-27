package com.lnavarro.peopleconcept.app.di.component;

import com.lnavarro.peopleconcept.app.di.RootModule;
import com.lnavarro.peopleconcept.app.ui.people.activity.PeopleDetailActivity;
import com.lnavarro.peopleconcept.app.ui.home.activity.HomeActivity;
import com.lnavarro.peopleconcept.app.ui.splash.activity.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by luis on 1/11/17.
 */

@Singleton
@Component(modules = RootModule.class)
public interface RootComponent {
    void inject(SplashActivity activity);
    void inject(HomeActivity activity);
    void inject(PeopleDetailActivity activity);
}
