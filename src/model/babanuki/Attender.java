package model.babanuki;

import java.util.ArrayList;

public abstract class Attender {
	protected ArrayList<Card> cards;
	protected String name;

	public Attender(String name) {
		this.name = name;
		initialize();
	}

//	初期化
	public void initialize() {
		this.cards = new ArrayList<Card>();
	}

//	手札の数を取得
	public int getNumberOfCards() {
		return this.cards.size();
	}

//	引かれたカードを手札から削除
	public Card removeCard(int number) {
		Card card = this.cards.get(number);
		this.cards.remove(number);
		return card;
	}


//	引いたカードを手札に追加
	public void addCard(Card card) {
		this.cards.add(card);
	}


//	同じ数字のカードを捨てる
	public void cut() {
		int i = 0;

		while(true) {
			int hand = this.cards.size();

			Card card1 = this.cards.get(i);
			int number1 = card1.getNumber();

			int j = i + 1;

			while(true) {


				if(j == this.cards.size()) {
					break;
				}

				Card card2 = this.cards.get(j);
				int number2 = card2.getNumber();


				if(number1 == number2) {
					System.out.println("一致しました！" + card1.toString() + card2.toString());
					this.cards.remove(j);
					this.cards.remove(i);
					i = 0;
					break;
				} else {
					j++;
				}
			}

			if(this.cards.size() == 0 || i == (this.cards.size()- 1) ) {
				break;
			}

			if(hand == this.cards.size()) {
			i++;
			}
		}
	}

//	public String toString() {
//		String string = name + ": ";
//		for(int i = 0; i < this.cards.size(); i++) {
//			Card card = this.cards.get(i);
//			string = string + card.toString();
//		}
//		return string;
//	}

	public abstract void display();
	public abstract void pick(Attender attender);
}

