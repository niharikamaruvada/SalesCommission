package com.springboot.assn.SalesCommission.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assn.SalesCommission.model.Product;
import com.springboot.assn.SalesCommission.model.Sales;
import com.springboot.assn.SalesCommission.model.SalesCommissionTable;
import com.springboot.assn.SalesCommission.model.Salesman;
import com.springboot.assn.SalesCommission.repository.SalesCommissionRepository;
import com.springboot.assn.SalesCommission.repository.SalesJdbcConnector;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@Service
public class SalesService 
{
	private static final Logger logger = LoggerFactory.getLogger(SalesService.class);
	
	@Autowired
	private SalesCommissionRepository repo;
	
	@Autowired
	private SalesJdbcConnector con;
	
	public boolean addSales(Sales sales)
	{
		//instead of sysout we use logger
		logger.info(sales.toString());
		
		Salesman[] salesman = sales.getSalesman();
		
		Product[]  product = sales.getProduct();
		
		//key is id and value is object of salesman
		HashMap<String, Salesman> hm = new HashMap<>();
		
		List<SalesCommissionTable> sctList = new ArrayList<>();
		
		for(Salesman s:salesman) {
			hm.put(s.getSalesman_id(),s);
		}
		
		for(Product p:product) {
			int mrp = Integer.parseInt(p.getMrp_per_unit());
			int quant = Integer.parseInt(p.getQuantity());
			int comm = Integer.parseInt(hm.get(p.getSalesman_id()).getCommission_rate());
			
			int total = mrp * quant;
			float total_comm = (float) ((comm / 100.0) * total);
			
			SalesCommissionTable sct = new SalesCommissionTable();
			
			//using system date for created_date
			LocalDate myObj = LocalDate.now();

			sct.setProduct(p.getProduct_name());
			sct.setProduct_quantity(p.getQuantity());
			sct.setSale_amount(String.valueOf(total));
			sct.setSalesman_commission(String.valueOf(total_comm));
			sct.setSalesman_name(hm.get(p.getSalesman_id()).getSalesman_name());
			sct.setSalesman_area(hm.get(p.getSalesman_id()).getSalesman_area());
			sct.setCreated_date(myObj.toString());

			sctList.add(sct);
			
		}
		List<SalesCommissionTable> s = repo.saveAll(sctList);
		
		if(s.size() > 0) return true;
		else return false;
		
	}
	public List<SalesCommissionTable> getSct(String date) throws SQLException {
		
		return con.getSalesByDate(date);
	}
}
