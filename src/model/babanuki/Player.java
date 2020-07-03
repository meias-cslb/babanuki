package model.babanuki;

import java.util.Scanner;

public class Player extends Attender {
	int hit;

	private Scanner scanner;

	public Player(Scanner scanner) {
		super("You");
		this.scanner = scanner;
	}

	@Override
	public void display() {
		String str = this.name + " : ";
		for(int i = 0; i < this.cards.size(); i++) {
			Card card = this.cards.get(i);
			str += card.toString();
		}
		System.out.println(str);

	}


	@Override
	public void pick(Attender attender) {

		while(true) {
			String msg = "相手のカードは" + attender.cards.size()+ "枚です。何枚目のカードを引きますか？";
			System.out.println(msg);

			int select = this.scanner.nextInt();
			select--;

			if(select >= 0 && select < attender.cards.size()){
				System.out.println("引いたカード：" + attender.cards.get(select));
				this.cards.add(attender.cards.get(select));
				attender.cards.remove(select);
				break;
			} else {
				continue;
			}
		}
	}
}
