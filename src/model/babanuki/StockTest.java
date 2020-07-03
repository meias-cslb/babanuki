package model.babanuki;

import org.junit.jupiter.api.Test;

class StockTest {

	@Test
	void testStock() {
		Stock stock = new Stock();
		while(stock.getNumberOfCards() > 0) {
			Card card = stock.pickCard();
			System.out.println(card);
		}

	}
}
