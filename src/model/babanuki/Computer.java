package model.babanuki;

import java.util.Collections;

public class Computer extends Attender {

	public Computer() {
		super("Computer");
	}

//	カードを裏面で表示
	@Override
	public void display() {
		String string = this.name + ": ";
		for(int i = 0; i < this.cards.size(); i++) {
			string += "[######]";
		}

		System.out.println(string);

	}


	@Override
	public void pick(Attender attender) {
		int select = (int)(Math.random() * attender.cards.size());

		System.out.println("引かれたカード：" + attender.cards.get(select));
		this.cards.add(attender.cards.get(select));
		attender.cards.remove(select);
		Collections.shuffle(this.cards);
	}

}
