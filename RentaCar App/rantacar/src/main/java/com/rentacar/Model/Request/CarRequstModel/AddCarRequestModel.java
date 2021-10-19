package com.rentacar.Model.Request.CarRequstModel;

import java.util.UUID;

public class AddCarRequestModel {
    private UUID id;
    private String licencePlate, make, model, color, size, fuel, image;
    private int year, engineCapacity, doors, power;
    private double price;
    private boolean automatic;

    public AddCarRequestModel(String licencePlate, String make, String model,
                              int year, int engineCapacity, String color,
                              double price, int doors,
                              String size, int power, boolean automatic,
                              String fuel, String image) {
        this.id = UUID.randomUUID();
        this.licencePlate = licencePlate;
        this.make = make;
        this.model = model;
        this.color = color;
        this.size = size;
        this.fuel = fuel;
        this.image = image;
        this.year = year;
        this.engineCapacity = engineCapacity;
        this.doors = doors;
        this.power = power;
        this.price = price;
        this.automatic = automatic;
    }

    public UUID getId() {
        return id;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getFuel() {
        return fuel;
    }

    public String getImage() {
        return image;
    }

    public int getYear() {
        return year;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public int getDoors() {
        return doors;
    }

    public int getPower() {
        return power;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAutomatic() {
        return automatic;
    }

}
