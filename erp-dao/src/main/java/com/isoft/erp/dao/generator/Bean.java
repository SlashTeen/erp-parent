package com.isoft.erp.dao.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/4/26.
 */
public class Bean {
    private double maxLatitude;
    private double maxLongitude;
    private double minLatitude;
    private double minLongitude;

    @Override
    public String toString() {
        return "Bean{" +
                "maxLatitude=" + maxLatitude +
                ", maxLongitude=" + maxLongitude +
                ", minLatitude=" + minLatitude +
                ", minLongitude=" + minLongitude +
                ", gps=" + gps +
                '}';
    }

    List<GPS> gps=new ArrayList<GPS>();

    public double getMaxLatitude() {
        return maxLatitude;
    }

    public void setMaxLatitude(double maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    public double getMaxLongitude() {
        return maxLongitude;
    }

    public void setMaxLongitude(double maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    public double getMinLatitude() {
        return minLatitude;
    }

    public void setMinLatitude(double minLatitude) {
        this.minLatitude = minLatitude;
    }

    public double getMinLongitude() {
        return minLongitude;
    }

    public void setMinLongitude(double minLongitude) {
        this.minLongitude = minLongitude;
    }

    public List<GPS> getGps() {
        return gps;
    }

    public void setGps(List<GPS> gps) {
        this.gps = gps;
    }
}
