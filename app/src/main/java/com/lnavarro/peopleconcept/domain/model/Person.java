package com.lnavarro.peopleconcept.domain.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by luis on 27/12/17.
 */

public class Person implements Parcelable{

    private Name name;

    private Location location;

    private Picture picture;

    private String phone;

    protected Person(Parcel in) {
        name = in.readParcelable(Name.class.getClassLoader());
        location = in.readParcelable(Location.class.getClassLoader());
        picture = in.readParcelable(Picture.class.getClassLoader());
        phone = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(name, flags);
        dest.writeParcelable(location, flags);
        dest.writeParcelable(picture, flags);
        dest.writeString(phone);
    }
}
