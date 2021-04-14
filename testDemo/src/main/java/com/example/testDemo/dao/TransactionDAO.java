package com.example.testDemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.testDemo.model.CSVObject;

@Repository
@Transactional
public interface TransactionDAO extends CrudRepository<CSVObject,Long> {
	
	@Query("SELECT e from transcation e where e.accountNumber =:id ")       
    List<CSVObject> findByAccountNumber(@Param("id") String id);      
	
	@Query("SELECT e from tractions e where e.customerId =:id ")       
    List<CSVObject> findByCustomerId(@Param("id") String id);
}
