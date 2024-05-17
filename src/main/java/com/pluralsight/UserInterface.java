package com.pluralsight;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    //UserInterface constructor
    public UserInterface() {
        init();
        display();
    }

    //Parameterless display method with void return type
    public void display() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Car Dealership Application =====");
            System.out.println("1. Get vehicles by price range");
            System.out.println("2. Get vehicles by make/model");
            System.out.println("3. Get vehicles by year range");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage range");
            System.out.println("6. Get vehicles by type");
            System.out.println("7. List all vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("10.Sell/Lease a vehicle");
            System.out.println("0. Quit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processGetAllVehiclesRequest();
                    break;
                case 8:
                    processAddVehicleRequest();
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    //Update later
                case 0:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //Parameterless init method with void return type
    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    //Display vehicles method with List of Vehicle objects as parameter and void return type
    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("===== Vehicles =====");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    //Parameterless get all vehicles method with void return type
    public void processGetAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
    }

    //Parameterless get by price method with void return type
    public void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter maximum price: ");
        double maxPrice = scanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }

    //Parameterless get by make/model method with void return type
    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter make: ");
        String make = scanner.nextLine();
        System.out.print("Enter model: ");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    //Parameterless get by year method with void return type
    public void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum year: ");
        int minYear = scanner.nextInt();
        System.out.print("Enter maximum year: ");
        int maxYear = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(vehicles);
    }

    //Parameterless get by color method with void return type
    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    //Parameterless get by mileage method with void return type
    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum mileage: ");
        int minMileage = scanner.nextInt();
        System.out.print("Enter maximum mileage: ");
        int maxMileage = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
        displayVehicles(vehicles);
    }

    //Parameterless get by vehicle type method with void return type
    public void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);
    }

    //Parameterless add vehicle method with void return type
    public void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter vehicle details:");
        System.out.print("VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Make: ");
        String make = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);

        dealership.addVehicle(newVehicle);

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
    }

    //Parameterless remove vehicle method with void return type
    public void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = scanner.nextInt();

        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);
            System.out.println("Vehicle removed successfully.");

            DealershipFileManager dealershipFileManager = new DealershipFileManager();
            dealershipFileManager.saveDealership(dealership);
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }

    public void processSellLeaseVehicleRequest(){
        
        }
    }
