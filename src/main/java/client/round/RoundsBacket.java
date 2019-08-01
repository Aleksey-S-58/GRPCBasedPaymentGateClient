package client.round;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class provides a set of user's behavior and returns random one.
 * @author Aleksey-S-58
 *
 */
public class RoundsBacket {

	private List<Round> rounds;
	private Random random = new Random();
	
	public RoundsBacket() {
		rounds = new ArrayList<>();
//
//		rounds.add(new RoundBuilder()
//				.deposit(Currency.EUR, 100)
//				.deposit(Currency.EUR, 100)
//				.deposit(Currency.EUR, 100)
//				.deposit(Currency.EUR, 100)
//				.deposit(Currency.EUR, 100)
//				.build());

		//add roundA
		rounds.add(new RoundBuilder().deposit(Currency.USD, 100)
				.withdraw(Currency.USD, 200)
				.deposit(Currency.EUR, 100)
				.balance()
				.withdraw(Currency.USD, 100)
				.balance()
				.withdraw(Currency.USD, 100)
				.build());
		//add roundB
		rounds.add(new RoundBuilder()
				.withdraw(Currency.GBP, 100)
				.deposit(Currency.GBP, 300)
				.withdraw(Currency.GBP, 100)
				.withdraw(Currency.GBP, 100)
				.withdraw(Currency.GBP, 100)
				.build());
		//add roundC
		rounds.add(new RoundBuilder()
				.balance()
				.deposit(Currency.USD, 100)
				.deposit(Currency.USD, 100)
				.withdraw(Currency.USD, 100)
				.deposit(Currency.USD, 100)
				.balance()
				.withdraw(Currency.USD, 200)
				.balance()
				.build());
	}
	
	public Round getRandomRound() {
		return rounds.get(random.nextInt(rounds.size()));
	}
	
}
