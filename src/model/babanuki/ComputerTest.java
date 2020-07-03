package model.babanuki;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	void testComputer() {
		Stock stock = new Stock();
		Computer computer = new Computer();
		Scanner scanner = new Scanner(System.in);
		Player player = new Player(scanner);

		while(stock.getNumberOfCards() > 26) {
			Card card = stock.pickCard();
			computer.addCard(card);
		}

		while(stock.getNumberOfCards() > 0) {
			Card card = stock.pickCard();
			player.addCard(card);
		}


		computer.display();
		player.display();
		computer.cut();
		System.out.println("-------------------------------------");
		computer.cut();
		System.out.println("-------------------------------------");
		player.cut();
		System.out.println("-------------------------------------");
		player.cut();
		computer.display();
		player.display();

		System.out.println(computer.cards.size());
		System.out.println(player.cards.size());

		do {
			computer.pick(player);
			computer.cut();
			computer.display();
			player.display();
			player.pick(computer);
			player.cut();
			computer.display();
			player.display();
		} while(player.cards.size() > 0 && computer.cards.size() > 0);

		if(player.cards.size() == 0) {
			System.out.println("You Win!");
		} else {
			System.out.println("You Lose...");
		}

	}
}
