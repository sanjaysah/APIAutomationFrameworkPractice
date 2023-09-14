package com.thetestingacademy.payload;

public class Place {
    private String placeName;
    private double longitude;
    private String state;
    private String stateAbb;
    private double latitude;

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbb() {
        return stateAbb;
    }

    public void setStateAbb(String stateAbb) {
        this.stateAbb = stateAbb;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
