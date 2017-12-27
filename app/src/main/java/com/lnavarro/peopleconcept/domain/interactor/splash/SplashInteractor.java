package com.lnavarro.peopleconcept.domain.interactor.splash;

import com.lnavarro.peopleconcept.domain.interactor.Interactor;

/**
 * Created by luis on 17/10/17.
 */

public interface SplashInteractor extends Interactor {
    interface Callback {
        void onPeopleSuccessfull();
        void onPeopleError();
    }
}
