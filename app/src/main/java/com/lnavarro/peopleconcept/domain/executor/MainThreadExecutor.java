package com.lnavarro.peopleconcept.domain.executor;

import android.os.Handler;

/**
 * Created by luis on 1/11/17.
 */

public class MainThreadExecutor {

    private Handler handler;

    public MainThreadExecutor(Handler handler){
        this.handler = handler;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
