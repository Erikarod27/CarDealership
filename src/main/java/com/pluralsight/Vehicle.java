package com.pluralsight;

public class Vehicle {
    //Instance variables
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    //Vehicle constructor with parameters
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    //Getter for VIN
    public int getVin() {
        return vin;
    }

    //Setter for VIN
    public void setVin(int vin) {
        this.vin = vin;
    }

    //Getter for year
    public int getYear() {
        return year;
    }

    //Setter for year
    public void setYear(int year) {
        this.year = year;
    }

    //Getter for make
    public String getMake() {
        return make;
    }

    //Setter for make
    public void setMake(String make) {
        this.make = make;
    }

    //Getter for model
    public String getModel() {
        return model;
    }

    //Setter for model
    public void setModel(String model) {
        this.model = model;
    }

    //Getter for vehicle type
    public String getVehicleType() {
        return vehicleType;
    }

    //Setter for vehicle type
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    //Getter for color
    public String getColor() {
        return color;
    }

    //Setter for color
    public void setColor(String color) {
        this.color = color;
    }

    //Getter for odometer
    public int getOdometer() {
        return odometer;
    }

    //Setter for odometer
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    //Getter for price
    public double getPrice() {
        return price;
    }

    //Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    //Override toString for custom format
    @Override
    public String toString() {
        return "Vehicle | " +
                "Vin: " + vin +
                " | Year: " + year +
                " | Make: " + make  +
                " | Model: " + model +
                " | Vehicle: " + vehicleType +
                " | Color: " + color +
                " | Odometer: " + odometer +
                " | Price: " + price;
    }
}
