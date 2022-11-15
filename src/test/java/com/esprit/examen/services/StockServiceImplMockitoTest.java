package com.esprit.examen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StockServiceImplMockitoTest {
	
	@Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockServiceImpl;

    Stock s= Stock.builder().libelleStock("stock test").qte(100).qteMin(10).build();
    List<Stock> listStocks = new ArrayList<Stock>() {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
            add(Stock.builder().libelleStock("stock test1").qte(100).qteMin(10).build());
            add(Stock.builder().libelleStock("stock test2").qte(200).qteMin(20).build());
        }
    };
    /*@Test
     public void testRetrieveStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(s));
        Stock s1 = stockServiceImpl.retrieveStock(s.getIdStock());
        Assertions.assertNotNull(s1);
    }*/
    @Test
    public void testAddstock() {
        Mockito.when(stockRepository.save(s)).thenReturn(s);
        Stock s1 = stockServiceImpl.addStock(s);
        Assertions.assertNotNull(s1);
}
    @Test
    public void testUpdatestock() {
        s.setQteMin(5);
        Mockito.when(stockRepository.save(s)).thenReturn(s);
        Stock s1 = stockServiceImpl.updateStock(s);
        Assertions.assertEquals(s,s1);
    }
}
