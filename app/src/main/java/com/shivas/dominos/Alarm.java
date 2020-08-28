package com.shivas.dominos;

import android.icu.text.StringSearch;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Alarm implements Parcelable {
    String date = "";

    String time = "";

    protected Alarm(Parcel in) {
        date = in.readString();
        time = in.readString();
    }

    public static final Creator<Alarm> CREATOR = new Creator<Alarm>() {
        @Override
        public Alarm createFromParcel(Parcel in) {
            return new Alarm(in);
        }

        @Override
        public Alarm[] newArray(int size) {
            return new Alarm[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(date);
        parcel.writeString(time);
    }
}
