package com.example.ha.tube;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ha on 2019-10-29.
 */

public class Contents implements Parcelable{
    String s;
    boolean check;
    public Contents(String s) {
        this.s = s;
        this.check = false;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
