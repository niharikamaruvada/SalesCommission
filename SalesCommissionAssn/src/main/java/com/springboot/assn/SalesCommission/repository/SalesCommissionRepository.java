package com.springboot.assn.SalesCommission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.assn.SalesCommission.model.SalesCommissionTable;

@Repository
public interface SalesCommissionRepository extends JpaRepository<SalesCommissionTable, Integer>

{
	
}
