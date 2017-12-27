package com.lnavarro.peopleconcept.domain.model.server;

import com.google.gson.annotations.SerializedName;
import com.lnavarro.peopleconcept.domain.model.Person;

import java.util.ArrayList;

/**
 * Created by luis on 17/10/17.
 */

public class PeopleResponse {

    @SerializedName("results")
    private ArrayList<Person> peopleList;

    public ArrayList<Person> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(ArrayList<Person> peopleList) {
        this.peopleList = peopleList;
    }
}
