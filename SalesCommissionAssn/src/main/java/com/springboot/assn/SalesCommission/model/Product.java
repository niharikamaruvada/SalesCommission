package com.springboot.assn.SalesCommission.model;


public class Product
{
	String product_name;
	@Override
	public String toString() {
		return "Product [product_name=" + product_name + ", quantity=" + quantity + ", mrp_per_unit=" + mrp_per_unit
				+ ", salesman_id=" + salesman_id + "]";
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	String quantity;
	String mrp_per_unit;
	String salesman_id;
	

	public String getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(String quantity) 
	{
		this.quantity = quantity;
	}
	public String getMrp_per_unit() 
	{
		return mrp_per_unit;
	}
	public void setMrp_per_unit(String mrp_per_unit) 
	{
		this.mrp_per_unit = mrp_per_unit;
	}
	public String getSalesman_id() 
	{
		return salesman_id;
	}
	public void setSalesman_id(String salesman_id) 
	{
		this.salesman_id = salesman_id;
	}

	
}
