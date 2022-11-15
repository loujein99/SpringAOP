package com.esprit.examen.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class StockServiceImplTest {
	 @Autowired
	    IStockService StockServiceImpl;
	 @Test
	 @Order(1)
	 public void testSaveStock(){
	   Stock s= StockServiceImpl.addStock(Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build());
	   Assertions.assertNotNull(s);
	    }
	 @Test
	 @Order(2)
	 public void testRetrieveAllStocks() {
	   int listStocks = StockServiceImpl.retrieveAllStocks().size();
	   StockServiceImpl.addStock(Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build());
	   Assertions.assertEquals(listStocks+1, StockServiceImpl.retrieveAllStocks().size());
	  } 
	 @Test
	 @Order(3)
	 public void testUpdateStock() {
	     Stock s= StockServiceImpl.addStock(Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build());
	     s.setQteMin(5);
	     Assertions.assertEquals(5,StockServiceImpl.updateStock(s).getQteMin());
	    }
}