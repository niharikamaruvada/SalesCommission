package com.springboot.assn.SalesCommission.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "sales_commission")
public class SalesCommissionTable implements Serializable
{
	private static final long serialVersionUID = 1L; //incremental value by 1
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id; //acts as primary key
	String product;
	String product_quantity;
	String sale_amount;
	String salesman_name;
	String salesman_commission;
	String salesman_area;
	String created_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}
	public String getSale_amount() {
		return sale_amount;
	}
	public void setSale_amount(String sale_amount) {
		this.sale_amount = sale_amount;
	}
	public String getSalesman_name() {
		return salesman_name;
	}
	public void setSalesman_name(String salesman_name) {
		this.salesman_name = salesman_name;
	}
	public String getSalesman_commission() {
		return salesman_commission;
	}
	public void setSalesman_commission(String salesman_commission) {
		this.salesman_commission = salesman_commission;
	}
	public String getSalesman_area() {
		return salesman_area;
	}
	public void setSalesman_area(String salesman_area) {
		this.salesman_area = salesman_area;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public SalesCommissionTable(int id, String product, String product_quantity, String sale_amount,
			String salesman_name, String salesman_commission, String salesman_area, String created_date) {
		super();
		this.id = id;
		this.product = product;
		this.product_quantity = product_quantity;
		this.sale_amount = sale_amount;
		this.salesman_name = salesman_name;
		this.salesman_commission = salesman_commission;
		this.salesman_area = salesman_area;
		this.created_date = created_date;
	}
	public SalesCommissionTable() {
	}
	
	@Override
	public boolean equals(Object o) {
	    if (o == this) {
	        return true;
	    }
	    if (!(o instanceof SalesCommissionTable)) {
	        return false;
	    }
	    SalesCommissionTable sct = (SalesCommissionTable) o;
	    return Objects.equals(salesman_name, sct.salesman_name) && Objects.equals(product, sct.product);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(salesman_name, product);
	}

	
}
