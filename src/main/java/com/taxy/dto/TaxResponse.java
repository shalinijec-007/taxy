package com.taxy.dto;

public class TaxResponse {
	
	private double income;
	private double tax;
	private double moneyLeft;
	private String explanation;
	
	public TaxResponse(double income, double tax, double moneyLeft,String explanation) {
		this.income = income;
		this.tax = tax;
		this.moneyLeft = moneyLeft;
		this.explanation = explanation;
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
	
	public String getExplanation() {
	    return explanation;
	}

}
