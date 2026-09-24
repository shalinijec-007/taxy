package com.taxy.dto;

public class TaxHistoryResponse {

    private Long id;
    private double income;
    private double tax;
    private double moneyLeft;
    private int age;

    public TaxHistoryResponse(Long id, double income, double tax,
                              double moneyLeft, int age) {
        this.id = id;
        this.income = income;
        this.tax = tax;
        this.moneyLeft = moneyLeft;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public double getIncome() {
        return income;
    }

    public double getTax() {
        return tax;
    }

    public double getMoneyLeft() {
        return moneyLeft;
    }

    public int getAge() {
        return age;
    }
}