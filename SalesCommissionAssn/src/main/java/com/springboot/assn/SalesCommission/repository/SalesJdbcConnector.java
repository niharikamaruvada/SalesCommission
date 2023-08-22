package com.springboot.assn.SalesCommission.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Service;
import com.springboot.assn.SalesCommission.model.SalesCommissionTable;

/*the database used is mysql. 
dependencies are added and connections are made in application.properties file. */
@Service
public class SalesJdbcConnector
{
	public List<SalesCommissionTable> getSalesByDate(String date) throws SQLException {
		//connection establishment
	    Connection con = DriverManager.getConnection(
	        "jdbc:mysql://localhost:3306/sales_commission",
	        "root", "root");
	    
	    PreparedStatement p = null;
	    ResultSet rs = null;
	    //query to obtain distinct values for a given date
	    String sql = "SELECT DISTINCT * FROM sales_commission WHERE created_date = ?";
	    p = con.prepareStatement(sql);
	    p.setString(1, date);
	    rs = p.executeQuery();
	    
	    //to add all non-duplicate elements to a list and return it.
	    List<SalesCommissionTable> list = new ArrayList<>();

	    // Use HashSet to remove duplicates
	    HashSet<SalesCommissionTable> set = new HashSet<>();

	    while (rs.next()) {
	        String product = rs.getString("product");
	        String salesman_name = rs.getString("salesman_name");
	        int id = rs.getInt("id");
	        String product_quantity = rs.getString("product_quantity");
	        String sale_amount = rs.getString("sale_amount");
	        String salesman_area = rs.getString("salesman_area");
	        String salesman_commission = rs.getString("salesman_commission");
	        String created_date = rs.getString("created_date");

	        SalesCommissionTable sc = new SalesCommissionTable();
	        sc.setId(id);
	        sc.setProduct(product);
	        sc.setProduct_quantity(product_quantity);
	        sc.setSale_amount(sale_amount);
	        sc.setSalesman_area(salesman_area);
	        sc.setSalesman_commission(salesman_commission);
	        sc.setSalesman_name(salesman_name);
	        sc.setCreated_date(created_date);

	        // Add the object to the HashSet
	        set.add(sc);
	    }
	    // Create a new ArrayList from the HashSet to remove duplicates
	    list.addAll(set);
	
	    return list;
	}

}
