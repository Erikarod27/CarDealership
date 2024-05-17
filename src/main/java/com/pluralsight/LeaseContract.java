package com.pluralsight;

public class LeaseContract extends Contract {
    private static final double LEASE_FEE_RATE = 0.07;
    private static final double LEASE_RATE = 0.04;
    private static final int LEASE_TERM = 36;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }

    @Override
    public double getTotalPrice() {
        double basePrice = getVehicle().getPrice();
        double endingValue = basePrice * 0.05;
        double leaseFee = basePrice * LEASE_FEE_RATE;
        double totalPrice = basePrice + leaseFee - endingValue;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = getTotalPrice();
        double monthlyPayment = (totalPrice * LEASE_RATE / (1 - Math.pow(1 + LEASE_RATE, -LEASE_TERM))) / LEASE_TERM;
        return monthlyPayment;
    }

}
