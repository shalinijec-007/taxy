package com.taxy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaxActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double income;
    private double tax;
    private double moneyLeft;
    private int age;
    
    public TaxActivity() {
    }

    public TaxActivity(double income, double tax, double moneyLeft, int age) {
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