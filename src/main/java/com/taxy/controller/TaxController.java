package com.taxy.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taxy.dto.TaxHistoryResponse;
import com.taxy.dto.TaxRequest;
import com.taxy.dto.TaxResponse;
import com.taxy.service.TaxService;

import jakarta.validation.Valid;

@RestController
public class TaxController {
	
	private final TaxService taxService;
	
	public TaxController(TaxService taxService) {
		this.taxService = taxService;
	}
	
	@GetMapping("/api/tax/hello")
	public String helloTaxy() {
		return "Hello from Taxy! Let's learn about taxes!";
	}
	
	@PostMapping("/api/tax/calculate")
	public TaxResponse calculateTax(@Valid @RequestBody TaxRequest request) {
		 return taxService.calculateTax(
		            request.getIncome(),
		            request.getAge()
		    );
	}
	
	@GetMapping("/api/tax/history")
	public List<TaxHistoryResponse> getHistory() {
	    return taxService.getHistory();
	}
	
	@GetMapping("/api/tax/history/{id}")
	public TaxHistoryResponse getHistoryById(@PathVariable Long id) {
	    return taxService.getHistoryById(id);
	}

}
