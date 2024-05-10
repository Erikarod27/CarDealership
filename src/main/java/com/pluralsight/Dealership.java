package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    //Instance variables
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    //Dealership constructor with parameters
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    //Get vehicle price method with min and max price parameters and List of Vehicles object return type
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //Get vehicles by make/model with make and model parameters and List of Vehicle objects return type
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //Get vehicles by year method with min and max year parameters and List of Vehicle objects return type
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //Get vehicles by color method with color parameters and List of Vehicle objects return type
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //Get vehicles by mileage method with min and max mileage parameters and List of Vehicle objects return type
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //Get vehicles by type method with vehicle type parameter and List of Vehicle objects return type
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    //Parameterless get all vehicles method with List of Vehicle objects return type
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    //Add vehicle method with Vehicle object parameter and void return type
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    //Remove vehicle method with Vehicle object parameter and void return type
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    //Getter for name
    public String getName() {
        return name;
    }

    //Setter for name
    public void setName(String name) {
        this.name = name;
    }

    //Getter for address
    public String getAddress() {
        return address;
    }

    //Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    //Getter for phone
    public String getPhone() {
        return phone;
    }

    //Setter for phone
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
