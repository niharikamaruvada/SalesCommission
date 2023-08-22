package com.springboot.assn.SalesCommission.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springboot.assn.SalesCommission.model.Sales;
import com.springboot.assn.SalesCommission.model.SalesCommissionTable;
import com.springboot.assn.SalesCommission.service.SalesService;

@RestController
public class SalesCommissionController 
{
	@Autowired
	SalesService salesService;

	@PostMapping("/sales")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> calculateSales(@RequestBody Sales sales){
		boolean b =  salesService.addSales(sales);
		
		if(b)
			return ResponseEntity.ok().body("success");
		else
			return ResponseEntity.badRequest().body("fail");
		
	}
	
	@GetMapping("/sales/commission")
	@CrossOrigin(origins = "http://localhost:3000")
	public 	List<SalesCommissionTable> getSct(@RequestParam String date) throws SQLException
	{
		return salesService.getSct(date);
	}
}