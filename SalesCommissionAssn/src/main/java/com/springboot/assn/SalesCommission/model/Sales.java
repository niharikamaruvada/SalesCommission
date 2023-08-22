package com.springboot.assn.SalesCommission.model;

import java.util.Arrays;

public class Sales {
    Salesman[] salesman = new Salesman[0];
    Product[] product = new Product[0];

    public Salesman[] getSalesman() {
        return salesman;
    }

    public void setSalesman(Salesman[] salesman) {
        this.salesman = salesman;
    }

    public Product[] getProduct() {
        return product;
    }

    public void setProduct(Product[] product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Sales [salesman=" + Arrays.toString(salesman) + ", product=" + Arrays.toString(product) + "]";
    }


}




