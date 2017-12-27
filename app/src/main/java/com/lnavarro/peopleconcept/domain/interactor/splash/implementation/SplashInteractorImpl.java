package com.lnavarro.peopleconcept.domain.interactor.splash.implementation;

import android.content.Context;

import com.lnavarro.peopleconcept.data.repository.PeopleRepository;
import com.lnavarro.peopleconcept.domain.executor.MainThreadExecutor;
import com.lnavarro.peopleconcept.domain.interactor.AbstractInteractor;
import com.lnavarro.peopleconcept.domain.model.server.PeopleResponse;
import com.lnavarro.peopleconcept.domain.interactor.splash.SplashInteractor;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * Created by luis on 17/10/17.
 */

public class SplashInteractorImpl extends AbstractInteractor implements SplashInteractor {

    private String MAX_RESULTS = "20";

    private SplashInteractor.Callback mCallback;
    private CompositeDisposable mCompositeDisposable;
    private PeopleRepository mPeopleRepository;
    private MainThreadExecutor mMainThreadExecutor;

    @Inject
    public SplashInteractorImpl(Context context, PeopleRepository repository, MainThreadExecutor mainThreadExecutor, CompositeDisposable compositeDisposable) {
        super(context);
        this.mCompositeDisposable = compositeDisposable;
        this.mPeopleRepository = repository;
        this.mMainThreadExecutor = mainThreadExecutor;
    }

    @Override
    public void run() {
        requestPeople();
    }

    @Override
    public void removeCallbacks() {
        this.mCallback = null;
    }

    @Override
    public void destroy() {
        mCompositeDisposable.clear();
    }

    public void addCallback(SplashInteractor.Callback callback) {
        this.mCallback = callback;
    }

    private void requestPeople() {
        mCompositeDisposable.add(
                mPeopleRepository
                        .getService()
                        .getPeople(MAX_RESULTS)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Response<PeopleResponse>>() {
                            @Override
                            public void accept(@NonNull Response<PeopleResponse> peopleResponse) throws Exception {
                                processResponse(peopleResponse);
                            }
                        }));

    }

    private void processResponse(Response<PeopleResponse> response) {
        if (response != null && response.body() != null && response.body().getPeopleList() != null) {
            mPeopleRepository.setPeople(response.body().getPeopleList());
            postPeopleReceived();
        } else {
            postError();
        }
    }

    private void postError() {
        if (mMainThreadExecutor.getHandler() != null && mCallback != null) {
            mMainThreadExecutor.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onPeopleError();
                }
            });
        }
    }

    private void postPeopleReceived() {
        if (mMainThreadExecutor.getHandler() != null && mCallback != null) {
            mMainThreadExecutor.getHandler().post(new Runnable() {
                @Override
                public void run() {
                    mCallback.onPeopleSuccessfull();
                }
            });
        }
    }
}
