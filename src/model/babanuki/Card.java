package model.babanuki;

public class Card {
	public enum Suit {
		SPADE,
		HEART,
		DIAMOND,
		CLUB,
		JOKER
	}

	private Suit suit;
	private int number;


	public Card(Suit suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getNumber() {
		return number;
	}


	public static String getSuitString(Suit suit) {
		String string = null;

		if(suit == Suit.SPADE) {
			string = "スペード";
		} else if(suit == Suit.HEART) {
			string = "ハート";
		} else if(suit == Suit.DIAMOND) {
			string = "ダイアモンド";
		} else if(suit == Suit.CLUB) {
			string = "クラブ";
		}

		return string;
	}


	public static String getNumberString(int number) {
		String string = null;

		if(number == 1) {
			string ="A";
		} else if(number == 11) {
			string ="J";
		} else if(number == 12) {
			string ="Q";
		} else if(number == 13) {
			string ="K";
		} else if(number >= 2 || number <= 10) {
			string = Integer.toString(number);
		}

		return string;
	}

	public String toString() {
		String suit = getSuitString(this.suit);
		String number = getNumberString(this.number);

		String string = "[]";

//		ジョーカーを生成
		if(this.suit == Suit.JOKER) {
			string = "[ジョーカー]";
//		ジョーカー以外のカードの表示方法を指定
		}else if(suit != null && number != null)
			string = "[" + suit + number + "]";

		return string;

	}

	public static Card[] getAllCards() {
//		0～52枚目のカードの配列を作成
		Card[] cards = new Card[53];
		int index = 0;

		Suit[] suits = {Suit.SPADE, Suit.HEART, Suit.DIAMOND, Suit.CLUB};

//		ジョーカー以外カードの生成
		for(int i = 0; i < suits.length; i++) {
			Suit suit = suits[i];
			for(int number = 1; number <= 13; number++) {
				Card card = new Card(suit,number);
				cards[index] = card;
				index++;
			}
		}

////		ジョーカーの生成
//		Suit suitJoker = suits[4];
//		int numberJoker = 123;
//		Card cardJoker = new Card(suitJoker,numberJoker);
//		cards[52] = cardJoker;

//		53枚目(インデックス番号52)にジョーカーを生成(Cardに(～,0)を渡しても0は表示されないでnullとなる)
		cards[52] = new Card(Suit.JOKER,0);

		return cards;
	}
}
