package com.lnavarro.peopleconcept.app.di.component;

import com.lnavarro.peopleconcept.app.di.PresenterModule;

import dagger.Component;

/**
 * Created by luis on 1/11/17.
 */
@Component(modules = PresenterModule.class, dependencies = {InteractorComponent.class})
public interface PresenterComponent {
}
