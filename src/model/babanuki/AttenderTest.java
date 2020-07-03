package model.babanuki;

import org.junit.jupiter.api.Test;

class AttenderTest {

	@Test
	void testStrength() {
		Stock stock = new Stock();

		Attender attender = new Attender("Test") {

			@Override
			public void display() {
				// TODO 自動生成されたメソッド・スタブ

			}

			@Override
			public void pick(Attender attender) {
				// TODO 自動生成されたメソッド・スタブ

			}
		};


		System.out.print("プレイヤー：");

		while(stock.getNumberOfCards() > 26) {
			Card card = stock.pickCard();
			attender.addCard(card);
			System.out.print(card);
		}

		System.out.println("");

		attender.cut();

		String str = "プレイヤー：";
		for(int i = 0; i < attender.cards.size(); i++) {
			Card card = attender.cards.get(i);
			str += card.toString();
		}
		System.out.println(str);

	}

}
