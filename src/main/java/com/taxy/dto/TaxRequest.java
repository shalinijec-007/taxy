package com.taxy.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

public class TaxRequest {

	@Positive(message = "Income must be greater than 0")
	private double income;
	@Min(value = 6, message = "Taxy is designed for kids age 6 and above")
	@Max(value = 17, message = "Taxy is designed for kids up to age 17")
    private int age;

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}