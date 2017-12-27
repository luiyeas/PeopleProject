package com.lnavarro.peopleconcept.app.ui.people.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnavarro.peopleconcept.R;
import com.lnavarro.peopleconcept.app.base.PeopleApplication;
import com.lnavarro.peopleconcept.app.ui.GenericActivity;
import com.lnavarro.peopleconcept.domain.model.Person;
import com.lnavarro.peopleconcept.presentation.heroes.PeopleDetailPresenterImpl;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by luis on 18/10/17.
 */

public class PeopleDetailActivity extends GenericActivity implements PeopleDetailPresenterImpl.View{

    public static final String PERSON_EXTRA = "person_extra";

    Unbinder mUnbinder;

    @Inject
    PeopleDetailPresenterImpl mPresenter;
    private Person mPerson;


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_image)
    ImageView mImageToolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.app_bar_layout)
    AppBarLayout mAppbarLayout;
    @BindView(R.id.name_text_view)
    TextView mNameTextView;
    @BindView(R.id.location_text_view)
    TextView mLocationTextView;
    @BindView(R.id.phone_textview)
    TextView mPhoneTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroe_detail);

        mUnbinder = ButterKnife.bind(this);

        initializeDagger();
        initActivityTransitions();
        ViewCompat.setTransitionName(mAppbarLayout, PERSON_EXTRA);
        supportPostponeEnterTransition();
        initializePresenter();

        mPerson = getPersonFromExtras();
        mPresenter.create();
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

        mPresenter.destroy();
        mUnbinder.unbind();
    }

    private void initializeDagger() {
        PeopleApplication app = (PeopleApplication) getApplication();
        app.getMainComponent().inject(this);
    }

    private void initializePresenter() {
        mPresenter.setView(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        mPresenter.onBackPressed();
    }

    private Person getPersonFromExtras() {
        return getIntent().getExtras().getParcelable(PERSON_EXTRA);
    }

    public void configureView() {

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mCollapsingToolbarLayout.setTitle(mPerson.getName().getFirst() + " " + mPerson.getName().getLast());

        Picasso.with(this).load(mPerson.getPicture().getLarge()).into(mImageToolbar, new Callback() {
            @Override
            public void onSuccess() {
                Bitmap bitmap = ((BitmapDrawable) mImageToolbar.getDrawable()).getBitmap();
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette palette) {
                        applyPalette(palette);
                    }
                });
            }

            @Override
            public void onError() {

            }
        });

        mNameTextView.setText(mPerson.getName().getFirst() + " " + mPerson.getName().getLast());
        mLocationTextView.setText(mPerson.getLocation().getCity());
        mPhoneTextView.setText(mPerson.getPhone());
    }


    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    private void applyPalette(Palette palette) {
        int primaryDark = getResources().getColor(R.color.colorPrimaryDark);
        int primary = getResources().getColor(R.color.colorPrimary);
        mCollapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
        mCollapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
        supportStartPostponedEnterTransition();
    }

}
