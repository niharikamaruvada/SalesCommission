package com.springboot.assn.SalesCommission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;



@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SalesCommissionAssnApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesCommissionAssnApplication.class, args);
	}

}
