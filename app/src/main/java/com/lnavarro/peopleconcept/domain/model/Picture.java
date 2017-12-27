package com.lnavarro.peopleconcept.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luis on 27/12/17.
 */

public class Picture implements Parcelable{

    private String large;

    protected Picture(Parcel in) {
        large = in.readString();
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(large);
    }
}
