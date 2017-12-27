package com.lnavarro.heroescleanarchitectureconcept.app.di;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.data.repository.PeopleRepository;
import com.lnavarro.heroescleanarchitectureconcept.domain.rest.RetrofitAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by luis on 1/11/17.
 */
@Module
public class RepositoryModule {

    @Singleton
    @Provides
    PeopleRepository provideHeroesRepository(Context context, RetrofitAdapter retrofitAdapter) {
        return new PeopleRepository(context, retrofitAdapter);
    }
}
