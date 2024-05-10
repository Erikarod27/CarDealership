package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DealershipFileManager {

    //Get dealership method with Dealership object return type
    public Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            String line;
            if ((line = br.readLine()) != null) {
                String[] dealershipData = line.split("\\|");
                String name = dealershipData[0];
                String address = dealershipData[1];
                String phone = dealershipData[2];
                dealership = new Dealership(name, address, phone);

                while ((line = br.readLine()) != null) {
                    String[] vehicleData = line.split("\\|");
                    int vin = Integer.parseInt(vehicleData[0]);
                    int year = Integer.parseInt(vehicleData[1]);
                    String make = vehicleData[2];
                    String model = vehicleData[3];
                    String vehicleType = vehicleData[4];
                    String color = vehicleData[5];
                    int odometer = Integer.parseInt(vehicleData[6]);
                    double price = Double.parseDouble(vehicleData[7]);
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealership;
    }

    //Save dealership method with Dealership object parameter and void return type
    public void saveDealership(Dealership dealership) {
        try (FileWriter fw = new FileWriter("src/main/resources/inventory.csv")) {
            fw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                fw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n"
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
