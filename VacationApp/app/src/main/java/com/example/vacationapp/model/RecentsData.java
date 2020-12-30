package com.example.vacationapp.model;

public class RecentsData {

    String PlaceName;
    String countryName;
    String price;
    Integer imageUrl;
    public Integer getImageUrl(){return imageUrl;}
    public void setImageUrl(Integer imageUrl){this.imageUrl = imageUrl;}
    public RecentsData(String placeName, String countryName, String price , Integer imageUrl) {
        PlaceName = placeName;
        this.countryName = countryName;
        this.price = price;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
