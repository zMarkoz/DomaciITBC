package com.rentacar.Model.Response;

public class SearchCarModel {
    private String make, model;
    private Integer year, power, doors;
    private Double price;
    private Boolean automatic;

    public SearchCarModel(String make, String model, Integer year, Integer power,
                          Integer doors, Double price, Boolean automatic) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.power = power;
        this.doors = doors;
        this.price = price;
        this.automatic = automatic;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getDoors() {
        return doors;
    }

    public Double getPrice() {
        return price;
    }

    public Boolean getAutomatic() {
        return automatic;
    }
}

