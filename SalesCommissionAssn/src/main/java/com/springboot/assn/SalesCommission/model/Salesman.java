package com.springboot.assn.SalesCommission.model;

public class Salesman
{
	String salesman_id;
	String salesman_name;
	String salesman_area;
	String commission_rate;
	
	public String getSalesman_id() 
	{
		return salesman_id;
	}
	public void setSalesman_id(String salesman_id) 
	{
		this.salesman_id = salesman_id;
	}
	public String getSalesman_name() 
	{
		return salesman_name;
	}
	public void setSalesman_name(String salesman_name)
	{
		this.salesman_name = salesman_name;
	}
	public String getSalesman_area() 
	{
		return salesman_area;
	}
	public void setSalesman_area(String salesman_area) 
	{
		this.salesman_area = salesman_area;
	}
	public String getCommission_rate() {
		return commission_rate;
	}
	public void setCommission_rate(String commission_rate) 
	{
		this.commission_rate = commission_rate;
	}
	@Override
	public String toString() {
		return "Salesman [salesman_id=" + salesman_id + ", salesman_name=" + salesman_name + ", salesman_area="
				+ salesman_area + ", commission_rate=" + commission_rate + "]";
	}

}
