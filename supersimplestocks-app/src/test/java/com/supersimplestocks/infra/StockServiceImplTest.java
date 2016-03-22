package com.supersimplestocks.infra;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.supersimplestocks.domain.Stock;
import com.supersimplestocks.domain.StockTypeEnum;
import com.supersimplestocks.domain.Trade;
import com.supersimplestocks.infra.StockDAO;
import com.supersimplestocks.infra.StockServiceImpl;

public class StockServiceImplTest {

	StockServiceImpl stockServiceImpl;
	Stock commonStock;
	Stock preferedStock;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	@SuppressWarnings("unchecked")
	public void setUp() throws Exception {
		
		stockServiceImpl = new StockServiceImpl();
		
		Trade trade = mock(Trade.class);
		when(trade.getPrice()).thenReturn(125.0);
		when(trade.getTimeStamp()).thenReturn(new Date());
		when(trade.getQuantity()).thenReturn(10L);
		
		Trade oldTrade = mock(Trade.class);
		when(oldTrade.getPrice()).thenReturn(5.0);
		when(oldTrade.getTimeStamp()).thenReturn(new Date((new Date().getTime() - (1400000000000L))));
		when(oldTrade.getQuantity()).thenReturn(100L);
		
		List<Trade> tradeList = Arrays.asList(oldTrade,trade);
		
		/* COMMON STOCK */
		commonStock = mock(Stock.class);
		when(commonStock.getType()).thenReturn(StockTypeEnum.COMMON);
		when(commonStock.getTrades()).thenReturn(tradeList);
		when(commonStock.getLastDividende()).thenReturn(23L);
		when(commonStock.getParValue()).thenReturn(100L);
		
		/* PREFERED STOCK */
		preferedStock = mock(Stock.class);
		when(preferedStock.getType()).thenReturn(StockTypeEnum.PREFERED);
		when(preferedStock.getTrades()).thenReturn(tradeList);
		when(preferedStock.getFixedDividend()).thenReturn(0.23);
		when(preferedStock.getParValue()).thenReturn(100L);
				
		List<Stock> stockList = Arrays.asList(commonStock, preferedStock);
		
		Map<String, Stock> mockedStockMap = mock(Map.class);
		when(mockedStockMap.values()).thenReturn(stockList);
		
		StockDAO stockDAO = mock(StockDAO.class);
		when(stockDAO.getAllStock()).thenReturn(mockedStockMap);
		stockServiceImpl.setStockDAO(stockDAO);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testGetPriceEarningRatio() {
		
		double priceEarningRatio = stockServiceImpl.getPriceEarningRatio(commonStock);
		assertEquals(5.4347, priceEarningRatio, 0.001);
	}

	@Test
	public void testGetDividendeYielWhenStockIsCommon() {
		
		double dividendeYield = stockServiceImpl.getDividendeYiel(commonStock);
		assertEquals(0.184, dividendeYield, 0);
	}

	@Test
	public void testGetDividendeYielWhenStockIsPrefered() {
		
		double dividendeYield = stockServiceImpl.getDividendeYiel(preferedStock);
		assertEquals(0.184, dividendeYield, 0);
	}
	
	@Test
	public void testCalculateStockPrice() {
		
		double stockPrice = stockServiceImpl.calculateStockPrice(commonStock);
		assertEquals(125.0, stockPrice, 0);
	}
	
	
	@Test
	public void testCalculateGBCE() {
		
		double GBCE = stockServiceImpl.calculateGBCE();
		assertEquals(125.0, GBCE, 0);
	}
	
}
