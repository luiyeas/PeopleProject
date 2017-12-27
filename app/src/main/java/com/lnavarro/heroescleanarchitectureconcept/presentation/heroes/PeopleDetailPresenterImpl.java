package com.lnavarro.heroescleanarchitectureconcept.presentation.heroes;

import android.content.Context;

import com.lnavarro.heroescleanarchitectureconcept.app.navigator.Navigator;
import com.lnavarro.heroescleanarchitectureconcept.presentation.Presenter;

import javax.inject.Inject;


/**
 * Created by luis on 18/10/17.
 */

public class PeopleDetailPresenterImpl extends Presenter<PeopleDetailPresenterImpl.View> {

    private Navigator mNavigator;

    @Inject
    public PeopleDetailPresenterImpl(Context context, Navigator navigator) {
        super(context);
        this.mNavigator = navigator;
    }

    public void create() {
        mView.configureView();
    }

    public void destroy() {
    }

    public void onBackPressed() {
        mNavigator.navigateBackToListDetail();
    }


    public interface View extends Presenter.View {
        void configureView();
    }

}
