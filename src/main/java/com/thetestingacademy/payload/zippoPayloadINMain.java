package com.thetestingacademy.payload;

import java.util.List;

public class zippoPayloadINMain {
    private int postcode;
    private String country;
    private String countryAbb;
    private List<Place> places;

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbb() {
        return countryAbb;
    }

    public void setCountryAbb(String countryAbb) {
        this.countryAbb = countryAbb;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
