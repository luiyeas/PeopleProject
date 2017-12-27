package com.lnavarro.peopleconcept.data.repository;

import android.content.Context;
import android.support.annotation.NonNull;

import com.lnavarro.peopleconcept.domain.model.Person;
import com.lnavarro.peopleconcept.domain.rest.RetrofitAdapter;
import com.lnavarro.peopleconcept.domain.Api;
import com.lnavarro.peopleconcept.domain.model.server.PeopleResponse;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by luis on 17/10/17.
 */
@Singleton
public class PeopleRepository {

    @NonNull
    private PeopleRepositoryService service;

    private ArrayList<Person> mListPeople;

    @Inject
    public PeopleRepository(Context context, RetrofitAdapter rAdapter) {
        this.service = rAdapter.getAdapter().create(PeopleRepositoryService.class);
    }

    public PeopleRepositoryService getService() {
        return this.service;
    }

    public interface PeopleRepositoryService {
        @Headers({"Accept: application/json"})
        @GET(Api.ENDPOINT.PEOPLE)
        Single<Response<PeopleResponse>> getPeople(@Query("results") String results);
    }

    public void setPeople(ArrayList<Person> listPeople) {
        this.mListPeople = listPeople;
    }

    public ArrayList<Person> getPeople() {
        return mListPeople;
    }
}
