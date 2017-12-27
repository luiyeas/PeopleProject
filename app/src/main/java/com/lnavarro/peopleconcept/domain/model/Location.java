package com.lnavarro.peopleconcept.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luis on 27/12/17.
 */

public class Location implements Parcelable{

    private String city;

    protected Location(Parcel in) {
        city = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(city);
    }
}
