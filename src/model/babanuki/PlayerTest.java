package model.babanuki;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void testPlayer() {
		Scanner scanner = new Scanner(System.in);
		Stock stock = new Stock();
		Player player = new Player(scanner);

		while(stock.getNumberOfCards() > 26) {
			Card card = stock.pickCard();
			player.addCard(card);
		}


		player.display();
		player.cut();
		player.display();


	}

}
