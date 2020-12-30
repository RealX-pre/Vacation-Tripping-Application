package com.example.vacationtripapp.model;

public class TopPlacesData {

    String PlaceName;
    String countryName;
    Integer imageUrl;
    public Integer getImageUrl(){return imageUrl;}
    public void setImageUrl(Integer imageUrl){this.imageUrl = imageUrl;}
    public TopPlacesData(String placeName, String countryName, Integer imageUrl) {
        PlaceName = placeName;
        this.countryName = countryName;
        this.imageUrl = imageUrl;
    }

    public String getPlaceName() {
        return PlaceName;
    }

    public void setPlaceName(String placeName) {
        PlaceName = placeName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
