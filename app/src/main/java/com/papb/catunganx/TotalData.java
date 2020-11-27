package com.papb.catunganx;

import android.os.Parcel;
import android.os.Parcelable;

public class TotalData implements Parcelable {
    protected TotalData(Parcel in) {
    }

    public static final Creator<TotalData> CREATOR = new Creator<TotalData>() {
        @Override
        public TotalData createFromParcel(Parcel in) {
            return new TotalData(in);
        }

        @Override
        public TotalData[] newArray(int size) {
            return new TotalData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
