package com.lnavarro.peopleconcept.presentation.splash;

import android.content.Context;
import android.widget.Toast;

import com.lnavarro.peopleconcept.R;
import com.lnavarro.peopleconcept.app.navigator.Navigator;
import com.lnavarro.peopleconcept.presentation.Presenter;
import com.lnavarro.peopleconcept.domain.interactor.splash.SplashInteractor;
import com.lnavarro.peopleconcept.domain.interactor.splash.implementation.SplashInteractorImpl;

import javax.inject.Inject;


/**
 * Created by luis on 17/10/17.
 */

public class SplashPresenterImpl extends Presenter<SplashPresenterImpl.View> implements SplashInteractor.Callback {

    private Context mContext;
    private SplashInteractorImpl mInteractor;
    private Navigator mNavigator;

    @Inject
    public SplashPresenterImpl(Context context, SplashInteractorImpl interactor, Navigator navigator) {
        super(context);
        this.mContext = context;
        this.mInteractor = interactor;
        this.mNavigator = navigator;
    }

    public void create() {
        mInteractor.addCallback(this);
        mInteractor.run();
    }

    public void destroy() {
        mInteractor.removeCallbacks();
        mInteractor.destroy();
    }

    @Override
    public void onPeopleSuccessfull() {
        mNavigator.navigateToHomeActivity();
    }

    @Override
    public void onPeopleError() {
        Toast.makeText(mContext, mContext.getString(R.string.generic_error_text), Toast.LENGTH_SHORT).show();
    }

    public interface View extends Presenter.View {

    }
}
