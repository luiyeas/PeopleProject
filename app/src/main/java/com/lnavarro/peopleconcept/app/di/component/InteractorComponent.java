package com.lnavarro.peopleconcept.app.di.component;

import com.lnavarro.peopleconcept.app.di.InteractorModule;

import dagger.Component;

/**
 * Created by luis on 1/11/17.
 */

@Component(modules = InteractorModule.class, dependencies = {RepositoryComponent.class})
public interface InteractorComponent {
}
