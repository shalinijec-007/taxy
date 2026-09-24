package com.taxy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taxy.dto.TaxHistoryResponse;
import com.taxy.dto.TaxResponse;
import com.taxy.entity.TaxActivity;
import com.taxy.repository.TaxActivityRepository;

@Service
public class TaxService {
	
	private final TaxActivityRepository taxActivityRepository;

	public TaxService(TaxActivityRepository taxActivityRepository) {
	    this.taxActivityRepository = taxActivityRepository;
	}
	
	public TaxResponse calculateTax(double income, int age) {
		double taxRate = 0.10;
		double tax =  income*taxRate;
		double moneyLeft = income - tax;
		TaxActivity activity =
		        new TaxActivity(income, tax, moneyLeft, age);

		taxActivityRepository.save(activity);
		String explanation;

		/**Age 6–9   → very simple explanation
           Age 10–13 → more detail
           Age 14+   → introduces tax rate**/
		if (age <= 9) {
		    explanation = "You earned $" + income
		            + ". $" + tax
		            + " goes into a community money box to help pay for things like schools, roads and parks!";
		} else if (age <= 13) {
		    explanation = "You earned $" + income
		            + ". You paid $" + tax
		            + " in tax. Taxes help the government pay for public services like schools, roads and emergency services.";
		} else {
		    explanation = "You earned $" + income
		            + ". At a 10% learning tax rate, you paid $" + tax
		            + " and kept $" + moneyLeft
		            + ". Real taxes use different rates and rules depending on income and other factors.";
		}
		return new TaxResponse(income,tax,moneyLeft,explanation);
	}
	
	public List<TaxHistoryResponse> getHistory() {

	    List<TaxActivity> activities = taxActivityRepository.findAll();

	    return activities.stream()
	            .map(activity -> new TaxHistoryResponse(
	                    activity.getId(),
	                    activity.getIncome(),
	                    activity.getTax(),
	                    activity.getMoneyLeft(),
	                    activity.getAge()
	            ))
	            .toList();
	}
	
	public TaxHistoryResponse getHistoryById(Long id) {

	    TaxActivity activity = taxActivityRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Tax activity not found"));

	    return new TaxHistoryResponse(
	            activity.getId(),
	            activity.getIncome(),
	            activity.getTax(),
	            activity.getMoneyLeft(),
	            activity.getAge()
	    );
	}

}
