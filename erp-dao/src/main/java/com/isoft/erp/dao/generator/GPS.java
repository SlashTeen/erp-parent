package com.isoft.erp.dao.generator;

/**
 * Created by dell on 2017/4/26.
 */
public class GPS {
    private double latitude;
    private double longitude;

    @Override
    public String toString() {
        return "GPS{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
