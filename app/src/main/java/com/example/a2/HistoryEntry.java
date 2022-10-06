package com.example.a2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

class HistoryEntry implements Parcelable {
    private final String name;
    private final int quantity;
    private final double price;
    private final Date date;

    public HistoryEntry(String n, int q, double p, Date d) {
        name = n;
        quantity = q;
        price = p;
        date = d;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getPrice() {
        return price;
    }
    public Date getDate() {
        return date;
    }

    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeInt(quantity);
        out.writeDouble(price);
        out.writeLong(date.getTime());
    }
    public static final Parcelable.Creator<HistoryEntry> CREATOR
            = new Parcelable.Creator<HistoryEntry>() {
        public HistoryEntry createFromParcel(Parcel in) {
            return new HistoryEntry(in);
        }
        public HistoryEntry[] newArray(int size) {
            return new HistoryEntry[size];
        }
    };
    private HistoryEntry(Parcel in) {
        name = in.readString();
        quantity = in.readInt();
        price = in.readDouble();
        date = new Date(in.readLong());
    }
}
