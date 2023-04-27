package com.ronlu.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public class Data implements Parcelable {

    private String amount;
    private String date;

    public Data() {}


    public Data(String amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    protected Data(Parcel in) {
        amount = in.readString();
        date = in.readString();
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Data{" +
                "amount='" + amount + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(amount);
        dest.writeString(date);
    }
}
