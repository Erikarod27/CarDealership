package com.pluralsight;

public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_UNDER_10000 = 295.00;
    private static final double PROCESSING_FEE_OVER_10000 = 495.00;
    private static final double LOAN_RATE_OVER_10000 = 0.0425;
    private static final double LOAN_RATE_UNDER_10000 = 0.0525;
    private static final int LOAN_TERM_OVER_10000 = 48;
    private static final int LOAN_TERM_UNDER_10000 = 24;
    private boolean financing;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financinng) {
        super(date, customerName, customerEmail, vehicle);
        this.financing = financinng;
    }

    public boolean isFinancing() {
        return financing;
    }
    public void setFinancing(boolean financing) {
        this.financing = financing;
    }

    @Override
    public double getTotalPrice() {
        double basePrice = getVehicle().getPrice();
        double salesTax = basePrice * SALES_TAX_RATE;
        double processingFee = basePrice < 10000 ? PROCESSING_FEE_UNDER_10000 : PROCESSING_FEE_OVER_10000;
        double totalPrice = basePrice + salesTax + RECORDING_FEE + processingFee;
        return totalPrice;
    }

    @Override
    public double getMonthlyPayment() {
        if (!financing) {
            return 0;
        }
        double basePrice = getVehicle().getPrice();
        double loanRate = basePrice < 10000 ? LOAN_RATE_UNDER_10000 : LOAN_RATE_OVER_10000;
        int loanTerm = basePrice < 10000 ? LOAN_TERM_UNDER_10000 : LOAN_TERM_OVER_10000;
        double loanAmount = getTotalPrice();
        double monthlyPayment = (loanAmount * loanRate) / (1 - Math.pow(1 + loanRate, -loanTerm)) / loanTerm;
        return monthlyPayment;
    }
}
