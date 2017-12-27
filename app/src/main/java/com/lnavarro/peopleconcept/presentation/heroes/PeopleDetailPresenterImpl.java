package com.lnavarro.peopleconcept.presentation.heroes;

import android.content.Context;

import com.lnavarro.peopleconcept.app.navigator.Navigator;
import com.lnavarro.peopleconcept.presentation.Presenter;

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
