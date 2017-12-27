package com.lnavarro.peopleconcept.domain.interactor;


import android.content.Context;


/**
 * Created by luis on 13/2/17.
 */
public abstract class AbstractInteractor implements Interactor {

    protected Context mContext;

    public AbstractInteractor( Context context) {
        mContext = context;
    }


}
