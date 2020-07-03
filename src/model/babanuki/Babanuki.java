package model.babanuki;

import java.util.Scanner;

public class Babanuki {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("【ババ抜き】");
		start(scanner);
		scanner.close();
	}

	public static void start(Scanner scanner) {

		String line = "---------------------------------------------------------------------------------";

		Player player = new Player(scanner);
		Computer computer = new Computer();

		Stock stock = new Stock();

		System.out.println("カードを配るよ！");
		System.out.println(line);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		プレイヤーとディーラーが手札を引き、表示
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

		System.out.println(line);
		System.out.println("【カード整理をするよ！】");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("【" + computer.name + "のカード整理】");
		computer.cut();
//		computer.cut();
		System.out.println("【あなたのカード整理】");
		player.cut();
//		player.cut();


		System.out.println(line);

		System.out.println("準備完了！ゲームを始めるよ！");
		System.out.println("Enter を押して！");
		scanner.nextLine();

		do {

			computer.display();
			player.display();

			System.out.println(player.name + " : " + player.cards.size() + "枚 VS "
											+ computer.name + " : " + computer.cards.size() + "枚");
			System.out.println(line);

			System.out.println("【" + computer.name + "のターン】");

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			computer.pick(player);
			computer.cut();
			System.out.println(line);
			computer.display();
			player.display();
			System.out.println(player.name + " : " + player.cards.size() + "枚 VS "
											+ computer.name + " : " + computer.cards.size() + "枚");

			if(player.cards.size() > 0 && computer.cards.size() > 0) {
				System.out.println(line);
				System.out.println("【あなたのターン】");
				player.pick(computer);
				player.cut();
				System.out.println(line);
			} else {
				break;
			}


		} while(player.cards.size() > 0 && computer.cards.size() > 0);


//		プレイヤーの手札が0枚または1枚になったら勝敗を判定
		if(player.cards.size() == 0 || computer.cards.size() == 0) {
			showResult(player,computer);
		}
	}


	public static void showResult(Attender player,Attender computer) {
		String line = "---------------------------------------------------------------------------------";

//		互いの手札を表示
		System.out.println(line);
		System.out.println("");


//		互いの残りの枚数を取得
		int playerInt = player.cards.size();
		int computerInt = computer.cards.size();

		String pMsg = "手札 : " + playerInt + "枚";
		String cMsg = "手札 : " + computerInt + "枚";

		if(playerInt == 1) {
			pMsg += " JOKER!";
		}

		if(computerInt == 1) {
			cMsg += " JOKER!";
		}


//		結果を表示
		String msg = "【" + player.name + "】" + pMsg + "  VS 【" + computer.name + "】" + cMsg;
		System.out.println(msg);
		if(playerInt > computerInt) {
			System.out.println(" " + player.name + "Lose...");
		} else {
			System.out.println(" " + player.name + "Win！");
		}
	}
}
