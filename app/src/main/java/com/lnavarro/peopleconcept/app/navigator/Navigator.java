package com.lnavarro.peopleconcept.app.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.widget.ImageView;

import com.lnavarro.peopleconcept.R;
import com.lnavarro.peopleconcept.app.ui.people.activity.PeopleDetailActivity;
import com.lnavarro.peopleconcept.app.ui.home.activity.HomeActivity;
import com.lnavarro.peopleconcept.domain.model.Person;

import static com.lnavarro.peopleconcept.app.ui.people.activity.PeopleDetailActivity.PERSON_EXTRA;

/**
 * Created by luis on 17/10/17.
 */

public class Navigator {

    private Activity mActivity;

    public Navigator() {

    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void navigateToHomeActivity() {
        if (mActivity != null) {
            Intent intent = new Intent(mActivity, HomeActivity.class);
            mActivity.startActivity(intent);
            mActivity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            mActivity.finish();
        }
    }

    public void navigateToHeroeDetailActivity(Person person, ImageView imageView) {
        if (mActivity != null) {
            Intent intent = new Intent(mActivity, PeopleDetailActivity.class);
            intent.putExtra(PERSON_EXTRA, person);

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity, imageView, PERSON_EXTRA);
            ActivityCompat.startActivity(mActivity, intent, options.toBundle());
        }
    }

    public void navigateBackToListDetail() {
        if (mActivity != null) {
            finishCurrentActivity();
        }
    }

    private void finishCurrentActivity() {
        mActivity.finish();
    }

}
